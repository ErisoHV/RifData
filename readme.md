# RifData
Clase java que permite obtener los datos del RIF de un contribuyente desde la página del SENIAT - Venezuela

**Uso**

1. Incluir la clase `RifDataConnection`
2. Utilizar el método `RifDataConnection.getDataRif(String NroRif)`, pasando como parámetro el nro de Rif
3. El método retorna un objeto `Rif` con los datos del rif.
4. Si el contribuyente no existe, el método `RifDataConnection.getDataRif(String NroRif)` generará la excepción `RifNoExisteException`
5. Para acceder más fácilmente a los datos que retorna, utilizar los métodos de la clase RIF
Ejemplo: `rifdata.getNombre()`  

**Ejemplo**



	Rif rifdata = RifDataConnection.getDataRif(rif);
	System.out.println(rifdata);
	System.out.println(rifdata.getNombre());


