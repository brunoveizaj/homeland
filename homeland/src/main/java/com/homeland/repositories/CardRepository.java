package com.homeland.repositories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.homeland.entities.Card;
import com.homeland.entities.PhotoCard;
import com.homeland.requests.repository.DocumentSQL;
import com.homeland.requests.repository.PhotoSQL;
import com.homeland.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class CardRepository {

	
	@PersistenceContext
	EntityManager em;
	
	
	public Card create(Card card)
	{
		em.persist(card);
		em.flush();
		return card;
	}
	
	public Card update(Card card)
	{
		return em.merge(card);
	}
	
	public PhotoCard create(PhotoCard pcard)
	{
		em.persist(pcard);
		em.flush();
		return pcard;
	}
	
	public PhotoCard update(PhotoCard pcard)
	{
		return em.merge(pcard);
	}
	
	@SuppressWarnings("rawtypes")
	public List<Card> searchCard(DocumentSQL criterias)
	{
		
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM Card c WHERE 1=1 ";
		String order = "ORDER BY c.nid,c.issueDate desc";
		
		if(StringUtil.isValid(criterias.getDob()))
		{
			sql += "AND c.dob=:dob ";
			params.put("dob", criterias.getDob());
		}
		
		if(StringUtil.isValid(criterias.getFatherName()))
		{
			sql += "AND c.fatherNameSx LIKE :fn ";
			params.put("fn", criterias.getFatherName());
		}
		
		if(StringUtil.isValid(criterias.getFromDob()))
		{
			sql += "AND c.dob>=:fdob ";
			params.put("fdob", criterias.getFromDob());
		}
		
		if(StringUtil.isValid(criterias.getGender()))
		{
			sql += "AND c.gender=:gender ";
			params.put("gender", criterias.getGender());
		}
		
		
		if(StringUtil.isValid(criterias.getMotherName()))
		{
			sql += "AND c.motherNameSx LIKE :mn ";
			params.put("mn", criterias.getMotherName());
		}
		
		
		if(StringUtil.isValid(criterias.getName()))
		{
			sql += "AND c.nameSx LIKE :name ";
			params.put("name", criterias.getName());
		}

		if(StringUtil.isValid(criterias.getNid()))
		{
			sql += "AND c.nid LIKE :nid ";
			params.put("nid", criterias.getNid());
		}
		
		if(StringUtil.isValid(criterias.getIdn()))
		{
			sql += "AND c.idc LIKE :idc ";
			params.put("idc", criterias.getIdn());
		}
		
		if(StringUtil.isValid(criterias.getSurname()))
		{
			sql += "AND c.surnameSx LIKE :surname ";
			params.put("surname", criterias.getSurname());
		}
		
		if(StringUtil.isValid(criterias.getToDob()))
		{
			sql += "AND c.dob<=:tdob ";
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
	public List<PhotoCard> searchPhoto(PhotoSQL criterias)
	{
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM PhotoCard c WHERE 1=1 ";
		String order = "ORDER BY c.idc desc";
		
/*
		if(StringUtil.isValid(criterias.getNid()))
		{
			sql = "SELECT new com.homeland.entities.PhotoCard(c.id,c.idc) FROM PhotoCard c WHERE 1=1 ";
			params.put("nid", criterias.getNid());
		}
*/
		if(StringUtil.isValid(criterias.getIdn()))
		{
			sql += "AND c.idc LIKE :idc ";
			params.put("idc", criterias.getIdn());
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
	
	
	public HashMap<String, String> getPersonLastDocNo(String nid)
	{
		String sql = "(Select idc,issue_date,'C' as \"typ\" FROM card where nid='"+StringUtil.formatSQ(nid)+"' order by issue_date desc limit 1) "
				+ "union "
				+ "(Select idp,issue_date,'P' as \"typ\" FROM passport where nid='"+StringUtil.formatSQ(nid)+"' order by issue_date desc limit 1) "
						+ "ORDER BY 2 DESC limit 1";
		
		List<Object[]> list = em.createNativeQuery(sql).getResultList();
		
		if(list != null && !list.isEmpty())
		{
			Object[] obj = list.get(0);
			
			HashMap<String,String> map = new HashMap<String, String>();
			
			map.put("idn", (String)obj[0]);
			map.put("type", (String)obj[2]);
			
			return map;
		}
		
		return null;
		
				
	}
}
