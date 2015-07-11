public interface InterfazRadio {
	final int constCambioAM = 10;
	final double constCambioFM = 0.2;
	final int maxAM = 1610;
	final int minAM = 530;
	final double minFM = 87.9;
	final double maxFM = 107.9;


	public void EncenderApagar();

	public void CambiarFrec();

	public void CargarEmisora(double emisora);

	public void AdelantarEmisora();

	public void AtrasarEmisora();

	public void GuardarEmisora(double emisora, int posicion);

	public void SubirVolumen();

	public void BajarVolumen();
}
