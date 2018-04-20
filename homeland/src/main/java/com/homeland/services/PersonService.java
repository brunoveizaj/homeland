package com.homeland.services;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.homeland.assemblers.Assembler;
import com.homeland.assemblers.RequestAssembler;
import com.homeland.constants.IDocument;
import com.homeland.dto.BorderDTO;
import com.homeland.dto.CardDTO;
import com.homeland.dto.OsheeDTO;
import com.homeland.dto.PassportDTO;
import com.homeland.dto.PersonDTO;
import com.homeland.dto.PhoneDTO;
import com.homeland.dto.TatimeDTO;
import com.homeland.entities.Person;
import com.homeland.models.PersonRaportDTO;
import com.homeland.repositories.PersonRepository;
import com.homeland.requests.api.BorderRequest;
import com.homeland.requests.api.DocumentRequest;
import com.homeland.requests.api.OsheeRequest;
import com.homeland.requests.api.PersonRequest;
import com.homeland.requests.api.PhoneRequest;
import com.homeland.requests.api.TatimeRequest;
import com.homeland.requests.repository.PersonSQL;
import com.homeland.utils.StringUtil;

@Service
public class PersonService {

	@Autowired
	PersonRepository personDAO;
	
	@Autowired
	BorderService borderService;
	@Autowired
	TatimeService tatimeService;
	@Autowired
	DocumentService documentService;
	@Autowired
	PhoneService phoneService;
	@Autowired
	OsheeService osheeService;
	
	
	public List<PersonDTO> searchPerson(PersonRequest req)
	{
		PersonSQL criterias = new RequestAssembler().apiToSql(req);
		List<Person> persons = personDAO.searchPerson(criterias);
		return new Assembler().personListToDto(persons);
	}
	
	public PersonDTO searchPersonByNid(PersonRequest req)
	{
		if(req == null || !StringUtil.isValid(req.getNid())) return null;
		
		PersonRequest request = new PersonRequest(req.getNid());
		PersonSQL criterias = new RequestAssembler().apiToSql(request);
		
		List<Person> persons = personDAO.searchPerson(criterias);
		
		if(persons != null && !persons.isEmpty())
		{
			return new Assembler().personListToDto(persons).get(0);
		}
		
		return null;

	}
	
	public List<PersonDTO> searchPersonByFamilyId(PersonRequest req)
	{
		if(req == null || req.getFamilyId() == null) return null;
		
		PersonRequest request = new PersonRequest(req.getFamilyId());
		PersonSQL criterias = new RequestAssembler().apiToSql(request);
		
		List<Person> persons = personDAO.searchPerson(criterias);
		
		return new Assembler().personListToDto(persons);
	}
	
	public List<PersonDTO> searchPersonFamilyByNid(PersonRequest req)
	{
		if(req == null || !StringUtil.isValid(req.getNid())) return null;
		
		PersonDTO p = searchPersonByNid(req);
		if(p == null) return null;
		
		PersonRequest request = new PersonRequest(p.getFamilyId());
		
		return searchPersonByFamilyId(request);

	}
	
	
	@Async
	public CompletableFuture<List<PersonDTO>> searchAsyncPersonByFamilyId(PersonRequest req)
	{
		return CompletableFuture.completedFuture(searchPersonByFamilyId(req));
	}
	
	
	
	
	
	
	
	
	public PersonRaportDTO getPersonRaport(String nid)
	{
		
		PersonRaportDTO raport = new PersonRaportDTO();
		
		PersonDTO person = searchPersonByNid(new PersonRequest(nid));
		if(person == null) return null;
		
		PersonRequest fr = new PersonRequest(person.getFamilyId());
		CompletableFuture<List<PersonDTO>> family = searchAsyncPersonByFamilyId(fr);
		
		PhoneRequest pr = new PhoneRequest();
		pr.setNid(person.getNid());
		CompletableFuture<List<PhoneDTO>> phones = phoneService.searchAsyncPhone(pr);
		
		DocumentRequest dr = new DocumentRequest();
		dr.setNid(person.getNid());
		dr.setDocType(IDocument.CARD);
		CompletableFuture<List<CardDTO>> cards = documentService.searchAsyncCard(dr);
		
		dr = new DocumentRequest();
		dr.setNid(person.getNid());
		dr.setDocType(IDocument.PASSPORT);
		CompletableFuture<List<PassportDTO>> passports = documentService.searchAsyncPassport(dr);
		
		BorderRequest br = new BorderRequest();
		br.setNid(person.getNid());
		CompletableFuture<List<BorderDTO>> borders = borderService.searchAsyncEntryExit(br);
		
		TatimeRequest tr = new TatimeRequest();
		tr.setNid(person.getNid());
		CompletableFuture<List<TatimeDTO>> tatime = tatimeService.searchAsyncTatime(tr);
		
		OsheeRequest or = new OsheeRequest();
		or.setFamilyId(person.getFamilyId());
		CompletableFuture<List<OsheeDTO>> oshees = osheeService.searchAsyncOshee(or);
		
		CompletableFuture.allOf(family,phones,cards,passports,borders,tatime,oshees).join();

		try {
			raport.setBorders(borders.get());
			raport.setCards(cards.get());
			raport.setFamily(family.get());
			raport.setOshees(oshees.get());
			raport.setPassports(passports.get());
			raport.setPerson(person);
			raport.setPhones(phones.get());
			raport.setTatime(tatime.get());
		} catch (InterruptedException | ExecutionException e) {
			System.err.println("INTERRUPTION EXCEPTION: PERSON RAPORT");
			e.printStackTrace();
		}
		
		return raport;
		
	}
	
	
	
	
}
