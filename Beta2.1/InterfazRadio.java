/**
 * @author Julio Gonzalez, Diego Morales, Diego Sosa
 * @version 2.0
 */
public interface InterfazRadio {
	/**
	 * constante que permite el cambio de frecuencia en AM
	 */
	final int CONST_CAMBIO_AM = 10;
	/**
	 * Constante que permite el cambio de frecuencia en FM
	 */
	final double CONST_CAMBIO_FM = 0.2; 
	/**
	 * Determina la MAx frecuencia que se alcanza en AM
	 */
	final int MAX_AM = 1610;
	/**
	 * Determina la minima frecuencia que se alcanza en AM
	 */
	final int MIN_AM = 530;
	/**
	 * Determina ma max frecuancia alcanzada en FM
	 */
	final double MAX_FM = 107.9;
	/**
	 * Determina la Min frecuencia alcanzada en FM 
	 */
	final double MIN_FM = 87.9;
	
	
	/**
	 * Metodo que permite encender y apagar la radio
	 */
	public void encenderApagar();
	
	/**
	 * Metodo que permite cambiar la frecuencia
	 */
	public void cambiarFrec();
	
	/**
	 *  Metodo que permite escoger una frecuencia guardada
	 * @param emisora
	 */
	public void cargarEmisora(double emisora);
	
	/**
	 * Metodo que permite cambiar a frecuencias mayores
	 */
	public void adelantarEmisora();
	
	/**
	 * Metodo que permite cambiar a frecuencias menores
	 */
	public void atrasarEmisora();
	
	/**
	 * Metodo que permite guardar emisoras
	 * @param emisora
	 * @param posicion
	
	 */
	public void guardarEmisora(double emisora, int posicion);
	
	/**
	 * Metodo que permite subir el volumen
	 */
	public void subirVolumen();
	
	/**
	 * Metodo que permite bajar el volumen 
	 */
	public void bajarVolumen();
	
}
