public class Radio implements InterfazRadio {
	private boolean Encendido;
	private String Frec;
	private double num;
	private double num1;
	public Radio() {
		// TODO Auto-generated constructor stub
		Encendido = false;
		Frec = "AM";
	    num=minAM();
		num1=minFM();
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
		if(Frec == "AM")
			{
			num=num+getconstCambioAM();
			System.out.println(num);
				if (num>=maxAM())
				{
					num=minAM();
				
				}else{
					num=num;
					}
			} 
			else {
			num1=num1+constCambioFM();
			System.out.println(num1);
			if (num1>=maxFM())
				{
					num1=minFM();
				
				}else{
					num1=num1;
					}
			
				
			}
		
			System.out.println("Adelantar Emisora");
		}
	}
	;
	
	public void AtrasarEmisora()
	{
		if(Encendido)
		{
		if(Frec == "AM")
			{
			num=num-getconstCambioAM();
			System.out.println(num);
				if (num<=minAM())
				{
					num=minAM();
				
				}else{
					num=num;
					}
			} 
			else {
			num1=num1-constCambioFM();
			System.out.println(num1);
				if (num1<=maxFM())
				{
					num1=minFM();
				
				}else{
					num1=num1;
			}
		
			System.out.println("Atrasar Emisora");
		        }
		
	    };
	}
	
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
	
	public String getNum()
	{
		if (Encendido)
		{
			if(Frec == "AM")
			{
				String num2 = Double.toString(num);
				return num2;
				
			} else {
					String num3 = Double.toString(num1);
					return num3;
			
					}
		}else {
			return "Radio 1.0";
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
