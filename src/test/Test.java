package test;

import java.util.ArrayList;

import rif.Rif;
import rif.RifDataConnection;
import exception.RifNoExisteException;
import exception.ServicioNoDisponibleException;
import exception.URLIncorrectaException;

public class Test {

	public static void main(String[] args) {

		ArrayList<String> rifs = new ArrayList<String>();		
		//No existe	
		rifs.add("J40329AAA0");
		//Existe
		rifs.add("V189404065");
		rifs.add("G200094907");
		for (String rif : rifs){
			try {
				Rif rifdata = RifDataConnection.getDataRif(rif);
				System.out.println(rifdata);
				System.out.println(rifdata.getNombre());
			
			} catch (ServicioNoDisponibleException e) {
				e.printStackTrace();
			} catch (RifNoExisteException e) {
				System.out.println("El Rif " + rif + " no existe");
			}catch (URLIncorrectaException e) {
					e.printStackTrace();
				}
		}
	}

}
