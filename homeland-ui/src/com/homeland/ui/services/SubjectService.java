package com.homeland.ui.services;

import java.util.List;

import com.homeland.ui.api.clients.SubjectClient;
import com.homeland.ui.criterias.SubjectRequest;
import com.homeland.ui.models.SubjectDTO;

public class SubjectService {

	public List<SubjectDTO> searchSubject(SubjectRequest req)
	{
		return new SubjectClient().searchSubject(req);
	}
	
	public SubjectDTO getSubjectByNipt(String nipt)
	{
		return new SubjectClient().getSubjectByNipt(nipt);
	}
	
}
