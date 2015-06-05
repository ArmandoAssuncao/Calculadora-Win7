package tipo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class TrataEventos implements ActionListener{
	private String valorEvento;
	private JTextField textField;
	FuncoesCalculadora funcaoCalculadora = new FuncoesCalculadora();

	public String getValorEvento() {
		return valorEvento;
	}

	public void setValorEvento(String valorEvento) {
		this.valorEvento = valorEvento;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		valorEvento = arg0.getActionCommand();
		System.out.println(valorEvento);
		this.textField.setText( funcaoCalculadora.recebeNumero(valorEvento) );//Adiciona no JTextfield a string
	}
	
	public void editaCampoTexto(JTextField campoTexto){
		this.textField = campoTexto;
	}
}
