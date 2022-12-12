package Grupo12.Projeto_ES;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class ReuniaoInterface {

	private JFrame frame;
	private final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();;
	private final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();;

	public ReuniaoInterface() {
		frame = new JFrame("Reuniões");

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.setSize(500, 400);

		frame.setLocation((WIDTH / 2) - frame.getWidth()-300, (HEIGHT / 2) - frame.getHeight()+200);

		addFrameContents();

	}
	
	private void addFrameContents() {
		frame.setLayout(new GridLayout(0,1));
		
		frame.add(new JLabel ("Participantes da reunião"));
		
		File file = new File("calendarios.txt");
		
		try {
			Scanner sc = new Scanner(file);
			
			List<String> contents = new ArrayList<String>();
			
			while (sc.hasNextLine()) {
				String[] aux = sc.nextLine().split(":");
				if (aux[0].equals("Nome")) {
					contents.add(aux[1]);

				}
			}
			
			sc.close();

			
			for (String nome : contents) {
				JCheckBox box = new JCheckBox(nome);
				frame.add(box);
			}
			
			JRadioButton manha = new JRadioButton("Manhã");
			JRadioButton tarde = new JRadioButton("Tarde");
			
			ButtonGroup group = new ButtonGroup();
			group.add(manha);
			group.add(tarde);
			
			frame.add(new JLabel());
			
			frame.add(new JLabel("Preferencia na parte do dia"));
			frame.add(manha);
			frame.add(tarde);
			
			
			
			frame.add(new JLabel());
			
			String [] opcao = {"Nenhuma", "Diária", "Semanal", "Mensal"};
			frame.add(new JLabel("Regularidade das reuniões"));
			
			JComboBox<String> opcoes = new JComboBox<String>(opcao);
			frame.add(opcoes);
			
			ArrayList<String> inicioDasReunioes = new ArrayList<String>(); 
			
			for (int i=1;i<=2;i++) {
				for (int j=1;j<=14;j++) {
					inicioDasReunioes.add("Semestre" + i + "/Semana " + j);
				}
			}
			
			frame.add(new JLabel ("Semana em que começam as reuniões"));
			
			String [] comecoReuniao = new String[inicioDasReunioes.size()+2];
			
			for (int i=0;i<inicioDasReunioes.size();i++) {
				comecoReuniao[i]=inicioDasReunioes.get(i);
			}
			
			comecoReuniao[inicioDasReunioes.size()]= "Semestre2/Semana15";
			comecoReuniao[inicioDasReunioes.size()+1]= "Semestre2/Semana16";
			
			JComboBox<String> inicio = new JComboBox<String>(comecoReuniao);
			frame.add(inicio);
			
			
			
			frame.add(new JLabel());
			
			JButton ok = new JButton("OK");
			ok.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			
			frame.add(ok);
			
			JButton cancelar = new JButton("Cancelar");
			cancelar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();

				}
			});
			frame.add(cancelar);
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("O ficheiro não foi econtrado");
		}
			
	}
	
	public void open() {
		frame.setVisible(true);
	}

}
