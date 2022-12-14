package Grupo12.Projeto_ES;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ReuniaoTest {

	Reuniao reuniao = new Reuniao (0,null,true,null,"15min");
	
	
	@Test
	void testFiltrarDatas() {
		List<String> resultado = new ArrayList<String>();
		resultado.add("1200");
		
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("1200");
		aux.add("1400");
		
		List<String> teste = reuniao.filtrarDatas(aux);
		
		assertEquals(resultado, teste);
	}

	@Test
	void testGetDuracao() {
		int resultado = 15;
		int teste = reuniao.getDuracao();
		
		assertEquals(resultado, teste);
	}

}
