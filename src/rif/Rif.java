package rif;

import java.math.BigDecimal;


public class Rif {
	
	private static final long serialVersionUID = 1L;
	
	private String RifNo;
	private String Nombre;
	private String NombreComercial;
	private Boolean EsAgenteRetencion;
	private Boolean EsContribuyente;
	private BigDecimal TasaRetencion;


	/**
	 * Empty constructor
	 */
	public Rif() {
		Nombre = "";
		NombreComercial = "";
		EsAgenteRetencion = false;
		EsContribuyente = false;
		TasaRetencion = new BigDecimal(0);
	}
	
	
	/**
	 * @param nombre
	 * @param nombreComercial
	 * @param esAgenteRetencion
	 * @param esContribuyente
	 * @param tasaRetencion
	 */
	public Rif(String nombre, String nombreComercial,
			Boolean esAgenteRetencion, Boolean esContribuyente,
			BigDecimal tasaRetencion) {
		Nombre = nombre;
		NombreComercial = nombreComercial;
		EsAgenteRetencion = esAgenteRetencion;
		EsContribuyente = esContribuyente;
		TasaRetencion = tasaRetencion;
	}
	
	/**
	 * @return the rifNo
	 */
	public String getRifNo() {
		return RifNo;
	}


	/**
	 * @param rifNo the rifNo to set
	 */
	public void setRifNo(String rifNo) {
		RifNo = rifNo;
	}

	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}
	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	/**
	 * @return the nombreComercial
	 */
	public String getNombreComercial() {
		return NombreComercial;
	}
	
	/**
	 * @param nombreComercial the nombreComercial to set
	 */
	public void setNombreComercial(String nombreComercial) {
		NombreComercial = nombreComercial;
	}
	
	/**
	 * @return the esAgenteRetencion
	 */
	public Boolean getEsAgenteRetencion() {
		return EsAgenteRetencion;
	}
	
	/**
	 * @param esAgenteRetencion the esAgenteRetencion to set
	 */
	public void setEsAgenteRetencion(Boolean esAgenteRetencion) {
		EsAgenteRetencion = esAgenteRetencion;
	}
	
	/**
	 * @return the esContribuyente
	 */
	public Boolean getEsContribuyente() {
		return EsContribuyente;
	}
	
	/**
	 * @param esContribuyente the esContribuyente to set
	 */
	public void setEsContribuyente(Boolean esContribuyente) {
		EsContribuyente = esContribuyente;
	}
	
	/**
	 * @return the tasaRetencion
	 */
	public BigDecimal getTasaRetencion() {
		return TasaRetencion;
	}
	
	/**
	 * @param tasaRetencion the tasaRetencion to set
	 */
	public void setTasaRetencion(BigDecimal tasaRetencion) {
		TasaRetencion = tasaRetencion;
	}
	
	
	@Override
	public String toString() {
		return "Rif [RifNo=" + RifNo + ", Nombre=" + Nombre
				+ ", NombreComercial=" + NombreComercial
				+ ", EsAgenteRetencion=" + EsAgenteRetencion
				+ ", EsContribuyente=" + EsContribuyente + ", TasaRetencion="
				+ TasaRetencion + "]";
	}
	
}
