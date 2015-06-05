package app;

import javax.swing.JFrame;

import gui.InterfaceGrafica;

public class Calculadora {

	public static void main(String[] args) {
		InterfaceGrafica calculadora = new InterfaceGrafica();
		
		calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
