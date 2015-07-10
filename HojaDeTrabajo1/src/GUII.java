import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUII extends JFrame {

	private JPanel contentPane;
	private JTextField txtRadio;

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
	public GUII() {
		
		Radio nRadio = new Radio();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnONOFF = new JButton("ON/OFF");
		btnONOFF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nRadio.EncenderApagar();
			}
		});
		btnONOFF.setBounds(24, 11, 89, 23);
		contentPane.add(btnONOFF);
		
		JButton btnAmfm = new JButton("AM/FM");
		btnAmfm.setBounds(514, 11, 89, 23);
		contentPane.add(btnAmfm);
		
		JButton buttonLtoR = new JButton("--->");
		buttonLtoR.setBounds(514, 132, 89, 23);
		contentPane.add(buttonLtoR);
		
		JButton buttonRtoL = new JButton("<---");
		buttonRtoL.setBounds(10, 132, 89, 23);
		contentPane.add(buttonRtoL);
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(10, 179, 39, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setBounds(59, 179, 40, 23);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(109, 179, 40, 23);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(159, 179, 40, 23);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(209, 179, 40, 23);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setBounds(259, 179, 40, 23);
		contentPane.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(309, 179, 40, 23);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(359, 179, 40, 23);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(409, 179, 40, 23);
		contentPane.add(btn9);
		
		JButton btn10 = new JButton("10");
		btn10.setBounds(459, 179, 45, 23);
		contentPane.add(btn10);
		
		JButton btn11 = new JButton("11");
		btn11.setBounds(514, 179, 45, 23);
		contentPane.add(btn11);
		
		JButton btn12 = new JButton("12");
		btn12.setBounds(569, 179, 55, 23);
		contentPane.add(btn12);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setBounds(24, 51, 45, 23);
		contentPane.add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setBounds(24, 85, 45, 23);
		contentPane.add(btnMinus);
		
		txtRadio = new JTextField();
		txtRadio.setText("Radio 1.0");
		txtRadio.setBounds(525, 60, 86, 36);
		contentPane.add(txtRadio);
		txtRadio.setColumns(10);
	}
}