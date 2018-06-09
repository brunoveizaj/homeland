package com.homeland.repositories;


import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class StatisticRepository {
	
	
	@PersistenceContext
	EntityManager em;
	
	
	public Long countAll(Class<?> T)
	{
		return (Long) em.createQuery("SELECT COUNT(t) FROM "+T.getName()+" t").getSingleResult();
	}
	
	public Long countToday(Class<?> T)
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		return (Long) em.createQuery("SELECT COUNT(t) FROM "+T.getName()+" t WHERE t.insertDate>=:today")
				.setParameter("today", c.getTime())
				.getSingleResult();
	}
	
	

}
