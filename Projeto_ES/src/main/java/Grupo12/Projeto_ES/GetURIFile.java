package Grupo12.Projeto_ES;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class GetURIFile { 
	public static void main(String[] args) throws Exception{
		String name = "AdelaideDjalo";
		try {
		File file = new File("URI" + name);
		PrintWriter printWriter = new PrintWriter(file);
		String httpsURL = "https://fenix.iscte-iul.pt/publico/publicPersonICalendar.do?method=iCalendar&username=aadoa@iscte.pt&password=alBC2CS6FVNgaUMbGgW2vihBSUO2yX9lfTjOPAcz06DRY7QkFrrnzsQweRkuXfCPMMAlBEtcye1jSaRgEPeCFjOXwEzITQvi3GhMM2rYp21wKDTXk8ATzbUNtwK1N6Xz";
		URL myUrl = new URL(httpsURL);
		HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
		InputStream is = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String inputLine;
		while ((inputLine = br.readLine()) != null) {
			printWriter.println(inputLine);
			//System.out.println(inputLine);
		}
		printWriter.close();
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	}
}
	