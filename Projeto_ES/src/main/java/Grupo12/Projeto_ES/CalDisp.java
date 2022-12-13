package Grupo12.Projeto_ES;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
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

		cal.setSize(800, 500);

		cal.setLocation((width / 2) - 300, (height / 2) - 500);

		lerCalendario();

	}

	public void lerCalendario() {

		File file = new File("calendarios.txt");

		try {
			Scanner sc = new Scanner(file);

			contents = new ArrayList<String>();


			while (sc.hasNextLine()) {
				String[] aux = sc.nextLine().split(":");
				if (aux[0].equals("Nome")) {
					contents.add(aux[1]);

				}
			}

			cal.setLayout(new GridLayout(0, 4));
			
			addOpcoes();

			cal.add(new JLabel());
			cal.add(new JLabel());
			cal.add(new JLabel());
			cal.add(new JLabel());
			cal.add(new JLabel());
			
			addButtons();



			sc.close();
		} catch (FileNotFoundException e) {
			JLabel aviso = new JLabel("Não há calendarios disponiveis");
			cal.add(aviso);
			System.out.println("O ficheiro não existe");
		}

	}
	
	private void addButtons() {
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cal.dispose();
			}
		});
		JButton marcarReunioes = new JButton("Data/Hora Reunião");
		marcarReunioes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ReuniaoInterface reunião = new ReuniaoInterface();	
				reunião.open();
			}
		});

		cal.add(ok);
		cal.add(marcarReunioes);
	}
	
	private void addOpcoes() {
		JLabel nomes = new JLabel("Nome");
		cal.add(nomes);
		cal.add(new JLabel());
		cal.add(new JLabel());
		cal.add(new JLabel());

		for (final String i : contents) {
			JLabel nome = new JLabel(i);
			cal.add(nome);
			JButton semestre1 = new JButton("Semestre 1");

			semestre1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Semanas semana = new Semanas(1, i, contents);
					semana.open();

				}
			});
			JButton semestre2 = new JButton("Semestre 2");
			semestre2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Semanas semana = new Semanas(2, i, contents);
					semana.open();

				}
			});
			
			JButton pesquisar = new JButton ("Pesquisar");
			pesquisar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Semanas semana = new Semanas (3,i, contents);
					semana.open();
					
				}
			});


			cal.add(semestre1);
			cal.add(semestre2);
			cal.add(pesquisar);
			
		}
	}
	
	
	

	public void open() {
		cal.setVisible(true);
	}

}
