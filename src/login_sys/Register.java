package login_sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import model.UserDO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {

	private JFrame frame, frmRegiterSystem;
	private JTextField textField;
	private JPasswordField txtPassword;
	private JTextField txtEmail;
	private JTextField txtName;
	private JPasswordField txtConfPass;
	
	//https://www.youtube.com/watch?v=-hpX9oEvoXc

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBounds(180, 20, 61, 16);
		frame.getContentPane().add(lblRegister);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(59, 52, 61, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(59, 94, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(59, 139, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(59, 181, 114, 16);
		frame.getContentPane().add(lblConfirmPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(180, 134, 220, 26);
		frame.getContentPane().add(txtPassword);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(180, 89, 220, 26);
		frame.getContentPane().add(txtEmail);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(180, 47, 220, 26);
		frame.getContentPane().add(txtName);
		
		txtConfPass = new JPasswordField();
		txtConfPass.setBounds(180, 176, 220, 26);
		frame.getContentPane().add(txtConfPass);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String email = txtEmail.getText();
				String password = txtPassword.getText();
				String confPass = txtConfPass.getText();
				
				if(name.equals("") || email.equals("") || password.equals("") || confPass.equals("")) {
					JOptionPane.showMessageDialog(null, "Invalid Regitration Detail details", "Registration Error", JOptionPane.ERROR_MESSAGE);
					txtName.setText(null);
					txtEmail.setText(null);
					txtPassword.setText(null);
					txtConfPass.setText(null);
				} else if(!password.equalsIgnoreCase(confPass)) {
					JOptionPane.showMessageDialog(null, "Paswords don't match", "Registration Error", JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtConfPass.setText(null);
				} else if(!validateEmail(email)) {
					JOptionPane.showMessageDialog(null, "Incorrect Email format", "Registration Error", JOptionPane.ERROR_MESSAGE);
					txtEmail.setText(null);
				} else {
					UserDO objUserDO = new UserDO();
					objUserDO.name = name;
					objUserDO.email = email;
					objUserDO.password = password;
					
					AppConstant.arrUsers.add(objUserDO);
					
					txtName.setText(null);
					txtEmail.setText(null);
					txtPassword.setText(null);
					txtConfPass.setText(null);
					
					frmRegiterSystem = new JFrame("Exit");
					if(JOptionPane.showConfirmDialog(frmRegiterSystem, "Successfull registration", 
							"Registration Success", JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_NO_OPTION) {
//						System.exit(0);	
						frame.setVisible(false);
					}
					
				}
			}
		});
		btnSave.setBounds(69, 224, 117, 29);
		frame.getContentPane().add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(null);
				txtEmail.setText(null);
				txtPassword.setText(null);
				txtConfPass.setText(null);
			}
		});
		btnReset.setBounds(267, 224, 117, 29);
		frame.getContentPane().add(btnReset);
		
		
	}

	public static boolean validateEmail(String Mail) {
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(Mail);

        return matcher.matches();
    }
}
