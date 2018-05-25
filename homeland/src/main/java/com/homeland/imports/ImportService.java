package com.homeland.imports;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeland.assemblers.Assembler;
import com.homeland.dto.BorderDTO;
import com.homeland.dto.CardDTO;
import com.homeland.dto.ImportDTO;
import com.homeland.dto.PassportDTO;
import com.homeland.dto.PhoneDTO;
import com.homeland.dto.PhotoDTO;
import com.homeland.dto.TicketDTO;
import com.homeland.dto.VehicleDTO;
import com.homeland.entities.Border;
import com.homeland.entities.Card;
import com.homeland.entities.Imports;
import com.homeland.entities.Passport;
import com.homeland.entities.Phone;
import com.homeland.entities.PhotoCard;
import com.homeland.entities.PhotoPassport;
import com.homeland.entities.Ticket;
import com.homeland.entities.Vehicle;
import com.homeland.repositories.BorderRepository;
import com.homeland.repositories.CardRepository;
import com.homeland.repositories.ImportRepository;
import com.homeland.repositories.PassportRepository;
import com.homeland.repositories.TicketRepository;
import com.homeland.repositories.VehicleRepository;
import com.homeland.utils.DateUtil;
import com.homeland.utils.StringUtil;


@Service
public class ImportService {

	@Autowired
	ImportRepository importDAO;
	@Autowired
	CardRepository cardDAO;
	@Autowired
	PassportRepository passportDAO;
	@Autowired
	VehicleRepository vehicleDAO;
	@Autowired
	TicketRepository ticketDAO;
	@Autowired
	BorderRepository borderDAO;
	
	
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
	public void registerPassport(PassportDTO dto)
	{
		Passport c = new Passport();
		
		c.setAddress(dto.getAddress());
		c.setCitizenship(dto.getCitizenship());
		c.setDob(dto.getDob());//yyyyMMdd
		c.setExpireDate(dto.getExpireDate());//yyyyMMdd
		c.setFatherName(dto.getFatherName());
		c.setFatherNameSx(StringUtil.formatSQ(dto.getFatherName()));
		c.setGender(dto.getGender());
		c.setIdp(dto.getIdp());
		c.setInserted(Calendar.getInstance().getTime());
		c.setIssueAuthority(dto.getIssueAuthority());
		c.setIssueDate(dto.getIssueDate());
		c.setMotherName(dto.getMotherName());
		c.setMotherNameSx(StringUtil.formatSQ(dto.getMotherName()));
		c.setName(dto.getName());
		c.setNameSx(StringUtil.formatSQ(dto.getName()));
		c.setNationality(dto.getNationality());
		c.setNid(dto.getNid());
		c.setPob(dto.getPob());
		c.setRid((long)dto.getId());
		c.setSurname(dto.getSurname());
		c.setSurnameSx(StringUtil.formatSQ(dto.getSurname()));
		c.setType(dto.getType());
		
		passportDAO.create(c);
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
	
	@Transactional
	public void registerPhotoPassport(PhotoDTO dto)
	{
		PhotoPassport p = new PhotoPassport();
		
		p.setRid((long)dto.getId());
		p.setIdp(dto.getIdDoc());
		p.setInserted(Calendar.getInstance().getTime());
		p.setPhoto(dto.getPhoto());
		
		passportDAO.create(p);
	}
	
	
	@Transactional
	public void registerPhone(PhoneDTO dto)
	{
		Phone p = new Phone();
		p.setDataSource(dto.getDataSource());
		p.setDob(dto.getDob());
		p.setFatherName(StringUtil.formatSQ(dto.getFatherName()));
		p.setInserted(Calendar.getInstance().getTime());
		p.setMotherName(StringUtil.formatSQ(dto.getMotherName()));
		p.setName(StringUtil.formatSQ(dto.getName()));
		p.setNid(StringUtil.formatSQ(dto.getNid()));
		p.setPhone(dto.getPhone());
		p.setRegDate(dto.getRegDate());
		p.setRid((long)dto.getId());
		p.setSurname(StringUtil.formatSQ(dto.getSurname()));
	}
	
	
	@Transactional
	public void registerVehicle(VehicleDTO dto)
	{
		Vehicle v = new Vehicle();
		
		v.setAddress(dto.getAddress());
		v.setCapacity(dto.getCapacity());
		v.setColor(dto.getColor());
		v.setDrivingPermitNo(dto.getDrivingPermitNo());
		v.setInserted(Calendar.getInstance().getTime());
		v.setModel(dto.getModel());
		v.setOwner(StringUtil.formatSQ(dto.getOwner()));
		v.setOwnerNid(StringUtil.formatSQ(dto.getOwnerNid()));
		v.setPlate(dto.getPlate());
		v.setProducer(StringUtil.formatSQ(dto.getProducer()));
		v.setRid((long)dto.getId());
		v.setState(dto.getState());
		v.setType(dto.getType());
		v.setUsedFor(dto.getUsedFor());
		v.setVin(dto.getVin());
		v.setYear(dto.getYear());
		
		vehicleDAO.create(v);
		
	}
	
	@Transactional
	public void registerTicket(TicketDTO dto)
	{
		Ticket t = new Ticket();
		t.setAmount(dto.getAmount());
		t.setInserted(Calendar.getInstance().getTime());
		t.setOfficer(dto.getOfficer());
		t.setOwner(dto.getOwner());
		t.setOwnerAddress(dto.getOwnerAddress());
		t.setPlate(dto.getPlate());
		t.setProducer(dto.getProducer());
		t.setRid((long)dto.getId());
		t.setSerialNo(dto.getSerialNo());
		t.setStatus(dto.getStatus());
		t.setTicketDate(DateUtil.toTimestamp(dto.getTicketDate()));
		t.setTicketPlace(dto.getTicketPlace());
		t.setViolator(dto.getViolator());
		t.setViolatorNid(dto.getViolatorNid());
		
		ticketDAO.create(t);
	}
	
	@Transactional
	public void registerBorder(BorderDTO dto)
	{
		Border b = new Border();
		
		b.setBcgId(dto.getBcgId());
		b.setCitizenType(dto.getCitizenType());
		b.setCrossingDate(DateUtil.toTimestamp(dto.getCrossingDate()));
		b.setCrossingGate(dto.getCrossingGate());
		b.setDob(dto.getDob());
		b.setDocNo(dto.getDocNo());
		b.setDocState(dto.getDocState());
		b.setDriver(dto.isDriver()?1:0);
		b.setEvent(dto.getEvent());
		b.setFatherName(StringUtil.formatSQ(dto.getFatherName()));
		b.setForeign(dto.isForeign()?1:0);
		b.setGender(dto.getGender());
		b.setName(StringUtil.formatSQ(dto.getName()));
		b.setInserted(Calendar.getInstance().getTime());
		b.setNationality(dto.getNationality());
		b.setNid(dto.getNid());
		b.setPlate(dto.getPlate());
		b.setPupose(dto.getPupose());
		b.setSurname(StringUtil.formatSQ(dto.getSurname()));
		b.setTravel(dto.getTravel());
		
		borderDAO.create(b);
		
	}
	
	
	
}
