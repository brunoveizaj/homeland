package com.homeland.repositories;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.homeland.entities.Address;
import com.homeland.requests.repository.AddressSQL;
import com.homeland.utils.StringUtil;



@Repository
@SuppressWarnings("unchecked")
public class AddressRepository {
	
	@PersistenceContext
	EntityManager em;
	
	
	
	
	public List<Address> getAddressByNid(String nid)
	{
		
		return em.createQuery("FROM Address a WHERE a.nid=:nid").setParameter("nid", nid.trim().toUpperCase())
				.getResultList();
		
	}
	
	public List<Address> getAddressByBuildingId(BigInteger bid)
	{
		
		return em.createQuery("FROM Address a WHERE a.buildingId=:bid").setParameter("bid", bid)
				.getResultList();
		
	}
	
	@SuppressWarnings("rawtypes")
	public List<Address>searchAddress(AddressSQL criterias)
	{
		
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM Address a WHERE 1=1 ";
		String order = "ORDER BY a.entranceNo";


		if(StringUtil.isValid(criterias.getNid()))
		{
			sql += "AND a.nid LIKE :nid ";
			params.put("nid", criterias.getNid());
		}		
		
		if(StringUtil.isValid(criterias.getFullName()))
		{
			sql += "AND a.name LIKE :name ";
			params.put("name", criterias.getFullName());
		}	
		
		if(StringUtil.isValid(criterias.getEntrance()))
		{
			sql += "AND a.entranceNo LIKE :eno ";
			params.put("eno", criterias.getEntrance());
		}	
		
		if(StringUtil.isValid(criterias.getStreet()))
		{
			sql += "AND a.street LIKE :street ";
			params.put("street", criterias.getStreet());
		}	
		
		if(StringUtil.isValid(criterias.getMunicipality()))
		{
			sql += "AND a.municipality LIKE :mun ";
			params.put("mun", criterias.getMunicipality());
		}	
		
		if(criterias.getUnitId() != null)
		{
			sql += "AND a.unitId = :uid ";
			params.put("uid", criterias.getUnitId());
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
