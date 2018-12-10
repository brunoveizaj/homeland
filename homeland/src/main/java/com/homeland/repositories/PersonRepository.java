package com.homeland.repositories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.homeland.entities.Person;
import com.homeland.requests.repository.PersonSQL;
import com.homeland.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class PersonRepository {

	@PersistenceContext
	EntityManager em;
	
	
	@SuppressWarnings("rawtypes")
	public List<Person> searchPerson(PersonSQL criterias)
	{
		
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM Person p WHERE 1=1 ";
		String order = "ORDER BY p.nid";
		
		if(StringUtil.isValid(criterias.getDob()))
		{
			sql += "AND p.dob=:dob ";
			params.put("dob", criterias.getDob());
		}
		
		if(StringUtil.isValid(criterias.getFatherName()))
		{
			sql += "AND p.fatherNameSx LIKE :fn ";
			params.put("fn", criterias.getFatherName());
		}
		
		if(StringUtil.isValid(criterias.getFromDob()))
		{
			sql += "AND p.dob>=:fdob ";
			params.put("fdob", criterias.getFromDob());
		}
		
		if(StringUtil.isValid(criterias.getGender()))
		{
			sql += "AND p.gender=:gender ";
			params.put("gender", criterias.getGender());
		}
		
		if(StringUtil.isValid(criterias.getMaidenName()))
		{
			sql += "AND p.maidenNameSx LIKE :maiden ";
			params.put("maiden", criterias.getMaidenName());
		}
		
		if(StringUtil.isValid(criterias.getMotherName()))
		{
			sql += "AND p.motherNameSx LIKE :mn ";
			params.put("mn", criterias.getMotherName());
		}
		
		if(StringUtil.isValid(criterias.getMunicipality()))
		{
			sql += "AND p.municipality LIKE :municip ";
			params.put("municip", criterias.getMunicipality());
		}
		
		if(StringUtil.isValid(criterias.getName()))
		{
			sql += "AND p.nameSx LIKE :name ";
			params.put("name", criterias.getName());
		}

		if(StringUtil.isValid(criterias.getNid()))
		{
			sql += "AND p.nid LIKE :nid ";
			params.put("nid", criterias.getNid());
		}
		
		if(StringUtil.isValid(criterias.getPob()))
		{
			sql += "AND p.pob LIKE :pob ";
			params.put("pob", criterias.getPob());
		}
		
		if(StringUtil.isValid(criterias.getRegion()))
		{
			sql += "AND p.region LIKE :region ";
			params.put("region", criterias.getRegion());
		}
		
		if(StringUtil.isValid(criterias.getSurname()))
		{
			sql += "AND p.surnameSx LIKE :surname ";
			params.put("surname", criterias.getSurname());
		}
		
		if(StringUtil.isValid(criterias.getToDob()))
		{
			sql += "AND p.dob<=:tdob ";
			params.put("tdob", criterias.getToDob());
		}
		
		if(StringUtil.isValid(criterias.getUnit()))
		{
			sql += "AND p.unit LIKE :unit ";
			params.put("unit", criterias.getUnit());
		}
		
		if(criterias.getFamilyId() != null)
		{
			sql += "AND p.familyId=:fid ";
			params.put("fid", criterias.getFamilyId());
			order = "ORDER BY p.familyRowId";
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
