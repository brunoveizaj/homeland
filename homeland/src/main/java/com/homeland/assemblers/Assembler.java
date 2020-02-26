package com.homeland.assemblers;

import java.util.ArrayList;
import java.util.List;

import com.homeland.constants.IDocument;
import com.homeland.constants.IStatus;
import com.homeland.dto.AddressDTO;
import com.homeland.dto.BorderDTO;
import com.homeland.dto.BorderGateDTO;
import com.homeland.dto.CardDTO;
import com.homeland.dto.ImportDTO;
import com.homeland.dto.LiveRaportDTO;
import com.homeland.dto.LoginDTO;
import com.homeland.dto.OsheeDTO;
import com.homeland.dto.PassportDTO;
import com.homeland.dto.PersonDTO;
import com.homeland.dto.PhoneDTO;
import com.homeland.dto.PhotoDTO;
import com.homeland.dto.SubjectDTO;
import com.homeland.dto.TatimeDTO;
import com.homeland.dto.TicketDTO;
import com.homeland.dto.UserDTO;
import com.homeland.dto.VehicleDTO;
import com.homeland.entities.Address;
import com.homeland.entities.Border;
import com.homeland.entities.BorderGate;
import com.homeland.entities.Card;
import com.homeland.entities.Imports;
import com.homeland.entities.LiveRaport;
import com.homeland.entities.Login;
import com.homeland.entities.Oshee;
import com.homeland.entities.Passport;
import com.homeland.entities.Person;
import com.homeland.entities.Phone;
import com.homeland.entities.PhotoCard;
import com.homeland.entities.PhotoPassport;
import com.homeland.entities.Subject;
import com.homeland.entities.Tatime;
import com.homeland.entities.Ticket;
import com.homeland.entities.User;
import com.homeland.entities.Vehicle;
import com.homeland.utils.CalculatorUtil;
import com.homeland.utils.DateUtil;

