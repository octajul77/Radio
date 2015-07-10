public class Radio implements InterfazRadio {
	public Radio() {
		// TODO Auto-generated constructor stub
	}
	public void EncenderApagar()
	{
		System.out.println("Encender Apagar");
	};
	
	public void CambiarFrec()
	{
		System.out.println("Cambiar Frec");
	};
	
	public void CargarEmisora(double emisora)
	{
		System.out.println("Cargar Emisora");
	};
	
	public void AdelantarEmisora()
	{
		System.out.println("Adelantar Emisora");
	}
	;
	
	public void AtrasarEmisora()
	{
		System.out.println("Atrasar Emisora");
		
	};
	
	public void GuardarEmisora(double emisora, int posicion)
	{
		System.out.println("Guardar Emisora");
	};
	
	public void SubirVolumen()
	{
		System.out.println("Subir Volumen");
	};
	
	public void BajarVolumen()
	{
		System.out.println("Bajar Volumen");
	};
}
