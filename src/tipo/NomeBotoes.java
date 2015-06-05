package tipo;

public enum NomeBotoes {
	/*NOME_BOTOES("MC", "MR", "MS", "M+", "M-", "<-", "CE", "C", "+-", "V-", "7", "8", "9",
				"/", "%", "4", "5", "6", "*", "1/X", "1", "2", "3", "-", "=", "0", ",", "+");*/
	
	BOTAO_MenC("MC"),
	BOTAO_MenR("MR"),
	BOTAO_MenS("MS"),
	BOTAO_MenMais("M+"),
	BOTAO_MenMenos("M-"),
	BOTAO_BACK("<-"),
	BOTAO_CE("CE"),
	BOTAO_C("C"),
	BOTAO_MaisMenos("+-"),
	BOTAO_Raiz("V-"),
	BOTAO_7("7"),
	BOTAO_8("8"),
	BOTAO_9("9"),
	BOTAO_Divisao("/"),
	BOTAO_Porcento("%"),
	BOTAO_4("4"),
	BOTAO_5("5"),
	BOTAO_6("6"),
	BOTAO_Multiplicacao("*"),
	BOTAO_1SobreX("1/x"),
	BOTAO_1("1"),
	BOTAO_2("2"),
	BOTAO_3("3"),
	BOTAO_Menos("-"),
	BOTAO_Igual("="),
	BOTAO_0("0"),
	BOTAO_Virgula(","),
	BOTAO_Mais("+");
	
	private String nome;

	private NomeBotoes(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
