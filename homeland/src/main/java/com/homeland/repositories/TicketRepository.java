package com.homeland.repositories;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.homeland.entities.Ticket;
import com.homeland.requests.repository.TicketSQL;
import com.homeland.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class TicketRepository {

	
	@PersistenceContext
	EntityManager em;
	
	
	public Ticket create(Ticket t)
	{
		em.persist(t);
		em.flush();
		return t;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public List<Ticket> searchTicket(TicketSQL criterias)
	{
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM Ticket t WHERE 1=1 ";
		String order = "ORDER BY t.ticketDate desc";

		
		if(StringUtil.isValid(criterias.getPlate()))
		{
			sql += "AND t.plate LIKE :plate ";
			params.put("plate", criterias.getPlate());
		}
		
		if(StringUtil.isValid(criterias.getViolatorNid()))
		{
			sql += "AND t.violatorNid LIKE :vnid ";
			params.put("vnid", criterias.getViolatorNid());
		}
		
		if(StringUtil.isValid(criterias.getStatus()))
		{
			sql += "AND t.status = :st ";
			params.put("st", criterias.getStatus());
		}
		
		if(StringUtil.isValid(criterias.getSerialNo()))
		{
			sql += "AND t.serialNo = :serial ";
			params.put("serial", criterias.getSerialNo());
		}
		
		if(StringUtil.isValid(criterias.getVin()))
		{
			sql = "SELECT t FROM Ticket t JOIN Vehicle v ON t.plate=v.plate WHERE v.vin=:vin ";
			params.put("vin", criterias.getVin());
		}
		
		
		sql += order;
		
		
		Query q = em.createQuery(sql);
		Iterator it = params.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry) it.next();
			q.setParameter((String) pair.getKey(), pair.getValue());
			it.remove();
		}
		
		
		if(criterias.getFirstResult() != null)
		{
			q.setFirstResult(criterias.getFirstResult());
		}
		
		if(criterias.getMaxResult() != null)
		{
			q.setMaxResults(criterias.getMaxResult());
		}
		
		
		
		return q.getResultList();
	}
	
	
	public Date lastDate()
	{
		return (Date)em.createQuery("SELECT MAX(t.timsRecDate) FROM Ticket t")
				.getSingleResult();
	}
	
	
	
	
}
