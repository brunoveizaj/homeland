package com.homeland.assemblers;

import java.util.ArrayList;
import java.util.List;

import com.homeland.dto.PropertyCartelDTO;
import com.homeland.dto.PropertyDTO;
import com.homeland.dto.PropertyMapDTO;
import com.homeland.utils.StringUtil;
import com.homeland.zrpp.KerkoPasuriPropertyModel;
import com.homeland.zrpp.MerrPasuriPronaretPropertyModel;
import com.homeland.zrpp.MerrPasuriPropertyModel;
import com.homeland.zrpp.ShkarkoKarteleModel;

public class ZrppAssembler {
	
	
	public PropertyDTO toDto(MerrPasuriPropertyModel m)
	{
		if(m == null) return null;
		
		PropertyDTO dto = new PropertyDTO();

		if(m.getAddress() != null)
		{
			dto.setAppNo(m.getAddress().getAppNo());
			dto.setBuildingNo(m.getAddress().getBuildingNo());
			dto.setDistrict(m.getAddress().getDistrict());
			dto.setEntryNo(m.getAddress().getEntryNo());
			dto.setFloor(m.getAddress().getFloor());
			dto.setMunicipaliy(m.getAddress().getMunicipaliy());
			dto.setStreet(m.getAddress().getStreet());
		}
		
		dto.setMapIndex(m.getMapIndex());
		dto.setOwner(m.getOwner());
		dto.setPage(m.getPage());
		dto.setPropertyId(m.getPropertyId());
		dto.setPropertyNo(m.getPropertyNo());
		dto.setRegDate(m.getRegDate());
		dto.setRegion(m.getRegion());
		dto.setVolume(m.getVolume());
		dto.setZk(m.getZk());
		
		return dto;
		
		
	}
	
	public PropertyCartelDTO toDto(ShkarkoKarteleModel m)
	{
		if(m == null) return null;
		
		PropertyCartelDTO dto = new PropertyCartelDTO();
		
		dto.setData(m.getContent());
		dto.setMessage(m.getMessage());
		dto.setRezult(m.getResult());
		
		return dto;
		
	}
	
	public PropertyMapDTO toDto(String base64)
	{
		if(!StringUtil.isValid(base64)) return null;
		
		PropertyMapDTO dto = new PropertyMapDTO();
		dto.setData(base64);
		
		return dto;
	}
	
	public PropertyDTO toDto(KerkoPasuriPropertyModel m)
	{
		if(m == null) return null;
		
		PropertyDTO dto = new PropertyDTO();

		if(m.getAddress() != null)
		{
			dto.setAppNo(m.getAddress().getAppNo());
			dto.setBuildingNo(m.getAddress().getBuildingNo());
			dto.setDistrict(m.getAddress().getDistrict());
			dto.setEntryNo(m.getAddress().getEntryNo());
			dto.setFloor(m.getAddress().getFloor());
			dto.setMunicipaliy(m.getAddress().getMunicipaliy());
			dto.setStreet(m.getAddress().getStreet());
		}
		
		dto.setMapIndex(m.getMapIndex());
		dto.setOwner(m.getOwner());
		dto.setPage(m.getPage());
		dto.setPropertyId(m.getPropertyId());
		dto.setPropertyNo(m.getPropertyNo());
		dto.setRegDate(m.getRegDate());
		dto.setRegion(m.getRegion());
		dto.setVolume(m.getVolume());
		dto.setZk(m.getZk());
		
		return dto;
		
		
	}

	public PropertyDTO toDto(MerrPasuriPronaretPropertyModel m)
	{
		if(m == null) return null;
		
		PropertyDTO dto = new PropertyDTO();

		if(m.getAddress() != null)
		{
			dto.setAppNo(m.getAddress().getAppNo());
			dto.setBuildingNo(m.getAddress().getBuildingNo());
			dto.setDistrict(m.getAddress().getDistrict());
			dto.setEntryNo(m.getAddress().getEntryNo());
			dto.setFloor(m.getAddress().getFloor());
			dto.setMunicipaliy(m.getAddress().getMunicipaliy());
			dto.setStreet(m.getAddress().getStreet());
		}
		
		dto.setMapIndex(m.getMapIndex());
		dto.setOwner(m.getOwner());
		dto.setPage(m.getPage());
		dto.setPropertyId(m.getPropertyId());
		dto.setPropertyNo(m.getPropertyNo());
		dto.setRegDate(m.getRegDate());
		dto.setRegion(m.getRegion());
		dto.setVolume(m.getVolume());
		dto.setZk(m.getZk());
		
		return dto;
		
		
	}

	public List<PropertyDTO> kerkoPasuriToList(List<KerkoPasuriPropertyModel> list)
	{
		if(list == null || list.isEmpty()) return null;
		
		List<PropertyDTO> data = new ArrayList<>();
		for(KerkoPasuriPropertyModel k : list)
		{
			data.add(toDto(k));
		}
		return data;
	}

	public List<PropertyDTO> merrPasuriPronaretToList(List<MerrPasuriPronaretPropertyModel> list)
	{
		if(list == null || list.isEmpty()) return null;
		
		List<PropertyDTO> data = new ArrayList<>();
		for(MerrPasuriPronaretPropertyModel k : list)
		{
			data.add(toDto(k));
		}
		return data;
	}




}
