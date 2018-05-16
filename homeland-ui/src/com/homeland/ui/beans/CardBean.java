package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.criterias.DocumentRequest;
import com.homeland.ui.models.CardDTO;
import com.homeland.ui.services.DocumentService;


@ManagedBean
@ViewScoped
public class CardBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	DocumentRequest request;
	List<CardDTO> cards;
	

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
	
	
	
	@PostConstruct
	public void load()
	{
		init();
	}
	
	public void init()
	{
		this.request = new DocumentRequest();
		this.cards = null;
	}
	
	public void search()
	{
		this.cards = new DocumentService().searchCards(request);
	}
	
	public void clear()
	{
		init();
	}
	
	
	

}
