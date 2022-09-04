package com.tu.testeunidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TesteunidadeApplicationTests {

	/**
	 * Crie o máximo de testes de unidade que conseguir para o método obterTipoTriangulo
	 * Sinta-se a vontade para corrigi-lo coso encontre alguma falha
	 */


	// Exemplo
	@Test
	public void obterTipoTriangulo_ComLadosIguais_RetorneEscaleno() {
		Triangulo t = new Triangulo(2,2,2);
		Assertions.assertEquals(t.obterTipoTriangulo(), Triangulo.EQUILATERO);
	}






	public class Triangulo {

		public static final String ISOSCELES = "ISOSCELES";
		public static final String ESCALENO = "ESCALENO";
		public static final String EQUILATERO = "EQUILATERO";


		private int a;
		private int b;
		private  int c;

		public Triangulo(Integer a, Integer b, Integer c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}


		private boolean isIsosceles() {
			return  (a == b) || (a == c) || (b == c);
		}

		private boolean isEscaleno() {
			return   (a != b && b != c && c != a);
		}

		private boolean isEquilatero() {
			return   (a == b && b == c);
		}


		/**
		 *
		 * @return O tipo de triagulo
		 */
		public String obterTipoTriangulo() {
			if(isIsosceles()) {
				return ISOSCELES;
			}else if(isEquilatero()){
				return EQUILATERO;
			}
			return ESCALENO;
		}

	}
}
