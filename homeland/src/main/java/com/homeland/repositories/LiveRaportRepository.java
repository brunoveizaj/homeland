package com.homeland.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.homeland.constants.ILiveRaport;
import com.homeland.entities.LiveRaport;
import com.homeland.utils.StringUtil;

@Repository
public class LiveRaportRepository {

	
	@PersistenceContext
	EntityManager em;
	
	
	
	public LiveRaport create(LiveRaport liveRaport)
	{
		em.persist(liveRaport);
		em.flush();
		return liveRaport;
	}
	
	public LiveRaport update(LiveRaport liveRaport)
	{
		return em.merge(liveRaport);
	}
	
	public LiveRaport findById(Integer id)
	{
		return em.find(LiveRaport.class, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public String getLastEntityLiveRaportStatus(String type, String key)
	{
		
		List<String> list = em.createQuery("Select l.status FROM LiveRaport l WHERE l.type=:type AND l.key=:key ORDER BY l.requestTime DESC")
				.setParameter("type", StringUtil.formatSQ(type))
				.setParameter("key", StringUtil.formatSQ(key))
				.setMaxResults(1)
				.getResultList();
		
		if(list != null && !list.isEmpty())
			return list.get(0);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public LiveRaport getLastEntityLiveRaport(String type, String key)
	{
		
		List<LiveRaport> list = em.createQuery("FROM LiveRaport l WHERE l.type=:type AND l.key=:key ORDER BY l.requestTime DESC")
				.setParameter("type", StringUtil.formatSQ(type))
				.setParameter("key", StringUtil.formatSQ(key))
				.setMaxResults(1)
				.getResultList();
		
		if(list != null && !list.isEmpty())
			return list.get(0);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public LiveRaport getLastEntityLiveCompletedRaport(String type, String key)
	{
		
		List<LiveRaport> list = em.createQuery("FROM LiveRaport l WHERE l.status=:status AND l.type=:type AND l.key=:key ORDER BY l.requestTime DESC")
				.setParameter("status", ILiveRaport.COMPLETED)
				.setParameter("type", StringUtil.formatSQ(type))
				.setParameter("key", StringUtil.formatSQ(key))
				.setMaxResults(1)
				.getResultList();
		
		if(list != null && !list.isEmpty())
			return list.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<LiveRaport> getLivePendingRequests() {
		return em.createQuery("FROM LiveRaport l WHERE l.status=:status ").setParameter("status", ILiveRaport.PENDING).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<LiveRaport> getLastLiveRaportRequests() {
		return em.createQuery("FROM LiveRaport l order by l.requestDate DESC ").setMaxResults(200).getResultList();
	}
	
	
}
