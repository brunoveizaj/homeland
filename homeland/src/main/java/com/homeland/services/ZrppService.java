package com.homeland.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.homeland.assemblers.ZrppAssembler;
import com.homeland.dto.PropertyCartelDTO;
import com.homeland.dto.PropertyDTO;
import com.homeland.dto.PropertyMapDTO;
import com.homeland.requests.api.ZrppRequest;
import com.homeland.zrpp.XmlAssembler;
import com.homeland.zrpp.ZrppCall;

@Service
public class ZrppService {
	
	
	public List<PropertyDTO> searchProperty(ZrppRequest req, Integer userId)
	{
		return new ZrppAssembler().kerkoPasuriToList(
					new XmlAssembler().kerkoPasuri(
							new ZrppCall().kerkoPasuri(req.getZk(), req.getVol(), req.getPage(), req.getPropertyNo(), req.getRegion(), req.getCity(), req.getStreet())
				));
	}
	
	public List<PropertyDTO> searchPropertyByOwner(ZrppRequest req, Integer userId)
	{
		return new ZrppAssembler().merrPasuriPronaretToList(
					new XmlAssembler().merrPasuriPronaret(
							new ZrppCall().merrPasuriPronaret(req.getName(), req.getSurname())
				));
	}
	
	public PropertyDTO getProperty(ZrppRequest req, Integer userId)
	{
		return new ZrppAssembler().toDto(
					new XmlAssembler().merrPasuri(
							new ZrppCall().merrPasuri(req.getZk(),req.getVol(),req.getPage()))
				);
	}
	
	public PropertyCartelDTO getPropertyCartel(ZrppRequest req, Integer userId)
	{
		return new ZrppAssembler().toDto(
					new XmlAssembler().shkarkoKartele(
							new ZrppCall().shkarkoKartele(req.getPropertyId()))
				);
	}
	
	public PropertyMapDTO getPropertyMap(ZrppRequest req, Integer userId)
	{
		return new ZrppAssembler().toDto(
					new XmlAssembler().gjeneroHarte(
							new ZrppCall().gjeneroHarte(req.getPropertyId()))
				);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
