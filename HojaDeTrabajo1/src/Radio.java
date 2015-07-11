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
		if (Encendido)
		{
			if(Frec == "AM")
			{
				Frec = "FM";
			} else {
				Frec = "AM";
			}
			System.out.println("Cambiar Frec");
			System.out.println("La Frecuencia es: "+Frec);
		}
	};
	
	public void CargarEmisora(double emisora)
	{
		if (Encendido)
		{
			System.out.println("Cargar Emisora");
		}
	};
	
	public void AdelantarEmisora()
	{
		if(Encendido)
		{
			System.out.println("Adelantar Emisora");
		}
	}
	;
	
	public void AtrasarEmisora()
	{
		if(Encendido)
		{
			System.out.println("Atrasar Emisora");
		}
		
	};
	
	public void GuardarEmisora(double emisora, int posicion)
	{
		if(Encendido)
		{
			System.out.println("Guardar Emisora");
		}
	};
	
	public void SubirVolumen()
	{
		if(Encendido)
		{
			System.out.println("Subir Volumen");
		}
	};
	
	public void BajarVolumen()
	{
		if(Encendido)
		{
			System.out.println("Bajar Volumen");
		}
	};
	
	public boolean getEncendido()
	{
		return Encendido;
	}
	
	public String getFrec()
	{
		if (Encendido)
		{
			return Frec;
		} else {
			return "Radio 1.0";
		}
	}
	public int getconstCambioAM()
	{
		return constCambioAM;
	}

	public double constCambioFM()
	{
		return constCambioFM;
	}

	public int maxAM()
	{
		return maxAM;
	}

	public int minAM()
	{
		return minAM;
	}

	public double maxFM()
	{
		return maxFM;
	}

	public double minFM()
	{
		return minFM;
	}
}
