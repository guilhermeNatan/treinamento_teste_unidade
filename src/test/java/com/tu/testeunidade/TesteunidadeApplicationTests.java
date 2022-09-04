package com.tu.testeunidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TesteunidadeApplicationTests {



	@Test
	public void  trianguloIsosceles() {
		Triangulo t = new Triangulo(3,3,4);
		Assertions.assertTrue(t.isIsosceles());

		t = new Triangulo(3,4,3);
		Assertions.assertTrue(t.isIsosceles());

		t = new Triangulo(4,3,3);
		Assertions.assertTrue(t.isIsosceles());


	}


	public class Triangulo {
		Integer a;
		Integer b;
		Integer c;

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

		public boolean isIsosceles() {
			return isTriangulo() && (a == b) || (a == c) || (b == c);
		}

		public boolean isEscaleno() {
			return isTriangulo() && (a != b && b != c && c != a);
		}

		public boolean isEquilatero() {
			return isTriangulo() && (a == b && b == c);
		}

	}
}
