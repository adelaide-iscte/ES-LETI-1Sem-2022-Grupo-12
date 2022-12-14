package Grupo12.Projeto_ES;

import java.util.ArrayList;

import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;

/**
 * Classe que demonstra a disponibilidade de quem pertence o horario a ser
 * demonstrado em relacao aos outros escolhidos
 */
public class Disponibilidade {

	private ArrayList<String> nomes;
	private JSONObject json;
	private int inicioSemana;
	private ArrayList<JSONObject> jsons = new ArrayList<JSONObject>();

	/** Construtor da classe */
	public Disponibilidade(ArrayList<String> nomes, int inicioSemana, JSONObject json) {
		this.nomes = nomes;
		this.json = json;
		this.inicioSemana = inicioSemana;

		juntarHorarios();
	}

	/** Junta os horarios escolhidos para comparar e demonstrar a disponibilidade */
	public void juntarHorarios() {
		if (nomes != null) {
			for (String nome : nomes) {
				JSONObject jsonSecundario = Calendar.gerarHorarioSemana(nome, inicioSemana);
				jsons.add(jsonSecundario);
			}
		}
	}

	/**
	 * Devolve um String com o nome da cor a ser utilizada no HTML, qunto mais perto
	 * da cor vermelho menor a disponibilidade
	 */
	public String getDisponibilidade(int day, int hour) {
		String dia = Integer.toString(day);
		String hora = Integer.toString(hour);
		try {

			int disp = 0;
			if (jsons.size() != 0) {
				for (JSONObject jsonSecundario : jsons) {
					if (((JSONObject) json.get(dia)).has(hora) && ((JSONObject) jsonSecundario.get(dia)).has(hora))
						disp++;
				}
			}
			if (disp == 1) {
				return "goldenrod";
			}
			if (disp == 2) {
				return "orangered";
			}
			if (disp >= 3) {
				return "red";
			}

			return "blue";

		} catch (org.json.JSONException e) {
			return "blue";
		}

	}

}
