package rif;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import exception.RifNoExisteException;
import exception.ServicioNoDisponibleException;
import exception.URLIncorrectaException;

public class RifDataConnection {

	private static String URL = "http://contribuyente.seniat.gob.ve/getContribuyente/getrif?rif=";
	
	
	public static Document getXMLSeniatData(String url) throws RifNoExisteException, ServicioNoDisponibleException, URLIncorrectaException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        try {
			return factory.newDocumentBuilder().parse(new URL(url).openStream());
		} catch (MalformedURLException e) {
			throw new URLIncorrectaException();
		} catch (SAXException e) {
			e.printStackTrace();
		}
        catch (IOException e) {
        	if (e instanceof UnknownHostException)
        		throw new ServicioNoDisponibleException();
        	else 
				throw new RifNoExisteException();
		} catch (ParserConfigurationException e) {
			throw new ServicioNoDisponibleException();
		}
		return null;
    }
	
	
	public static Rif getDataRif(String rif) throws ServicioNoDisponibleException, RifNoExisteException, URLIncorrectaException{	
		//TODO validacion de RIF
		Document doc = getXMLSeniatData(URL + rif);

        if (doc != null){        	
        	Rif dataRif = new Rif();

        	doc.getDocumentElement().normalize();
        	NodeList data = (NodeList) doc.getChildNodes().item(0); // rif:Rif  -> Root

        	dataRif.setRifNo(rif);

        	String name[] = data.item(0).getTextContent().split("\\("); //rif:Nombre        
        	dataRif.setNombre(name[0]);
        	
        	dataRif.setNombreComercial(name.length>1?name[1].replace(")", ""):"");

        	dataRif.setEsAgenteRetencion(data.item(1).getTextContent().equalsIgnoreCase("SI"));
        	dataRif.setEsContribuyente(data.item(2).getTextContent().equalsIgnoreCase("SI"));
        	dataRif.setTasaRetencion(new BigDecimal(data.item(3).getTextContent()));

        	return dataRif;
        }
        return null;
      }
	
	
	
}
