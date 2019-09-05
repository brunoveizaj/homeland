package com.homeland.repositories;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.homeland.entities.Address;
import com.homeland.requests.repository.AddressSql;



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
	
	public List<Address>searchAddress(AddressSql sql)
	{
		
		return null;
		
	}
	
	

}
