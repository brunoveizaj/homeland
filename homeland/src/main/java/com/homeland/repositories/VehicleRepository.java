package com.homeland.repositories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.homeland.entities.Vehicle;
import com.homeland.requests.repository.VehicleSQL;
import com.homeland.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class VehicleRepository {

	@PersistenceContext
	EntityManager em;
	
	
	public Vehicle create(Vehicle v)
	{
		em.persist(v);
		em.flush();
		return v;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public List<Vehicle> searchVehicle(VehicleSQL criterias)
	{
		
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM Vehicle v WHERE 1=1 ";
		String order = "ORDER BY v.plate desc";

		
		if(StringUtil.isValid(criterias.getPlate()))
		{
			sql += "AND v.plate LIKE :plate ";
			params.put("plate", criterias.getPlate());
		}
		
		if(StringUtil.isValid(criterias.getVin()))
		{
			sql += "AND v.vin LIKE :vin ";
			params.put("vin", criterias.getVin());
		}

		if(StringUtil.isValid(criterias.getOwner()))
		{
			sql += "AND v.owner LIKE :owner ";
			params.put("owner", criterias.getOwner());
		}
		
		if(StringUtil.isValid(criterias.getProducer()))
		{
			sql += "AND v.producer LIKE :prod ";
			params.put("prod", criterias.getProducer());
		}
		
		if(StringUtil.isValid(criterias.getModel()))
		{
			sql += "AND v.model LIKE :model ";
			params.put("model", criterias.getModel());
		}
		if(StringUtil.isValid(criterias.getColor()))
		{
			sql += "AND v.color LIKE :color ";
			params.put("color", criterias.getColor());
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
