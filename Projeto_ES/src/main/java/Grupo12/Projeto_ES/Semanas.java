package Grupo12.Projeto_ES;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Semanas {
	
	public int semestre;
	public String nome;
	public JFrame frame;
	private final int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public Semanas(int semestre, String nome) {
		this.semestre=semestre;
		this.nome=nome;
		
		frame = new JFrame(nome + " semestre " + semestre);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.setSize(1000, 300);

		frame.setLocation((width / 2) - frame.getWidth() + 300, (height / 2) - frame.getHeight());
		
		if (this.semestre==1)
			addPrimeiroSemestre ();
		if (this.semestre==2)
			addSegundoSemestre ();
		if (this.semestre==3)
			addPesquisar();
	}
	
	private void addPrimeiroSemestre () {
		frame.setLayout(new GridLayout(0,5));
		int dia = 20220912;
		
		for (int i=1;i<=14;i++) {
			final int day = dia;
			final int numeroSemana=i;

			
			JButton semana = new JButton(Integer.toString(i));
			semana.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Calendar.gerarHorarioSemana(nome, day, numeroSemana);
				}
				
			});
			frame.add(semana);
			dia = Calendar.nextWeek(dia);
		}
		for (int i=0;i<8;i++) {
			frame.add(new JLabel());
		}
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		
		frame.add(ok);
	}
		
		private void addSegundoSemestre () {
			frame.setLayout(new GridLayout(0,5));
			int dia = 20230206;

			
			for (int i=1;i<=16;i++) {
				final int day = dia;
				final int numeroSemana=i;
				
				JButton semana = new JButton(Integer.toString(i));
				semana.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println(day);
						Calendar.gerarHorarioSemana(nome, day, numeroSemana);
					}
					
				});
				frame.add(semana);
				dia = Calendar.nextWeek(dia);
				
			}
		
			for (int i=0;i<11;i++) {
				frame.add(new JLabel());
			}
			
			JButton ok = new JButton("Ok");
			ok.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					
				}
			});
			
			frame.add(ok);
			
			
	}
		
		private void addPesquisar () {
			frame.setLayout(new GridLayout(0,1));
			
			JLabel info = new JLabel("Colocque o dia em que a semana começa(Ex. 20221010)");
			frame.add(info);
			
			final JTextField data = new JTextField("");
			frame.add(data);
			
			final JCheckBox check = new JCheckBox("Pesquisar dia");
			frame.add(check);
			
			JButton pesquisar = new JButton("Pesquisar");
			pesquisar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (data.getText().equals("")) { 
						JOptionPane.showMessageDialog(frame, "Nehuma data foi selecionada");
					}else {
						if (check.isSelected()) {
							Calendar.gerarHoarioDia(nome, Integer.parseInt(data.getText()));
						}else {
							Calendar.gerarHorarioSemana(nome, Integer.parseInt(data.getText()), Integer.parseInt(data.getText()));
						}
						frame.dispose();
					}
					
				}
			});
			
			frame.add(pesquisar);
			
			JButton cancelar = new JButton("Cancelar");
			cancelar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					
				}
			});
			
			frame.add(cancelar);
			
		}
		
		
	
		public void open() {
			frame.setVisible(true);
		}
	

}
