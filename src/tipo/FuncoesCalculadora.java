package tipo;

public class FuncoesCalculadora {
	private final String operadores = "+\\-*/";
	private String expressao = "";
	private String operador = "";
	private String valor1 = "0";
	private String valor2 = "";
	private String resultado = "";
	private String menClear;
	private String menRecorver;
	private String menSave;
	private String menPlus; //PROVAVEL DE N USAR
	private String menSubt; //PROVAVEL DE N USAR
	
	public FuncoesCalculadora() {}
	
	public FuncoesCalculadora(String valor1, String valor2) {
		this.valor1 = valor1;
		this.valor2 = valor2;
	}

	public String getValor1() {
		return valor1;
	}

	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}

	public String getValor2() {
		return valor2;
	}

	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}
	
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	

	@Override
	public String toString() {
		return "Funcoes [valor1=" + valor1 + ", valor2=" + valor2 + "]";
	}
	
	public String recebeNumero(String valor){
		verificaValor(valor);
		editaExpressao();
		
		return expressao;
	}
	
	private void verificaValor(String valor){
		if(valor.matches("[0-9]")){
			if(operador.equals("")){
				if(valor1.equals("0")){
					valor1 = "";
				}
				valor1 += valor;
			}
			else{
				valor2 += valor;
			}
		}
		else if(valor.matches("(["+operadores+"]{1})")){
			if(valor2.equals("")){
				operador = valor;
			}
			else{
				verificaOperador();
				operador = valor;
				valor1 = resultado;
				valor2 = "";
				resultado = "";
			}
		}
		else if(valor.equals("=")){
			if(!resultado.equals("")){
				verificaOperador();
			}
			else if(!valor2.equals("")){
				verificaOperador();
				valor1 = resultado;
				valor2 = "";
				resultado = "";
				operador = "";
			}
			else if(!operador.equals("") && valor2.equals("")){
				valor2 = valor1;
				verificaOperador();
				valor1 = resultado;
				valor2 = "";
				resultado = "";
				operador = "";
			}
		}
	}
	
	private void verificaOperador(){
		//if(valor2.equals("")) return;
		
		switch(operador){
		case "+":
			soma();
			break;
		case "-":
			subtracao();
			break;
		case "*":
			multiplicacao();
			break;
		case "/":
			divisao();
			break;
		}
	}
	
	private void soma(){
		double result = Double.parseDouble(valor1) + Double.parseDouble(valor2);
		this.resultado =  String.valueOf(result);
		arredondaZero(resultado);
		expressao = resultado;
	}
	
	private void subtracao(){
		double result = Double.parseDouble(valor1) - Double.parseDouble(valor2);
		this.resultado =  String.valueOf(result);
		arredondaZero(resultado);
		expressao = resultado;
	}
	
	private void multiplicacao(){
		double result = Double.parseDouble(valor1) * Double.parseDouble(valor2);
		this.resultado =  String.valueOf(result);
		arredondaZero(resultado);
		expressao = resultado;
	}
	
	private void divisao(){
		double result = Double.parseDouble(valor1) / Double.parseDouble(valor2);
		this.resultado =  String.valueOf(result);
		arredondaZero(resultado);
		expressao = resultado;
	}
	
	private void arredondaZero(String valor){
		if(valor.matches(".*\\.0")){
			resultado = resultado.substring(0, resultado.lastIndexOf("."));
			expressao = resultado;
		}
	}
	
	
	private void editaExpressao(){
		expressao = String.format("%s%s%s%s", valor1, operador, valor2, resultado);
	}
	
}
