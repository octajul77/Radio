import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ON/OFF");
		btnNewButton.setBounds(24, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAmfm = new JButton("AM/FM");
		btnAmfm.setBounds(514, 11, 89, 23);
		contentPane.add(btnAmfm);
		
		JButton button = new JButton("--->");
		button.setBounds(514, 132, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("<---");
		button_1.setBounds(10, 132, 89, 23);
		contentPane.add(button_1);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.setBounds(10, 179, 39, 23);
		contentPane.add(btnNewButton_1);
		
		JButton button_2 = new JButton("2");
		button_2.setBounds(59, 179, 40, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.setBounds(109, 179, 40, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.setBounds(159, 179, 40, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.setBounds(209, 179, 40, 23);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.setBounds(259, 179, 40, 23);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.setBounds(309, 179, 40, 23);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.setBounds(359, 179, 40, 23);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.setBounds(409, 179, 40, 23);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("10");
		button_10.setBounds(459, 179, 45, 23);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("11");
		button_11.setBounds(514, 179, 45, 23);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("12");
		button_12.setBounds(569, 179, 55, 23);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("+");
		button_13.setBounds(24, 51, 45, 23);
		contentPane.add(button_13);
		
		JButton btnNewButton_2 = new JButton("-");
		btnNewButton_2.setBounds(24, 85, 45, 23);
		contentPane.add(btnNewButton_2);
		
		txtRadio = new JTextField();
		txtRadio.setText("Radio 1.0");
		txtRadio.setBounds(525, 60, 86, 36);
		contentPane.add(txtRadio);
		txtRadio.setColumns(10);
	}
}