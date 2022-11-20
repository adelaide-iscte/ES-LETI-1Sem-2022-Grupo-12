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

	public static void uriInformation(String name) {

		StringBuilder content = new StringBuilder();

//		try {
//			URI uri = new URI(WebcalUri.split(":")[2]);
//			URI newUri = new URI("http", uri.getHost(), uri.getPath(), uri.getQuery(), null);
//			URL url = newUri.toURL();
//			URLConnection urlConnection = url.openConnection();
//			BufferedReader buffReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//
//			String line;
//			while ((line=buffReader.readLine()) != null) {
//				content.append(line + "\n");
//			}
//			
//			buffReader.close();
//			
//			System.out.println(content.toString());
//
//		} catch (URISyntaxException e) {
//			System.out.println(
//					"Erro a formar o URI, certifique-se que ao adicionar o URI não deixou um espaço em branco no fim");
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try {
			URI uri = new URI(getURI(name).split(":")[2]);
			URI newUri = new URI("http", uri.getHost(), uri.getPath(), uri.getQuery(), null);
			URL url = newUri.toURL();

			InputStream in = url.openStream();
			Files.copy(in, Paths.get(name + "Calendario.txt"), StandardCopyOption.REPLACE_EXISTING);

			System.out.println(url.toString());

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void workWeek(String name, int week) {

		File f = new File(name + "Calendario.txt");
		int fullWeek = week;
		JSONObject allDays = new JSONObject();

		try {
			Scanner sc = new Scanner(f);

			while (fullWeek != (week + 5)) {
				while (sc.hasNextLine()) {
					String dtStart = sc.nextLine();
					if (dtStart.split(":")[0].equals("DTSTART")) {
						String[] start = dtStart.split("T");
						String[] date = start[3].split(":");
						if (date[1].equals(Integer.toString(fullWeek))) {
							while (!sc.nextLine().equals("END:VEVENT")) {
								System.out.println("It works");
								sc.nextLine();
							}
						}

					}
				}

				fullWeek++;
			}

			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static void readDay (String string, int day){

		File file = new File(string);

		
		try { 
			Scanner sc = new Scanner (file);
			while (sc.hasNextLine()) {
				String [] aux = sc.nextLine().split(":|\\ - ");

				if(aux[0].equals("X-WR-CALNAME")||aux[0].equals("SUMMARY")||aux[0].equals("LOCATION")){
					System.out.println(aux[1]);
				}
				if(aux[0].equals("END")){
					sc.close();
					break;
				}
				if(aux[0].equals("DTSTART")){
					String unOrganizedDate = aux[1];
					String organizedDate;

					if(unOrganizedDate.length() >8){
						organizedDate = unOrganizedDate.substring(0,8);
						String startTime =unOrganizedDate.substring(9,13);
						System.out.println("data aula: " + organizedDate);
						System.out.println("hora aula: " +startTime);
					}
				}
				if(aux[0].equals("DTEND")){
					String endTime = aux[1];

					if(endTime.length() >8){
						endTime = endTime.substring(9,13);
						System.out.println("hora fim: " + endTime);
					}
				}		
			}
			sc.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Não é possivel aceder ao ficheiro");
		}
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
		
		workWeek("Luis Fraga", 20221010);
		
		readDay ("URI_teste.txt", 20221010);

	}

}
