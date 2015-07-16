/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
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

    @Override
    public void cargarEmisora(int posicion){
		if(Encendido){
			System.out.println("Cargando Emisora");
			if (Frec=="AM"){
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
     * Retorna la frecuencia
     * @return Frecuencia AM o FM
     */
    public String getFrec(){
		return Frec;
	}


    public double getEmisora(){
    	if(Frec == "AM"){
			return AM;
		}
		else{
			return FM;
		}
	}

	public boolean getEncendido(){
		return Encendido;
	}

	public String toString(){
		return "La mejor radio del mundo";
	}

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
