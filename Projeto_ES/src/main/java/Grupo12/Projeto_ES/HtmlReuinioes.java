package Grupo12.Projeto_ES;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.Desktop;
import java.io.FileNotFoundException;

public class HtmlReuinioes {
	public static void reunioesHtml(JSONObject reunioes, ArrayList<String> participantes, int duracao) {		
		File file = new File("reunioes.html");
		try {
			PrintWriter printWriter = new PrintWriter(file);
			String html = "<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ " \r\n"
					+ "<body>\r\n"
					+ "    <h1>Datas/Horas Sugeridas</h1>\r\n"
					+ "        <table border=\"10\" cellspacing=\"0\" align=\"center\" bordercolor=\"grey\">\r\n"
					+ "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"50\"\r\n"
					+ "                width=\"100\">\r\n"
					+ "                <b><font color=\"blue\">Dia</font></b></br>\r\n"
					+ "            </td>\r\n"
					+ "            <td align=\"center\" height=\"50\"\r\n"
					+ "                width=\"100\">\r\n"
					+ "                <b><font color=\"blue\">Hora</font></b>\r\n"
					+ "            </td>\r\n"
					+ "            <td align=\"center\" height=\"50\"\r\n"
					+ "                width=\"100\">\r\n"
					+ "                <b><font color=\"red\">Participantes</font></b>\r\n"
					+ "            </td>\r\n"
					+ "        </tr>\r\n"
					+ row(reunioes , participantes, duracao)
					+ "       </table>\r\n"
					+ "</body>\r\n"
					+ "</html>";
			printWriter.println(html);
			printWriter.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Desktop desktop = Desktop.getDesktop();
			if (file.exists())
				desktop.open(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		file.delete();
	}
	public static String row(JSONObject reunioes,  ArrayList<String> participantes, int duracao) {
		String resultado = null;
		
		
		Iterator<String> jsonItr = reunioes.keys();
		
		while (jsonItr.hasNext()) {
			String dia = jsonItr.next();
			JSONArray horas = (JSONArray) reunioes.get(dia);
			for (Object hora: horas) {
				int finalReuniao = Integer.parseInt((String) hora) + duracao;
				resultado+= "        <tr>\r\n"
						+ "        	<td align=\"center\" height=\"100\">" + dia + "</td>\r\n"
						+ "            <td align=\"center\" height=\"100\">" + hora + "-" + finalReuniao + "</td>\r\n"
						+ "            <td align=\"center\" height=\"100\"><button type=\"button\" onclick=\"alert('" + participantes + "')\">Ver Detalhes</button></td>\r\n"
						+ "        </tr>\r\n";
			}
		}
		
		return resultado;
	}
	

}
