package com.homeland.zrpp;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class XmlAssembler {
	
	
	
	public List<KerkoPasuriPropertyModel> kerkoPasuri(String xml)
	{
		
		try {
			
            JAXBContext jaxbContext = JAXBContext.newInstance(KerkoPasuriResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            KerkoPasuriResponse resp = (KerkoPasuriResponse) jaxbUnmarshaller.unmarshal(reader);
            if(resp!=null)
            {
            	String json = resp.getBody().getResult();
            	ObjectMapper mapper = new ObjectMapper();
                List<KerkoPasuriPropertyModel> list = mapper.readValue(json,new TypeReference<List<KerkoPasuriPropertyModel>>(){});
                return list;
            }
                        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return null;
		
	}
	
	public MerrPasuriPropertyModel merrPasuri(String xml)
	{
		
		try {
			
            JAXBContext jaxbContext = JAXBContext.newInstance(MerrPasuriResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            MerrPasuriResponse resp = (MerrPasuriResponse) jaxbUnmarshaller.unmarshal(reader);
            if(resp!=null)
            {
            	String json = resp.getBody().getResult();
            	ObjectMapper mapper = new ObjectMapper();
                MerrPasuriPropertyModel m = mapper.readValue(json,MerrPasuriPropertyModel.class);
                return m;
            }
                        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return null;
		
	}
	
	public List<MerrPasuriPronaretPropertyModel> merrPasuriPronaret(String xml)
	{
		
		try {
			
            JAXBContext jaxbContext = JAXBContext.newInstance(MerrPasuriPronaretResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            MerrPasuriPronaretResponse resp = (MerrPasuriPronaretResponse) jaxbUnmarshaller.unmarshal(reader);
            if(resp!=null)
            {
            	String json = resp.getBody().getResult();
            	ObjectMapper mapper = new ObjectMapper();
                List<MerrPasuriPronaretPropertyModel> list = mapper.readValue(json,new TypeReference<List<MerrPasuriPronaretPropertyModel>>(){});
                return list;
            }
                        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return null;
		
	}
	
	public ShkarkoKarteleModel shkarkoKartele(String xml)
	{
		
		try {
			
            JAXBContext jaxbContext = JAXBContext.newInstance(ShkarkoKarteleResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            ShkarkoKarteleResponse resp = (ShkarkoKarteleResponse) jaxbUnmarshaller.unmarshal(reader);
            if(resp!=null)
            {
            	String json = resp.getBody().getResult();
            	ObjectMapper mapper = new ObjectMapper();
            	ShkarkoKarteleModel m = mapper.readValue(json,ShkarkoKarteleModel.class);
                return m;
            }
                        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return null;
		
	}

		
	public String gjeneroHarte(String xml) {
		
		try {
			
            JAXBContext jaxbContext = JAXBContext.newInstance(GjeneroHarteResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            GjeneroHarteResponse resp = (GjeneroHarteResponse) jaxbUnmarshaller.unmarshal(reader);
            if(resp!=null)
            {
            	return resp.getBody().getContent();            	
            }
                        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return null;
	}
	
	

}
