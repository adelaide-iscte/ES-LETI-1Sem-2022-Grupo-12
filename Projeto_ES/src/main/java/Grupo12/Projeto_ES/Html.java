package Grupo12.Projeto_ES;

import java.io.File;

import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.JSONObject;

import java.awt.Desktop;
import java.io.FileNotFoundException;

/** Classe estática que cria os HTML para visualizar os horários */
public class Html {

	/**
	 * Método que cria o HTML para visualizar uma semana. Recebe como argumentos o
	 * numero da semana, o dia do inicio da semana, o objeto JSON com o horário, e
	 * uma lista com os nomes dos hoários que seram comparados com este para
	 * calcular a disponibilidade
	 */
	public static void visualizarSemana(int numeroSemana, int day, JSONObject semana, ArrayList<String> nomes) {
		File file = new File("agenda.html");
		try {
			int horaCerta = 8;
			int horaEmeia = 0;
			Disponibilidade disp = new Disponibilidade(nomes, day, semana);
			int diaSeguinte = day;
			PrintWriter printWriter = new PrintWriter(file);
			String html = "<!DOCTYPE html>\r\n" + "<html>\r\n" + " \r\n" + "<body>\r\n" + "    <h1>Horário Semana "
					+ numeroSemana + "</h1>\r\n"
					+ "    <table border=\"8\" cellspacing=\"0\" align=\"center\" bordercolor=\"blue\">\r\n"
					+ "        <tr>\r\n" + "            <td align=\"center\" height=\"50\"\r\n"
					+ "                width=\"300\"><br>\r\n" + "                <b>Hora/Dia</b></br>\r\n"
					+ "            </td>\r\n" + "            <td align=\"center\" height=\"50\"\r\n"
					+ "                width=\"300\">\r\n" + "                <b>Segunda(" + (diaSeguinte = day)
					+ ")</b>\r\n" + "            </td>\r\n" + "            <td align=\"center\" height=\"50\"\r\n"
					+ "                width=\"300\">\r\n" + "                <b>Terça("
					+ (diaSeguinte = Calendar.nextDay(diaSeguinte)) + ")</b>\r\n" + "            </td>\r\n"
					+ "            <td align=\"center\" height=\"50\"\r\n" + "                width=\"300\">\r\n"
					+ "                <b>Quarta(" + (diaSeguinte = Calendar.nextDay(diaSeguinte)) + ")</b>\r\n"
					+ "            </td>\r\n" + "            \r\n"
					+ "            <td align=\"center\" height=\"50\"\r\n" + "                width=\"300\">\r\n"
					+ "                <b>Quinta(" + (diaSeguinte = Calendar.nextDay(diaSeguinte)) + ")</b>\r\n"
					+ "            </td>\r\n" + "            <td align=\"center\" height=\"50\"\r\n"
					+ "                width=\"300\">\r\n" + "                <b>Sexta("
					+ (diaSeguinte = Calendar.nextDay(diaSeguinte)) + ")</b>\r\n        </tr>\r\n" + "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n" + "                <b>" + horaCerta
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ "        </tr>\r\n" + "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaEmeia + ":30-" + (horaCerta = horaEmeia + 2) + ":00</b></td>\r\n"
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = day), semana, disp)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ "        </tr>\r\n" + "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaCerta + ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ "        </tr>\r\n" + "        <tr>\r\n" + multBlocoVazio(12, 13) + "        </tr>\r\n"
					+ "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + (horaCerta += 2) + ":00-" + (horaEmeia = horaCerta + 1)
					+ ":30</b></td>\r\n" + bloco((horaCerta * 100), (diaSeguinte = day), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ "        </tr>\r\n" + "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaEmeia + ":30-" + (horaCerta = horaEmeia + 2) + ":00</b></td>\r\n"
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = day), semana, disp)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ "        </tr>\r\n" + "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaCerta + ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ "        </tr>\r\n" + "        <tr>\r\n" + multBlocoVazio(17, 18) + "        </tr>\r\n"
					+ "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + (horaCerta += 2) + ":00-" + (horaEmeia = horaCerta + 1)
					+ ":30</b></td>\r\n" + bloco((horaCerta * 100), (diaSeguinte = day), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ "        </tr>\r\n" + "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaEmeia + ":30-" + (horaCerta = horaEmeia + 2) + ":00</b></td>\r\n"
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = day), semana, disp)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco(((horaEmeia * 100) + 30), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ "        </tr>\r\n" + "        <tr>\r\n" + "            <td align=\"center\" height=\"100\">\r\n"
					+ "                <b>" + horaCerta + ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), (diaSeguinte = day), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ bloco((horaCerta * 100), (diaSeguinte = Calendar.nextDay(diaSeguinte)), semana, disp)
					+ "        </tr>\r\n" + "    </table>\r\n" + "    <tr>\r\n"
					+ "    <font color=\"blue\"></<b>AZUL</b></font> A disponibilidade dos utilizadores está livre.</font></td><br>\r\n"
					+ "    <font color=\"orange\"></<b>LARANJA</b></font> A disponibilidade dos utilizadores está parcialmente ocupada.</font></td></br>\r\n"
					+ "    <font color=\"red\"></<b>VERMELHO</b></font> A disponibilidade dos utilizadores está ocupada.</font></td></br>\r\n"
					+ "    </tr> </body>\r\n" + " \r\n" + "</html>";

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

	/**
	 * Método que cria o HTML para visualizar um dia. Recebe como argumentos o dia
	 * do inicio da semana, o objeto JSON com o horário, e uma lista com nomes
	 */
	public static void visualizarDia(int day, JSONObject semana, ArrayList<String> nomes) {
		File file = new File("agenda.html");
		try {
			int horaCerta = 8;
			int horaEmeia = 0;
			Disponibilidade disp = new Disponibilidade(nomes, day, semana);

			PrintWriter printWriter = new PrintWriter(file);
			String html = " <!DOCTYPE html>\r\n" + "<html>\r\n" + " \r\n" + "<body>\r\n" + "    <h1>" + day
					+ "</h1>\r\n"
					+ "    <table border=\"8\" cellspacing=\"0\" align=\"center\" bordercolor=\"red\">\r\n"
					+ "        <tr>\r\n" + "            <td align=\"center\" height=\"50\"\r\n                <b>"
					+ horaCerta + ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), day, semana, disp) + "        </tr>\r\n" + "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n" + "                <b>" + horaEmeia
					+ ":30-" + (horaCerta = horaEmeia + 2) + ":00</b></td>\r\n"
					+ bloco(((horaEmeia * 100) + 30), day, semana, disp) + "        </tr>\r\n" + "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n" + "                <b>" + horaCerta
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), day, semana, disp) + "        </tr>\r\n" + "        <tr>\r\n"
					+ umBlocoVazio(12, 13) + "        </tr>\r\n" + "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n" + "                <b>" + (horaCerta += 2)
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), day, semana, disp) + "        </tr>\r\n" + "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n" + "                <b>" + horaEmeia
					+ ":30-" + (horaCerta = horaEmeia + 2) + ":00</b></td>\r\n"
					+ bloco(((horaEmeia * 100) + 30), day, semana, disp) + "        </tr>\r\n" + "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n" + "                <b>" + horaCerta
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), day, semana, disp) + "        </tr>\r\n" + "        <tr>\r\n"
					+ umBlocoVazio(17, 18) + "        </tr>\r\n" + "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n" + "                <b>" + (horaCerta += 2)
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), day, semana, disp) + "        </tr>\r\n" + "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n" + "                <b>" + horaEmeia
					+ ":30-" + (horaCerta = horaEmeia + 2) + ":00</b></td>\r\n"
					+ bloco(((horaEmeia * 100) + 30), day, semana, disp) + "        </tr>\r\n" + "        <tr>\r\n"
					+ "            <td align=\"center\" height=\"100\">\r\n" + "                <b>" + horaCerta
					+ ":00-" + (horaEmeia = horaCerta + 1) + ":30</b></td>\r\n"
					+ bloco((horaCerta * 100), day, semana, disp) + "        </tr>\r\n" + "    </table>\r\n"
					+ "    <tr>\r\n"
					+ "    <font color=\"blue\"></<b>AZUL</b></font> A disponibilidade dos utilizadores está livre.</font></td><br>\r\n"
					+ "    <font color=\"orange\"></<b>LARANJA</b></font> A disponibilidade dos utilizadores está parcialmente ocupada.</font></td></br>\r\n"
					+ "    <font color=\"red\"></<b>VERMELHO</b></font> A disponibilidade dos utilizadores está ocupada.</font></td></br>\r\n"
					+ "    </tr>" + "</body>\r\n" + " \r\n" + "</html>";
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

	/** Método que devolve uma String para demonstrar blocos vazios no HTML */
	public static String multBlocoVazio(int horaInicio, int horaFim) {
		return "<td align=\"center\" height=\"50\">\r\n" + "                <b>" + horaInicio + ":30-" + horaFim
				+ ":00</b></td>\r\n" + "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n";

	}

	/** Método que devolve uma String para demonstrar um bloco vazio no HTML */
	public static String umBlocoVazio(int horaInicio, int horaFim) {
		return "<td align=\"center\" height=\"50\">\r\n" + "                <b>" + horaInicio + ":30-" + horaFim
				+ ":00</b></td>\r\n" + "<td align=\"center\" height=\"100\"\r\n></td>\r\n";
	}

	/**
	 * Método que devolve uma String para demonstrar um bloco que demonstra uma aula
	 * marcada ou um bloco vazio no HTML
	 */
	public static String bloco(int hour, int day, JSONObject semana, Disponibilidade disp) {
		String hora = Integer.toString(hour);
		String dia = Integer.toString(day);

		try {
			return "<td align=\"center\" height=\"100\"><font color=\"" + disp.getDisponibilidade(day, hour)
					+ "\">Cadeira:</font>"
					+ ((JSONObject) (((JSONObject) (semana.get(dia))).get(hora))).get("Disciplina")
					+ "<br><font color=\"" + disp.getDisponibilidade(day, hour) + "\">Sala:</font> "
					+ ((JSONObject) (((JSONObject) (semana.get(dia))).get(hora))).get("Sala") + "<br><font color=\""
					+ disp.getDisponibilidade(day, hour) + "\"></td>\r\n";

		} catch (org.json.JSONException e) {
			return "<td align=\"center\" height=\"100\"\r\n></td>\r\n";
		}
	}

}
