import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VitaminaTest {

	private static final double DELTA = 0.001;

	@Test
	@DisplayName("Vitamina pequena soma apenas o valor do leite")
	void precoDeVitaminaPequena() {
		Vitamina vitamina = new Vitamina(EFruta.MANGA);

		assertEquals(5.00, vitamina.preco(), DELTA);
	}

	@Test
	@DisplayName("Vitamina média tem acréscimo de 40%")
	void precoDeVitaminaMedia() {
		Vitamina vitamina = new Vitamina(EFruta.MANGA);

		int quantidade = vitamina.adicionar(EFruta.MORANGO);

		assertEquals(2, quantidade);
		assertEquals(7.35, vitamina.preco(), DELTA);
	}

	@Test
	@DisplayName("Vitamina grande tem acréscimo de 60%")
	void precoDeVitaminaGrande() {
		Vitamina vitamina = new Vitamina(EFruta.CUPUACU);
		vitamina.adicionar(EFruta.GRAVIOLA);

		int quantidade = vitamina.adicionar(EFruta.LARANJA);

		assertEquals(3, quantidade);
		assertEquals(9.0667, vitamina.preco(), DELTA);
	}

	@Test
	@DisplayName("Vitamina aceita qualquer combinação de frutas, sem laranja")
	void vitaminaAceitaFrutasQuaisquer() {
		Vitamina vitamina = new Vitamina(EFruta.CUPUACU);

		int quantidade = vitamina.adicionar(EFruta.MORANGO);

		assertEquals(2, quantidade);
		assertEquals(8.40, vitamina.preco(), DELTA);
	}

	@Test
	@DisplayName("Vitamina não aceita uma quarta fruta")
	void vitaminaNaoAceitaQuartaFruta() {
		Vitamina vitamina = new Vitamina(EFruta.CUPUACU);
		vitamina.adicionar(EFruta.GRAVIOLA);
		vitamina.adicionar(EFruta.LARANJA);

		int quantidade = vitamina.adicionar(EFruta.MORANGO);

		assertEquals(3, quantidade);
		assertEquals(9.0667, vitamina.preco(), DELTA);
	}

	@Test
	@DisplayName("Relato da vitamina traz tipo, tamanho, frutas e preço")
	void relatoDaVitamina() {
		Vitamina vitamina = new Vitamina(EFruta.MANGA);
		vitamina.adicionar(EFruta.MORANGO);

		String relato = vitamina.toString();

		assertTrue(relato.contains("Vitamina"));
		assertTrue(relato.contains("Média"));
		assertTrue(relato.contains("MANGA"));
		assertTrue(relato.contains("MORANGO"));
		assertTrue(relato.contains("R$"));
	}

}
