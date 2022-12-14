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
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

/**
 * Classe que cria a interface para criar e dar os argumentos para as reuniões
 */
public class ReuniaoInterface {

	private JFrame frame;
	private final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();;
	private final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private ArrayList<JCheckBox> boxes = new ArrayList<JCheckBox>();
	private ArrayList<String> nomes = new ArrayList<String>();
	private JComboBox<String> inicioDasReunioes;
	private JComboBox<String> opcoesDeRegularidade;
	private JRadioButton manha;
	private JRadioButton tarde;
	private JComboBox<String> opcoesDeDuracao;;

	/** Construtor a classe */
	public ReuniaoInterface() {
		frame = new JFrame("Reuniões");

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.setSize(500, 400);

		frame.setLocation((WIDTH / 2) - frame.getWidth() - 300, (HEIGHT / 2) - frame.getHeight() + 200);

		addFrameContents();

	}

	/** Método que adiciona os elementso da interface */
	private void addFrameContents() {
		frame.setLayout(new GridLayout(0, 1));

		frame.add(new JLabel("Participantes da reunião"));

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

			addCheckBoxe(contents);

			addPerferencia();

			addRegularidade();

			addInicioDasReunioes();

			addDuracoes();

			addButtons();

		} catch (FileNotFoundException e) {
			System.out.println("O ficheiro não foi econtrado");
		}

	}

	/** Método que adiciona as opções dos participantes das reuniões */
	private void addCheckBoxe(List<String> contents) {
		for (String nome : contents) {
			JCheckBox box = new JCheckBox(nome);
			boxes.add(box);
			frame.add(box);
		}
	}

	/** Método que coloca as opções da perferencia na interface */
	private void addPerferencia() {
		manha = new JRadioButton("Manhã");
		tarde = new JRadioButton("Tarde");

		ButtonGroup group = new ButtonGroup();
		group.add(manha);
		group.add(tarde);

		frame.add(new JLabel());

		frame.add(new JLabel("Preferencia na parte do dia"));
		frame.add(manha);
		frame.add(tarde);

		frame.add(new JLabel());
	}

	/** Método que coloca as opções da regularidade na interface */
	private void addRegularidade() {
		String[] opcao = { "Unica vez", "Semanal" };
		frame.add(new JLabel("Regularidade das reuniões"));

		opcoesDeRegularidade = new JComboBox<String>(opcao);
		frame.add(opcoesDeRegularidade);
	}

	/** Método que coloca as opções do inicio das reuniões na interface */
	private void addInicioDasReunioes() {
		ArrayList<String> inicioReunioes = new ArrayList<String>();

		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 14; j++) {
				inicioReunioes.add("Semestre" + i + "/Semana" + j);
			}
		}

		frame.add(new JLabel("Semana em que começam as reuniões"));

		String[] comecoReuniao = new String[inicioReunioes.size() + 2];

		for (int i = 0; i < inicioReunioes.size(); i++) {
			comecoReuniao[i] = inicioReunioes.get(i);
		}

		comecoReuniao[inicioReunioes.size()] = "Semestre2/Semana15";
		comecoReuniao[inicioReunioes.size() + 1] = "Semestre2/Semana16";

		inicioDasReunioes = new JComboBox<String>(comecoReuniao);
		frame.add(inicioDasReunioes);
	}

	/** Método que coloca as opções da duração da reunião na interface */
	private void addDuracoes() {
		frame.add(new JLabel("Duração da reunião"));

		String[] duracoes = { "15min", "30min", "1hora" };
		opcoesDeDuracao = new JComboBox<String>(duracoes);
		frame.add(opcoesDeDuracao);
	}

	/** Método que coloca os butões para interagir na interface */
	private void addButtons() {
		frame.add(new JLabel());

		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tarde.isSelected() && !manha.isSelected()) {
					JOptionPane.showMessageDialog(frame, "Prencha todos os campos");

				} else {
					participantes();
					if (nomes.size() == 0) {
						JOptionPane.showMessageDialog(frame, "Prencha todos os campos");

					} else {
						criarReuniao();
					}
				}
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
	}

	/** Método que cria um objeto Reuniao e gera a reunião */
	private void criarReuniao() {
		String[] semestreSemana = ((String) inicioDasReunioes.getSelectedItem()).split("Semestre|\\/|\\Semana");
		int dia = getDia(semestreSemana);
		boolean perferencia = getPerferencia();
		String regularidade = (String) opcoesDeRegularidade.getSelectedItem();
		String duracao = (String) opcoesDeDuracao.getSelectedItem();

		Reuniao reuniao = new Reuniao(dia, nomes, perferencia, regularidade, duracao);
		reuniao.gerarReuniao();

	}

	/** Método que devolve o dia para começar a criar as reuniões */
	private int getDia(String[] semestreSemana) {
		int dia = 0;

		if (Integer.parseInt(semestreSemana[1]) == 1)
			dia = 20220912;
		if (Integer.parseInt(semestreSemana[1]) == 2)
			dia = 20230206;

		int semana = Integer.parseInt(semestreSemana[3]);

		for (int i = 0; i < semana - 1; i++) {
			int semanaAnterior = dia;
			dia = Calendar.nextWeek(semanaAnterior);
		}

		return dia;
	}

	/**
	 * Método que coloca os nomes dos participantes numa lista para dar como
	 * argumento para a classe Reuniao
	 */
	private void participantes() {
		for (JCheckBox box : boxes) {
			if (box.isSelected()) {
				nomes.add(box.getText());
			}
		}
	}

	/** Método que devolve a perferencia */
	private boolean getPerferencia() {
		if (manha.isSelected())
			return true;

		return false;
	}

	/** Método para abrir a interface */
	public void open() {
		frame.setVisible(true);
	}

}
