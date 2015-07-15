import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PruebasJUNIT {
	private Radio nRadio;
	private double[] FMArray;
	private double[] AMArray;
	private boolean Encendido;
	private String Frec;
	
	@Before
	public void start()
	{
		nRadio = new Radio();
		FMArray = new double[12];
		AMArray = new double[12];
		Encendido = true;
		Frec = "FM";
		for(int i=0; i<12; i++){
			FMArray[i] = 0.0;
			AMArray[i] = 0.0;
		}
	}
	@Test
	public void test1() {
		assertEquals(0.0,nRadio.cEmisora(1),0);
	}
	@Test
	public void test2() {
		assertEquals(1,nRadio.vFrecAM("AM"),0);
	}

}
