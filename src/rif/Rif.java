package rif;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Rif {
	
	private static String URL = "http://contribuyente.seniat.gob.ve/getContribuyente/getrif?rif=";
	public static String NOMBRE = "Nombre";
	public static String NOMBRE_COMERCIAL = "NombreComercial";
	public static String AGENTE_RETENCION = "AgenteDeRetencion";
	public static String CONTRIBUYENTE = "Contribuyente";
	public static String TASA = "Tasa";
	
	
	private static Document getXMLData (String urlRif){
		URL url;
		try {
			url = new URL(urlRif);
			 URLConnection uc = null;
				try {
						uc = url.openConnection();
						uc.connect();
						InputStreamReader input = new InputStreamReader(uc.getInputStream());

					    BufferedReader in = new BufferedReader(input);
					    
					    String inputLine;
					    String content = "";
					    while ((inputLine = in.readLine()) != null) {
					        content += inputLine;
					    }
					    in.close();
					    
					    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
				        DocumentBuilder builder;  
				        Document doc = null;
				        try 
				        {  
				            builder = factory.newDocumentBuilder();  
				            doc = (Document) builder.parse( new InputSource( new StringReader( content ) ) ); 
				            return doc;
				        } catch (Exception e) {  
				            e.printStackTrace();  
				        } 
				} catch (Exception e1) {
					return null;
				}
		} catch (MalformedURLException e2) {
			System.out.println("URL mal formada");
		}
	   
		return null;
	}

	public static HashMap<String, Object> getDataRif(String rif){	    
		Document doc = getXMLData(URL + rif);

        if (doc != null){
        	HashMap<String,Object> datos = new HashMap<String, Object>();
        	doc.getDocumentElement().normalize();
        	NodeList data = (NodeList) doc.getChildNodes().item(0); // rif:Rif  -> Root
        	datos.put("RIF", rif);

        	String name[] = data.item(0).getTextContent().split("\\("); //rif:Nombre        	
        	datos.put(NOMBRE, name[0]);
        	if (name.length>1){
            	datos.put(NOMBRE_COMERCIAL, name[1].replace(")", ""));
        	}
        	else{
        		datos.put(NOMBRE_COMERCIAL, "");
        	}
        	
        	datos.put(AGENTE_RETENCION, data.item(1).getTextContent().equalsIgnoreCase("SI"));
        	datos.put(CONTRIBUYENTE, data.item(2).getTextContent().equalsIgnoreCase("SI"));
        	datos.put(TASA, new BigDecimal(data.item(3).getTextContent()));
        	
        	return datos;
        }
        return null;
      }
}
