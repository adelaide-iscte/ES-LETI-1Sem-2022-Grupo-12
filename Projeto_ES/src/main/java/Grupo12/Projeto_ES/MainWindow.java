package Grupo12.Projeto_ES;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class MainWindow {
	
	private JFrame frame;
	private JButton viewCalendario;
	private JButton addCalendario;
	
	public MainWindow() {
		
		this.frame = new JFrame ("MainWindow");
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.setSize(300, 200);
		
		frame.setLocation(0, 200);
		
		addFrameContents();

	}
	
	
	public void addFrameContents() {
		
		frame.setLayout(new GridLayout(0,1));
		
		viewCalendario = new JButton("Vizualizar calendarios");
		viewCalendario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CalDisp calendario = new CalDisp();
				calendario.open();
				
				
			}
			
		});
		
		frame.add(viewCalendario);
		
		addCalendario = new JButton ("Adicionar um novo calendario");
		addCalendario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddCal addCal = new AddCal ();
				addCal.open();
				
			}
		});
		
		frame.add(addCalendario);
		
		frame.add(new JLabel());
		
		JButton terminar = new JButton("Terminar");
		
		terminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		frame.add(terminar);
		
	}
	
	public void open() {
		frame.setVisible(true);
	}
	
	
	

}
