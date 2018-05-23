package com.homeland.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeland.assemblers.Assembler;
import com.homeland.assemblers.RequestAssembler;
import com.homeland.dto.SubjectDTO;
import com.homeland.entities.Subject;
import com.homeland.repositories.SubjectRepository;
import com.homeland.requests.api.SubjectRequest;
import com.homeland.requests.repository.SubjectSQL;
import com.homeland.utils.StringUtil;

@Service
public class SubjectService {

	
	@Autowired
	SubjectRepository subjectDAO;
	
	public List<SubjectDTO> searchSubject(SubjectRequest req, Integer userId)
	{
		SubjectSQL criterias = new RequestAssembler().apiToSql(req);
		List<Subject> persons = subjectDAO.searchSubject(criterias);
		return new Assembler().subjectListToDto(persons);
	}
	
	public SubjectDTO getSubjectByNipt(String nipt, Integer userId)
	{
		if(!StringUtil.isValid(nipt)) return null;
		
		SubjectRequest request = new SubjectRequest(nipt);
		SubjectSQL criterias = new RequestAssembler().apiToSql(request);
		
		List<Subject> persons = subjectDAO.searchSubject(criterias);
		
		if(persons != null && !persons.isEmpty())
		{
			return new Assembler().subjectListToDto(persons).get(0);
		}
		
		return null;

	}
	
	
	
	
	
	
	
}
