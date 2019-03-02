package com.homeland.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homeland.assemblers.Assembler;
import com.homeland.assemblers.RequestAssembler;
import com.homeland.dto.PhoneDTO;
import com.homeland.entities.EaglePhone;
import com.homeland.entities.Phone;
import com.homeland.repositories.PersonRepository;
import com.homeland.repositories.PhoneRepository;
import com.homeland.requests.api.PhoneRequest;
import com.homeland.requests.repository.PhoneSQL;
import com.homeland.utils.DateUtil;
import com.homeland.utils.StringUtil;

@Service
public class PhoneService {

	
	@Autowired
	PhoneRepository phoneDAO;
	@Autowired
	PersonRepository perDAO;
	
	public List<PhoneDTO> searchPhone(PhoneRequest req, Integer userId)
	{
		PhoneSQL criterias = new RequestAssembler().apiToSql(req);
		List<Phone> phones = phoneDAO.searchPhone(criterias);
		return new Assembler().phoneListToDto(phones);
	}
	
	
	@Async
	public CompletableFuture<List<PhoneDTO>> searchAsyncPhone(PhoneRequest req, Integer userId)
	{
		return CompletableFuture.completedFuture(searchPhone(req,userId));
	}
	
	
	
	//@Async
	//@Transactional
	//@Scheduled(cron="0 48 22 * * *")
	public void startUpdateEagle()
	{
		int start = 11148619;
		int limit = 50000;
		boolean cont = true;
		
		
		while(cont)
		{
			System.out.println("Start="+start+ ":" + "Limit="+limit );
			
			List<EaglePhone> list = phoneDAO.loadEagle(start, limit);
			
			cont = (list != null && !list.isEmpty());
			
			if(cont) 
			{
				for(EaglePhone e : list)
				{											
					/*	if(StringUtil.isValid(e.getNid()))
						{
							PersonSQL sql = new PersonSQL();
							sql.setNid(e.getNid());
							List<Person> perList = perDAO.searchPerson(sql);
							if(perList != null && !perList.isEmpty() && perList.size() == 1)
							{
								Person one = perList.get(0);
								
								Phone p = new Phone();
								
								p.setDataSource("VDF");
								p.setDob(DateUtil.formatReverseDate(one.getDob()));
								p.setFatherName(one.getFatherNameSx());
								p.setInserted(new Date());
								p.setMotherName(one.getMotherNameSx());
								p.setName(one.getNameSx());
								p.setNid(one.getNid());
								p.setPhone(e.getPhone());
								p.setRegDate(DateUtil.formatDate(new Date()));
								p.setSurname(one.getSurnameSx());
								
								p = registerPhone(p);
								e.setDob(one.getDob());
								phoneDAO.updateCommit(e);
								if(p!=null)
								System.out.println("Phone create: "+p.getPhone()+"  NID="+p.getNid() );
							}
						}	*/
					
				    	System.out.println("NAME: "+e.getName());
				    	if(StringUtil.isValid(e.getName()) && e.getName().length() > 4)
				    	{
				    		Phone p = new Phone();

							String[] names = e.getName().replace("  ", " ").split(" ");
							
							if(names != null && names.length == 3)
							{
									p.setName(names[0]);
									p.setFatherName(names[1]);
									p.setSurname(names[2]);			
									System.err.println(names[0] + "-"+names[1]+"-"+names[2]);
							}
							else if(names != null && names.length == 2)
							{
								p.setName(names[0]);
								p.setSurname(names[1]);		
								
								System.err.println(names[0] + " - "+names[1]);
							}
														
									
									p.setDataSource("VDF");
									p.setInserted(new Date());
									p.setPhone(e.getPhone());
									p.setRegDate(DateUtil.formatDate(new Date()));
									
									p = registerPhone(p);
									phoneDAO.updateCommit(e);
									if(p!=null)
									System.out.println("Phone create: "+p.getPhone()+"  NID="+p.getNid() );
								
							}
				    	
					start = e.getId();
					
					System.out.println(start);
				}
			}
			
		}
		
		
		
	}
	
	@Transactional
	public Phone registerPhone(Phone phone)
    {
        try{
        String no = phone.getPhone();
        
        
        if(!StringUtil.isValid(no))
        {
            return null;
        }
        

        
        no = no.replace(" ", "").replace("+", "").replace("-", "").replace(".", "").replace(",", "").replace("'", "").replace("\"", "")
                .replace("*", "").replace("!", "").replace("?", "").replace("#", "").replace("%", "").replace("None", "");
        
        
        if(no.length()<6)
        {
            return null;
        }
        
        try {
            if (BigDecimal.ZERO == new BigDecimal(no)) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
        
        if((no.startsWith("0035569") || no.startsWith("0035568") || no.startsWith("0035567") || no.startsWith("0035566")) && no.length()>13)
        {
            no = "0" + no.substring("00355".length());
        }
        else if((no.startsWith("035569") || no.startsWith("035568") || no.startsWith("035567") || no.startsWith("035566")) && no.length()>12)
        {
            no = "0" + no.substring("0355".length());
        }
        else if((no.startsWith("35569") || no.startsWith("35568") || no.startsWith("35567") || no.startsWith("35566")) && no.length()>11)
        {
            no = "0" + no.substring("355".length());
        }
        
        else if((no.startsWith("00355069") || no.startsWith("00355068") || no.startsWith("00355067") || no.startsWith("00355066")) && no.length()>14)
        {
            no = "0" + no.substring("003550".length());
        }
        else if((no.startsWith("69") || no.startsWith("68") || no.startsWith("67") || no.startsWith("66")) && no.length()>8)
        {
            no = "0"+no;
        }
        
        phone.setPhone(no);
        
        return phoneDAO.createCommit(phone);
        
        }catch(Exception e){System.out.print("EXCEPTION \n");e.printStackTrace();}
        
        return null;
        
    }
    
	
	
}
