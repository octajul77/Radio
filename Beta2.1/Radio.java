/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego Morales, Julio Gonzalez, Diego Sosa
 */
public class Radio implements InterfazRadio{
	private boolean Encendido;
	private String Frec;
	private double AM;
	private double FM;
	private double[] FMArray;
	private double[] AMArray;
	private double nEmisora;

    /**
     * Constructor del objeto Radio. Inicializa los atributos y arrays.
     */
    public Radio() {
		Encendido = false;
		Frec = "AM";
        AM = MIN_AM;
		FM = MIN_FM;
		nEmisora = 0.0;
		FMArray = new double[12];
		AMArray = new double[12];
		for(int i=0; i<12; i++){
			FMArray[i] = 0.0;
			AMArray[i] = 0.0;
		}
	}

    /**
     * Enciende o apaga la radio modificando el atributo 'Encendido'
     */
        @Override
    public void encenderApagar(){
		if (!Encendido){
			Encendido = true;
		}
		else{
			Encendido = false;
		}
		System.out.println("Encender Apagar");
		System.out.println(Encendido);
	}

    /**
     * Cambia la frecuencia entre AM y Fm modificando el atributo Frec.
     */
        @Override
    public void cambiarFrec(){
		if (Encendido){
			if(Frec == "AM"){
				Frec = "FM";
			}
			else{
				Frec = "AM";
			}
			System.out.println("Cambiar Frec");
			System.out.println("La Frecuencia es: "+Frec);
		}
	}

    /**
     * Carga el numero de la emisora en AM o FM, dependiendo
     * de la frecuencia seleccionada.
     * @param emisora Numero de emisora (double)
     */
        @Override
    public void cargarEmisora(double emisora){
		if (Encendido){
			if(Frec == "AM"){
				AM = emisora;
			}
			else{
				FM = emisora;
			}
		}
	}

    /**
     * Adelanta el numero de la emisora dependiendo de la frecuencia
     * seleccionada, utilizando la constante de cambio.
     */
        @Override
    public void adelantarEmisora(){
		if(Encendido){
		if(Frec == "AM"){
			AM=AM+CONST_CAMBIO_AM;
			System.out.println(AM);
			if (AM>=MAX_AM){
				AM=MIN_AM;
			}
		}
		else{
			FM=FM+CONST_CAMBIO_FM;
			System.out.println(FM);
			if (FM>=MAX_FM){
				FM=MIN_FM;
			}
		}
		System.out.println("Adelantar Emisora");
		}
	}

    /**
     * Atrasa el numero de la emisora dependiendo de la frecuencia
     * seleccionada, utilizando la constante de cambio.
     */
        @Override
    public void atrasarEmisora(){
		if(Encendido){
		if(Frec == "AM"){
			AM=AM-CONST_CAMBIO_AM;
			System.out.println(AM);
			if (AM<=MIN_AM){
				AM=MIN_AM;
			}
		}
		else {
			FM=FM-CONST_CAMBIO_FM;
			System.out.println(FM);
			if (FM<=MIN_FM){
				FM=MIN_FM;
			}
		}
		System.out.println("Atrasar Emisora");
		}
	}

    /**
     * Guarda la emisora selecionada en un array, dependiendo de la frecuencia y posicion especiifica.
     * @param emisora Numero de emisora
     * @param posicion Numero de boton seleccionado a traves de la interfaz grafica
     */
        @Override
    public void guardarEmisora(double emisora, int posicion){
		if(Encendido){
			System.out.println("Guardar Emisora");
			if (Frec=="AM"){
				AMArray[posicion-1]=emisora;
				System.out.println(emisora);
				System.out.println("Guardado "+AMArray[posicion-1]+" en el array de AM en la posicion "+(posicion-1));
			}
			else{
				FMArray[posicion-1]=emisora;
				System.out.println(emisora);
				System.out.println("Guardado "+FMArray[posicion-1]+" en el array de FM en la posicion "+(posicion-1));
			}
		}
	}

    /**
     * Carga la emisora seleccionada dependiendo del boton oprimido y frecuencia.
     * @param posicion Numero de boton seleccionado a traves de la interfaz grafica
     * @return El numero de la emisora cargado
     */
    public double cEmisora(int posicion){
		if(Encendido){
			System.out.println("Cargando Emisora");
			if (Frec=="AM"){
				nEmisora = AMArray[posicion-1];
			}
			else{
				nEmisora = FMArray[posicion-1];
			}
		}
		return nEmisora;
	}

    /**
     * Imprime en consola que el volumen sube
     */
        @Override
    public void subirVolumen(){
		if(Encendido){
			System.out.println("Subir Volumen");
		}
	}

    /**
     * Imprime en consola que el volumen baja
     */
        @Override
    public void bajarVolumen(){
		if(Encendido){
			System.out.println("Bajar Volumen");
		}
	}

    /**
     * Retorna el estado de la radio (encendido o apagado)
     * @return Estado de la radio como true o false
     *
     */
    public boolean getEncendido(){
		return Encendido;
	}

    /**
     * Retorna la frecuencia
     * @return Frecuencia AM o FM
     */
    public String getFrec(){
		if (Encendido){
			return Frec;
		}
		else{
			return "       Radio 2DJ";
		}
	}

    /**
     * Retorna un 1 o 0 dependiendo de si el String ingresado corresponde o no a AM
     * @param f Frecuencia
     * @return 1 0 0
     */
    public int vFrecAM(String f)
	{
		if (f=="AM"){
			return 1;
		}
		return 0;
	}

    /**
     * Retorna el numero de emisora, dependiendo de si es Am o FM.
     * @return Numero de emisora como String
     */
    public String getNum(){
		if (Encendido)
		{
			if(Frec == "AM"){
				String num2 = Double.toString(AM);
				return num2;
			}
			else{
				String num3 = Double.toString(FM);
				num3+="00";
				return num3.substring(0,5);
			}
		}
		else{
			return "       Radio 2DJ";
		}
	}

}
