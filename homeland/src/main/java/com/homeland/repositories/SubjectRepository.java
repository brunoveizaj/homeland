package com.homeland.repositories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.homeland.entities.Subject;
import com.homeland.requests.repository.SubjectSQL;
import com.homeland.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class SubjectRepository {

	
	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("rawtypes")
	public List<Subject> searchSubject(SubjectSQL criterias)
	{
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM Subject s WHERE 1=1 ";
		String order = "ORDER BY s.name";

		if(StringUtil.isValid(criterias.getNipt()))
		{
			sql += "AND s.nipt LIKE :nipt ";
			params.put("nipt", criterias.getNipt());
		}
		
		if(StringUtil.isValid(criterias.getName()))
		{
			sql += "AND s.name LIKE :name ";
			params.put("name", criterias.getName());
		}
		
		if(StringUtil.isValid(criterias.getManagers()))
		{
			sql += "AND s.extraSx LIKE :ext ";
			params.put("ext", "%"+criterias.getManagers()+"%");
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
