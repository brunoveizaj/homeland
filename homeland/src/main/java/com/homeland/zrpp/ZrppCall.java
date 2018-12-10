package com.homeland.zrpp;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ZrppCall {
	
	
	
	public String kerkoPasuri(String zk, String vol, String page, String propertyNo, String region, String city, String street)
	{
		if(zk == null) zk="";
		if(vol==null) vol="";
		if(page==null) page="";
		if(propertyNo==null) propertyNo="";
		if(region==null) region="";
		if(city==null) city="";
		if(street==null) street="";
		
		
		String request = 
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">" + 
				"   <soapenv:Header/>" + 
				"   <soapenv:Body>" + 
				"      <sZonakadastrale>"+zk+"</sZonakadastrale>" + 
				"      <sVolumi>"+vol+"</sVolumi>" + 
				"      <sFaqja>"+page+"</sFaqja>" + 
				"      <sNr_pasurie>"+propertyNo+"</sNr_pasurie>" + 
				"      <rrethi>"+region+"</rrethi>" + 
				"      <qyteti>"+city+"</qyteti>" + 
				"      <sRruga>"+street+"</sRruga>" + 
				"   </soapenv:Body>" + 
				"</soapenv:Envelope>";
		
		String CON_STR = "http://134.0.63.134:6864/PASURITEZRPP_WS1_WEB/awws/PasuriteZrpp_WS.awws";
		
		
		try {
            URL url = new URL(CON_STR);
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            // specify that we will send output and accept input            
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);
            http.setConnectTimeout(10000);  // long timeout, but not infinite
            http.setReadTimeout(40000);
            http.setUseCaches(false);
            http.setDefaultUseCaches(false);
            // tell the web server what we are sending
            http.setRequestProperty("Content-Type", "text/xml");
            con.setRequestProperty("SOAPAction", "urn:PasuriteZrpp_WS/KerkoPasuri");
            
            OutputStreamWriter writer = new OutputStreamWriter(http.getOutputStream());
            writer.write(request);
            writer.flush();
            writer.close();
            // reading the response
            InputStreamReader reader = new InputStreamReader(http.getInputStream());
            StringBuilder buf = new StringBuilder();
            char[] cbuf = new char[2048];
            int num;
            while (-1 != (num = reader.read(cbuf))) {
                buf.append(cbuf, 0, num);
            }
            String result = buf.toString();
            
            return result;
        } catch (Throwable t) {
            t.printStackTrace(System.out);
            
        }
		
		
		return null;
	}

	
	public String merrPasuriPronaret(String name, String surname)
	{
		if(name == null) name="";
		if(surname==null) surname="";
		
		
		String request = 
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
				"   <soapenv:Header/>" + 
				"   <soapenv:Body>" + 
				"      <sEmri>"+name+"</sEmri>" + 
				"      <sMbiemri>"+surname+"</sMbiemri>" + 
				"   </soapenv:Body>" + 
				"</soapenv:Envelope>";
		
		String CON_STR = "http://134.0.63.134:6864/PASURITEZRPP_WS1_WEB/awws/PasuriteZrpp_WS.awws";
		
		
		try {
            URL url = new URL(CON_STR);
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            // specify that we will send output and accept input            
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);
            http.setConnectTimeout(10000);  // long timeout, but not infinite
            http.setReadTimeout(40000);
            http.setUseCaches(false);
            http.setDefaultUseCaches(false);
            // tell the web server what we are sending
            http.setRequestProperty("Content-Type", "text/xml");
            con.setRequestProperty("SOAPAction", "urn:PasuriteZrpp_WS/Merr_pasuri_per_pronaret");
            
            OutputStreamWriter writer = new OutputStreamWriter(http.getOutputStream());
            writer.write(request);
            writer.flush();
            writer.close();
            // reading the response
            InputStreamReader reader = new InputStreamReader(http.getInputStream());
            StringBuilder buf = new StringBuilder();
            char[] cbuf = new char[2048];
            int num;
            while (-1 != (num = reader.read(cbuf))) {
                buf.append(cbuf, 0, num);
            }
            String result = buf.toString();
            
            return result;
        } catch (Throwable t) {
            t.printStackTrace(System.out);
            
        }
		
		
		return null;
	}

	
	public String merrPasuri(String zk, String vol, String page)
	{
		if(zk == null) zk="";
		if(vol==null) vol="";
		if(page==null) page="";
		
		
		String request = 
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
				"   <soapenv:Header/>" + 
				"   <soapenv:Body>" + 
				"      <sZonaKadastrale>"+zk+"</sZonaKadastrale>" + 
				"      <sVolumi>"+vol+"</sVolumi>" + 
				"      <sFaqja>"+page+"</sFaqja>" + 
				"   </soapenv:Body>" + 
				"</soapenv:Envelope>";
		
		String CON_STR = "http://134.0.63.134:6864/PASURITEZRPP_WS1_WEB/awws/PasuriteZrpp_WS.awws";
		
		
		try {
            URL url = new URL(CON_STR);
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            // specify that we will send output and accept input            
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);
            http.setConnectTimeout(10000);  // long timeout, but not infinite
            http.setReadTimeout(40000);
            http.setUseCaches(false);
            http.setDefaultUseCaches(false);
            // tell the web server what we are sending
            http.setRequestProperty("Content-Type", "text/xml");
            con.setRequestProperty("SOAPAction", "urn:PasuriteZrpp_WS/MerrPasuri");
            
            OutputStreamWriter writer = new OutputStreamWriter(http.getOutputStream());
            writer.write(request);
            writer.flush();
            writer.close();
            // reading the response
            InputStreamReader reader = new InputStreamReader(http.getInputStream());
            StringBuilder buf = new StringBuilder();
            char[] cbuf = new char[2048];
            int num;
            while (-1 != (num = reader.read(cbuf))) {
                buf.append(cbuf, 0, num);
            }
            String result = buf.toString();
            
            return result;
        } catch (Throwable t) {
            t.printStackTrace(System.out);
            
        }
		
		
		return null;
	}
	
	
	public String shkarkoKartele(String propertyId)
	{
		if(propertyId == null) propertyId="";
		
		
		String request = 
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">" + 
				"   <soapenv:Header/>" + 
				"   <soapenv:Body>" + 
				"      <idpasurise>"+propertyId+"</idpasurise>" + 
				"   </soapenv:Body>" + 
				"</soapenv:Envelope>";
		
		String CON_STR = "http://134.0.63.134:6864/PASURITEZRPP_WS1_WEB/awws/PasuriteZrpp_WS.awws";
		
		
		try {
            URL url = new URL(CON_STR);
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            // specify that we will send output and accept input            
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);
            http.setConnectTimeout(10000);  // long timeout, but not infinite
            http.setReadTimeout(40000);
            http.setUseCaches(false);
            http.setDefaultUseCaches(false);
            // tell the web server what we are sending
            http.setRequestProperty("Content-Type", "text/xml");
            con.setRequestProperty("SOAPAction", "urn:PasuriteZrpp_WS/ShkarkoKartele");
            
            OutputStreamWriter writer = new OutputStreamWriter(http.getOutputStream());
            writer.write(request);
            writer.flush();
            writer.close();
            // reading the response
            InputStreamReader reader = new InputStreamReader(http.getInputStream());
            StringBuilder buf = new StringBuilder();
            char[] cbuf = new char[2048];
            int num;
            while (-1 != (num = reader.read(cbuf))) {
                buf.append(cbuf, 0, num);
            }
            String result = buf.toString();
            
            return result;
        } catch (Throwable t) {
            t.printStackTrace(System.out);
            
        }
		
		
		return null;
	}
	
	
	public String gjeneroHarte(String propertyId)
	{
		if(propertyId == null) propertyId="";
		
		
		String request = 
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">" + 
				"   <soapenv:Header/>" + 
				"   <soapenv:Body>" + 
				"      <nId_pasurie>"+propertyId+"</nId_pasurie>" + 
				"   </soapenv:Body>" + 
				"</soapenv:Envelope>";
		
		String CON_STR = "http://134.0.63.134:8083/WS_HARTA_ZRPP_WEB/awws/WS_harta_zrpp.awws";
		
		
		try {
            URL url = new URL(CON_STR);
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            // specify that we will send output and accept input            
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);
            http.setConnectTimeout(10000);  // long timeout, but not infinite
            http.setReadTimeout(40000);
            http.setUseCaches(false);
            http.setDefaultUseCaches(false);
            // tell the web server what we are sending
            http.setRequestProperty("Content-Type", "text/xml");
            con.setRequestProperty("SOAPAction", "urn:WS_harta_zrpp/gjenero_harte");
            
            OutputStreamWriter writer = new OutputStreamWriter(http.getOutputStream());
            writer.write(request);
            writer.flush();
            writer.close();
            // reading the response
            InputStreamReader reader = new InputStreamReader(http.getInputStream());
            StringBuilder buf = new StringBuilder();
            char[] cbuf = new char[2048];
            int num;
            while (-1 != (num = reader.read(cbuf))) {
                buf.append(cbuf, 0, num);
            }
            String result = buf.toString();
           // System.err.println("\nResponse from server after POST:\n" + result);
            
            return result;
        } catch (Throwable t) {
            t.printStackTrace(System.out);
            
        }
		
		
		return null;
	}
	
	
	
	
	
	
	
	public static void main(String args[])
	{
		String xml = new ZrppCall().gjeneroHarte("2145720");//5/22+3-40   ale":"8531", "Volumi":"2", "Faqja":"246"
		
		System.out.println(new XmlAssembler().gjeneroHarte(xml));
	}

}
