package com.homeland.assemblers;


import com.homeland.dto.BorderDTO;
import com.homeland.dto.UserDTO;
import com.homeland.entities.Border;
import com.homeland.entities.User;
import com.homeland.utils.DateUtil;

public class DomainAssembler {

	
	
	
	
	
	public Border toDomain(Border border,BorderDTO dto)
	{
		
		if(dto == null) return border;
		
		if(border == null) {
			border = new Border();
		}
		
		border.setCitizenType(dto.getCitizenType());
		border.setCrossingDate(DateUtil.toTimestamp(dto.getCrossingDate()));
		border.setCrossingGate(dto.getCrossingGate());
		border.setDob(dto.getDob());
		border.setDocNo(dto.getDocNo());
		border.setDocState(dto.getDocState());
		border.setDriver(dto.isDriver()?1:0);
		border.setEvent(dto.getEvent());
		border.setFatherName(dto.getFatherName());
		border.setGender(dto.getGender());
		border.setId(dto.getId());
		border.setName(dto.getName());
		border.setNationality(dto.getNationality());
		border.setNid(dto.getNid());
		border.setPlate(dto.getPlate());
		border.setPupose(dto.getPupose());
		border.setSurname(dto.getSurname());
		border.setTravel(dto.getTravel());
		border.setBcgId(dto.getBcgId());
		
		return border;
		
	}
	

	
	
	
	public User toDomain(User entity, UserDTO dto)
	{
		if(dto == null) return entity;
		
		if(entity == null) {
			entity = new User();
		}
		entity.setId(dto.getId());
		entity.setCreatedTime(DateUtil.toTimestamp(dto.getCreatedTime()));
		entity.setCreatedUserId(dto.getCreatedUserId());
		entity.setId(dto.getId());
		entity.setModifyTime(DateUtil.toTimestamp(dto.getModifyTime()));
		entity.setModifyUserId(dto.getModifyUserId());
		entity.setRole(dto.getRole());
		entity.setStatus(dto.getStatus());
		entity.setUsername(dto.getUsername());
		entity.setSecret(dto.getSecret());
		
		
		return entity;
		
	}
	
	
	
	
	
}
