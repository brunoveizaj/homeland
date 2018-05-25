package com.homeland.imports;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeland.assemblers.Assembler;
import com.homeland.dto.CardDTO;
import com.homeland.dto.ImportDTO;
import com.homeland.dto.PhotoDTO;
import com.homeland.entities.Card;
import com.homeland.entities.Imports;
import com.homeland.entities.Passport;
import com.homeland.entities.Phone;
import com.homeland.entities.PhotoCard;
import com.homeland.entities.PhotoPassport;
import com.homeland.entities.Ticket;
import com.homeland.entities.Vehicle;
import com.homeland.repositories.CardRepository;
import com.homeland.repositories.ImportRepository;
import com.homeland.utils.StringUtil;


@Service
public class ImportService {

	@Autowired
	ImportRepository importDAO;
	@Autowired
	CardRepository cardDAO;
	
	
	@Transactional
	public ImportDTO openImport(String type)
	{
		Imports i = new Imports();
		i.setDataSource(type);
		i.setStartTime(Calendar.getInstance().getTime());
		i.setTotal(0);
		
		i = importDAO.create(i);
		
		return new Assembler().toDto(i);
	}
	
	@Transactional
	public ImportDTO closeImport(ImportDTO dto)
	{
		Imports i = importDAO.findById(dto.getId());
		i.setTotal(dto.getTotal());
		i.setEndTime(Calendar.getInstance().getTime());
		
		i = importDAO.update(i);
		
		return new Assembler().toDto(i);
	}
	
	public Long getLastRid(String type)
	{
		Class<?> c = null;
		
		if(type.equals(Type.CARD)) c = Card.class;
		else if(type.equals(Type.PASSPORT)) c = Passport.class;
		else if(type.equals(Type.PHONE)) c = Phone.class;
		else if(type.equals(Type.VEHICLE)) c = Vehicle.class;
		else if(type.equals(Type.TICKET)) c = Ticket.class;
		//else if(type.equals(Type.BORDER)) c = Border.class;
		else if(type.equals(Type.PHOTO_CARD)) c = PhotoCard.class;
		else if(type.equals(Type.PHOTO_PASSPORT)) c = PhotoPassport.class;
		
		return importDAO.getLastRid(c);
		
	}
	
	@Transactional
	public void registerCard(CardDTO dto)
	{
		Card c = new Card();
		c.setAppartment(dto.getAppartment());
		c.setBuilding(dto.getBuilding());
		c.setCardType(dto.getCardType());
		c.setCitizenship(dto.getCitizenship());
		c.setCity(dto.getCity());
		c.setDob(dto.getDob());//yyyyMMdd
		c.setExpireDate(dto.getExpireDate());//yyyyMMdd
		c.setFatherName(dto.getFatherName());
		c.setFatherNameSx(StringUtil.formatSQ(dto.getFatherName()));
		c.setGender(dto.getGender());
		c.setIdc(dto.getIdc());
		c.setInserted(Calendar.getInstance().getTime());
		c.setIssueAuthority(dto.getIssueAuthority());
		c.setIssueDate(dto.getIssueDate());
		c.setMotherName(dto.getMotherName());
		c.setMotherNameSx(StringUtil.formatSQ(dto.getMotherName()));
		c.setName(dto.getName());
		c.setNameSx(StringUtil.formatSQ(dto.getName()));
		c.setNationality(dto.getNationality());
		c.setNid(dto.getNid());
		c.setPhoneOne(dto.getPhoneOne());
		c.setPhoneTwo(dto.getPhoneTwo());
		c.setPob(dto.getPob());
		c.setRegion(dto.getRegion());
		c.setRid((long)dto.getId());
		c.setStreet(dto.getStreet());
		c.setSurname(dto.getSurname());
		c.setSurnameSx(StringUtil.formatSQ(dto.getSurname()));
		c.setZgjcCode(dto.getZgjcCode());
		
		cardDAO.create(c);
	}
	
	@Transactional
	public void registerPhotoCard(PhotoDTO dto)
	{
		PhotoCard p = new PhotoCard();
		
		p.setRid((long)dto.getId());
		p.setIdc(dto.getIdDoc());
		p.setInsterted(Calendar.getInstance().getTime());
		p.setPhoto(dto.getPhoto());
		
		cardDAO.create(p);
	}
	
	
}
