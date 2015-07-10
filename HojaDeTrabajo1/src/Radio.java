public class Radio implements InterfazRadio {
	private boolean Encendido;
	private String Frec;
	public Radio() {
		// TODO Auto-generated constructor stub
		Encendido = false;
		Frec = "AM";
	}
	public void EncenderApagar()
	{
		if (!Encendido) 
		{
			Encendido = true;
		} else {
			Encendido = false;
		}
		System.out.println("Encender Apagar");
		System.out.println(Encendido);
	};
	
	public void CambiarFrec()
	{
		if(Frec == "AM")
		{
			Frec = "FM";
		} else {
			Frec = "AM";
		}
		System.out.println("Cambiar Frec");
		System.out.println("La Frecuencia es: "+Frec);
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
	
	public boolean getEncendido()
	{
		return Encendido;
	}
	
	public String getFrec()
	{
		return Frec;
	}
	public int getCONST_CAMBIO_AM()
	{
		return CONST_CAMBIO_AM; 
	}
	
	public double CONST_CAMBIO_FM()
	{
		return CONST_CAMBIO_FM;
	}
	
	public int MAX_AM()
	{
		return MAX_AM;
	}
	
	public int MIN_AM()
	{
		return MIN_AM;
	}
	
	public double MAX_FM()
	{
		return MAX_FM;
	}
	
	public double MIN_FM()
	{
		return MIN_FM;
	}
}
