package com.homeland.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.homeland.entities.Imports;

@Repository
public class ImportRepository {

	@PersistenceContext
	EntityManager em;
	
	public Imports create(Imports imports)
	{
		em.persist(imports);
		em.flush();
		return imports;
	}
	
	public Imports update(Imports imports)
	{
		return em.merge(imports);
	}
	
	public Imports findById(Integer id)
	{
		return em.find(Imports.class, id);
	}
	
	public Long getLastRid(Class<?> T)
	{
		return (Long) em.createQuery("SELECT MAX(t.rid) FROM "+T.getName()+" t").getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Imports> getLastImports(Integer limit)
	{
		return em.createQuery("FROM Imports i ORDER BY i.id DESC")
				.setMaxResults(limit).getResultList();
	}
	
	
	
	
	
	
}
