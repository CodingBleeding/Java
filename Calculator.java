import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 576);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.GRAY);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(160)
					.addComponent(textArea)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 543, GroupLayout.PREFERRED_SIZE)
					.addGap(219))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(360, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton button = new JButton("+");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(button);
		
		JButton button_1 = new JButton("-");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		panel.add(button_1);
		
		JButton button_4 = new JButton("1");
		button_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		panel.add(button_4);
		
		JButton button_5 = new JButton("2");
		button_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		panel.add(button_5);
		
		JButton button_6 = new JButton("3");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		panel.add(button_6);
		
		JButton button_3 = new JButton("\u00F7");
		button_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		panel.add(button_3);
		
		JButton button_2 = new JButton("\u00D7");
		panel.add(button_2);
		button_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		
		JButton button_7 = new JButton("4");
		button_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		panel.add(button_7);
		
		JButton button_8 = new JButton("5");
		button_8.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		panel.add(button_8);
		
		JButton button_9 = new JButton("6");
		button_9.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		panel.add(button_9);
		
		JButton button_13 = new JButton("(");
		button_13.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		panel.add(button_13);
		
		JButton button_14 = new JButton(")");
		button_14.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		panel.add(button_14);
		
		JButton button_10 = new JButton("7");
		button_10.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		panel.add(button_10);
		
		JButton button_11 = new JButton("8");
		button_11.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		panel.add(button_11);
		
		JButton button_12 = new JButton("9");
		button_12.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 65));
		panel.add(button_12);

	}
}
