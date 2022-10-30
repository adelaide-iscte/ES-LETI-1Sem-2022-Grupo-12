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
	private JLabel labelURI;
	private JLabel labelName;
	private JTextField textFieldURI;
	private JTextField textFieldName;
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
		
		frame.setLayout(new GridLayout(5,1));
		
		labelName = new JLabel ("Coloque o nome de quem pertenceo calendario");
		frame.add(labelName);
		
		textFieldName = new JTextField ("Coloque o nome aqui");
		frame.add(textFieldName);
		
		labelURI = new JLabel ("Coloque o URI na caixa");
		frame.add(labelURI);
		
		textFieldURI = new JTextField("Coloque aqui o URI");
		frame.add(textFieldURI);
		
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
