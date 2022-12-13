package Grupo12.Projeto_ES;

import java.util.ArrayList;

import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;

public class Disponibilidade {

	private ArrayList<String> nomes;
	private JSONObject json;
	private int inicioSemana;
	private ArrayList<JSONObject> jsons = new ArrayList<JSONObject>();

	public Disponibilidade(ArrayList<String> nomes, int inicioSemana, JSONObject json) {
		this.nomes = nomes;
		this.json = json;
		this.inicioSemana = inicioSemana;
		
		juntarHorarios();
	}
	
	
	public void juntarHorarios () {
		if (nomes!= null) {
			for (String nome : nomes) {
				JSONObject jsonSecundario = Calendar.gerarHorarioSemana(nome, inicioSemana);
				jsons.add(jsonSecundario);
			}
		}
	}
	
	
	public String getDisponibilidade(int day, int hour) {
		String dia = Integer.toString(day);
		String hora = Integer.toString(hour);
		try {
		
		int disp = 0;
		if (jsons.size()!=0) {
			for (JSONObject jsonSecundario : jsons) {
				if (((JSONObject) json.get(dia)).has(hora) && ((JSONObject) jsonSecundario.get(dia)).has(hora))
					disp++;
			}
		}
		if (disp==1) {
			return "goldenrod";
		}
		if (disp==2) {
			return "orangered";
		}
		if (disp>=3) {
			return "red";
		}
		
		return "blue";
		
		}catch (org.json.JSONException e){
			return "blue";
		}
		
	}

}
