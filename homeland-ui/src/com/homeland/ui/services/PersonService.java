package com.homeland.ui.services;

import java.util.List;

import com.homeland.ui.api.clients.PersonClient;
import com.homeland.ui.criterias.PersonRequest;
import com.homeland.ui.models.PersonDTO;
import com.homeland.ui.models.PersonRaportDTO;

public class PersonService {

	public List<PersonDTO> searchPerson(PersonRequest req)
	{
		return new PersonClient().searchPerson(req);
	}
	
	public PersonRaportDTO personRaport(String nid)
	{
		return new PersonClient().personRaport(nid);
	}
	
	
	
	
}
