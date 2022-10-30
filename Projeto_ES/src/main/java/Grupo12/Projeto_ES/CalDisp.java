package Grupo12.Projeto_ES;


import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class CalDisp {

	private JFrame cal;
	private final int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private ArrayList<String> contents;

	public CalDisp() {
		cal = new JFrame("Calendarios");

		cal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		cal.setSize(300, 200);

		cal.setLocation((width / 2) - cal.getWidth() + 100, (height / 2) - cal.getHeight() - 300);

		readCalendario();
	}

	public void readCalendario() {


		File file = new File("calendarios.txt");

		try {
			Scanner sc = new Scanner(file);

			contents = new ArrayList<String>();

			int num = 1;

			while (sc.hasNextLine()) {
				num++;
				String[] aux = sc.nextLine().split(":");
				System.out.println(aux[0]);
				if (aux[0].equals("Nome")) {
					contents.add(aux[1]);

				}
			}

			cal.setLayout(new GridLayout(num, 1));

			JLabel nomes = new JLabel("Nome");
			cal.add(nomes);

			for (String i : contents) {
				System.out.println(i);
				JLabel nome = new JLabel(i);
				cal.add(nome);
			}

			sc.close();
		} catch (FileNotFoundException e) {
			JLabel aviso = new JLabel("Não há calendarios disponiveis");
			cal.add(aviso);
			System.out.println("O ficheiro não existe");
		}

	}

	public void open() {
		cal.setVisible(true);
	}

}

