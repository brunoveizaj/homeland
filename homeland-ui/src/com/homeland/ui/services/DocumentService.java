package com.homeland.ui.services;

import java.util.List;

import com.homeland.ui.api.clients.DocumentClient;
import com.homeland.ui.constants.IDocument;
import com.homeland.ui.criterias.DocumentRequest;
import com.homeland.ui.criterias.PhotoRequest;
import com.homeland.ui.models.CardDTO;
import com.homeland.ui.models.PassportDTO;
import com.homeland.ui.models.PhotoDTO;

public class DocumentService {

	
	public List<CardDTO> searchCards(DocumentRequest req)
	{
		req.setDocType(IDocument.CARD);
		return new DocumentClient().searchCards(req);
	}
	
	public List<PassportDTO> searchPassports(DocumentRequest req)
	{
		req.setDocType(IDocument.PASSPORT);
		return new DocumentClient().searchPassports(req);
	}
	
	public PhotoDTO getDocumentPhoto(PhotoRequest req)
	{
		return new DocumentClient().getDocumentPhoto(req);
	}
	
	public PhotoDTO getPersonPhoto(PhotoRequest req)
	{
		return new DocumentClient().getPersonPhoto(req);
	}
	
	
	
	
}
