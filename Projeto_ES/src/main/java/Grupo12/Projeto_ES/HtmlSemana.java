package Grupo12.Projeto_ES;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.JSONObject;

public class HtmlSemana {
	public static void main(String[] args) {
		File file = new File("agenda.html");
	    String numerosemana = "segunda";
		try {
			int day = 0;
			int horaCerta = 0;
			int horaEmeia = 0;
			int diaSeguinte = day;
			JSONObject semana= null;
			

			PrintWriter printWriter = new PrintWriter(file);
			String html = " <!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ " \r\n"
					+ "<body>\r\n"
					+ "    <h1>"+numerosemana+"</h1>\r\n"
					+ "    <table border=\"8\" cellspacing=\"0\" align=\"center\" bordercolor=\"red\">\r\n"
					+ "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"50\"\r\n"
					+ "                <b>" + horaCerta 
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)	+ "</tr>\r\n"
					+ "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>8:00-9:30</b></td>\r\n"
					+ "            <td align=\"center\" height=\"100\"><font color=\"orange\"></<b>Cadeira</b></font><br><font color=\"orange\">Sala:</font><br><font color=\"orange\">Professor:</font></td>\r\n"
					+ "\r\n"
					+ "        </tr>\r\n"
					+ "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaCerta 
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana) + "\r\n"
					+ "        </tr>\r\n"
					+ "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n"
					+  "                <b>" + horaCerta 
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)+ "/tr>\r\n"
					+ "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"50\">\r\n"
					+  "                <b>" + horaCerta 
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)+ "</tr>\r\n"
					+ "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaCerta 
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)+ "</tr>\r\n"
					+ "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaCerta 
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)
					+ "        </tr>\r\n"
					+ "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaCerta 
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)+ "</tr>\r\n"
					+ "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"50\">\r\n"
					+ "                <b>" + horaCerta 
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)+ "</tr>\r\n"
					+ "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaCerta 
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)+ "</tr>\r\n"
					+ "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaCerta 
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)+ "</tr>\r\n"
					+ "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaCerta 
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)+ "</tr>\r\n"
					+ "    </table>\r\n"
					+ "\r\n"
					+ "</body> \r\n"
					+ "</html>";
			printWriter.println(html);
			printWriter.close();
	
		}  catch (FileNotFoundException e) {
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
	public static String bloco(int hour, int day, JSONObject semana) {
		String hora = Integer.toString(hour);
		String dia = Integer.toString(day);		
		try {
		return "<td align=\"center\" height=\"100\"><font color=\"orange\">Cadeira:</font>"
				+ ((JSONObject)(((JSONObject)(semana.get(dia))).get(hora))).get("Disciplina") 
				+ "<br><font color=\"orange\">Sala:</font> "
				+ ((JSONObject)(((JSONObject)(semana.get(dia))).get(hora))).get("Sala")
				+ "<br><font color=\"orange\"></td>\r\n";
	
		}catch (org.json.JSONException e) {
			return "<td align=\"center\" height=\"100\"\r\n></td>\r\n";
		}
		
		
	}
	}


