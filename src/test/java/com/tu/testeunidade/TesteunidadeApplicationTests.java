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
	// 1   Você tem no mínimo 3 casos de testes que representam um triângulo isósceles válido e
	//    que você tenha tentado as três permutações possíveis (Ex.: 3,3,4; 3,4,3; 4,3,3) ?
	@Test
	public void  obterTipoTriangulo_ComDoisLadosIguais_RetorneIsosceles() {
		Triangulo t = new Triangulo(3,3,4);
		Assertions.assertEquals(t.obterTipoTriangulo(), Triangulo.ISOSCELES);

		t = new Triangulo(3,4,3);
		Assertions.assertEquals(t.obterTipoTriangulo(), Triangulo.ISOSCELES);

		t = new Triangulo(4,3,3);
		Assertions.assertEquals(t.obterTipoTriangulo(), Triangulo.ISOSCELES);

	}


	// 2 -   Você tem um caso de teste que representa um triângulo escaleno INválido?
	//    Note que casos de testes como 1,2,3 e 2,5,10 não ganham um “sim” nesta
	//    pergunta, pois não existem triângulos válidos com esses lados
	//    (um lado deve ser menor que a soma dos outros).

	@Test
	public void obterTipoTriangulo_TrianguloInvalido_LanceExcecaoTrianguloInvalido() {
		Triangulo t = new Triangulo(1,2,3);
		checkException(t);
	}


	//3 - Você tem um caso de teste que representa um triângulo eqüilátero válido?
	@Test
	public void obterTipoTriangulo_ComTodosLadosIguais_RetorneEscaleno() {
		Triangulo t = new Triangulo(2,2,2);
		Assertions.assertEquals(t.obterTipoTriangulo(), Triangulo.EQUILATERO);
	}


	//4 Você tem um caso de teste que representa um triângulo isósceles?
	@Test
	public void obterTipoTriangulo_RepresentaTrianguloIsoceles() {
		Triangulo t = new Triangulo(2,2,4);
		checkException(t);

		t = new Triangulo(3,3,4);
		Assertions.assertEquals(t.obterTipoTriangulo(), Triangulo.ISOSCELES);
	}

	// 5-  Você tem um caso de teste no qual um dos lados é zero?
	@Test
	public void obterTipoTriangulo_ComLadoIgualAZero_LanceTrianguloException() {
		Triangulo t = new Triangulo(0,3,4);
		checkException(t);

	}

	//6 - Você tem um caso de teste no qual um dos lados tem o valor negativo?
	@Test
	public void obterTipoTriangulo_ComLadoNegativo_LanceExcecaoTrianguloInvalido() {
		Triangulo t = new Triangulo(-3,3,4);
		checkException(t);
	}

	// 7 - Você tem um caso de teste com 3 inteiros maiores que zero, onde a soma de dois lados é igual ao terceiro lado?
	@Test
	public void obterTipoTriangulo_SomaDosDeDoisLadosIgualAoTerceiro_LanceExcecaoTrianguloInvalido() {
		Triangulo t = new Triangulo(1,2,3);
		checkException(t);

		t = new Triangulo(3,3,6);
		checkException(t);
	}

	// 8 - Você tem no mínimo 3 casos de teste da categoria 7 para as quais você tentou as três permutações ?
	@Test
	public void obterTipoTriangulo_SomaDosDeDoisLadosIgualAoTerceiroPermutacoes_LanceExcecaoTrianguloInvalido() {
		Triangulo t = new Triangulo(1,2,3);
		checkException(t);

		t = new Triangulo(1,3,2);
		checkException(t);

		t = new Triangulo(3,1,2);
		checkException(t);
	}


	// 9 - Você tem um caso de teste com 3 inteiros maiores que zero, onde a soma de dois lados é menor que o terceiro lado (1,2,4 ou 12,15,30)?
	@Test
	public void obterTipoTriangulo_SomaDosDeDoisLadosMenorAoTerceiro_LanceExcecaoTrianguloInvalido(){
		Triangulo t = new Triangulo(1,2,4);
		checkException(t);
	}


	// 10 -  Você tem um caso de teste na categoria 9 para o qual você tentou as três permutações (Ex.: 1,2,4; 1,4,2 e 4,1,2) ?
	@Test
	public void obterTipoTriangulo_SomaDosDeDoisLadosMenorAoTerceiroPermutacoes_LanceExcecaoTrianguloInvalido(){
		Triangulo t = new Triangulo(1,2,4);
		checkException(t);

		t = new Triangulo(1,4,2);
		checkException(t);

		t = new Triangulo(4,1,2);
		checkException(t);
	}

	private void checkException(Triangulo triangulo) {
		RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, triangulo::obterTipoTriangulo);
		Assertions.assertEquals("Não é um triangulo" ,runtimeException.getMessage());
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

		public boolean isTriangulo() {
			return Math.abs(b - c) < a && a < Math.abs(b + c) &&
					Math.abs(a - c) < b && b < Math.abs(a + c) &&
					Math.abs(a - b) < c && c < Math.abs(a + b);
		}


		private boolean isIsosceles() {
			return  (a == b) || (a == c) || (b == c);
		}

		private boolean isEscaleno() {
			return   (a != b && b != c && c != a);
		}

		private boolean isEquilatero() {
			return   (a == b && b == c );
		}


		/**
		 *
		 * @return O tipo de triagulo
		 */
		public String obterTipoTriangulo() {
			if(isTriangulo()) {
				if(isEquilatero()){
					return EQUILATERO;
				}
				else if(isIsosceles()) {
					return ISOSCELES;
				}

				return ESCALENO;
			}
			 throw new RuntimeException("Não é um triangulo");
		}

	}
}
