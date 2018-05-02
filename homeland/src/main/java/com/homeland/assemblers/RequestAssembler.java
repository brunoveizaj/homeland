package com.homeland.assemblers;

import com.homeland.requests.api.BorderRequest;
import com.homeland.requests.api.DocumentRequest;
import com.homeland.requests.api.OsheeRequest;
import com.homeland.requests.api.PersonRequest;
import com.homeland.requests.api.PhoneRequest;
import com.homeland.requests.api.PhotoRequest;
import com.homeland.requests.api.SubjectRequest;
import com.homeland.requests.api.TatimeRequest;
import com.homeland.requests.api.TicketRequest;
import com.homeland.requests.api.UserRequest;
import com.homeland.requests.api.VehicleRequest;
import com.homeland.requests.repository.BorderSQL;
import com.homeland.requests.repository.DocumentSQL;
import com.homeland.requests.repository.OsheeSQL;
import com.homeland.requests.repository.PersonSQL;
import com.homeland.requests.repository.PhoneSQL;
import com.homeland.requests.repository.PhotoSQL;
import com.homeland.requests.repository.SubjectSQL;
import com.homeland.requests.repository.TatimeSQL;
import com.homeland.requests.repository.TicketSQL;
import com.homeland.requests.repository.UserSQL;
import com.homeland.requests.repository.VehicleSQL;
import com.homeland.utils.DateUtil;

public class RequestAssembler {

	
	
	public PersonSQL apiToSql(PersonRequest req)
	{
		PersonSQL sql = new PersonSQL();
				
		if(req != null)
		{
			System.err.println("ASSEMBLER: req "+req);
			
			sql.setDob(DateUtil.toReverseDate(req.getDob()));
			sql.setFamilyId(req.getFamilyId());
			sql.setFatherName(req.getFatherName());
			if(req.getFromAge() != null)
			{
				sql.setToDob(DateUtil.getDobReverse(req.getFromAge()));
			}
			if(req.getToAge() != null)
			{
				sql.setFromDob(DateUtil.getDobReverse(req.getToAge()));
			}
			sql.setGender(req.getGender());
			sql.setMaidenName(req.getMaidenName());
			sql.setMotherName(req.getMotherName());
			sql.setMunicipality(req.getMunicipality());
			sql.setName(req.getName());
			sql.setNid(req.getNid());
			sql.setPob(req.getPob());
			sql.setRegion(req.getRegion());
			sql.setSurname(req.getSurname());
			sql.setUnit(req.getUnit());
			sql.setFirstResult(req.getFirstResult());
			sql.setMaxResult(req.getMaxResult());
		}
		
		System.err.println("ASSEMBLER SQL: "+sql);
		
		return sql;
	}
	
	public DocumentSQL apiToSql(DocumentRequest req)
	{
		DocumentSQL sql = new DocumentSQL();
		
		if(req != null)
		{
			
			sql.setDocType(req.getDocType());
			sql.setIdn(req.getIdn());
			sql.setDob(DateUtil.toReverseDate(req.getDob()));
			sql.setFatherName(req.getFatherName());
			if(req.getFromAge() != null)
			{
				sql.setToDob(DateUtil.getDobReverse(req.getFromAge()));
			}
			if(req.getToAge() != null)
			{
				sql.setFromDob(DateUtil.getDobReverse(req.getToAge()));
			}
			sql.setGender(req.getGender());
			sql.setMotherName(req.getMotherName());
			sql.setName(req.getName());
			sql.setNid(req.getNid());
			sql.setSurname(req.getSurname());
			sql.setFirstResult(req.getFirstResult());
			sql.setMaxResult(req.getMaxResult());
			
		}
		
		return sql;
	}
	
	public PhotoSQL apiToSql(PhotoRequest req)
	{
		PhotoSQL sql = new PhotoSQL();
		
		if(req != null)
		{
			
			sql.setDocType(req.getDocType());
			sql.setIdn(req.getIdn());
			sql.setNid(req.getNid());
			sql.setFirstResult(req.getFirstResult());
			sql.setMaxResult(req.getMaxResult());
			
		}
		
		return sql;
	}
	
