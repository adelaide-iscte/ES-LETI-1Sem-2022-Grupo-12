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
import java.util.Arrays;
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
						String[] uri = sc.nextLine().split(":");
						if (uri[1].equals("webcal"))
							if (uri[2].split("//").length > 1) {
								return uri[2].split("//")[1];
							}else {
								return uri[2];
							}
						if (uri[1].split("//").length > 1)
							return uri[1].split("//")[1];
						return uri[1];
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
		String disciplina = null;
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
							if (day < 20221031 || day >= 20230327) {
								aulas.add(Integer.toString((startTime + 100)));
							} else {
								aulas.add(Integer.toString(startTime));
							}
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
		System.out.println(Arrays.toString(aulas.toArray()));
		return aulas;
	}
	
	public static List<String> searchAvailability(List<String> Day){
		List<String> availableTimes = new ArrayList<String>();
		int availableBlock;
		int i= 0;
		if(Day!=null){
			for(String str:Day){
				if(i==3)
					i=0;
				if(i==2){
					availableTimes.add(str);
				}
				
				i++;
				
			}
		}
		System.out.println(Arrays.toString(availableTimes.toArray()));
		return availableTimes;

	}

	public static void createURIFile(String name, String uri) throws Exception {
		String fileName = name;
		File file = new File(fileName + "URI.txt");
		if (!file.exists()) {
			try {

				PrintWriter printWriter = new PrintWriter(fileName + "URI.txt");
				String httpsURL = "https://" + uri;
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

	public static int nextDay(int day) {
		if (day == 20220930)
			return 20221001;
		if (day == 20221031)
			return 20221101;
		if (day == 20221130)
			return 20221201;
		if (day == 20221231)
			return 20230101;
		if (day == 20230131)
			return 20230201;
		if (day == 20230228)
			return 20230301;
		if (day == 20230331)
			return 20230401;
		if (day == 20230430)
			return 20230501;
		if (day == 20230531)
			return 20230601;
		if (day == 20230630)
			return 20230701;
		if (day == 20230731)
			return 20230801;
		return day + 1;
	}

	public static int nextWeek(int day) {
		int nextWeek = day + 7;

		if (nextWeek > 20220930 && nextWeek < 20221001)
			return 20221001 + (nextWeek - 20220930 - 1);
		if (nextWeek > 20221031 && nextWeek < 20221101)
			return 20221101 + (nextWeek - 20221031 - 1);
		if (nextWeek > 20221130 && nextWeek < 20221201)
			return 20221201 + (nextWeek - 20221130 - 1);
		if (nextWeek > 20221231 && nextWeek < 20230101)
			return 20230101 + (nextWeek - 20221231 - 1);
		if (nextWeek > 20230131 && nextWeek < 20230201)
			return 20230201 + (nextWeek - 20230131 - 1);
		if (nextWeek > 20230228 && nextWeek < 20230301)
			return 20230301 + (nextWeek - 20230228 - 1);
		if (nextWeek > 20230331 && nextWeek < 20230401)
			return 20230401 + (nextWeek - 20230331 - 1);
		if (nextWeek > 20230430 && nextWeek < 20230501)
			return 20230501 + (nextWeek - 20230430 - 1);
		if (nextWeek > 20230531 && nextWeek < 20230601)
			return 20230601 + (nextWeek - 20230531 - 1);
		if (nextWeek > 20230630 && nextWeek < 20230701)
			return 20230701 + (nextWeek - 20230630 - 1);
		if (nextWeek > 20230731 && nextWeek < 20230801)
			return 20230801 + (nextWeek - 20230731 - 1);
		return nextWeek;
	}

	public static JSONObject getJsonWeek(String uri, int fistDay) {

		return null;
	}

	public static void gerarHorarioSemana(String nome, int inicioSemana, int numeroSemana) {

		try {
			createURIFile(nome, getURI(nome));
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject semana = new JSONObject();
		int diaDaSemana = inicioSemana;
		int j = 0;

		while (j <= 4) {
			if (readDay(nome + "URI.txt", diaDaSemana) != null) {
				List<String> day = new ArrayList<String>(readDay(nome + "URI.txt", diaDaSemana));
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
			diaDaSemana = nextDay(diaDaSemana);
		}

		Html.visualizarSemana(numeroSemana, inicioSemana, semana);
		System.out.println("..........");
		readDay(nome + "URI.txt", 20220929);
		System.out.println("..........");

		searchAvailability(readDay(nome + "URI.txt", 20220929));
		System.out.println("..........");

	}
	
	public static void gerarHoarioDia (String nome, int dia) {
		try {
			createURIFile(nome, getURI(nome));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONObject day = new JSONObject();

		if (readDay(nome + "URI.txt", dia) != null) {
			List<String> listaDia = new ArrayList<String>(readDay(nome + "URI.txt", dia));
			JSONObject info = new JSONObject();
			JSONObject hora = new JSONObject();
			int i = 0;
			for (String objects : listaDia) {
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
			if (listaDia.size() > 0)
				day.put(listaDia.get(listaDia.size() - 1), hora);
		}
		
		Html.visualizarDia(dia, day);
		
	}

}
