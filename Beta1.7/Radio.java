public class Radio implements InterfazRadio {
	private boolean Encendido;
	private String Frec;
	private double AM;
	private double FM;
	private double[] FMArray;
	private double[] AMArray;
	private double nEmisora;
	public Radio() {
		// TODO Auto-generated constructor stub
		Encendido = false;
		Frec = "AM";
	    AM=minAM();
		FM=minFM();
		nEmisora = 0.0;
		FMArray = new double[12];
		AMArray = new double[12];
		for(int i=0; i<12; i++){
			FMArray[i] = 0.0;
			AMArray[i] = 0.0;
		}
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
			if(Frec == "AM")
			{
				AM = emisora;
			} else {
				FM = emisora;
			}
		}
	};

	public void AdelantarEmisora()
	{
		if(Encendido)
		{
		if(Frec == "AM")
			{
				AM=AM+getconstCambioAM();
				System.out.println(AM);
				if (AM>=maxAM())
				{
					AM=minAM();
				}
			} else {
				FM=FM+constCambioFM();
				System.out.println(FM);
				if (FM>=maxFM())
				{
					FM=minFM();

				}
			}
		System.out.println("Adelantar Emisora");
		}
	}

	public void AtrasarEmisora()
	{
		if(Encendido)
		{
		if(Frec == "AM")
			{
				AM=AM-getconstCambioAM();
				System.out.println(AM);
				if (AM<=minAM())
				{
					AM=minAM();
				}
			} else {
				FM=FM-constCambioFM();
				System.out.println(FM);
				if (FM<=minFM())
				{
					FM=minFM();
				}
			}
		System.out.println("Atrasar Emisora");
		}	    
	};


	public void GuardarEmisora(double emisora, int posicion)
	{
		if(Encendido)
		{
			System.out.println("Guardar Emisora");
			if (Frec=="AM")
			{
				AMArray[posicion-1]=emisora;
				System.out.println(emisora);
				System.out.println("Guardado "+AMArray[posicion-1]+" en el array de AM en la posicion "+(posicion-1));
			} else {
				FMArray[posicion-1]=emisora;
				System.out.println(emisora);
				System.out.println("Guardado "+FMArray[posicion-1]+" en el array de FM en la posicion "+(posicion-1));
			}

		}
	};
	
	public double cEmisora(int posicion)
	{
		if(Encendido)
		{
			System.out.println("Cargando Emisora");
			if (Frec=="AM")
			{
				nEmisora = AMArray[posicion-1]; 
			} else {
				nEmisora = FMArray[posicion-1];
			}
		}
		return nEmisora;
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
			return "------ Radio 1.7 ------";
		}
	}

	public void changeFrec()
	{
		if (Frec=="AM")
		{
			Frec = "FM";
		} else {
			Frec = "AM";
		}
	}
	public String getNum()
	{
		if (Encendido)
		{
			if(Frec == "AM")
			{
				String num2 = Double.toString(AM);
				return num2;

			} else {
					String num3 = Double.toString(FM);
					num3+="00";
					return num3.substring(0,5);

					}
		}else {
			return "------- Radio 1.7 -------";
		}
	};


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
