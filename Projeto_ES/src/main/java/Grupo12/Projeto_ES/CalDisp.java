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

		cal.setLocation((width / 2) - cal.getWidth() + 100, (height / 2) - cal.getHeight() - 100);

		readCalendario();
	
		readFirstClass ("URI_teste.txt");
		
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
				if (aux[0].equals("Nome")) {
					contents.add(aux[1]);

				}
			}

			cal.setLayout(new GridLayout(num, 1));

			JLabel nomes = new JLabel("Nome");
			cal.add(nomes);

			for (String i : contents) {
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
	
	public static String getURI (String name) {
		File file = new File ("calendarios.txt");
		
		try {
			Scanner sc = new Scanner (file);
			while (sc.hasNextLine()) {
				String [] aux = sc.nextLine().split(":");
				if (aux[1].equals(name)) {
					return sc.nextLine();
				}
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Não é possivel aceder ao ficheiro");
		}
		
		System.out.println("Nome introduzido não econtrado");
		return null;
	}
	////
	public void readFirstClass (String string){

		File file = new File(string);

		
		try { 
			Scanner sc = new Scanner (file);
			while (sc.hasNextLine()) {
				String [] aux = sc.nextLine().split(":|\\ - ");

				if(aux[0].equals("X-WR-CALNAME")||aux[0].equals("SUMMARY")||aux[0].equals("LOCATION")){
					System.out.println("nome do aluno: " + aux[1]);
				}
				if(aux[0].equals("END")){
					sc.close();
					break;
				}
				if(aux[0].equals("DTSTART")){
					String unOrganizedDate = aux[1];
					String organizedDate;

					if(unOrganizedDate.length() >8){
						organizedDate = unOrganizedDate.substring(0,8);
						String startTime =unOrganizedDate.substring(9,13);
						System.out.println("data aula: " + organizedDate);
						System.out.println("hora aula: " +startTime);
					}
				}
				if(aux[0].equals("DTEND")){
					String endTime = aux[1];

					if(endTime.length() >8){
						endTime = endTime.substring(9,13);
						System.out.println("hora fim: " + endTime);
					}
				}
				
			}
			sc.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("Não é possivel aceder ao ficheiro");
		}
	}



	

	public void open() {
		cal.setVisible(true);
	}
	

}

