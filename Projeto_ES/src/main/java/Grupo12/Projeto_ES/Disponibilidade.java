package Grupo12.Projeto_ES;

import java.util.ArrayList;

import org.json.JSONObject;

public class Disponibilidade {

	private ArrayList<String> nomes;
	private String dia;
	private JSONObject json;
	private String hora;

	public Disponibilidade(ArrayList<String> nomes, int dia, int hora, JSONObject json) {
		this.nomes = nomes;
		this.dia = Integer.toString(dia);
		this.hora = Integer.toString(hora);
		this.json = json;
	}

	public String disponibilidade() {
		int disp = 0;
		if (nomes.size() != 0) {
			for (String nome : nomes) {
				JSONObject jsonSecundario = Calendar.gerarHoarioDia(nome, Integer.parseInt(dia));
				if (((JSONObject) json.get(dia)).has(hora) && jsonSecundario.has(hora))
					disp++;
			}
		}
		if (disp==1) {
			return "yellow";
		}
		if (disp==2) {
			return "orange";
		}
		if (disp>=3) {
			return "red";
		}
		

		return "blue";
	}

}
