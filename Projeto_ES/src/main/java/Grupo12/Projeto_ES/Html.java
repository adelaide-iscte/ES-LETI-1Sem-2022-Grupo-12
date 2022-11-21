package Grupo12.Projeto_ES;

import java.io.File;
import java.io.PrintWriter;
import java.awt.Desktop; 
import java.io.FileNotFoundException;


public class Html {
	public static void main(String[] args) {
		File file = new File("agenda.html");
		try {
        String hora = "8:00-9:30";
        String professor = "fixolas";
        String sala = "auditorio";
        String disciplina = "LeagueOfLegends";        
		int semana = 1;		
		
		PrintWriter printWriter = new PrintWriter(file);				
		String html = "<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ " \r\n"
				+ "<body>\r\n"
				+ "    <h1>Horário Semana 1</h1>\r\n"
				+ "    <table border=\"8\" cellspacing=\"0\" align=\"center\" bordercolor=\"blue\">\r\n"
				+ "        <tr>\r\n"
				+ "            <td align=\"center\" height=\"50\"\r\n"
				+ "                width=\"100\"><br>\r\n"
				+ "                <b>Hora/Dia</b></br>\r\n"
				+ "            </td>\r\n"
				+ "            <td align=\"center\" height=\"50\"\r\n"
				+ "                width=\"100\">\r\n"
				+ "                <b>Segunda</b>\r\n"
				+ "            </td>\r\n"
				+ "            <td align=\"center\" height=\"50\"\r\n"
				+ "                width=\"100\">\r\n"
				+ "                <b>Terça</b>\r\n"
				+ "            </td>\r\n"
				+ "            <td align=\"center\" height=\"50\"\r\n"
				+ "                width=\"100\">\r\n"
				+ "                <b>Quarta</b>\r\n"
				+ "            </td>\r\n"
				+ "            \r\n"
				+ "            <td align=\"center\" height=\"50\"\r\n"
				+ "                width=\"100\">\r\n"
				+ "                <b>Quinta</b>\r\n"
				+ "            </td>\r\n"
				+ "            <td align=\"center\" height=\"50\"\r\n"
				+ "                width=\"100\">\r\n"
				+ "                <b>Sexta</b>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td align=\"center\" height=\"100\">\r\n"
				+ "                <b>8:00-9:30</b></td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td align=\"center\" height=\"100\">\r\n"
				+ "                <b>9:30-11:00</b></td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td align=\"center\" height=\"100\">\r\n"
				+ "                <b>11:00-12:30</b></td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td align=\"center\" height=\"50\">\r\n"
				+ "                <b>12:30-13:00</b></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td align=\"center\" height=\"100\">\r\n"
				+ "                <b>13:00-14:30</b></td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td align=\"center\" height=\"100\">\r\n"
				+ "                <b>14:30-16:00</b></td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td align=\"center\" height=\"100\">\r\n"
				+ "                <b>16:00-17:30</b></td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td align=\"center\" height=\"50\">\r\n"
				+ "                <b>17:30-18:00</b></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "            <td align=\"center\" height=\"50\"></td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td align=\"center\" height=\"100\">\r\n"
				+ "                <b>18:00-19:30</b></td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td align=\"center\" height=\"100\">\r\n"
				+ "                <b>19:30-21:00</b></td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td align=\"center\" height=\"100\">\r\n"
				+ "                <b>21:00-22:30</b></td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "            <td align=\"center\" height=\"100\">Cadeira:<br>Sala:<br>Professor:</td>\r\n"
				+ "        </tr>\r\n"
				+ "    </table>\r\n"
				+ "</body>\r\n"
				+ " \r\n"
				+ "</html>";

		printWriter.println(html);
		printWriter.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	     try  {
	       Desktop desktop = Desktop.getDesktop();
	        if(file.exists()) desktop.open(file);
	     }  
	        catch(Exception e)  
	        {  
	            e.printStackTrace();  
	        }  
	     try {
	    	    Thread.sleep(10 * 1000);
	    	} catch (InterruptedException e) {
	    	    e.printStackTrace();
	    	}
	     file.delete();
	}
	
}


