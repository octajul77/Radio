import java.awt.EventQueue;

/**
 * @author Julio Gonzalez, Diego Morales, Diego Sosa
 * @version 2.0
 */
class Main{
	public static void main (String [] args){
		EventQueue.invokeLater(new Runnable(){
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 * Permite correr el programa y mostrar la interfaz
			 */
			public void run(){
				try{
					GUI frame = new GUI();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
