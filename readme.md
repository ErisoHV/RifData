# RifData
Clase java que permite obtener los datos del RIF de un contribuyente desde la página del SENIAT - Venezuela

**Uso**

1. Incluir la clase Rif
2. Utilizar el método `Rif.getDataRif(String NroRif)`, pasando como parámetro el nro de Rif
3. El método retorna un `HashMap<String,Object>`, con un valor `String`, `Boolean` o `BigDecimal`, dependiendo de la información.
4. Si el contribuyente no existe, el método `Rif.getDataRif(String NroRif)` retornará *null*
5. Para acceder más fácilmente a los datos que retorna, utilizar los keys que provee la clase:

- `Rif.NOMBRE`: el valor será un **String** con el nombre del contribuyente
- `Rif.NOMBRE_COMERCIAL`: el valor será **String** con el nombre comercial del contribuyente
- `Rif.AGENTE_RETENCION`: el valor será un **Boolean** que indica si el contribuyente es un agente de retención o no.
- `Rif.CONTRIBUYENTE`: el valor será un **Boolean** que indica si el RIF proporcionado es de un contribuyente 
- `Rif.TASA`: el valor será un **BigDecimal** con la tasa de retención del contribuyente

Ejemplo: `dataRif.get(Rif.NOMBRE)`  
