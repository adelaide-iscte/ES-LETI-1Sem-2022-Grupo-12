package Grupo12.Projeto_ES;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AddCal {
	private JFrame frame;
	private JButton addUrl;
	private JLabel label;
	private JTextField textField;
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
		
		frame.setLayout(new GridLayout(3,1));
		
		label = new JLabel ("Coloque o URL na caixa");
		frame.add(label);
		
		textField = new JTextField("Coloque aqui o URL");
		frame.add(textField);
		
		addUrl = new JButton ("Adicionar calendario");
		addUrl.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				frame.dispose();
				
			}
			
		});
		
		frame.add(addUrl);
		
		
	}
	
	public void open() {
		frame.setVisible(true);
	}
	
	
	
	

}
