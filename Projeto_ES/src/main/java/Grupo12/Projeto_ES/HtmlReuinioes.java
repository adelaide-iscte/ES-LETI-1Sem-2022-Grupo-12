package Grupo12.Projeto_ES;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.Desktop;
import java.io.FileNotFoundException;

public class HtmlReuinioes {
	public static void main(String[] arg) {
		int hour = 1340;
		int day = 20202022;
		ArrayList<String> participantes = new ArrayList<>();
		String periodicidade = "semanal";
		String semana ="sexta-feira";
		
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
					+ "            <td align=\"center\" height=\"50\"\r\n"
					+ "                width=\"100\">\r\n"
					+ "                <b><font color=\"blue\">Periodicidade</font></b>\r\n"
					+ "            </td>\r\n"
					+ "            \r\n"
					+ "            <td align=\"center\" height=\"50\"\r\n"
					+ "                width=\"100\">\r\n"
					+ "                <b><font color=\"blue\">Dia da Semana</font></b>\r\n"
					+ "            </td>\r\n"
					+ "        </tr>\r\n"
					+ row(hour,day, participantes,periodicidade,semana)
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
	public static String row(int hour, int day, ArrayList<String> participantes, String periodicidade, String semana) {
		String hora = Integer.toString(hour);
		String dia = Integer.toString(day);
		return "        <tr>\r\n"
		+ "        	<td align=\"center\" height=\"100\">" + dia + "</td>\r\n"
		+ "            <td align=\"center\" height=\"100\">" + hora + "</td>\r\n"
		+ "            <td align=\"center\" height=\"100\"><button type=\"button\" onclick=\"alert('" + participantes + "')\">Ver Detalhes</button></td>\r\n"
		+ "            <td align=\"center\" height=\"100\">" + periodicidade + "</td>\r\n"
		+ "            <td align=\"center\" height=\"100\">" + semana + "</td>\r\n"
		+ "        </tr>\r\n";
	}
	

}
