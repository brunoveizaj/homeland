package com.homeland.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homeland.constants.ILiveRaport;
import com.homeland.entities.LiveRaport;
import com.homeland.exceptions.GeneralException;
import com.homeland.models.LivePersonRaportDTO;
import com.homeland.repositories.LiveRaportRepository;
import com.homeland.utils.StringUtil;

@Service
@Transactional
public class LiveRaportService {

	
	@Autowired LiveRaportRepository liveRaportDAO;
	
	
	public LiveRaport createLiveRaport(String type, String key, String user)
	{
		
		String lastStatus = liveRaportDAO.getLastEntityLiveRaportStatus(type, key);
		
		if(StringUtil.isValid(lastStatus))
		{
			if(lastStatus.equals(ILiveRaport.PENDING))
			{
				throw new GeneralException("Nje kerkese eshte ne pritje...");
			}
		}
		
		
		LiveRaport rp = new LiveRaport();
		rp.setKey(StringUtil.formatSQ(key));
		rp.setRequestTime(Calendar.getInstance().getTime());
		rp.setType(type);
		rp.setStatus(ILiveRaport.PENDING);
		rp.setRequestUser(user);
		
		rp = liveRaportDAO.create(rp);
		
		return rp;
		
	}
	
	public void registerJsonData(Integer id, String json)
	{
		LiveRaport rp = liveRaportDAO.findById(id);
		
		rp.setDataJson(json);
		rp.setResponseTime(Calendar.getInstance().getTime());
		rp.setStatus(ILiveRaport.COMPLETED);
		
		liveRaportDAO.update(rp);
		
	}
	
	public void cancelRequest(Integer id)
	{
		LiveRaport rp = liveRaportDAO.findById(id);
		rp.setResponseTime(Calendar.getInstance().getTime());
		rp.setStatus(ILiveRaport.CANCELED);
		
		liveRaportDAO.update(rp);
		
	}
	
	public LivePersonRaportDTO getPersonLiveRaport(String nid)
	{
		LiveRaport lastRaport = liveRaportDAO.getLastEntityLiveRaport(ILiveRaport.TYPE_PERSON, nid);
		
		if(lastRaport == null)
		{
			LivePersonRaportDTO r = new LivePersonRaportDTO();
			r.setCanAskRequest(true);
			r.setDataJson(null);
			r.setDisplayMessage("Per kete person nuk ka te dhena ne sistem!...Beni kerkese per te marre te dhenat LIVE!");
			r.setHasData(false);
			
			return r;
		}
		
		
		if(lastRaport.getStatus().equals(ILiveRaport.PENDING))
		{
			
			LiveRaport completedRaport = liveRaportDAO.getLastEntityLiveCompletedRaport(ILiveRaport.TYPE_PERSON, nid);
			
			LivePersonRaportDTO r = new LivePersonRaportDTO();
			r.setCanAskRequest(false);
			r.setDataJson(completedRaport == null ? null : completedRaport.getDataJson());
			r.setDisplayMessage("Kerkesa eshte ne pritje...!");
			r.setHasData(completedRaport != null);
			r.setLastRaportId(lastRaport.getId());
			r.setLastRaportStatus(lastRaport.getStatus());
			r.setLastRequestDate(lastRaport.getRequestTime());
			r.setLastResponseDate(completedRaport == null ? null : completedRaport.getResponseTime());
			
			return r;
		}
		
		if(lastRaport.getStatus().equals(ILiveRaport.COMPLETED))
		{
			LivePersonRaportDTO r = new LivePersonRaportDTO();
			r.setCanAskRequest(true);
			r.setDataJson(lastRaport.getDataJson());
			r.setDisplayMessage("Beni kerkese per te marre te dhenat LIVE!");
			r.setHasData(true);
			r.setLastRaportId(lastRaport.getId());
			r.setLastRaportStatus(lastRaport.getStatus());
			r.setLastRequestDate(lastRaport.getRequestTime());
			r.setLastResponseDate(lastRaport.getResponseTime());
			
			return r;
		}
		
		if(lastRaport.getStatus().equals(ILiveRaport.CANCELED))
		{
			
			LiveRaport completedRaport = liveRaportDAO.getLastEntityLiveCompletedRaport(ILiveRaport.TYPE_PERSON, nid);
			
			LivePersonRaportDTO r = new LivePersonRaportDTO();
			r.setCanAskRequest(true);
			r.setDataJson(completedRaport == null ? null : completedRaport.getDataJson());
			r.setDisplayMessage("Kerkesa e fundit eshte anulluar...! Beni kerkese per marrjen e te dhenave LIVE!");
			r.setHasData(completedRaport != null);
			r.setLastRaportId(lastRaport.getId());
			r.setLastRaportStatus(lastRaport.getStatus());
			r.setLastRequestDate(lastRaport.getRequestTime());
			r.setLastResponseDate(completedRaport == null ? null : completedRaport.getResponseTime());
			
			return r;
		}
		
		return null;
		
	}
	
	
	
	public List<LiveRaport> getLivePendingRequests()
	{
		return liveRaportDAO.getLivePendingRequests();
	}
	
	public List<LiveRaport> getLastLiveRequests()
	{
		return liveRaportDAO.getLastLiveRaportRequests();
	}
	
	
	
}
