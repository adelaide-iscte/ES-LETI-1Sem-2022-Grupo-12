package Grupo12.Projeto_ES;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CalendarTest {

	@Test
	void testGetURI() {
		String resultado = "Resultado";
		String teste = Calendar.getURI("Teste");
		
		assertEquals(resultado, teste);
	}


	@Test
	void testSearchAvailability() {
		List<String> resultado = new ArrayList<String>();
		resultado.add("800");
		resultado.add("930");
		resultado.add("1100");
		resultado.add("1300");
		resultado.add("1430");
		resultado.add("1730");
		resultado.add("1800");
		resultado.add("2100");
		
		List<String> aux = new ArrayList<String>();
		aux.add("1300");
		aux.add("1430");
		aux.add("1600");
		aux.add("1730");
		aux.add("1800");
		aux.add("1930");
		aux.add("2100");
		aux.add("2230");
		
		List<String> teste = Calendar.searchAvailability(aux);
		
		assertEquals(resultado, teste);
		
		
	}

	@Test
	void testNextDay() {
		int resultado = 20230801;
		int teste = Calendar.nextDay(20230731);
		
		assertEquals(resultado, teste);
	}

	@Test
	void testNextWeek() {
		int resultado = 20230806;
		int teste = Calendar.nextWeek(20230730);
		
		assertEquals(resultado, teste);
	}

}
