package Grupo12.Projeto_ES;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainWindow {
	
	private JFrame frame;
	private JButton viewCalendario;
	private JButton addCalendario;
	private final int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public MainWindow() {
		
		this.frame = new JFrame ("MainWindow");
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.setSize(300, 200);
		
		frame.setLocation((width/2)-frame.getWidth(), (height/2)-frame.getHeight());
		
		addFrameContents();

	}
	
	
	public void addFrameContents() {
		
		frame.setLayout(new GridLayout(3,1));
		
		viewCalendario = new JButton("Vizualizar calendarios");
		viewCalendario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CalDisp cal = new CalDisp();
				cal.open();
				
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
		
		
		
		
	}
	
	public void open() {
		frame.setVisible(true);
	}
	
	
	

}
