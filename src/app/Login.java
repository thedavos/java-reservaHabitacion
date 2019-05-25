package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import utils.*;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField usernametxt;
	private JTextField passwordtxt;
	public static JLabel beforeTimer;
	public static JLabel timer;
	public static Login dialog = new Login();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			initThread();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(100, 100, 334, 218);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(49, 56, 66, 15);
		contentPanel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(49, 108, 100, 15);
		contentPanel.add(lblContrasea);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(173, 54, 124, 19);
		contentPanel.add(usernametxt);
		usernametxt.setColumns(10);
		
		passwordtxt = new JTextField();
		passwordtxt.setBounds(173, 106, 124, 19);
		contentPanel.add(passwordtxt);
		passwordtxt.setColumns(10);
		
		beforeTimer = new JLabel("");
		beforeTimer.setBounds(62, 12, 223, 15);
		contentPanel.add(beforeTimer);
		
		timer = new JLabel("");
		timer.setBounds(249, 12, 48, 15);
		contentPanel.add(timer);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String username = usernametxt.getText();
						String password = passwordtxt.getText();
						
						Validation eval = new Validation();
						
						try {
							eval.validateLogin(username, password);
							dialog.dispose();
							
							Menu menu = new Menu();
							menu.setVisible(true);
							menu.setLocationRelativeTo(null);
							
						} catch (Throwable e) {
							JOptionPane.showMessageDialog(null, "Datos erróneos", "ERROR", JOptionPane.ERROR_MESSAGE);;
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}		
	}
	
	static void initThread() {
		Timer counter = new Timer();
		counter.start();
		try {
			counter.startCounter(dialog);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
