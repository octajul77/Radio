import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

import javax.swing.*;

import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

import javax.sound.sampled.*;
/**
 * @author Julio Gonzalez, Diego Morales, Diego Sosa
 * @version 2.0
 */
public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel txtRadio, titleRadio;
	private JButton Save;
	private URL FontURL;
	private Font font, fonttitle, fontcontrol;
	private GraphicsEnvironment ge;
 	private Clip [] clip;
 	private int song=0;
	private FloatControl gainControl;
	private int last;
	private boolean save;
	//NEW
	private boolean Encendido;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GUI() throws Exception{
		Encendido = false;
		Radio nRadio = new Radio();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		fontcontrol = new Font("Arial", Font.BOLD, 20);

		clip = new Clip[11];
		try{
			for(int i=0; i<11; i++){
				clip[i] = AudioSystem.getClip();
			}
		}
		catch(Exception e){
		}
		try{
		clip[0].open(AudioSystem.getAudioInputStream(new File("Content/Music/Beast.wav")));
		clip[1].open(AudioSystem.getAudioInputStream(new File("Content/Music/Girls_Just_Wanna_Have_Fun.wav")));
		clip[2].open(AudioSystem.getAudioInputStream(new File("Content/Music/La_Vie_En_Rose.wav")));
		clip[3].open(AudioSystem.getAudioInputStream(new File("Content/Music/Paper_Doll.wav")));
		clip[4].open(AudioSystem.getAudioInputStream(new File("Content/Music/Ten_Cents_A_Dance.wav")));
		clip[5].open(AudioSystem.getAudioInputStream(new File("Content/Music/The_Entertainer.wav")));
		clip[6].open(AudioSystem.getAudioInputStream(new File("Content/Music/Will_The_Circle_Be_Unbroken.wav")));
		clip[7].open(AudioSystem.getAudioInputStream(new File("Content/Music/Wonderful_Wonderful.wav")));
		clip[8].open(AudioSystem.getAudioInputStream(new File("Content/Music/You_Always_Hurt_The_One_You_Love.wav")));
		clip[9].open(AudioSystem.getAudioInputStream(new File("Content/Music/You_Belong_To_Me.wav")));
		clip[10].open(AudioSystem.getAudioInputStream(new File("Content/Music/Tunning.wav")));
		}
		catch(IOException e)
		{
			System.out.println("ERROR 0001: No se encontraron los archivos, asegurese de ubicar la carpeta Content junto a los .class");
		}
		/*gainControl = (FloatControl) clip[song].getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10);*/



		JButton btnONOFF = new JButton("ON/OFF");
		btnONOFF.setFont(new Font("Arial", Font.BOLD, 14));
		btnONOFF.setBackground(Color.LIGHT_GRAY);
		btnONOFF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nRadio.encenderApagar();
				try{
					if(Encendido){
						clip[song].stop();
						txtRadio.setBackground(Color.darkGray);
						txtRadio.setText(" ");
						Encendido=false;
					}
					else{
						clip[song].start();
						txtRadio.setBackground(Color.green);
						txtRadio.setText("      "+nRadio.getNum()+" "+nRadio.getFrec());
						Encendido=true;
					}
				}
				catch(Exception ex){
				}
			}
		});
		btnONOFF.setBounds(24, 11, 89, 23);
		contentPane.add(btnONOFF);

		JButton btnAmfm = new JButton("AM/FM");
		btnAmfm.setFont(new Font("Arial", Font.BOLD, 14));
		btnAmfm.setBackground(Color.LIGHT_GRAY);
		btnAmfm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Encendido){
					nRadio.cambiarFrec();
					txtRadio.setText("      "+nRadio.getNum()+" "+nRadio.getFrec());
					music(nRadio.getNum(), nRadio.getFrec());
				}
			}
		});
		btnAmfm.setBounds(695, 11, 89, 23);
		contentPane.add(btnAmfm);

		JButton buttonLtoR = new JButton(">");
		buttonLtoR.setOpaque(true);
		buttonLtoR.setBackground(Color.LIGHT_GRAY);
		buttonLtoR.setForeground(Color.BLACK);
		buttonLtoR.setFont(fontcontrol);
		buttonLtoR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Encendido){
					nRadio.adelantarEmisora();
					txtRadio.setText("      "+nRadio.getNum()+" "+nRadio.getFrec());
					music(nRadio.getNum(), nRadio.getFrec());
				}
			}
		});
		buttonLtoR.setBounds(734, 60, 50, 80);
		contentPane.add(buttonLtoR);

		JButton buttonRtoL = new JButton("<");
		buttonRtoL.setOpaque(true);
		buttonRtoL.setBackground(Color.LIGHT_GRAY);
		buttonRtoL.setForeground(Color.BLACK);
		buttonRtoL.setFont(fontcontrol);
		buttonRtoL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Encendido){
					nRadio.atrasarEmisora();
					txtRadio.setText("      "+nRadio.getNum()+" "+nRadio.getFrec());
					music(nRadio.getNum(), nRadio.getFrec());
				}
			}
		});
		buttonRtoL.setBounds(685, 60, 50, 80);
		contentPane.add(buttonRtoL);

		nBtn btn1 = new nBtn("1");
		btn1.setFont(new Font("Arial", Font.BOLD, 16));
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnControl(1,nRadio);
				music(nRadio.getNum(), nRadio.getFrec());
			}
		});
		btn1.setBounds(14, 165, 55, 50);
		contentPane.add(btn1);

		nBtn btn2 = new nBtn("2");
		btn2.setFont(new Font("Arial", Font.BOLD, 16));
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnControl(2,nRadio);
				music(nRadio.getNum(), nRadio.getFrec());
			}
		});
		btn2.setBounds(79, 165, 55, 50);
		contentPane.add(btn2);

		nBtn btn3 = new nBtn("3");
		btn3.setFont(new Font("Arial", Font.BOLD, 16));
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnControl(3,nRadio);
				music(nRadio.getNum(), nRadio.getFrec());
			}
		});
		btn3.setBounds(144, 165, 55, 50);
		contentPane.add(btn3);

		nBtn btn4 = new nBtn("4");
		btn4.setFont(new Font("Arial", Font.BOLD, 16));
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnControl(4,nRadio);
				music(nRadio.getNum(), nRadio.getFrec());
			}
		});
		btn4.setBounds(209, 165, 55, 50);
		contentPane.add(btn4);

		nBtn btn5 = new nBtn("5");
		btn5.setFont(new Font("Arial", Font.BOLD, 16));
		btn5.setBackground(Color.LIGHT_GRAY);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnControl(5,nRadio);
				music(nRadio.getNum(), nRadio.getFrec());
			}
		});
		btn5.setBounds(274, 165, 55, 50);
		contentPane.add(btn5);

		nBtn btn6 = new nBtn("6");
		btn6.setFont(new Font("Arial", Font.BOLD, 16));
		btn6.setBackground(Color.LIGHT_GRAY);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnControl(6,nRadio);
				music(nRadio.getNum(), nRadio.getFrec());
			}
		});
		btn6.setBounds(339, 165, 55, 50);
		contentPane.add(btn6);

		nBtn btn7 = new nBtn("7");
		btn7.setFont(new Font("Arial", Font.BOLD, 16));
		btn7.setBackground(Color.LIGHT_GRAY);
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnControl(7,nRadio);
				music(nRadio.getNum(), nRadio.getFrec());
			}
		});
		btn7.setBounds(404, 165, 55, 50);
		contentPane.add(btn7);

		nBtn btn8 = new nBtn("8");
		btn8.setFont(new Font("Arial", Font.BOLD, 16));
		btn8.setBackground(Color.LIGHT_GRAY);
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnControl(8,nRadio);
				music(nRadio.getNum(), nRadio.getFrec());
			}
		});
		btn8.setBounds(469, 165, 55, 50);
		contentPane.add(btn8);

		nBtn btn9 = new nBtn("9");
		btn9.setFont(new Font("Arial", Font.BOLD, 16));
		btn9.setBackground(Color.LIGHT_GRAY);
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnControl(9,nRadio);
				music(nRadio.getNum(), nRadio.getFrec());
			}
		});
		btn9.setBounds(534, 165, 55, 50);
		contentPane.add(btn9);

		nBtn btn10 = new nBtn("10");
		btn10.setFont(new Font("Arial", Font.BOLD, 16));
		btn10.setBackground(Color.LIGHT_GRAY);
		btn10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnControl(12,nRadio);
				music(nRadio.getNum(), nRadio.getFrec());
			}
		});
		btn10.setBounds(599, 165, 55, 50);
		contentPane.add(btn10);

		nBtn btn11 = new nBtn("11");
		btn11.setBackground(Color.LIGHT_GRAY);
		btn11.setFont(new Font("Arial", Font.BOLD, 16));
		btn11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnControl(11,nRadio);
				music(nRadio.getNum(), nRadio.getFrec());
			}
		});
		btn11.setBounds(664, 165, 55, 50);
		contentPane.add(btn11);

		nBtn btn12 = new nBtn("12");
		btn12.setBackground(Color.LIGHT_GRAY);
		btn12.setFont(new Font("Arial", Font.BOLD, 16));
		btn12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnControl(12,nRadio);
				music(nRadio.getNum(), nRadio.getFrec());
			}
		});
		btn12.setBounds(729, 165, 55, 50);
		contentPane.add(btn12);

		JButton btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Arial", Font.BOLD, 20));
		btnPlus.setBackground(Color.LIGHT_GRAY);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nRadio.subirVolumen();
				/*if(Encendido){
					FloatControl gainControl = (FloatControl) clip[song].getControl(FloatControl.Type.MASTER_GAIN);
					if(gainControl.getValue()<=2)
						gainControl.setValue((gainControl.getValue()+2));
					else
						gainControl.setValue(4);
				txtRadio.setText("        Volume: "+((int)(gainControl.getValue())+20));
				}*/

			}
		});
		btnPlus.setBounds(70, 60, 50, 80);
		contentPane.add(btnPlus);

		JButton btnMinus = new JButton("-");
		btnMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nRadio.bajarVolumen();
				/*if(Encendido){
				FloatControl gainControl = (FloatControl) clip[song].getControl(FloatControl.Type.MASTER_GAIN);
				if(gainControl.getValue()>=-18)
					gainControl.setValue((gainControl.getValue()-2));
				else
					gainControl.setValue(-20);
				txtRadio.setText("        Volume: "+((int)(gainControl.getValue())+20));
				}*/

			}
		});
		btnMinus.setFont(new Font("Arial", Font.BOLD, 20));
		btnMinus.setBackground(Color.LIGHT_GRAY);
		btnMinus.setBounds(20, 60, 50, 80);
		contentPane.add(btnMinus);

		txtRadio = new JLabel("");
		txtRadio.setForeground(Color.BLACK);
		try{
			FontURL = new URL("http://www.webpagepublicity.com/free-fonts/d/Digital%20Readout%20Upright.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, FontURL.openStream());
			font = font.deriveFont(Font.PLAIN,48);
			ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			txtRadio.setFont(font);
		}
		catch(Exception e){
			System.out.println("ERROR 002: No se ha podido cargar la fuente, por favor verifique su conexion a internet");
		}
		txtRadio.setOpaque(true);
		txtRadio.setBackground(Color.darkGray);
		txtRadio.setBounds(144, 44, 510, 110);
		contentPane.add(txtRadio);

		titleRadio = new JLabel("Radio D2J");
		try{
			FontURL = new URL("http://www.webpagepublicity.com/free-fonts/b/Battlestar.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, FontURL.openStream());
			font = font.deriveFont(Font.PLAIN,22);
			ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			titleRadio.setFont(font);
		}
		catch(Exception e){
			System.out.println("ERROR 002: No se ha podido cargar la fuente, por favor verifique su conexion a internet");
		}
		titleRadio.setBounds(300, 10, 170, 25);
		contentPane.add(titleRadio);

		Save = new JButton("Save");
		Save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Encendido){
					save = true;
					Save.setForeground(Color.red);
					System.out.println("Boton Save esta activado");
				}
			}
		});
		Save.setFont(new Font("Arial", Font.BOLD, 14));
		Save.setBackground(Color.LIGHT_GRAY);
		Save.setBounds(133, 11, 89, 23);
		contentPane.add(Save);
	}
	//Control de botones 1-12

	/**
	 *  Metodo que permite guardar la emisora en el boton deseado solo si se tiene activado el boton save
	 * @param posicion
	 * @param nRadio
	 */
	public void btnControl(int posicion, Radio nRadio)
	{
		if(Encendido){
			if(save) {
				double nEmisora=Double.parseDouble(nRadio.getNum());
				nRadio.guardarEmisora(nEmisora, posicion);
				save = false;
				System.out.println("El boton save esta desactivado");
				Save.setForeground(Color.black);
			}
			if (nRadio.cEmisora(posicion)!=0.0){
			txtRadio.setText("      "+nRadio.cEmisora(posicion)+"0 "+nRadio.getFrec());
			nRadio.cargarEmisora(nRadio.cEmisora(posicion));
			}
		}
	}

	//Music Controller
		/**
		 *  Metodo que permite implementar segun la emisora que se encuentre la cancion establecida
		 * @param x
		 * @param frec
		 */
		public void music(String x, String frec){
			if(x.equals("530.0"))
				song=0;
			else
			if(x.equals("780.0"))
				song=1;
			else
			if(x.equals("900.0"))
				song=2;
			else
			if(x.equals("1200.0"))
				song=3;
			else
			if(x.equals("1600.0"))
				song=4;
			else
			if(x.equals("87.90"))
				song=5;
			else
			if(x.equals("94.70"))
				song=6;
			else
			if(x.equals("99.70"))
				song=7;
			else
			if(x.equals("103.5"))
				song=8;
			else
			if(x.equals("107.5"))
				song=9;
			else
				song=10;
			if(last!=song){
				clip[last].stop();
				clip[song].start();
				last=song;
				if(!clip[song].isRunning())
					clip[song].setFramePosition(0);
			}
		}
}
class nBtn extends JButton{
	private double emisoraAM;
	private double emisoraFM;
	private String frec;
	public nBtn(String string)
	{
		super(string);
		emisoraAM = 0.0;
		emisoraFM = 0.0;
	}
	public void setEmisora(double emisora, String frec)
	{
		if(frec == "AM")
		{
			this.emisoraAM = emisora;
		} else {
			this.emisoraFM = emisora; 
		}	
	}
	public double getEmisora(String frec)
	{
		if(frec == "AM")
		{
			return this.emisoraAM;
		} else {
			return this.emisoraFM; 
		}	
	}
}
