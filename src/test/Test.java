package test;

import rif.Rif;

public class Test {

	public static void main(String[] args) {
		//Existen
		System.out.println(Rif.getDataRif("V189404065"));
		System.out.println(Rif.getDataRif("G200094907"));
		//No existe
		System.out.println(Rif.getDataRif("J40329AAA0"));
	}

}
