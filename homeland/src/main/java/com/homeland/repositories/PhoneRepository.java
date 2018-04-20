package com.homeland.repositories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.homeland.entities.Phone;
import com.homeland.requests.repository.PhoneSQL;
import com.homeland.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class PhoneRepository {

	
	
	@PersistenceContext
	EntityManager em;
	
	
	
	@SuppressWarnings("rawtypes")
	public List<Phone> searchPhone(PhoneSQL criterias)
	{
		
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM Phone p WHERE 1=1 ";
		String order = "ORDER BY p.nid,p.name,p.surname";

		
		if(StringUtil.isValid(criterias.getFatherName()))
		{
			sql += "AND p.fatherName LIKE :fn ";
			params.put("fn", criterias.getFatherName());
		}
		
		if(StringUtil.isValid(criterias.getName()))
		{
			sql += "AND p.name LIKE :name ";
			params.put("name", criterias.getName());
		}

		if(StringUtil.isValid(criterias.getNid()))
		{
			sql += "AND p.nid LIKE :nid ";
			params.put("nid", criterias.getNid());
		}
		
		if(StringUtil.isValid(criterias.getSurname()))
		{
			sql += "AND p.surname LIKE :surname ";
			params.put("surname", criterias.getSurname());
		}
		
		if(StringUtil.isValid(criterias.getPhoneNo()))
		{
			sql += "AND p.phone LIKE :phone ";
			params.put("phone", criterias.getPhoneNo()+"%");
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
