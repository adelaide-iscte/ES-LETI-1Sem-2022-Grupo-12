package Grupo12.Projeto_ES;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONObject;

public class Reuniao {

	private int beginDay;
	private ArrayList<String> nomes = new ArrayList<String>();
	private boolean perferencia;
	private String regularidade;

	public Reuniao(int beginDay, ArrayList<String> nomes, boolean perferencia, String regularidade) {
		this.beginDay = beginDay;
		this.nomes = nomes;
		this.perferencia = perferencia;
		this.regularidade = regularidade;
	}

	public void gerarReuniao() {

		String aux1 = nomes.get(0);
		String aux2 = nomes.get(1);

		

		ArrayList<String> auxString = new ArrayList<String>(Calendar.availabilityOneWeek(aux1, aux2, beginDay));

		ArrayList<String> datas = filtrarDatas(auxString);

		JSONObject reunioes = turnToJson(datas);

		System.out.println(reunioes);
		
		HtmlReuinioes.reunioesHtml(reunioes, nomes);

	}
	
	
	private ArrayList<String> filtrarDatas (ArrayList<String> datasSugeridas){
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
	
	private JSONObject turnToJson (ArrayList<String> datas) {
		JSONObject reunioes = new JSONObject();
		
		ArrayList<String> horas = new ArrayList<String>();
		String dia = null;		
		
		for (String s : datas) {
			if (Integer.parseInt(s) > 2400) {
				if (horas.size() != 0) {
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
	
	
	
	
	
	
	

}
