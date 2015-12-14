package test;

import java.util.HashMap;

import rif.Rif;

public class Test {

	public static void main(String[] args) {
		//Existen
		System.out.println(Rif.getDataRif("V189404065"));
		System.out.println(Rif.getDataRif("G200094907"));
		HashMap<String,Object> dataRif = Rif.getDataRif("G200094907");
		if (dataRif != null && !dataRif.isEmpty())
			System.out.println(dataRif.get(Rif.NOMBRE));
		System.out.println(((Boolean)dataRif.get(Rif.AGENTE_RETENCION))?"Es agente de retención":"No es agente de retención");
		//No existe
		System.out.println(Rif.getDataRif("J40329AAA0"));
		dataRif = Rif.getDataRif("J40329AAA0");
		if (dataRif != null && !dataRif.isEmpty())
			System.out.println(dataRif.get(Rif.NOMBRE));
		
		
	}

}