public class Assembler {

	
	public PersonDTO toDto(Person person)
	{
		
		if(person == null) return null;
		
		PersonDTO dto = new PersonDTO();
		
		dto.setAddress(person.getAddress());
		dto.setBuilding(person.getBuilding());
		dto.setCivilStatus(person.getCivilStatus());
		dto.setDob(DateUtil.formatReverseDate(person.getDob()));
		dto.setFamilyId(person.getFamilyId());
		dto.setFamilyRelation(person.getFamilyRelation());
		dto.setFamilyRowId(person.getFamilyRowId());
		dto.setFatherName(person.getFatherName());
		dto.setFraction(person.getFraction());
		dto.setGender(person.getGender());
		dto.setId(person.getId());
		dto.setMaidenName(person.getMaidenName());
		dto.setMotherName(person.getMotherName());
		dto.setMunicipality(person.getMunicipality());
		dto.setName(person.getName());
		dto.setNid(person.getNid());
		dto.setPob(person.getPob());
		dto.setQv(person.getQv());
		dto.setRegion(person.getRegion());
		dto.setStreet(person.getStreet());
		dto.setSurname(person.getSurname());
		dto.setUnit(person.getUnit());
		dto.setVotingListNo(person.getVotingListNo());
		
		return dto;
		
	}
	
	
	public List<PersonDTO> personListToDto(List<Person> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<PersonDTO> list = new ArrayList<>();
		
		for(Person i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	
	public BorderDTO toDto(Border border)
	{
		
		if(border == null) return null;
		
		BorderDTO dto = new BorderDTO();
		
		dto.setCitizenType(border.getCitizenType());
		//dto.setCrossingDate(DateUtil.formatTimestamp(border.getCrossingDate()));
		//dto.setTimsRecordDate(DateUtil.formatTimestamp(border.getTimsRecordDate()));
		dto.setCrossingDate(border.getCrossingDate());
		dto.setTimsRecordDate(border.getTimsRecordDate());
		dto.setCrossingGate(border.getCrossingGate());
		dto.setDob(border.getDob());
		dto.setDocNo(border.getDocNo());
		dto.setDocState(border.getDocState());
		dto.setDriver(border.getDriver()==1);
		dto.setEvent(border.getEvent());
		dto.setFatherName(border.getFatherName());
		dto.setGender(border.getGender());
		dto.setId(border.getId());
		dto.setName(border.getName());
		dto.setNationality(border.getNationality());
		dto.setNid(border.getNid());
		dto.setPlate(border.getPlate());
		dto.setPupose(border.getPupose());
		dto.setSurname(border.getSurname());
		dto.setTravel(border.getTravel());
		dto.setBcgId(border.getBcgId());
		dto.setForeign(border.getForeign() == IStatus.ACTIVE);
		
		
		return dto;
		
	}
	
	public List<BorderDTO> borderListToDto(List<Border> borders)
	{
		if(borders == null || borders.isEmpty()) return null;
		
		List<BorderDTO> list = new ArrayList<>();
		
		for(Border i : borders)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	
	
	public PhotoDTO toDto(PhotoCard photo)
	{
		if(photo == null) return null;
		
		PhotoDTO p = new PhotoDTO();
		p.setId(photo.getId());
		p.setIdDoc(photo.getIdc());
		p.setPhoto(CalculatorUtil.encodeBASE64(photo.getPhoto()));
		p.setDocType(IDocument.CARD);
		p.setRid(photo.getRid());
		
		return p;
	}
	
	public PhotoDTO toDto(PhotoPassport photo)
	{
		if(photo == null) return null;
		
		PhotoDTO p = new PhotoDTO();
		p.setId(photo.getId());
		p.setIdDoc(photo.getIdp());
		p.setPhoto(CalculatorUtil.encodeBASE64(photo.getPhoto()));
		p.setDocType(IDocument.PASSPORT);
		
		return p;
	}
	
	
	public CardDTO toDto(Card card)
	{
		if(card == null) return null;
		
		CardDTO dto = new CardDTO();
		
		dto.setAppartment(card.getAppartment());
		dto.setBuilding(card.getBuilding());
		dto.setCardType(card.getCardType());
		dto.setCitizenship(card.getCitizenship());
		dto.setCity(card.getCity());
		dto.setDob(DateUtil.formatReverseDate(card.getDob()));
		dto.setExpireDate(DateUtil.formatReverseDate(card.getExpireDate()));
		dto.setFatherName(card.getFatherName());
		dto.setGender(card.getGender());
		dto.setId(card.getId());
		dto.setIdc(card.getIdc());
		dto.setIssueAuthority(card.getIssueAuthority());
		dto.setIssueDate(DateUtil.formatReverseDate(card.getIssueDate()));
		dto.setMotherName(card.getMotherName());
		dto.setName(card.getName());
		dto.setNationality(card.getNationality());
		dto.setNid(card.getNid());
		dto.setPhoneOne(card.getPhoneOne());
		dto.setPhoneTwo(card.getPhoneTwo());
		dto.setPob(card.getPob());
		dto.setRegion(card.getRegion());
		dto.setStreet(card.getStreet());
		dto.setSurname(card.getSurname());
		dto.setZgjcCode(card.getZgjcCode());
		dto.setRid(card.getRid());
		
		return dto;
		
	}

	public List<CardDTO> cardListToDto(List<Card> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<CardDTO> list = new ArrayList<>();
		
		for(Card i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	
	public ImportDTO toDto(Imports imports)
	{
		if(imports == null) return null;
		
		ImportDTO dto = new ImportDTO();
		
		dto.setDataSource(imports.getDataSource());
		dto.setEndTime(DateUtil.formatTimestamp(imports.getEndTime()));
		dto.setId(imports.getId());
		dto.setStartTime(DateUtil.formatTimestamp(imports.getStartTime()));
		dto.setTotal(imports.getTotal());
		
		return dto;
		
	}
	
	public List<ImportDTO> importsListToDto(List<Imports> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<ImportDTO> list = new ArrayList<>();
		
		for(Imports i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
	}
	
	
	public PassportDTO toDto(Passport passp)
	{
		if(passp == null) return null;
		
		PassportDTO dto = new PassportDTO();
		
		dto.setAddress(passp.getAddress());
		dto.setType(passp.getType());
		dto.setCitizenship(passp.getCitizenship());
		dto.setDob(DateUtil.formatReverseDate(passp.getDob()));
		dto.setExpireDate(DateUtil.formatReverseDate(passp.getExpireDate()));
		dto.setFatherName(passp.getFatherName());
		dto.setGender(passp.getGender());
		dto.setId(passp.getId());
		dto.setIdp(passp.getIdp());
		dto.setIssueAuthority(passp.getIssueAuthority());
		dto.setIssueDate(DateUtil.formatReverseDate(passp.getIssueDate()));
		dto.setMotherName(passp.getMotherName());
		dto.setName(passp.getName());
		dto.setNationality(passp.getNationality());
		dto.setNid(passp.getNid());
		dto.setPob(passp.getPob());
		dto.setSurname(passp.getSurname());
		dto.setRid(passp.getRid());
		
		return dto;
		
	}
	
	
	public List<PassportDTO> passportListToDto(List<Passport> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<PassportDTO> list = new ArrayList<>();
		
		for(Passport i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	
	public PhoneDTO toDto(Phone entity)
	{
		if(entity == null) return null;
		
		PhoneDTO dto = new PhoneDTO();
		
		dto.setDataSource(entity.getDataSource());
		dto.setDob(entity.getDob());
		dto.setFatherName(entity.getFatherName());
		dto.setId(entity.getId());
		dto.setMotherName(entity.getMotherName());
		dto.setName(entity.getName());
		dto.setNid(entity.getNid());
		dto.setPhone(entity.getPhone());
		dto.setRegDate(entity.getRegDate());
		dto.setSurname(entity.getSurname());
		dto.setRid(entity.getRid());
		
		return dto;
		
	}
	
	public List<PhoneDTO> phoneListToDto(List<Phone> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<PhoneDTO> list = new ArrayList<>();
		
		for(Phone i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public SubjectDTO toDto(Subject entity)
	{
		if(entity == null) return null;
		
		SubjectDTO dto = new SubjectDTO();
		
		dto.setActioners(entity.getActioners());
		dto.setActivity(entity.getActivity());
		dto.setAddress(entity.getAddress());
		dto.setAdministrators(entity.getAdministrators());
		dto.setCity(entity.getCity());
		dto.setEmail(entity.getEmail());
		dto.setId(entity.getId());
		dto.setLegalForm(entity.getLegalForm());
		dto.setMainActivity(entity.getMainActivity());
		dto.setMunicipality(entity.getMunicipality());
		dto.setName(entity.getName());
		dto.setNipt(entity.getNipt());
		dto.setPhone(entity.getPhone());
		dto.setRegDate(entity.getRegDate());
		dto.setRegion(entity.getRegion());
		dto.setStatus(entity.getStatus());
		
		return dto;
		
	}
	
	public List<SubjectDTO> subjectListToDto(List<Subject> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<SubjectDTO> list = new ArrayList<>();
		
		for(Subject i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	
	
	public TatimeDTO toDto(Tatime entity)
	{
		if(entity == null) return null;
		
		TatimeDTO dto = new TatimeDTO();
		
		dto.setDob(entity.getDob());
		dto.setDrt(entity.getDrt());
		dto.setId(entity.getId());
		dto.setMonth(entity.getMonth());
		dto.setName(entity.getName());
		dto.setNid(entity.getNid());
		dto.setNipt(entity.getNipt());
		dto.setProfession(entity.getProfession());
		dto.setSalary(entity.getSalary());
		dto.setSubject(entity.getSubject());
		dto.setSurname(entity.getSurname());
		dto.setYear(entity.getYear());
		
		
		return dto;
		
	}
	
	public List<TatimeDTO> tatimeListToDto(List<Tatime> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<TatimeDTO> list = new ArrayList<>();
		
		for(Tatime i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public UserDTO toDto(User entity)
	{
		if(entity == null) return null;
		
		UserDTO dto = new UserDTO();
		
		dto.setCreatedTime(DateUtil.formatTimestamp(entity.getCreatedTime()));
		dto.setCreatedUserId(entity.getCreatedUserId());
		dto.setId(entity.getId());
		dto.setModifyTime(DateUtil.formatTimestamp(entity.getModifyTime()));
		dto.setModifyUserId(entity.getModifyUserId());
		dto.setRole(entity.getRole());
		dto.setStatus(entity.getStatus());
		dto.setUsername(entity.getUsername());
		dto.setSecret(entity.getSecret());
		
		
		return dto;
		
	}
	
	public List<UserDTO> userListToDto(List<User> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<UserDTO> list = new ArrayList<>();
		
		for(User i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	
	public TicketDTO toDto(Ticket entity)
	{
		if(entity == null) return null;
		
		TicketDTO dto = new TicketDTO();
		
		dto.setAmount(entity.getAmount());
		dto.setId(entity.getId());
		dto.setOfficer(entity.getOfficer());
		dto.setOwner(entity.getOwner());
		dto.setOwnerAddress(entity.getOwnerAddress());
		dto.setPlate(entity.getPlate());
		dto.setProducer(entity.getProducer());
		dto.setSerialNo(entity.getSerialNo());
		dto.setStatus(entity.getStatus());
		dto.setTicketDate(entity.getTicketDate());
		dto.setTicketPlace(entity.getTicketPlace());
		dto.setViolator(entity.getViolator());
		dto.setViolatorNid(entity.getViolatorNid());
		dto.setRid(entity.getRid());
		
		
		return dto;
		
	}
	
	public List<TicketDTO> ticketListToDto(List<Ticket> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<TicketDTO> list = new ArrayList<>();
		
		for(Ticket i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public VehicleDTO toDto(Vehicle entity)
	{
		if(entity == null) return null;
		
		VehicleDTO dto = new VehicleDTO();
		
		dto.setAddress(entity.getAddress());
		dto.setCapacity(entity.getCapacity());
		dto.setColor(entity.getColor());
		dto.setDrivingPermitNo(entity.getDrivingPermitNo());
		dto.setId(entity.getId());
		dto.setModel(entity.getModel());
		dto.setOwner(entity.getOwner());
		dto.setOwnerNid(entity.getOwnerNid());
		dto.setPlate(entity.getPlate());
		dto.setProducer(entity.getProducer());
		dto.setState(entity.getState());
		dto.setType(entity.getType());
		dto.setUsedFor(entity.getUsedFor());
		dto.setVin(entity.getVin());
		dto.setYear(entity.getYear());
		dto.setRid(entity.getRid());
		
		
		return dto;
		
	}
	
	public List<VehicleDTO> vehicleListToDto(List<Vehicle> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<VehicleDTO> list = new ArrayList<>();
		
		for(Vehicle i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public OsheeDTO toDto(Oshee entity)
	{
		if(entity == null) return null;
		
		OsheeDTO dto = new OsheeDTO();
		
		dto.setAdmUnit(entity.getAdmUnit());
		dto.setAppNo(entity.getAppNo());
		dto.setBuildingNo(entity.getBuildingNo());
		dto.setContractNo(entity.getContractNo());
		dto.setEntranceNo(entity.getEntranceNo());
		dto.setFamilyId(entity.getFamilyId());
		dto.setFamilyRelation(entity.getFamilyRelation());
		dto.setGeoX(entity.getGeoX());
		dto.setGeoY(entity.getGeoY());
		dto.setGeoZ(entity.getGeoZ());
		dto.setId(entity.getId());
		dto.setMunicipality(entity.getMunicipality());
		dto.setNid(entity.getNid());
		dto.setPhoneOne(entity.getPhoneOne());
		dto.setPhoneTwo(entity.getPhoneTwo());
		dto.setPhoneThree(entity.getPhoneThree());
		dto.setPostalCode(entity.getPostalCode());
		dto.setStreet(entity.getStreet());
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		dto.setFatherName(entity.getFatherName());
				
		return dto;
		
	}
	
	public List<OsheeDTO> osheeListToDto(List<Oshee> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<OsheeDTO> list = new ArrayList<>();
		
		for(Oshee i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	public LoginDTO toDto(Login l)
	{
		if(l == null) return null;
		
		LoginDTO dto = new LoginDTO();
		
		dto.setBrowser(l.getBrowser());
		dto.setId(l.getId());
		dto.setIp(l.getIp());
		dto.setLoginTime(l.getLoginTime());
		dto.setLogoutTime(l.getLogoutTime());
		dto.setToken(l.getToken());
		dto.setUserId(l.getUserId());
		dto.setUsername(l.getUsername());
		
		return dto;
		
	}
	
	public List<LoginDTO> loginListToDto(List<Login> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<LoginDTO> list = new ArrayList<>();
		
		for(Login i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}
	
	
	public BorderGateDTO toDto(BorderGate e)
	{
		if(e == null) return null;
		
		BorderGateDTO dto = new BorderGateDTO();
		dto.setId(e.getId());
		dto.setName(e.getName());
		
		return dto;
	}
	
	
	public List<BorderGateDTO> borderGateListToDto(List<BorderGate> data)
	{
		if(data == null || data.isEmpty()) return null;
		
		List<BorderGateDTO> list = new ArrayList<>();
		
		for(BorderGate i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
		
	}

	
	public AddressDTO toDto(Address e)
	{
		if(e == null) return null;
		
		AddressDTO dto = new AddressDTO();
		dto.setId(e.getId());
		dto.setName(e.getName());
		dto.setAddressId(e.getAddressId());
		dto.setAdmUnit(e.getAdmUnit());
		dto.setBuildingNo(e.getBuildingNo());
		dto.setBuildingCode(e.getBuildingCode());
		dto.setBuildingEntrance(e.getBuildingEntrance());
		dto.setBuildingId(e.getBuildingId());
		dto.setCity(e.getCity());
		dto.setEntranceId(e.getEntranceId());
		dto.setEntranceNo(e.getEntranceNo());
		dto.setMunicipality(e.getMunicipality());
		dto.setNid(e.getNid());
		dto.setStreet(e.getStreet());
		dto.setSubjectType(e.getSubjectType());
		dto.setUnitId(e.getUnitId());
		
		
		return dto;
	}

	public List<AddressDTO> addressListToDto(List<Address> data) {
		
       if(data == null || data.isEmpty()) return null;
		
		List<AddressDTO> list = new ArrayList<>();
		
		for(Address i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
	}

	
	public LiveRaportDTO toDto(LiveRaport e)
	{
		if(e == null) return null;
		
		LiveRaportDTO dto = new LiveRaportDTO();
		dto.setId(e.getId());
		dto.setDataJson(e.getDataJson());
		dto.setResponseTime(e.getResponseTime());
		dto.setKey(e.getKey());
		dto.setRequestTime(e.getRequestTime());
		dto.setStatus(e.getStatus());
		dto.setType(e.getType());
		
		
		return dto;
	}

	public List<LiveRaportDTO> liveRaportToDto(List<LiveRaport> data) {
		if(data == null || data.isEmpty()) return null;
		
		List<LiveRaportDTO> list = new ArrayList<>();
		
		for(LiveRaport i : data)
		{
			list.add(toDto(i));
		}
		
		return list;
	}
	
	
	
	
}
