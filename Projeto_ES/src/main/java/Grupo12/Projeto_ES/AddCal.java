package Grupo12.Projeto_ES;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/** Classe para criar a interface com o utilizador para acrescentar hórarios */
public class AddCal {
	private JFrame frame;
	private JButton addUrl;
	private JLabel labelURI;
	private JLabel labelName;
	private JTextField textFieldURI;
	private JTextField textFieldName;
	private final int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	/** Construtor da classe */
	public AddCal() {

		this.frame = new JFrame("addCalWindow");

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.setSize(300, 200);

		frame.setLocation((width / 2) - frame.getWidth() + 300, (height / 2) - frame.getHeight());

		addFrameContents();

	}

	/** Método principal para adicionar os elementos da interface */
	public void addFrameContents() {

		frame.setLayout(new GridLayout(7, 1));

		labelName = new JLabel("Coloque o nome de quem pertenceo calendario");
		frame.add(labelName);

		textFieldName = new JTextField();
		frame.add(textFieldName);

		labelURI = new JLabel("Coloque o URI na caixa");
		frame.add(labelURI);

		textFieldURI = new JTextField();
		frame.add(textFieldURI);

		frame.add(new JLabel());

		addUrl = new JButton("Adicionar calendario");
		addUrl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (textFieldURI.getText().equals("") || textFieldName.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Um ou ambos os campos não estão preenchidos");
				} else {
					calendarList(textFieldName.getText(), textFieldURI.getText());
					frame.dispose();
				}

			}

		});

		frame.add(addUrl);

		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

			}
		});
		frame.add(cancelar);

	}

	/** Método para abrir a janela */
	public void open() {
		frame.setVisible(true);
	}

	/** Método para criar um ficheiro de texto para guardar os nomes e o s URIs */
	public void calendarList(String nome, String uri) {
		File lista = new File("calendarios.txt");
		if (!textFieldName.getText().equals("") || !textFieldURI.getText().equals("")) {
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
					List<String> novaPessoaLista = new ArrayList<String>();
					novaPessoaLista.add("Nome:" + textFieldName.getText() + "\r\n" + "URI:" + textFieldURI.getText());
					Scanner texto = new Scanner(lista);
					while (texto.hasNextLine()) {
						String aux = texto.nextLine();
						novaPessoaLista.add(aux);
					}
					PrintWriter printWriter = new PrintWriter(lista);

					for (String novaPessoa : novaPessoaLista) {
						printWriter.println(novaPessoa);
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

}
