package utils;

import javax.swing.JOptionPane;

public class Validation {
	
	public void validateLogin(String username, String password) throws Throwable {
		String usernamePattern = "[a-zA-Z]+";
		String passwordPattern = "[a-z0-9]+";
		
		if (username.matches(usernamePattern) && password.matches(passwordPattern)) {
			JOptionPane.showMessageDialog(null, "Has sido validado, bienvenido al sistema!");
		} else {
			throw new Throwable();
		}
	}
}
