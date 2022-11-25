package Grupo12.Projeto_ES;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

import javax.net.ssl.HttpsURLConnection;

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
						String aeiou = sc.nextLine();
						System.out.println(aeiou);
						return aeiou;
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

	public static List<String> readDay(String string, int day) {

		File file = new File(string);
		List<String> aulas = new ArrayList<String>();
		String organizedDate = null;
		String disciplina=null;
		int startTime = 0;

		try {
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				String[] aux = sc.nextLine().split(":|\\ - |\\,");

				if (aux[0].equals("DTSTART") && Integer.parseInt(aux[1].substring(0, 8)) == day) {
					String unOrganizedDate = aux[1];

					if (unOrganizedDate.length() > 8) {
						organizedDate = unOrganizedDate.substring(0, 8);
						startTime = Integer.parseInt(unOrganizedDate.substring(9, 13));
					}
					sc.nextLine();
					String[] disciplinas = sc.nextLine().split(":|\\ - |\\,");

					if (disciplinas[0].equals("SUMMARY")) {
						disciplina = disciplinas[1];
					}
					String sala;
					while (!(sala = sc.nextLine()).split(":")[0].equals("LOCATION")) {
					}

					if (sala.split(":|\\ - |\\,")[0].equals("LOCATION")) {
						if (sala.split(":|\\ - |\\,").length > 1) {
							aulas.add(disciplina);
							aulas.add(sala.split(":|\\ - |\\,")[1]);
							aulas.add(Integer.toString((startTime + 100)));
						}
					}

					if (disciplinas[0].equals("DTEND")) {
						String endTime = disciplinas[1];

						if (endTime.length() > 8) {
							endTime = endTime.substring(9, 13);
						}
					}
					if (disciplinas[0].equals("DTSTART")) {
						String endTime = disciplinas[1];

						if (endTime.length() > 8) {
							endTime = endTime.substring(9, 13);
						}
					}

				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Não é possivel aceder ao ficheiro");
		}
		if (organizedDate != null)
			aulas.add(organizedDate);
		return aulas;
	}

	public static void createURIFile(String name, String uri) throws Exception {
		String fileName = name;
		File file = new File(fileName + "URI.txt");
		if (!file.exists()) {
			try {

				PrintWriter printWriter = new PrintWriter(fileName + "URI.txt");
				String httpsURL = "https:" + uri;
				URL myUrl = new URL(httpsURL);
				HttpsURLConnection conn = (HttpsURLConnection) myUrl.openConnection();
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String inputLine;
				while ((inputLine = br.readLine()) != null) {
					printWriter.println(inputLine);
					// System.out.println(inputLine);
				}
				printWriter.close();
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public static JSONObject getJsonWeek(String uri, int fistDay) {

		return null;
	}

	public static void main(String[] args) {

//		JSONObject json = new JSONObject();
//		JSONObject dia = new JSONObject();
//		JSONArray jArray = new JSONArray();
//
//		dia.put("disciplina", "PCD");
//		dia.put("horaInicio", "13:00");
//
//		jArray.put(2, dia);
//
//		json.put("2022/10/10", jArray);
//		json.put("atum", "tuna");
//		json.put("20221011", "PCD;1330;C405");
//		json.put("vvv", dia);
//
//		System.out.println(json.get("20221011").toString().split(";")[0]);
//		System.out.println((((JSONObject) json.get("vvv")).get("disciplina")));
//
//		String s = "aa:ss:aa";
//		String[] f = s.split("#");
//		System.out.println(f[0]);
//
//		String a = "DTSTART:20221010T100000Z";
//		String[] d = a.split(":");
//		String[] ab = a.split("T");
//		String[] abc = ab[3].split(":");
//		int week = 20221010;
//
//		System.out.println(abc[1]);
//		System.out.println((Integer.toString(week).equals(abc[1])));
//		System.out.println(d[0].equals("DTSTART"));

		try {
			createURIFile("Luis Fraga",
					"//fenix.iscte-iul.pt/publico/publicPersonICalendar.do?method=iCalendar&username=ldmfa@iscte.pt&password=WO0G8YATTP1tDnHcsadLlOXY7DVzzCFtAWEPoynnnwrrXisaK5XWziFEPrQWRBumQEpCAyhUtOLfEs9Q1qQncKseCMnNMVAf6LZd71erh2tDbygT5lJ9TENQKdiepPlN");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject semana = new JSONObject();
		int inicioSemana = 20221010;
		int j = 0;

		while (j <= 4) {
			System.out.println(inicioSemana);
			System.out.println(j);
			if (readDay("Luis FragaURI.txt", inicioSemana) != null) {
				List<String> day = new ArrayList<String>(readDay("Luis FragaURI.txt", inicioSemana));
				JSONObject info = new JSONObject();
				JSONObject hora = new JSONObject();
				int i = 0;
				for (String objects : day) {
					if (i == 3) {
						info = new JSONObject();
						i = 0;
					}
					if (i == 0)
						info.put("Disciplina", objects);
					if (i == 1)
						info.put("Sala", objects);
					if (i == 2)
						hora.put(objects, info);

					i++;
				}
				if (day.size() > 0)
					semana.put(day.get(day.size() - 1), hora);
			}
			j++;
			inicioSemana += 1;
		}
		System.out.println(semana);

	}

}
