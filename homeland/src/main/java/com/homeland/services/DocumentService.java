package com.homeland.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.homeland.assemblers.Assembler;
import com.homeland.assemblers.RequestAssembler;
import com.homeland.constants.IDocument;
import com.homeland.dto.CardDTO;
import com.homeland.dto.PassportDTO;
import com.homeland.dto.PhotoDTO;
import com.homeland.entities.Card;
import com.homeland.entities.Passport;
import com.homeland.entities.PhotoCard;
import com.homeland.entities.PhotoPassport;
import com.homeland.repositories.CardRepository;
import com.homeland.repositories.PassportRepository;
import com.homeland.requests.api.DocumentRequest;
import com.homeland.requests.api.PhotoRequest;
import com.homeland.requests.repository.DocumentSQL;
import com.homeland.requests.repository.PhotoSQL;
import com.homeland.utils.CalculatorUtil;
import com.homeland.utils.StringUtil;

@Service
public class DocumentService {
	
	
	@Autowired 
	CardRepository cardDAO;
	@Autowired 
	PassportRepository passportDAO;
	
	
	public List<CardDTO> searchCard(DocumentRequest req, Integer userId)
	{
		DocumentSQL criterias = new RequestAssembler().apiToSql(req);
		List<Card> cards = cardDAO.searchCard(criterias);
		return new Assembler().cardListToDto(cards);
	}
	
	public List<PassportDTO> searchPassport(DocumentRequest req, Integer userId)
	{
		DocumentSQL criterias = new RequestAssembler().apiToSql(req);
		List<Passport> passports = passportDAO.searchPassport(criterias);
		return new Assembler().passportListToDto(passports);
	}
	
	public PhotoDTO getDocumentPhoto(PhotoRequest req, Integer userId)
	{		
		PhotoSQL criterias = new RequestAssembler().apiToSql(req);
		
		String idn = criterias.getIdn();
		
		if(StringUtil.isValid(idn))
		{
			idn = idn.toUpperCase();
			idn = CalculatorUtil.enca(idn);
			criterias.setIdn(idn);
		}
		
		if(req.getDocType().equals(IDocument.CARD))
		{
			criterias.setMaxResult(1);
			List<PhotoCard> photos = cardDAO.searchPhoto(criterias);
			if(photos != null && !photos.isEmpty())
			{
			   return new Assembler().toDto(photos.get(0));
			}
		}
		
		else if(req.getDocType().equals(IDocument.PASSPORT))
		{
			criterias.setMaxResult(1);
			List<PhotoPassport> photos = passportDAO.searchPhoto(criterias);
			if(photos != null && !photos.isEmpty())
			{
			   return new Assembler().toDto(photos.get(0));
			}
		}
		
		return null;
		
	}
	
	
	@Async
	public CompletableFuture<List<CardDTO>> searchAsyncCard(DocumentRequest req, Integer userId)
	{
		return CompletableFuture.completedFuture(searchCard(req, userId));
	}
	
	@Async
	public CompletableFuture<List<PassportDTO>> searchAsyncPassport(DocumentRequest req, Integer userId)
	{
		return CompletableFuture.completedFuture(searchPassport(req, userId));
	}
	
	
	
	

}
