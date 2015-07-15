public class Radio implements InterfazRadio {
	private boolean Encendido;
	private String Frec;
	private double AM;
	private double FM;
	private double[] FMArray;
	private double[] AMArray;
	private double nEmisora;
	public Radio() {
		Encendido = false;
		Frec = "AM";
	    AM = MIN_AM();
		FM = MIN_FM();
		nEmisora = 0.0;
		FMArray = new double[12];
		AMArray = new double[12];
		for(int i=0; i<12; i++){
			FMArray[i] = 0.0;
			AMArray[i] = 0.0;
		}
	}
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
	public void adelantarEmisora(){
		if(Encendido){
		if(Frec == "AM"){
			AM=AM+getCONST_CAMBIO_AM();
			System.out.println(AM);
			if (AM>=MAX_AM()){
				AM=MIN_AM();
			}
		}
		else{
			FM=FM+CONST_CAMBIO_FM();
			System.out.println(FM);
			if (FM>=MAX_FM()){
				FM=MIN_FM();
			}
		}
		System.out.println("Adelantar Emisora");
		}
	}
	public void atrasarEmisora(){
		if(Encendido){
		if(Frec == "AM"){
			AM=AM-getCONST_CAMBIO_AM();
			System.out.println(AM);
			if (AM<=MIN_AM()){
				AM=MIN_AM();
			}
		}
		else {
			FM=FM-CONST_CAMBIO_FM();
			System.out.println(FM);
			if (FM<=MIN_FM()){
				FM=MIN_FM();
			}
		}
		System.out.println("Atrasar Emisora");
		}
	}
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
	public void subirVolumen(){
		if(Encendido){
			System.out.println("Subir Volumen");
		}
	}
	public void bajarVolumen(){
		if(Encendido){
			System.out.println("Bajar Volumen");
		}
	}
	public boolean getEncendido(){
		return Encendido;
	}
	public String getFrec(){
		if (Encendido){
			return Frec;
		}
		else{
			return "       Radio 2DJ";
		}
	}
	public int vFrecAM(String f)
	{
		if (f=="AM"){
			return 1;
		}
		return 0;
	}
	public void changeFrec(){
		if (Frec=="AM"){
			Frec = "FM";
		}
		else{
			Frec = "AM";
		}
	}
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
	public int getCONST_CAMBIO_AM(){
		return CONST_CAMBIO_AM;
	}
	public double CONST_CAMBIO_FM(){
		return CONST_CAMBIO_FM;
	}
	public int MAX_AM(){
		return MAX_AM;
	}
	public int MIN_AM(){
		return MIN_AM;
	}
	public double MAX_FM(){
		return MAX_FM;
	}
	public double MIN_FM(){
		return MIN_FM;
	}
}