	public PhoneSQL apiToSql(PhoneRequest req)
	{
		PhoneSQL sql = new PhoneSQL();
		
		if(req != null)
		{
			
			sql.setFatherName(req.getFatherName());
			sql.setName(req.getName());
			sql.setSurname(req.getSurname());
			sql.setNid(req.getNid());
			sql.setPhoneNo(req.getPhoneNo());
			sql.setFirstResult(req.getFirstResult());
			sql.setMaxResult(req.getMaxResult());
			
		}
		
		return sql;
	}
	
	public TatimeSQL apiToSql(TatimeRequest req)
	{
		TatimeSQL sql = new TatimeSQL();
		
		if(req != null)
		{
			
			sql.setName(req.getName());
			sql.setSurname(req.getSurname());
			sql.setNid(req.getNid());
			sql.setNipt(req.getNipt());
			sql.setYear(req.getYear());
			sql.setMonth(req.getMonth());
			sql.setFirstResult(req.getFirstResult());
			sql.setMaxResult(req.getMaxResult());
			
		}
		
		return sql;
	}
	
	public SubjectSQL apiToSql(SubjectRequest req)
	{
		SubjectSQL sql = new SubjectSQL();
		
		if(req != null)
		{
			
			sql.setName(req.getName());
			sql.setNipt(req.getNipt());
			sql.setManagers(req.getManagers());
			sql.setFirstResult(req.getFirstResult());
			sql.setMaxResult(req.getMaxResult());
			
		}
		
		return sql;
	}
	
	
	public VehicleSQL apiToSql(VehicleRequest req)
	{
		VehicleSQL sql = new VehicleSQL();
		
		if(req != null)
		{
			
			sql.setColor(req.getColor());
			sql.setModel(req.getModel());
			sql.setOwner(req.getName(), req.getFatherName(), req.getSurname());
			sql.setPlate(req.getPlate());
			sql.setProducer(req.getProducer());
			sql.setVin(req.getVin());
			sql.setFirstResult(req.getFirstResult());
			sql.setMaxResult(req.getMaxResult());
			
		}
		
		return sql;
	}
	
	public UserSQL apiToSql(UserRequest req)
	{
		UserSQL sql = new UserSQL();
		
		if(req != null)
		{
			
			sql.setUsername(req.getUsername());
			sql.setRole(req.getRole());
			sql.setStatus(req.getStatus());
			sql.setFirstResult(req.getFirstResult());
			sql.setMaxResult(req.getMaxResult());
			
		}
		
		return sql;
	}
	
	public TicketSQL apiToSql(TicketRequest req)
	{
		TicketSQL sql = new TicketSQL();
		
		if(req != null)
		{
			
			sql.setPlate(req.getPlate());
			sql.setSerialNo(req.getSerialNo());
			sql.setStatus(req.getStatus());
			sql.setVin(req.getVin());
			sql.setViolatorNid(req.getViolatorNid());
			sql.setFirstResult(req.getFirstResult());
			sql.setMaxResult(req.getMaxResult());
			
		}
		
		return sql;
	}
	
	public BorderSQL apiToSql(BorderRequest req)
	{
		BorderSQL sql = new BorderSQL();
		
		if(req != null)
		{
			
			sql.setPlate(req.getPlate());
			sql.setBcgId(req.getBcgId());
			sql.setDocNo(req.getDocNo());
			sql.setEvent(req.getEvent());
			sql.setFatherName(req.getFatherName());
			sql.setFrom(DateUtil.toDate(req.getFrom()));
			sql.setTo(DateUtil.toDate(req.getTo()));
			sql.setName(req.getName());
			sql.setNid(req.getNid());
			sql.setSurname(req.getSurname());
			sql.setVin(req.getVin());
			sql.setFirstResult(req.getFirstResult());
			sql.setMaxResult(req.getMaxResult());
			
		}
		
		return sql;
	}
	
	public OsheeSQL apiToSql(OsheeRequest req)
	{
		OsheeSQL sql = new OsheeSQL();
		
		if(req != null)
		{
			
			sql.setContractNo(req.getContractNo());
			sql.setFamilyId(req.getFamilyId());
			sql.setNid(req.getNid());
			sql.setFirstResult(req.getFirstResult());
			sql.setMaxResult(req.getMaxResult());
			
		}
		
		return sql;
	}
	
	
	
}
