package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.constants.IDocument;
import com.homeland.ui.criterias.DocumentRequest;
import com.homeland.ui.models.CardDTO;
import com.homeland.ui.services.DocumentService;
import com.homeland.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class CardBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	DocumentRequest request;
	List<CardDTO> cards;
	CardDTO selectedCard;
	

	
	
	public DocumentRequest getRequest() {
		return request;
	}

	public void setRequest(DocumentRequest request) {
		this.request = request;
	}

	public List<CardDTO> getCards() {
		return cards;
	}

	public void setCards(List<CardDTO> cards) {
		this.cards = cards;
	}

	public CardDTO getSelectedCard() {
		return selectedCard;
	}

	public void setSelectedCard(CardDTO selectedCard) {
		this.selectedCard = selectedCard;
	}
	
	
	
	

	@PostConstruct
	public void load()
	{
		init();
	}
	
	public void init()
	{
		this.request = new DocumentRequest(IDocument.CARD);
		this.cards = null;
		this.selectedCard = null;
	}
	
	
	public void search()
	{
		try {
			this.selectedCard = null;
			this.cards = new DocumentService().searchCards(request);
			if(cards == null || cards.isEmpty())
			{
				Messages.throwFacesMessage("Nuk u gjet asnje karte", 2);
			}
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
			this.cards = null;			
		}
	}
	
	public void clear()
	{
		init();
	}
	
	

}
