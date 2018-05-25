package com.homeland.repositories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.homeland.entities.Border;
import com.homeland.requests.repository.BorderSQL;
import com.homeland.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class BorderRepository {
	
	@PersistenceContext
	EntityManager em;
	
	
	public Border create(Border b)
	{
		em.persist(b);
		em.flush();
		return b;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public List<Border> searchEntryExit(BorderSQL criterias)
	{
		
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM Border b WHERE 1=1 ";
		String order = "ORDER BY b.crossingDate desc";
		
		if(StringUtil.isValid(criterias.getBcgId()))
		{
			sql += "AND b.bcgId=:bcgid ";
			params.put("bcgid", criterias.getBcgId());
		}
		
		if(StringUtil.isValid(criterias.getDocNo()))
		{
			sql += "AND b.docNo LIKE :docno ";
			params.put("docno", criterias.getDocNo());
		}
		
		if(StringUtil.isValid(criterias.getEvent()))
		{
			sql += "AND b.docNo=:event ";
			params.put("event", criterias.getEvent());
		}
		
		if(StringUtil.isValid(criterias.getPlate()))
		{
			sql += "AND b.plate LIKE :plate ";
			params.put("plate", criterias.getPlate());
		}
		
		if(criterias.getFrom() != null)
		{
			sql += "AND b.crossingDate >= :from ";
			params.put("from", criterias.getFrom());
		}
		
		if(criterias.getTo() != null)
		{
			sql += "AND b.crossingDate >= :to ";
			params.put("to", criterias.getTo());
		}
		
		if(criterias.getForeign() != null)
		{
			sql += "AND b.foreign = :for ";
			params.put("for", criterias.getForeign());
		}
		
		if(StringUtil.isValid(criterias.getFatherName()))
		{
			sql += "AND b.fatherName LIKE :fn ";
			params.put("fn", criterias.getFatherName());
		}
		
		if(StringUtil.isValid(criterias.getName()))
		{
			sql += "AND b.name LIKE :name ";
			params.put("name", criterias.getName());
		}

		if(StringUtil.isValid(criterias.getNid()))
		{
			sql += "AND b.nid LIKE :nid ";
			params.put("nid", criterias.getNid());
		}		
		
		if(StringUtil.isValid(criterias.getSurname()))
		{
			sql += "AND b.surname LIKE :surname ";
			params.put("surname", criterias.getSurname());
		}

		if(StringUtil.isValid(criterias.getVin()))
		{
			sql = "SELECT b FROM Border b JOIN Vehicle v on b.plate=v.plate WHERE v.vin LIKE :vin ";
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
	

}
