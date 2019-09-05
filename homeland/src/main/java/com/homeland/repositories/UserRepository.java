package com.homeland.repositories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.homeland.constants.IStatus;
import com.homeland.entities.Login;
import com.homeland.entities.User;
import com.homeland.requests.repository.UserSQL;
import com.homeland.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class UserRepository {

	@PersistenceContext
	EntityManager em;
	
	
	public User findById(Integer userId)
	{
		return em.find(User.class, userId);
	}
	
	public User findByUsername(String uname)
	{
		try {
		return (User)em.createQuery("FROM User u where upper(u.username)=:uname")
				.setParameter("uname", uname.trim().toUpperCase())
				.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List<User> searchUser(UserSQL criterias)
	{
		HashMap<String,Object> params = new HashMap<>();
		String sql = "FROM User u WHERE 1=1 ";
		String order = "ORDER BY u.username";

		
		if(StringUtil.isValid(criterias.getUsername()))
		{
			sql += "AND LOWER(u.username) LIKE :uname ";
			params.put("uname", criterias.getUsername().trim().toLowerCase());
		}
		
		if(StringUtil.isValid(criterias.getRole()))
		{
			sql += "AND u.role = :role ";
			params.put("role", criterias.getRole());
		}

		if(criterias.getStatus() != null)
		{
			sql += "AND u.status = :st ";
			params.put("st", criterias.getStatus()?IStatus.ACTIVE:IStatus.NOT_ACTIVE);
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
	
	public User create(User user)
	{
		em.persist(user);
		em.flush();
		return user;
	}
	
	public Login create(Login login)
	{
		em.persist(login);
		em.flush();
		return login;
	}
	
	public User update(User user)
	{
		return em.merge(user);
	}
	
	
	
	
	
}
