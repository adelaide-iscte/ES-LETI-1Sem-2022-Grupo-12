package Grupo12.Projeto_ES;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

/** Classe para cirar e organizar as reuniões */
public class Reuniao {

	private int beginDay;
	private ArrayList<String> nomes = new ArrayList<String>();
	private boolean perferencia;
	private String regularidade;
	private String duracao;

	/** Construtuor da classe */
	public Reuniao(int beginDay, ArrayList<String> nomes, boolean perferencia, String regularidade, String duracao) {
		this.beginDay = beginDay;
		this.nomes = nomes;
		this.perferencia = perferencia;
		this.regularidade = regularidade;
		this.duracao = duracao;
	}

	/** Método principal para criar as reuniões e organiza-las em JSON */
	public void gerarReuniao() {

		ArrayList<String> marcacoes = new ArrayList<String>();

		if (regularidade.equals("Unica vez"))
			marcacoes = allmembersAvailability(beginDay);

		if (regularidade.equals("Semanal"))
			marcacoes = allMemberAvailabilityWeekly();

		ArrayList<String> datas = filtrarDatas(marcacoes);

		JSONObject reunioes = turnToJson(datas);

		int duracao = getDuracao();

		HtmlReuinioes.reunioesHtml(reunioes, nomes, duracao);

	}

	/** Método que devolve uma lista com as datas em relação à perferencia */
	private ArrayList<String> filtrarDatas(ArrayList<String> datasSugeridas) {
		ArrayList<String> datas = datasSugeridas;
		Iterator<String> itr = datas.iterator();

		while (itr.hasNext()) {
			String data = itr.next();
			if (perferencia) {
				if (Integer.parseInt(data) > 1300 && Integer.parseInt(data) < 2400) {
					itr.remove();
				}
			} else {
				if (Integer.parseInt(data) < 1300) {
					itr.remove();
				}
			}
		}

		return datas;

	}

	/**
	 * Método que devolve um objeto JSON a partir da lista das datas para as
	 * reuniões
	 */
	private JSONObject turnToJson(ArrayList<String> datas) {
		JSONObject reunioes = new JSONObject();

		ArrayList<String> horas = new ArrayList<String>();
		String dia = null;

		for (String s : datas) {
			if (Integer.parseInt(s) > 2400) {
				if (horas.size() != 0 && dia != null) {
					reunioes.put(dia, horas);
					dia = s;
					horas = new ArrayList<String>();
				} else {
					dia = s;
				}
			} else {
				horas.add(s);
			}
		}
		reunioes.put(dia, horas);

		return reunioes;
	}

	/**
	 * Método que compara as listas dos participantes da reunião para uma unica
	 * semana
	 */
	private ArrayList<String> allmembersAvailability(int day) {
		int beginWeek = day;
		ArrayList<String> marcacoes = new ArrayList<String>();

		if (nomes.size() == 1) {
			marcacoes.addAll(Calendar.availabilityOneWeek(nomes.get(0), null, beginWeek));
		} else {
			marcacoes = (ArrayList<String>) Calendar.availabilityOneWeek(nomes.get(0), nomes.get(1), beginWeek);
			for (int i = 2; i < nomes.size(); i++) {
				ArrayList<String> semanaParticipante = (ArrayList<String>) Calendar.availabilityOneWeek(nomes.get(i),
						null, beginWeek);
				ArrayList<String> aux = marcacoes;
				marcacoes = (ArrayList<String>) Calendar.compareAvailable2Days(aux, semanaParticipante);
			}
		}

		return marcacoes;
	}

	/** Método que devolve um inteiro em relação à data dada */
	private int getDuracao() {
		if (duracao.equals("15min"))
			return 15;

		if (duracao.equals("30min"))
			return 30;

		if (duracao.equals("1hora"))
			return 100;

		return 0;
	}

	/**
	 * Método que compara as listas dos participantes da reunião para várias semanas
	 */
	private ArrayList<String> allMemberAvailabilityWeekly() {
		ArrayList<String> semanal = new ArrayList<String>();
		int thisWeek = beginDay;

		if (beginDay < 20221216) {
			while (thisWeek <= 20221216) {
				int newWeek = thisWeek;
				semanal.addAll(allmembersAvailability(newWeek));
				thisWeek = Calendar.nextWeek(thisWeek);
			}
		} else {
			while (thisWeek <= 20230526) {
				semanal.addAll(allmembersAvailability(thisWeek));
				thisWeek = Calendar.nextWeek(thisWeek);
			}
		}

		return semanal;

	}

}
