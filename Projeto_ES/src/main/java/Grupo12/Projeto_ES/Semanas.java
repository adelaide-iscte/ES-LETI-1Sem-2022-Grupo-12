package Grupo12.Projeto_ES;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
	}
	
	private void addPrimeiroSemestre () {
		frame.setLayout(new GridLayout(0,5));
		int dia = 20220912;
		
		for (int i=1;i<=14;i++) {
			final int day = dia;
			
			JButton semana = new JButton(Integer.toString(i));
			semana.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Calendar.gerarHorario(nome, day);
				}
				
			});
			frame.add(semana);
			dia = Calendar.nextWeek(dia);
		}
	}
		
		private void addSegundoSemestre () {
			frame.setLayout(new GridLayout(0,5));
			int dia = 20230206;

			
			for (int i=1;i<=16;i++) {
				final int day = dia;
				
				JButton semana = new JButton(Integer.toString(i));
				semana.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println(day);
						Calendar.gerarHorario(nome, day);
					}
					
				});
				frame.add(semana);
				dia = Calendar.nextWeek(dia);
				
			}
		
		
	}
	
		public void open() {
			frame.setVisible(true);
		}
	

}
