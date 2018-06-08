package com.homeland.repositories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.homeland.entities.Oshee;
import com.homeland.requests.repository.OsheeSQL;
import com.homeland.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class OsheeRepository {

	
	@PersistenceContext
	EntityManager em;
	
	
	
	@SuppressWarnings("rawtypes")
	public List<Oshee> searchOshee(OsheeSQL criterias)
	{
		HashMap<String,Object> params = new HashMap<>();
		String sql = "SELECT new com.homeland.entities.Oshee(o,p.name,p.surname,p.fatherName) FROM Oshee o LEFT JOIN Person p on o.nid=p.nid WHERE 1=1 ";
		String order = "ORDER BY o.contractNo ";
		
		if(StringUtil.isValid(criterias.getContractNo()))
		{
			sql += "AND o.contractNo LIKE :cno ";
			params.put("cno", criterias.getContractNo());
		}
		
		if(StringUtil.isValid(criterias.getNid()))
		{
			sql += "AND o.nid LIKE :nid ";
			params.put("nid", criterias.getNid());
		}
		
		if(criterias.getFamilyId() != null)
		{
			sql += "AND o.familyId=:fid ";
			params.put("fid", criterias.getFamilyId());
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
