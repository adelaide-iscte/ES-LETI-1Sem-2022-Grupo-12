package Grupo12.Projeto_ES;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.Object;

public class Calendar {

	public static String getURI(String name) {
		File file = new File("calendarios.txt");

		if (file.exists()) {
			try {
				Scanner sc = new Scanner(file);
				while (sc.hasNextLine()) {
					String[] aux = sc.nextLine().split(":");
					if (aux[1].equals(name)) {
						return sc.nextLine();
					}
				}

				sc.close();
			} catch (FileNotFoundException e) {
				System.out.println("Não é possivel aceder ao ficheiro");
			}

		}
		System.out.println("Nome introduzido não econtrado");
		return null;
	}




	
	public static List<String> readDay (String string, int day){

		File file = new File(string);
		//oi
		List<String> aulas = new ArrayList<String>();
		


		try { 
			Scanner sc = new Scanner (file);



			while (sc.hasNextLine()) {
				String [] aux = sc.nextLine().split(":|\\ - |\\,");




				if(aux[0].equals("DTSTART") && Integer.parseInt(aux[1].substring(0,8))==day){
					String unOrganizedDate = aux[1];
					String organizedDate;

					if(unOrganizedDate.length() >8){
						organizedDate = unOrganizedDate.substring(0,8);
						aulas.add(organizedDate);
						int startTime = Integer.parseInt(unOrganizedDate.substring(9,13));
						System.out.println("data aula: " + organizedDate);
						System.out.println("hora aula: " + (startTime + 100));
						aulas.add(Integer.toString((startTime+100)));
						System.out.println("hora fim: " + (startTime + 230));
					}
						sc.nextLine();
						String [] aux1 = sc.nextLine().split(":|\\ - |\\,");

						System.out.println("meqie " + aux1[0]);
						if(aux1[0].equals("SUMMARY")){
							aulas.add(aux1[1]);
							System.out.println(aux1[1]);
						}
						String aux2;
						while(!(aux2 = sc.nextLine()).split(":")[0].equals("LOCATION")){
						}
						
						if (aux2.split(":|\\ - |\\,")[0].equals("LOCATION")){
							aulas.add(aux2.split(":|\\ - |\\,")[1]);
							System.out.println(aux2.split(":|\\ - |\\,")[1]);
						}

						if(aux1[0].equals("DTEND")){
							String endTime = aux1[1];
							

							if(endTime.length() >8){
								endTime = endTime.substring(9,13);
								System.out.println("hora fim: " + endTime);
							}
						}
						if(aux1[0].equals("DTSTART")){
							String endTime = aux1[1];

							if(endTime.length() >8){
								endTime = endTime.substring(9,13);
								System.out.println("hora inicio: " + endTime);
							}
						}
						
							
				}
			}
			sc.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Não é possivel aceder ao ficheiro");
		}
		return aulas;
	}


	public static void main(String[] args) {

		JSONObject json = new JSONObject();
		JSONObject dia = new JSONObject();
		JSONArray jArray = new JSONArray();

		dia.put("disciplina", "PCD");
		dia.put("horaInicio", "13:00");

		jArray.put(2, dia);

		json.put("2022/10/10", jArray);
		json.put("atum", "tuna");
		json.put("20221011", "PCD;1330;C405");
		json.put("vvv", dia);

		System.out.println(json.get("20221011").toString().split(";")[0]);
		System.out.println((((JSONObject) json.get("vvv")).get("disciplina")));

		String s = "aa:ss:aa";
		String[] f = s.split("#");
		System.out.println(f[0]);

		String a = "DTSTART:20221010T100000Z";
		String[] d = a.split(":");
		String[] ab = a.split("T");
		String[] abc = ab[3].split(":");
		int week = 20221010;

		System.out.println(abc[1]);
		System.out.println((Integer.toString(week).equals(abc[1])));
		System.out.println(d[0].equals("DTSTART"));


		readDay("URI_teste.txt", 20221018);

	}

}
