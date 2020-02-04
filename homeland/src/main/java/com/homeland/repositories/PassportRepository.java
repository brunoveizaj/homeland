package com.homeland.repositories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.homeland.entities.Passport;
import com.homeland.entities.PhotoPassport;
import com.homeland.requests.repository.DocumentSQL;
import com.homeland.requests.repository.PhotoSQL;
import com.homeland.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class PassportRepository {

		
		@PersistenceContext
		EntityManager em;
		
		public Passport create(Passport p)
		{
			em.persist(p);
			em.flush();
			return p;
		}
		
		public PhotoPassport create(PhotoPassport p)
		{
			em.persist(p);
			em.flush();
			return p;
		}
		
		@SuppressWarnings("rawtypes")
		public List<Passport> searchPassport(DocumentSQL criterias)
		{
			
			HashMap<String,Object> params = new HashMap<>();
			String sql = "FROM Passport p WHERE 1=1 ";
			String order = "ORDER BY p.nid,p.issueDate desc";
			
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
			
			
			if(StringUtil.isValid(criterias.getMotherName()))
			{
				sql += "AND p.motherNameSx LIKE :mn ";
				params.put("mn", criterias.getMotherName());
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
			
			if(StringUtil.isValid(criterias.getIdn()))
			{
				sql += "AND p.idp LIKE :idp ";
				params.put("idp", criterias.getIdn());
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
		
		@SuppressWarnings("rawtypes")
		public List<PhotoPassport> searchPhoto(PhotoSQL criterias)
		{
			HashMap<String,Object> params = new HashMap<>();
			String sql = "FROM PhotoPassport p WHERE 1=1 ";
			String order = "ORDER BY p.idp desc";
			
			if(StringUtil.isValid(criterias.getIdn()))
			{
				sql += "AND p.idp LIKE :idp ";
				params.put("idp", criterias.getIdn());
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

