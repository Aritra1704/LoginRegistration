package login_sys;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.UserDO;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login_System {

	private JFrame frame;
	private JTextField txtEmail;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_System window = new Login_System();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(206, 26, 75, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(40, 81, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(40, 151, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		txtEmail = new JTextField(10);
		txtEmail.setBounds(113, 76, 315, 26);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JPasswordField(10);
		txtPassword.setBounds(113, 146, 315, 26);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = txtPassword.getText();
				String email = txtEmail.getText();
				
				UserDO objUserDO = null;
				for(UserDO userDO: AppConstant.arrUsers) {
					if(userDO.email.equalsIgnoreCase(email))
						objUserDO = userDO;
				}
				if(objUserDO != null && objUserDO.password.equalsIgnoreCase(password)) {
					JOptionPane.showMessageDialog(null, "Successfull login", "Login Success", JOptionPane.PLAIN_MESSAGE);
					txtPassword.setText(null);
					txtEmail.setText(null);
				} else if(objUserDO != null) {
					JOptionPane.showMessageDialog(null, "Incorrect password", "Login Error", JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Login details", "Login Error", JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtEmail.setText(null);
				}
			}
		});
		btnLogin.setBounds(27, 211, 112, 29);
		frame.getContentPane().add(btnLogin);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnForgotPassword.setBounds(299, 211, 133, 29);
		frame.getContentPane().add(btnForgotPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register.main(null); 
			}
		});
		btnRegister.setBounds(164, 211, 117, 29);
		frame.getContentPane().add(btnRegister);
	}
}
