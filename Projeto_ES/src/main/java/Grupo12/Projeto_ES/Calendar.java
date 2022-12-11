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
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.Object;

public class Calendar {

	//Metodo a testar
	public static String getURI(String name) {
		File file = new File("calendarios.txt");

		if (file.exists()) {
			try {
				Scanner sc = new Scanner(file);
				while (sc.hasNextLine()) {
					String[] fileSplit = sc.nextLine().split(":");
					if (fileSplit[1].equals(name)) {
						String[] uri = sc.nextLine().split(":");
						if (uri[1].equals("webcal"))
							if (uri[2].split("//").length > 1) {
								return uri[2].split("//")[1];
							} else {
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
	
	/** Este metodo dado uma string que é o nome do fichiro URI e um dia em formato (aaaammdd),
	 * vai procurar no ficherio URI: a hora de começo a de fim o professor da cadeira, a cadeira,
	 * e a sala colocando estas Strings numa lista. */
	public static List<String> readDay(String string, int day) {

		File uri = new File(string);
		List<String> aulas = new ArrayList<String>();
		String organizedDate = null;
		String disciplina = null;
		int startTime = 0;
		try {
			Scanner sc = new Scanner(uri);

			while (sc.hasNextLine()) {
				String[] splittedString = sc.nextLine().split(":|\\ - |\\,");
				if (splittedString[0].equals("DTSTART") && Integer.parseInt(splittedString[1].substring(0, 8)) == day) {
					String unOrganizedDate = splittedString[1];
					if (unOrganizedDate.length() > 8) {
						organizedDate = unOrganizedDate.substring(0, 8);
						startTime = Integer.parseInt(unOrganizedDate.substring(9, 13));
					}
					sc.nextLine();
					String[] disciplinas = sc.nextLine().split(":|\\ - |\\,");
					if (disciplinas[0].equals("SUMMARY")) {
						disciplina = disciplinas[1];
					}
					String salaDeAula;
					while (!(salaDeAula = sc.nextLine()).split(":")[0].equals("LOCATION")) {
					}

					if (salaDeAula.split(":|\\ - |\\,")[0].equals("LOCATION")) {
						if (salaDeAula.split(":|\\ - |\\,").length > 1) {
							aulas.add(disciplina);
							aulas.add(salaDeAula.split(":|\\ - |\\,")[1]);
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
		return aulas;
	}

	//Metodo a testar
	/** Este metodo cria uma lista de todos os tempos disponiveis possiveis,Além disso este metodo também recebe a informação do metedo
	 *  readDay (readDay() devolve uma lista de informação),e procura nessa lista pelos tempos de começo de cada aula e compara com a lista anterior
	 *  devolvendo uma lista de tempos disponiveis */
	public static List<String> searchAvailability(List<String> ReadDay) {
		List<String> availableTimes = new ArrayList<String>();
		availableTimes.add("800");
		availableTimes.add("930");
		availableTimes.add("1100");
		availableTimes.add("1300");
		availableTimes.add("1430");
		availableTimes.add("1600");
		availableTimes.add("1730");
		availableTimes.add("1800");
		availableTimes.add("1930");
		availableTimes.add("2100");
		int i = 0;
		if (ReadDay != null) {
			for (String dayInfo : ReadDay) {
				if (i == 3)
					i = 0;
				if (i == 2) {
					if (availableTimes.contains(dayInfo)) {
						availableTimes.remove(dayInfo);
					}
				}
				i++;
			}
		}
		
		return availableTimes;
	}
	
	/** Este metodo recebe duas Listas de horas disponiveis e devolve uma lista de horas disponiveis comuns entre as listas anteriores */

	public static List<String> compareAvailable2Days(List<String> day1List, List<String> day2List) {
		List<String> availableHoursList = new ArrayList<String>();
		List<String> finalList = new ArrayList<String>();
		availableHoursList.addAll(day1List);
		availableHoursList.addAll(day2List);
		Set<String> set1 = new HashSet<>();
		for (String availableHours : availableHoursList) {
			if (!set1.add(availableHours)) {
				finalList.add(availableHours);
			}
		}
		System.out.println(finalList);
		return finalList;
	}
    /** O metodo recebe duas listas de horas disponiveis(cada uma de 1 utilizador diferente) e um dia de inicio de semana
     *  e devolve as horas disponiveis comuns entre os dois utilizadores ao longo de uma semana em foramto de lista  */
	public static List<String> availabilityOneWeek(String calName1,String calName2, int weekStart) {
		List<String> availableDates = new ArrayList<String>();
		List<String> availableHoursCal1 = new ArrayList<String>();
		List<String> availableHoursCal2 = new ArrayList<String>();
		List<String> comparedAvailableHours = new ArrayList<String>();
		int weekDay = weekStart;
		int j = 0;
		while (j <= 4) {
			if (readDay(calName1 + "URI.txt", weekDay) != null && readDay(calName2 + "URI.txt",weekDay)!= null) {
				List<String> calDay1 = new ArrayList<String>(readDay(calName1 + "URI.txt", weekDay));
				List<String> calDay2 = new ArrayList<String>(readDay(calName2 + "URI.txt", weekDay));
				availableHoursCal1 = searchAvailability(calDay1);
				availableHoursCal2 = searchAvailability(calDay2);
				comparedAvailableHours =compareAvailable2Days(availableHoursCal1,availableHoursCal2);
				availableDates.add(Integer.toString(weekDay));
				availableDates.addAll(comparedAvailableHours);
			}
			j++;
			weekDay = nextDay(weekDay);
		}
		return availableDates;
	}
	
	public static List<String> availabilityOneMonth(String calName1,String calName2,int monthStart){
		List<String> availableDates = new ArrayList<String>();
		int monthDay = monthStart;
		int j=0;
		
		while(j <= 3){
			if(isItMonthStart(monthStart)==true){
			availableDates.addAll(availabilityOneWeek(calName1,calName2,monthDay));
			monthDay =nextWeek(monthDay);
			j++;
			}
		}
	
		return availableDates;
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
				}
				printWriter.close();
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	//Metodo a testar
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

	//Metodo a testar
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
	public static boolean isItMonthStart (int day){
		if(day==20220912 || day==20221003||day==20221107||day==20221205||day==20230206||day==20230306||day==20230403||day==20230501)
			return true;
		return false;
	}
	


	public static JSONObject getJsonWeek(String uri, int fistDay) {

		return null;
	}

	public static JSONObject gerarHorarioSemana(String nome, int inicioSemana) {
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
		
		return semana;
	}

	public static JSONObject gerarHoarioDia(String nome, int dia) {
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
		return day;
	}

	public static void DisponibilidadeSemana(String nome, int dia) {
		try {
			createURIFile(nome, getURI(nome));
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject day = new JSONObject();

		if (readDay(nome + "URI.txt", dia) != null) {
			List<String> listaDia = new ArrayList<String>(readDay(nome + "URI.txt", dia));
			List<String> listaHorasLivres = new ArrayList<String>(searchAvailability(listaDia));

			JSONObject horaDisp = new JSONObject();

			for (String objects : listaHorasLivres) {

				horaDisp.put(objects, "");

			}
			if (listaDia.size() > 0)
				day.put(listaDia.get(listaDia.size() - 1), horaDisp);

		}
		System.out.println(day.get(Integer.toString(dia)));

		// Html.visualizarDia(dia, day);

	}
	
	public static void gerarHTMLSemana(String nome, int inicioSemana, int numeroSemana, ArrayList<String> nomes) {
		JSONObject semana = gerarHorarioSemana(nome, inicioSemana);
		
		Html.visualizarSemana(numeroSemana, inicioSemana, semana, nomes);
	}
	
	public static void gerarHTMLDia (String nome, int dia, ArrayList<String> nomes) {
		JSONObject day = gerarHoarioDia(nome, dia);
		
		Html.visualizarDia(dia, day, nomes);
	}
	
	
	

	public static void main(String[] args) {

		
		List<String> i = availabilityOneWeek("gr","Luis", 20220926);
		List<String> j = availabilityOneMonth("gr","Luis",20220912);

		//List<String> i = availabilityOneWeek("gr", 20220926);

		//		List<String> j = new ArrayList<String>(Arrays.asList("20220926", "800", "930", "1100", "1730", "1800", "1930",
		//				"20220927", "800", "930", "1800", "1930"));
		//		System.out.println("_____________________________");
		//		
		System.out.println(j);



	}

}
