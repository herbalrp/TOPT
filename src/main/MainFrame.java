package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	
	private JPanel contentPane;
	JSpinner spinner = new JSpinner();
	JSpinner spinner_1 = new JSpinner();
	JSpinner spinner_2 = new JSpinner();
	JSpinner spinner_3 = new JSpinner();
	JSpinner spinner_4 = new JSpinner();
	JSpinner spinner_5 = new JSpinner();
	JSpinner spinner_6 = new JSpinner();
	JSpinner spinner_7 = new JSpinner();
	JSpinner spinner_8 = new JSpinner();
	JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("TOPT");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 812, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("F min");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
	
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 25));
		spinner.setModel(new SpinnerNumberModel(new Double(10), new Double(0), null, new Double(1)));
		
		
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		spinner_1.setModel(new SpinnerNumberModel(new Double(5), new Double(0), null, new Double(1)));
		
		
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		spinner_2.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		
		JLabel lblFMax = new JLabel("F max");
		lblFMax.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNumber = new JLabel("interspace");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNumber_1 = new JLabel("number");
		lblNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		
		spinner_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		spinner_3.setModel(new SpinnerNumberModel(new Integer(3), new Integer(0), null, new Integer(1)));
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Algorithm algorithm = new Algorithm((int) spinner_4.getValue(), (int) spinner_8.getValue(), (double) spinner_5.getValue(), 
						(double) spinner_6.getValue(), (int) spinner_7.getValue());
				String info = algorithm.start((double) spinner_1.getValue(), (double) spinner.getValue(), (int) spinner_2.getValue(), 
						(int) spinner_3.getValue());
				textArea.setText(" ");
				textArea.setText(info);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
		
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 25));
		textArea.setEditable(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 787, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblFMax)
								.addComponent(lblNumber)
								.addComponent(lblNumber_1))
							.addGap(8)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton))
								.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFMax))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumber))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNumber_1)
								.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
							.addGap(18)))
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_1 = new JLabel("population size");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblParametryAlgorytmuEwolucyjnego = new JLabel("Genetic algorithm");
		lblParametryAlgorytmuEwolucyjnego.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JButton btnNewButton_1 = new JButton("Default");
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblMutationP = new JLabel("crossing p.");
		lblMutationP.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblMutationP_1 = new JLabel("mutation p.");
		lblMutationP_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		
		spinner_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		spinner_4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
	
		spinner_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		spinner_5.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.0));
		
		
		spinner_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		spinner_6.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.0));
		
		JLabel lblTimes = new JLabel("time [s]");
		lblTimes.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		
		spinner_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		spinner_7.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				setDefault();
			}
		});
		
		JLabel label = new JLabel("time [s]");
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		spinner_8.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		
		spinner_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(lblParametryAlgorytmuEwolucyjnego)
							.addGap(117))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
											.addComponent(lblMutationP, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
											.addComponent(lblMutationP_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblTimes, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
										.addGap(74)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
									.addGap(74)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(spinner_8, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
											.addComponent(spinner_5, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
											.addComponent(spinner_6, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
											.addComponent(spinner_7, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
										.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
									.addGap(25))))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblParametryAlgorytmuEwolucyjnego)
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_8, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMutationP)
						.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMutationP_1)
						.addComponent(spinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTimes, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	protected void setDefault() {
		
		spinner_4.setValue(100);
		spinner_5.setValue(0.7);
		spinner_6.setValue(0.01);
		spinner_7.setValue(60);
		spinner_8.setValue(60);
		
		
	}
}
