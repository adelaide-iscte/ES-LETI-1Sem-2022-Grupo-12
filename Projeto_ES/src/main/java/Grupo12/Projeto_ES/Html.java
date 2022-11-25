package Grupo12.Projeto_ES;

import java.io.File;

import java.io.PrintWriter;

import org.json.JSONObject;

import java.awt.Desktop;
import java.io.FileNotFoundException;

public class Html {
	public static void main(int day, JSONObject semana) {
		File file = new File("agenda.html");
		try {
			int horaCerta = 8;
			int horaEmeia = 0;
			int diaSeguinte = day;
			PrintWriter printWriter = new PrintWriter(file);
			String html = "<!DOCTYPE html>\r\n" + "<html>\r\n" + " \r\n" + "<body>\r\n"
					+ "    <h1>Horário Semana 1</h1>\r\n"
					+ "    <table border=\"8\" cellspacing=\"0\" align=\"center\" bordercolor=\"blue\">\r\n"
					+ "        <tr>\r\n" + "            <td align=\"center\" height=\"50\"\r\n"
					+ "                width=\"300\"><br>\r\n" + "                <b>Hora/Dia</b></br>\r\n"
					+ "            </td>\r\n" + "            <td align=\"center\" height=\"50\"\r\n"
					+ "                width=\"300\">\r\n" + "                <b>Segunda</b>\r\n"
					+ "            </td>\r\n" + "            <td align=\"center\" height=\"50\"\r\n"
					+ "                width=\"300\">\r\n" + "                <b>Terça</b>\r\n"
					+ "            </td>\r\n" + "            <td align=\"center\" height=\"50\"\r\n"
					+ "                width=\"300\">\r\n" + "                <b>Quarta</b>\r\n"
					+ "            </td>\r\n" + "            \r\n"
					+ "            <td align=\"center\" height=\"50\"\r\n" + "                width=\"300\">\r\n"
					+ "                <b>Quinta</b>\r\n" + "            </td>\r\n"
					+ "            <td align=\"center\" height=\"50\"\r\n" + "                width=\"300\">\r\n"
					+ "                <b>Sexta</b>\r\n" + "        </tr>\r\n" + "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n" + "                <b>" + horaCerta
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ "        </tr>\r\n" + "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaEmeia + ":30-" + (horaCerta = horaEmeia + 2) + ":00</b></td>\r\n"
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = day), semana)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ "        </tr>\r\n" + "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaCerta + ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ "        </tr>\r\n" + "        <tr>\r\n" + blocoVazio(12, 13) + "        </tr>\r\n"
					+ "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + (horaCerta += 2) + ":00-" + (horaEmeia = horaCerta + 1)
					+ ":30</b></td>\r\n" + bloco((horaCerta * 100), (diaSeguinte = day), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ "        </tr>\r\n" + "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaEmeia + ":30-" + (horaCerta = horaEmeia + 2) + ":00</b></td>\r\n"
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = day), semana)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ "        </tr>\r\n" + "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaCerta + ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ "        </tr>\r\n" + "        <tr>\r\n" + blocoVazio(17, 18) + "        </tr>\r\n"
					+ "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + (horaCerta += 2) + ":00-" + (horaEmeia = horaCerta + 1)
					+ ":30</b></td>\r\n" + bloco((horaCerta * 100), (diaSeguinte = day), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ "        </tr>\r\n" + "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaEmeia + ":30-" + (horaCerta = horaEmeia + 2) + ":00</b></td>\r\n"
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = day), semana)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ "        </tr>\r\n" + "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaCerta + ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana)
					+ "        </tr>\r\n" + "    </table>\r\n" + "</body>\r\n" + " \r\n" + "</html>";

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
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		file.delete();
	}

	public static String blocoVazio(int hora1, int hora2) {
		return "<td align=\"center\" height=\"50\">\r\n" + "                <b>" + hora1 + ":30-" + hora2
				+ ":00</b></td>\r\n" + "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n";

	}

	public static String umBlocoVazio() {
		return "<td align=\"center\" height=\"100\"\r\n></td>\r\n";
	}

	public static String bloco(int hour, int day, JSONObject semana) {
			System.out.println(day);
			System.out.println(hour);
		String hora = Integer.toString(hour);
		String dia = Integer.toString(day);
		
		try {
			System.out.println("Aula de " + ((JSONObject)(((JSONObject)(semana.get(dia))).get(hora))).get("Disciplina") 
					+ "na sala " + ((JSONObject)(((JSONObject)(semana.get(dia))).get(hora))).get("Sala"));
		return "<td align=\"center\" height=\"100\"><font color=\"blue\">Cadeira:</font>"
				+ ((JSONObject)(((JSONObject)(semana.get(dia))).get(hora))).get("Disciplina") 
				+ "<br><font color=\"blue\">Sala:</font> "
				+ ((JSONObject)(((JSONObject)(semana.get(dia))).get(hora))).get("Sala")
				+ "<br><font color=\"blue\"></td>\r\n";
		
		
		
		}catch (org.json.JSONException e) {
//			System.out.println("deu treta");
			return umBlocoVazio();
//			return "<td align=\"center\" height=\"50\">\r\n</td>\r\n"
//					+ "            <td align=\"center\" height=\"50\"></td>\r\n"
//					+ "            <td align=\"center\" height=\"50\"></td>\r\n"
//					+ "            <td align=\"center\" height=\"50\"></td>\r\n"
//					+ "            <td align=\"center\" height=\"50\"></td>\r\n"
//					+ "            <td align=\"center\" height=\"50\"></td>\r\n";
		}
	}

}
