
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
	private int Volumen;
	private double[] FMArray;
	private double[] AMArray;

    /**
     * Constructor del objeto Radio. Inicializa los atributos y arrays.
     */
    public Radio() {
		Encendido = false;
		Frec = "AM";
        AM = MIN_AM;
		FM = MIN_FM;
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
			if(Frec.equals("AM")){
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
     * Este metodo permite cargar la emisora que se tiene guardada dependiendo de el boton que ingrese el usuario
     * @param posicion
     */
    @Override
    public void cargarEmisora(int posicion){
		if(Encendido){
			System.out.println("Cargando Emisora");
			if (Frec.equals("AM")){
				AM = AMArray[posicion-1];
			}
			else{
				FM = FMArray[posicion-1];
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
		if(Frec.equals("AM")){
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
		if(Frec.equals("AM")){
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
			if (Frec.equals("AM")){
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
     * Imprime en consola que el volumen sube
     * Ademas que se encarga de subir el volumen 
     * hasta el maximo permitido para mostrar en el display
     */
        @Override
    public void subirVolumen(){
	if(Encendido){
		if (Volumen<25)
			{
				Volumen+=1;
			}
		System.out.println("Subir Volumen");
		}
	}

    /**
     * Imprime en consola que el volumen baja
     * Ademas que se encraga de bajar volumen al minimo que es cero y lo
     * muestra en el display
     */
        @Override
    public void bajarVolumen(){
	if(Encendido){
		if (Volumen>0)
			{
				Volumen-=1;
			}
		System.out.println("Bajar Volumen");
		}
	}

    /**
     * Retorna la frecuencia
     * @return Frecuencia AM o FM
     */
    public String getFrec(){
		return Frec;
	}


    /**
     * Este metodo permite regresar la emisora en que se encuentra 
     * en el momento que se llama el metodo 
     * @return AM si se esta en AM o FM si se esta en FM
     */
    public double getEmisora(){
    	if(Frec.equals("AM")){
			return AM;
		}
		else{
			return FM;
		}
	}

	/**
	 * Metodo que permite verificar el estado de
	 * atributo encendido
	 * @return Encendido
	 */
	public boolean getEncendido(){
		return Encendido;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "La mejor radio del mundo";
	}

	/**
	 * Metodo que permite ver el volumen actual
	 * en la radio para mostrar en el display
	 * @return Volumen
	 */
	public int getVolumen(){
		return Volumen;
	}

	 /* MÃ©todo utilizado para pruebas en JUnit
	 /**
     * Retorna un 1 o 0 dependiendo de si el String ingresado corresponde o no a AM
     * @param f Frecuencia
     * @return 1 0 0

    public int vFrecAM(String f)
	{
		if (f=="AM"){
			return 1;
		}
		return 0;
	}
	*/
}
