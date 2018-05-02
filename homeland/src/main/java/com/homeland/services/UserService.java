package com.homeland.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeland.assemblers.Assembler;
import com.homeland.assemblers.DomainAssembler;
import com.homeland.assemblers.RequestAssembler;
import com.homeland.constants.IStatus;
import com.homeland.dto.UserDTO;
import com.homeland.entities.User;
import com.homeland.exceptions.EntityExistsException;
import com.homeland.exceptions.NoContentException;
import com.homeland.exceptions.NotFoundException;
import com.homeland.repositories.UserRepository;
import com.homeland.requests.api.UserRequest;
import com.homeland.requests.repository.UserSQL;
import com.homeland.utils.StringUtil;

@Service
public class UserService {

	@Autowired
	UserRepository userDAO;
	
	
	public List<UserDTO> searchUser(UserRequest req)
	{
		UserSQL criterias = new RequestAssembler().apiToSql(req);
		List<User> users = userDAO.searchUser(criterias);
		return new Assembler().userListToDto(users);
	}
	
	public UserDTO findUserById(Integer userId)
	{
		if(userId == null) return null;
		
		return new Assembler().toDto(userDAO.findById(userId));
	}
	
	public UserDTO findUserByUsername(String username)
	{
		if(!StringUtil.isValid(username)) return null;
		
		UserRequest req = new UserRequest(username);
		
		List<UserDTO> users = searchUser(req);
		
		if(users!=null && !users.isEmpty())
		{
			return users.get(0);
		}
		
		return null;
	}
	
	public UserDTO registerUser(UserDTO dto,Integer userId)
	{
		
		if(dto == null) return null;
		
		if(!StringUtil.isValid(dto.getUsername()))
		{
			throw new NoContentException("Plotesoni 'Perdoruesin'");
		}
		
		if(!StringUtil.isValid(dto.getSecret()))
		{
			throw new NoContentException("Plotesoni 'Fjalekalimin'");
		}
		
		if(!StringUtil.isValid(dto.getRole()))
		{
			throw new NoContentException("Plotesoni 'Rolin'");
		}
		
		if(findUserByUsername(dto.getUsername()) != null)
		{
			throw new EntityExistsException("Perdoruesi ekziston");
		}
		
		User u = new DomainAssembler().toDomain(null,dto);
		u.setCreatedTime(new Date());
		u.setStatus(IStatus.ACTIVE);
		u.setCreatedUserId(userId);
		
		return new Assembler().toDto(userDAO.create(u));
		
	}
	
	public UserDTO modifyUser(UserDTO dto,Integer userId)
	{
		
		if(dto == null) return null;
		
		if(!StringUtil.isValid(dto.getUsername()))
		{
			throw new NoContentException("Plotesoni 'Perdoruesin'");
		}
		
		if(!StringUtil.isValid(dto.getSecret()))
		{
			throw new NoContentException("Plotesoni 'Fjalekalimin'");
		}
		
		if(!StringUtil.isValid(dto.getRole()))
		{
			throw new NoContentException("Plotesoni 'Rolin'");
		}
		
		
		List<User> usrList = userDAO.searchUser(new RequestAssembler().apiToSql(new UserRequest(dto.getUsername())));
		if(usrList == null || usrList.isEmpty())
		{
			throw new NotFoundException("Ky perdorues nuk ekziston");
		}
		
		User usr = usrList.get(0);
		
		if(usr.getId() != dto.getId())
		{
			throw new EntityExistsException("Perdoruesi '"+dto.getUsername()+"' eshte i zene");
		}
		
		User u = new DomainAssembler().toDomain(usr, dto);
		u.setModifyTime(new Date());
		u.setModifyUserId(userId);
				
		return new Assembler().toDto(userDAO.update(u));
		
	}
	
	
	
	
}
