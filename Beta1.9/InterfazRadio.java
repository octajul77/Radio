public interface InterfazRadio {
	final int CONST_CAMBIO_AM = 10;
	final double CONST_CAMBIO_FM = 0.2; 
	final int MAX_AM = 1610;
	final int MIN_AM = 530;
	final double MAX_FM = 107.9;
	final double MIN_FM = 87.9;
	
	
	public void encenderApagar();
	
	public void cambiarFrec();
	
	public void cargarEmisora(double emisora);
	
	public void adelantarEmisora();
	
	public void atrasarEmisora();
	
	public void guardarEmisora(double emisora, int posicion);
	
	public void subirVolumen();
	
	public void bajarVolumen();
	
}
