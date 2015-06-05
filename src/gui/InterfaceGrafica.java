package gui;

import tipo.FuncoesCalculadora;
import tipo.NomeBotoes;
import tipo.TrataEventos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGrafica extends JFrame{
	TrataEventos trataEvento;
	FuncoesCalculadora funcoesCalculadora;
	JPanel campoTexto;
	JPanel campoTotalBotoes;
	JPanel painelPrincipal;
	JTextField textField;
	Font fonteBotoes;
	Color corDeFundo;
	
	public InterfaceGrafica() {
		super("Calculadora");

		painelPrincipal = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));
		trataEvento = new TrataEventos();
		funcoesCalculadora = new FuncoesCalculadora();
		textField= new JTextField();
		corDeFundo = new Color(217, 228, 241);
		
		
		trataEvento.editaCampoTexto(textField);
		
		//Janela Principal
		setResizable(false);
		setSize(218, 312);
		//setLocationByPlatform(true);
		setLocationRelativeTo(null);
		
		//add a barra de Menu
		setJMenuBar(barraDeMenu());
		
		painelPrincipal.add(campoTexto());
		painelPrincipal.add(adicionaBotoes());
		painelPrincipal.setBackground(corDeFundo);
		
		//add barraDeMenu
		barraDeMenu();
		
		//add campoTexto
		//getContentPane().add(campoTexto());
		
		//add botoes
		//getContentPane().add(adicionaBotoes());

		getContentPane().add(painelPrincipal);
		
		setVisible(true);
	}//InterfaceGrafica()
	
	private JMenuBar barraDeMenu(){
		//Menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(190,20));
		//menuBar.setFont(fonteBotoes);
		
		JMenu menuExibir = new JMenu("Exibir");
		menuBar.add(menuExibir);
		
		JMenu menuEditar = new JMenu("Editar");
		menuBar.add(menuEditar);
		
		JMenu menuSobre = new JMenu("Sobre");
		menuBar.add(menuSobre);
		
		JMenuItem menuItemAutor = new JMenuItem("Autor");
		menuSobre.add(menuItemAutor);
		
		menuItemAutor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Cria a area de texto
				JTextArea areaTexto = new JTextArea(20, 20);
				areaTexto.setText("Autor: Armando Assunção");
				areaTexto.setEditable(false);
				areaTexto.setVisible(true);
				areaTexto.setBackground(Color.LIGHT_GRAY);
				areaTexto.setFont(new Font("SansSerif", Font.BOLD, 18));//Define a fonte
				
				//Cria a caixa de dialogo
				JDialog caixaAutor = new JDialog();
				caixaAutor.setSize(300, 100);
				caixaAutor.add(areaTexto);
				caixaAutor.setLocationRelativeTo(InterfaceGrafica.this);
				caixaAutor.setVisible(true);
			}
		});
		
		return menuBar;
	}
	
	private JPanel campoTexto(){
		//CampoTexto
		campoTexto = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		campoTexto.setSize(190, 50);
		campoTexto.setBackground(Color.BLUE);
		
		//textField
		Font fonteTexto = new Font("Consolas", Font.PLAIN, 23);
		Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
		//textField.setBackground(Color.WHITE);
		
		textField.setText("0");
		textField.setPreferredSize(new Dimension(190,50));
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setFont(fonteTexto);
		textField.setBorder(border);
		textField.setEditable(false);
		textField.setVisible(true);
		campoTexto.add(textField);
		
		return campoTexto;
	}
	
	public JPanel adicionaBotoes() {
		campoTotalBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		constraints.insets = new Insets(-4,2,9,3);

		//Cria um JPanel para adicionar os botoes
		JPanel campoBotoes = new JPanel(new GridBagLayout());
		campoBotoes.setBackground(corDeFundo);
		campoBotoes.setPreferredSize(new Dimension(200,200));
		
		Font fonteBotoes = new Font("Calibri", Font.PLAIN, 18);
		Insets insetsBotao = new Insets(0,2,-2,2); //Define a margem dos botões
		
		
		NomeBotoes nomeBotoes[] = NomeBotoes.values();
		String nomeBotao;
		int numBotoes = nomeBotoes.length;
		int numColunas = 5;
		int numLinhas = numBotoes / numColunas;
		int numBotoesRestantes = numBotoes % numColunas;
		
		int posicaoNomeBotao = 0;
		System.out.println(numBotoes);
		
		//adiciona os botões
		for(int linha = 0; linha < numLinhas; linha++){
			for(int coluna = 0; coluna < numColunas; coluna++){
				nomeBotao = nomeBotoes[posicaoNomeBotao].getNome();
				posicaoNomeBotao++;
				JButton botao = new JButton(nomeBotao);
				botao.setMargin(insetsBotao);
				botao.setFont(fonteBotoes);
				constraints.gridy = linha;
				constraints.gridx = coluna;
				constraints.gridwidth = 1;
				constraints.gridheight = 1;
				
				if(nomeBotao.equals("=")){
					constraints.gridheight = 2;
				}
				else if(nomeBotao.equals("0")){
					constraints.gridwidth = 2;
				}
				
				botao.addActionListener(trataEvento);
				campoBotoes.add(botao, constraints);
			}
		}
		//adiciona o restante dos botões
		for(int coluna = 0; coluna < numBotoesRestantes; coluna++){
			nomeBotao = nomeBotoes[posicaoNomeBotao].getNome();
			System.out.println(nomeBotao);
			posicaoNomeBotao++;
			JButton botao = new JButton(nomeBotao);
			botao.setMargin(insetsBotao);
			botao.setFont(fonteBotoes);
			constraints.gridy = numLinhas;
			constraints.gridx = coluna;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			
			if(nomeBotao.equals("=")){
				constraints.gridheight = 2;
			}
			if(nomeBotao.equals("0")){
				constraints.gridwidth = 2;
				coluna++;
				numBotoesRestantes++;
			}
			
			botao.addActionListener(trataEvento);
			campoBotoes.add(botao, constraints);
		}
		
		campoTotalBotoes.add(campoBotoes);
		return campoTotalBotoes;
	}
	/*
    public JPanel adicionaBotoes() {
		int coluna = 0;
		int linha = 1;

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.insets = new Insets(50,0,-47,3);

		//Cria um JPanel para adicionar os botoes
		JPanel campoBotoes = new JPanel(new GridBagLayout());
		campoBotoes.setSize(10, 10);
		campoBotoes.setLocation(100, 100);
		campoBotoes.setPreferredSize(new Dimension(10, 10));
		campoBotoes.setBackground(Color.cyan);
		
		//Botoes linha 1
		c.gridx = coluna;
		c.gridy = linha; 
		JButton botaoMC = new JButton("MC");
		campoBotoes.add(botaoMC, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoMR = new JButton("MR");
		campoBotoes.add(botaoMR, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoMS = new JButton("MS");
		campoBotoes.add(botaoMS, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoMPlus = new JButton("M+");
		campoBotoes.add(botaoMPlus, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoMSubt = new JButton("M-");
		campoBotoes.add(botaoMSubt, c);
		
		//Botoes linha 2
		coluna = 0;
		linha++;
		c.gridx = 0;
		c.gridy = linha;
		JButton botaoApagaChar = new JButton("<-");
		campoBotoes.add(botaoApagaChar, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoCE = new JButton("CE");
		campoBotoes.add(botaoCE, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoC = new JButton("C");
		campoBotoes.add(botaoC, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoMaisMenos = new JButton("+-");
		campoBotoes.add(botaoMaisMenos, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoRaiz = new JButton("raiz");
		campoBotoes.add(botaoRaiz, c);
		
		//Botoes linha 3
		coluna = 0;
		linha++;
		c.gridx = 0;
		c.gridy = linha;
		JButton botaoNum07 = new JButton("7");
		campoBotoes.add(botaoNum07, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoNum08 = new JButton("8");
		campoBotoes.add(botaoNum08, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoNum09 = new JButton("9");
		campoBotoes.add(botaoNum09, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoBarra = new JButton("/");
		campoBotoes.add(botaoBarra, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoPorcento = new JButton("%");
		campoBotoes.add(botaoPorcento, c);
		
		//Botoes linha 2
		coluna = 0;
		linha++;
		c.gridx = 0;
		c.gridy = linha;
		JButton botaoNum04 = new JButton("4");
		campoBotoes.add(botaoNum04, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoNum05 = new JButton("5");
		campoBotoes.add(botaoNum05, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoNum06 = new JButton("6");
		campoBotoes.add(botaoNum06, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoAsteristico = new JButton("*");
		campoBotoes.add(botaoAsteristico, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botao1SobreX = new JButton("1/x");
		campoBotoes.add(botao1SobreX, c);
		
		//Botoes linha 3
		coluna = 0;
		linha++;
		c.gridx = 0;
		c.gridy = linha;
		JButton botaoNum01 = new JButton("1");
		campoBotoes.add(botaoNum01, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoNum02 = new JButton("2");
		campoBotoes.add(botaoNum02, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoNum03 = new JButton("3");
		campoBotoes.add(botaoNum03, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoMenos = new JButton("-");
		campoBotoes.add(botaoMenos, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		c.gridheight = 2;
		JButton botaoIgual = new JButton("=");
		campoBotoes.add(botaoIgual, c);
		
		//Botoes linha 5
		coluna = 0;
		linha++;
		c.gridx = 0;
		c.gridy = linha;
		c.gridheight = 1;
		c.gridwidth = 2;
		JButton botaoNum00 = new JButton("0");
		campoBotoes.add(botaoNum00, c);
		
		c.gridwidth = 1;
		coluna+=1; //Aumenta em 1 a coluna porque o 0 ocupa dois espaços.
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoVirgula = new JButton(",");
		campoBotoes.add(botaoVirgula, c);
		
		c.gridx = ++coluna;
		c.gridy = linha;
		JButton botaoMais = new JButton("+");
		campoBotoes.add(botaoMais, c);

		botaoMC.addActionListener(trataEvento);
		botaoMR.addActionListener(trataEvento);
		botaoMS.addActionListener(trataEvento);
		botaoMPlus.addActionListener(trataEvento);
		botaoMSubt.addActionListener(trataEvento);
		botaoNum07.addActionListener(trataEvento);
		botaoNum08.addActionListener(trataEvento);
		botaoNum09.addActionListener(trataEvento);
		botaoBarra.addActionListener(trataEvento);
		botaoPorcento.addActionListener(trataEvento);
		botaoNum04.addActionListener(trataEvento);
		botaoNum05.addActionListener(trataEvento);
		botaoNum06.addActionListener(trataEvento);
		botaoAsteristico.addActionListener(trataEvento);
		botao1SobreX.addActionListener(trataEvento);
		botaoNum01.addActionListener(trataEvento);
		botaoNum02.addActionListener(trataEvento);
		botaoNum03.addActionListener(trataEvento);
		botaoMenos.addActionListener(trataEvento);
		botaoIgual.addActionListener(trataEvento);
		botaoApagaChar.addActionListener(trataEvento);
		botaoCE.addActionListener(trataEvento);
		botaoC.addActionListener(trataEvento);
		botaoMaisMenos.addActionListener(trataEvento);
		botaoRaiz.addActionListener(trataEvento);
		botaoNum00.addActionListener(trataEvento);
		botaoVirgula.addActionListener(trataEvento);
		botaoMais.addActionListener(trataEvento);
		
		return campoBotoes;
    }//adicionaBotoes()
    */
}