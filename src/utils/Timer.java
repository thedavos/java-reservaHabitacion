package utils;

import javax.swing.JFrame;

import app.Login;

public class Timer extends Thread {
	
	public void startCounter(Login login) throws InterruptedException {
		Login.beforeTimer.setText("Esta ventana se cerrará en ");
		for (int i = 10; i >= 0; i--) {
			Login.timer.setText(i + "s");
			Thread.sleep(1000);
		}
		
		login.dispose();
	}
	
	public void startCounter(JFrame window) throws InterruptedException {
		for (int i = 10; i >= 0; i--) {
			Login.timer.setText(i + "s");
			Thread.sleep(1000);
		}
		
		window.dispose();
	}
}
