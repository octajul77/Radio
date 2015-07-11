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

public class GUII extends JFrame {

	private JPanel contentPane;
	private JLabel txtRadio, imgRadio;
	private URL FontURL;
	private Font font, fontcontrol;
	private GraphicsEnvironment ge;
 	private Clip [] clip;
 	private int song=0;
	private FloatControl gainControl;
	private int last;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUII frame = new GUII();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUII() throws Exception{

		Radio nRadio = new Radio();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		fontcontrol = new Font("Arial", Font.BOLD, 20);

		clip = new Clip[10];
		try{
			for(int i=0; i<10; i++){
				clip[i] = AudioSystem.getClip();
			}
		}
		catch(Exception e){
		}
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



		JButton btnONOFF = new JButton("ON/OFF");
		btnONOFF.setFont(new Font("Arial", Font.BOLD, 14));
		btnONOFF.setBackground(Color.LIGHT_GRAY);
		btnONOFF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nRadio.EncenderApagar();
				try{
				if(!nRadio.getEncendido()){
					clip[song].stop();
				}
				if(nRadio.getEncendido()){
					clip[song].start();
					gainControl = (FloatControl) clip[song].getControl(FloatControl.Type.MASTER_GAIN);
					gainControl.setValue(-10);
					txtRadio.setText("      "+nRadio.getNum()+" "+nRadio.getFrec());
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
				nRadio.CambiarFrec();
				txtRadio.setText("      "+nRadio.getNum()+" "+nRadio.getFrec());
				music(nRadio.getNum(), nRadio.getFrec());
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
				nRadio.AdelantarEmisora();
				txtRadio.setText("      "+nRadio.getNum()+" "+nRadio.getFrec());
				music(nRadio.getNum(), nRadio.getFrec());
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
				nRadio.AtrasarEmisora();
				txtRadio.setText("      "+nRadio.getNum()+" "+nRadio.getFrec());
				music(nRadio.getNum(), nRadio.getFrec());
			}
		});
		buttonRtoL.setBounds(685, 60, 50, 80);
		contentPane.add(buttonRtoL);

		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Arial", Font.BOLD, 16));
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double nEmisora=Double.parseDouble(nRadio.getNum());
				nRadio.GuardarEmisora(nEmisora, 1);
			}
		});
		btn1.setBounds(14, 165, 55, 50);
		contentPane.add(btn1);

		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Arial", Font.BOLD, 16));
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double nEmisora=Double.parseDouble(nRadio.getNum());
				nRadio.GuardarEmisora(nEmisora, 2);
			}
		});
		btn2.setBounds(79, 165, 55, 50);
		contentPane.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Arial", Font.BOLD, 16));
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double nEmisora=Double.parseDouble(nRadio.getNum());
				nRadio.GuardarEmisora(nEmisora, 3);
			}
		});
		btn3.setBounds(144, 165, 55, 50);
		contentPane.add(btn3);

		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Arial", Font.BOLD, 16));
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double nEmisora=Double.parseDouble(nRadio.getNum());
				nRadio.GuardarEmisora(nEmisora, 4);
			}
		});
		btn4.setBounds(209, 165, 55, 50);
		contentPane.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Arial", Font.BOLD, 16));
		btn5.setBackground(Color.LIGHT_GRAY);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double nEmisora=Double.parseDouble(nRadio.getNum());
				nRadio.GuardarEmisora(nEmisora, 5);
			}
		});
		btn5.setBounds(274, 165, 55, 50);
		contentPane.add(btn5);

		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Arial", Font.BOLD, 16));
		btn6.setBackground(Color.LIGHT_GRAY);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double nEmisora=Double.parseDouble(nRadio.getNum());
				nRadio.GuardarEmisora(nEmisora, 6);
			}
		});
		btn6.setBounds(339, 165, 55, 50);
		contentPane.add(btn6);

		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Arial", Font.BOLD, 16));
		btn7.setBackground(Color.LIGHT_GRAY);
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double nEmisora=Double.parseDouble(nRadio.getNum());
				nRadio.GuardarEmisora(nEmisora, 7);
			}
		});
		btn7.setBounds(404, 165, 55, 50);
		contentPane.add(btn7);

		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Arial", Font.BOLD, 16));
		btn8.setBackground(Color.LIGHT_GRAY);
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double nEmisora=Double.parseDouble(nRadio.getNum());
				nRadio.GuardarEmisora(nEmisora, 8);
			}
		});
		btn8.setBounds(469, 165, 55, 50);
		contentPane.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Arial", Font.BOLD, 16));
		btn9.setBackground(Color.LIGHT_GRAY);
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double nEmisora=Double.parseDouble(nRadio.getNum());
				nRadio.GuardarEmisora(nEmisora, 9);
			}
		});
		btn9.setBounds(534, 165, 55, 50);
		contentPane.add(btn9);

		JButton btn10 = new JButton("10");
		btn10.setFont(new Font("Arial", Font.BOLD, 16));
		btn10.setBackground(Color.LIGHT_GRAY);
		btn10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double nEmisora=Double.parseDouble(nRadio.getNum());
				nRadio.GuardarEmisora(nEmisora, 10);
			}
		});
		btn10.setBounds(599, 165, 55, 50);
		contentPane.add(btn10);

		JButton btn11 = new JButton("11");
		btn11.setBackground(Color.LIGHT_GRAY);
		btn11.setFont(new Font("Arial", Font.BOLD, 16));
		btn11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double nEmisora=Double.parseDouble(nRadio.getNum());
				nRadio.GuardarEmisora(nEmisora, 11);
			}
		});
		btn11.setBounds(664, 165, 55, 50);
		contentPane.add(btn11);

		JButton btn12 = new JButton("12");
		btn12.setBackground(Color.LIGHT_GRAY);
		btn12.setFont(new Font("Arial", Font.BOLD, 16));
		btn12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double nEmisora=Double.parseDouble(nRadio.getNum());
				nRadio.GuardarEmisora(nEmisora, 12);
			}
		});
		btn12.setBounds(729, 165, 55, 50);
		contentPane.add(btn12);

		JButton btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Arial", Font.BOLD, 20));
		btnPlus.setBackground(Color.LIGHT_GRAY);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nRadio.SubirVolumen();
				if(nRadio.getEncendido()){
					FloatControl gainControl = (FloatControl) clip[song].getControl(FloatControl.Type.MASTER_GAIN);
					if(gainControl.getValue()<=2)
						gainControl.setValue((gainControl.getValue()+2));
					else
						gainControl.setValue(4);
				txtRadio.setText("        Volume: "+((int)(gainControl.getValue())+20));
				}

			}
		});
		btnPlus.setBounds(70, 60, 50, 80);
		contentPane.add(btnPlus);

		JButton btnMinus = new JButton("-");
		btnMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nRadio.BajarVolumen();
				if(nRadio.getEncendido()){
				FloatControl gainControl = (FloatControl) clip[song].getControl(FloatControl.Type.MASTER_GAIN);
				if(gainControl.getValue()>=-18)
					gainControl.setValue((gainControl.getValue()-2));
				else
					gainControl.setValue(-20);
				txtRadio.setText("        Volume: "+((int)(gainControl.getValue())+20));
				}

			}
		});
		btnMinus.setFont(new Font("Arial", Font.BOLD, 20));
		btnMinus.setBackground(Color.LIGHT_GRAY);
		btnMinus.setBounds(20, 60, 50, 80);
		contentPane.add(btnMinus);

		txtRadio = new JLabel("------- Radio 1.7 -------");
		txtRadio.setForeground(Color.BLACK);
		FontURL = new URL("http://www.webpagepublicity.com/" +
            "free-fonts/d/Digital%20Readout%20Upright.ttf");
		font = Font.createFont(Font.TRUETYPE_FONT, FontURL.openStream());
		font = font.deriveFont(Font.PLAIN,48);
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(font);
		txtRadio.setFont(font);
		txtRadio.setOpaque(true);
		txtRadio.setBackground(Color.GREEN);
		txtRadio.setBounds(144, 44, 510, 110);
		contentPane.add(txtRadio);
	}

	//Music Controller
		public void music(String x, String frec){
			if(x.equals("530.0"))
				song=0;
			if(x.equals("580.0"))
				song=1;
			if(x.equals("620.0"))
				song=2;
			if(x.equals("660.0"))
				song=3;
			if(x.equals("700.0"))
				song=4;
			if(x.equals("87.90"))
				song=5;
			if(x.equals("89.10"))
				song=6;
			if(x.equals("90.70"))
				song=7;
			if(x.equals("91.90"))
				song=8;
			if(x.equals("92.50"))
				song=9;
			if(last!=song){
				clip[last].stop();
				clip[song].start();
				last=song;
			}
		}
}
