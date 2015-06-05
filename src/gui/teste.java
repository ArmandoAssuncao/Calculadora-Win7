package gui;


import javax.swing.JFrame;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

import tipo.NomeBotoes;
import javax.swing.DropMode;

public class teste extends JFrame{
	
	public static void main(String[] args) {
		
		for(NomeBotoes botoes : NomeBotoes.values()){
			System.out.println(botoes.getNome());
		}
		
		new teste();
	}
	
	private JTextField textField;
	
	public void teste2() {
		
		JTextPane textPane = new JTextPane();
		getContentPane().add(textPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		getContentPane().add(textField, BorderLayout.WEST);
		textField.setColumns(10);
		
		JEditorPane editorPane = new JEditorPane();
		getContentPane().add(editorPane, BorderLayout.EAST);
		
		JTextArea textArea = new JTextArea();
		getContentPane().add(textArea, BorderLayout.SOUTH);
	}
	
	public teste(){
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JTextPane textPane = new JTextPane();
		panel.add(textPane);
		textPane.setSize(100, 100);
		JFrame frame = new JFrame("Colored Trails");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JButton btn;
	
	    JPanel mainPanel = new JPanel();
	    //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	    /*mainPanel.setSize(500,500);
	    mainPanel.setMaximumSize(new Dimension(200,300));
	    mainPanel.setMinimumSize(new Dimension(400,400));
	    mainPanel.setMaximumSize(new Dimension(100,100));
	    mainPanel.setPreferredSize(new Dimension(500, 500));*/
	    mainPanel.setBackground(Color.BLUE);
	    mainPanel.setLocation(20, 20);
	
	    JPanel firstPanel = new JPanel();
	    firstPanel.setLayout(new GridLayout(4, 4));
	    firstPanel.setMaximumSize(new Dimension(400, 400));
	    for (int i=1; i<=4; i++) {
	        for (int j=1; j<=4; j++) {
	            btn = new JButton();
	            btn.setPreferredSize(new Dimension(100, 100));
	            firstPanel.add(btn);
	        }
	    }
	
	   /* JPanel secondPanel = new JPanel();
	    secondPanel.setLayout(new GridBagLayout());
	    secondPanel.setLocation(90, 90);
	    secondPanel.setSize(800, 800);
	    secondPanel.setMaximumSize(new Dimension(800, 800));
	    secondPanel.setMinimumSize(new Dimension(800,800));
	    secondPanel.setBackground(Color.BLACK);
	    GridBagConstraints constraints = new GridBagConstraints();
	    constraints.insets = new Insets(3, 0, 0, 3);
	    for (int i=0; i<=5; i++) {
	        for (int j=0; j<=13; j++) {
	            btn = new JButton(j*i + "");
	            //btn.setSize(300, 300);
	            //btn.setMargin(new Insets(5,5,5,5));
	            constraints.fill = GridBagConstraints.BOTH;
	    		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
	            constraints.gridx = j;
	            constraints.gridy = i;
	            constraints.gridheight = 1;
	            constraints.gridwidth = 1;
	            secondPanel.add(btn, constraints);
	        }
	    }
	    
	    constraints.gridx = 5;
        constraints.gridy = 9;
        constraints.gridheight = 8;
        constraints.gridwidth = 4;
	    btn = new JButton("z");
	    //btn.setMargin(new Insets(5,50,50,5));
	    secondPanel.add(btn, constraints);
	    
	    constraints.gridx = 0;
        constraints.gridy = 8;
        //constraints.gridheight = 5;
        //constraints.gridwidth = 4;
	    btn = new JButton("x");
	    btn.setMargin(new Insets(200,50,100,50));
	    secondPanel.add(btn, constraints);*/
	    
	    JPanel terceiroPainel = new JPanel();
	    terceiroPainel.setBackground(Color.RED);
	    terceiroPainel.setPreferredSize(new Dimension(10,100));
	    /*terceiroPainel.setMaximumSize(new Dimension(200,200));
	    terceiroPainel.setMinimumSize(new Dimension(400,400));*/
	    terceiroPainel.setLocation(50, 2);
	
	    //mainPanel.add(firstPanel, BorderLayout.NORTH);
	    //mainPanel.add(secondPanel, BorderLayout.SOUTH);
	    //mainPanel.add(terceiroPainel, BorderLayout.SOUTH);
	    frame.setContentPane(mainPanel);
	
	    //frame.setSize(520,600);
	    frame.setMinimumSize(new Dimension(800,800));
	    //frame.setMaximumSize(new Dimension(300,300));
	    frame.setVisible(true);
	}

}
