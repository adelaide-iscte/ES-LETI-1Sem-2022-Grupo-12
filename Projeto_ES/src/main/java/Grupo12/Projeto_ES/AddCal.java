package Grupo12.Projeto_ES;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;



public class AddCal {
	private JFrame frame;
	private JButton addUrl;
	private JLabel labelURI;
	private JLabel labelName;
	private JTextField textFieldURI;
	private JTextField textFieldName;
	private final int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public AddCal() {
		
		this.frame = new JFrame ("addCalWindow");
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.setSize(300, 200);
		
		frame.setLocation((width/2)-frame.getWidth()+300, (height/2)-frame.getHeight());
		
		addFrameContents();
		
		
		}		
	
	
	public void addFrameContents() {
		
		frame.setLayout(new GridLayout(5,1));
		
		labelName = new JLabel ("Coloque o nome de quem pertenceo calendario");
		frame.add(labelName);
		
		textFieldName = new JTextField ("Coloque o nome aqui");
		frame.add(textFieldName);
		
		labelURI = new JLabel ("Coloque o URI na caixa");
		frame.add(labelURI);
		
		textFieldURI = new JTextField("Coloque aqui o URI");
		frame.add(textFieldURI);
		
		addUrl = new JButton ("Adicionar calendario");
		addUrl.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				calendarList(textFieldName.getText(), textFieldURI.getText());
				//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				frame.dispose();
				
			}
			
		});
		
		frame.add(addUrl);
		
		
	}
	
	public void open() {
		frame.setVisible(true);
	}
	
	public void calendarList(String nome, String uri) {
		File lista = new File("calendarios.txt");
		if (!lista.exists()) {
			try {
				PrintWriter printWriter;
				printWriter = new PrintWriter("calendarios.txt");
				printWriter.println("Nome:" + textFieldName.getText());
				printWriter.println("URI:" + textFieldURI.getText());
				printWriter.close();
				System.out.println("criei o novo file");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				List<String> nova_pessoa = new ArrayList<String>();
				nova_pessoa.add("Nome:" + textFieldName.getText() + "\r\n" + "URI:" + textFieldURI.getText()  );
				Scanner texto = new Scanner(lista);
				while (texto.hasNextLine()) {
					String aux = texto.nextLine();
					System.out.println(aux);
					nova_pessoa.add(aux);
				}
				PrintWriter printWriter = new PrintWriter (lista);
				
				for (String i : nova_pessoa) {
					printWriter.println(i);
				}
				
				texto.close();
				printWriter.close();
				System.out.println("modifiquei");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	

}
