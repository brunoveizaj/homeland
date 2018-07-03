package com.homeland.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.homeland.assemblers.Assembler;
import com.homeland.dto.ImportDTO;
import com.homeland.dto.LoginDTO;
import com.homeland.entities.Card;
import com.homeland.entities.Person;
import com.homeland.models.EntityCounter;
import com.homeland.repositories.ImportRepository;
import com.homeland.repositories.StatisticRepository;

@Service
public class StatisticService {
	
	
	@Autowired
	ImportRepository importDAO;
	@Autowired 
	StatisticRepository statDAO;
	
	
	
	public List<ImportDTO> getLastImports(Integer limit)
	{
		return new Assembler().importsListToDto(importDAO.getLastImports(limit));
	}
	
	public List<LoginDTO> logins(Integer limit)
	{
		return new Assembler().loginListToDto(statDAO.listLogins(limit));
	}
	
	
	public Long countAll(Class<?> T)
	{
		return statDAO.countAll(T);
	}
	
	public Long countToday(Class<?> T)
	{
		return statDAO.countToday(T);
	}
	
	public EntityCounter getEntityCounter(Class<?> T)
	{
		EntityCounter e = new EntityCounter();
		e.setT(T);
		
		e.setTotalCnt(countAll(T));
		e.setTodayCnt(countToday(T));
		
		return e;
		
	}
	
	@Async
	public CompletableFuture<EntityCounter> getAsyncEntityCounter(Class<?> T)
	{		
		return CompletableFuture.completedFuture(getEntityCounter(T));
	}
	
	
	public List<EntityCounter> getEntityStatistics()
	{		
		CompletableFuture<EntityCounter> person = getAsyncEntityCounter(Person.class);
		CompletableFuture<EntityCounter> card = getAsyncEntityCounter(Card.class);
		//....
		
		
		CompletableFuture.allOf(person,card).join();
		
		List<EntityCounter> list = new ArrayList<>();
		try {
			list.add(person.get());
			list.add(card.get());
			//.....
			
		} catch (InterruptedException | ExecutionException e) {
			System.err.println("INTERRUPTION EXCEPTION: ENTITY STATISTIC");
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
}
