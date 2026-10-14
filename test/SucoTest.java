import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SucoTest {

	private static final double DELTA = 0.001;

	@Test
	@DisplayName("Suco de uma fruta custa o valor da própria fruta")
	void precoDeSucoSimples() {
		Suco suco = new Suco(EFruta.MORANGO);

		assertEquals(3.00, suco.preco(), DELTA);
	}

	@Test
	@DisplayName("Suco de duas frutas com laranja custa a média das frutas")
	void precoDeSucoMisto() {
		Suco suco = new Suco(EFruta.LARANJA);

		int quantidade = suco.adicionar(EFruta.MORANGO);

		assertEquals(2, quantidade);
		assertEquals(2.50, suco.preco(), DELTA);
	}

	@Test
	@DisplayName("Segunda fruta é aceita quando a laranja é a fruta incluída")
	void laranjaPodeSerASegundaFruta() {
		Suco suco = new Suco(EFruta.MANGA);

		int quantidade = suco.adicionar(EFruta.LARANJA);

		assertEquals(2, quantidade);
		assertEquals(2.25, suco.preco(), DELTA);
	}

	@Test
	@DisplayName("Suco sem laranja não aceita uma segunda fruta")
	void sucoSemLaranjaNaoAceitaSegundaFruta() {
		Suco suco = new Suco(EFruta.MANGA);

		int quantidade = suco.adicionar(EFruta.MORANGO);

		assertEquals(1, quantidade);
		assertEquals(2.50, suco.preco(), DELTA);
	}

	@Test
	@DisplayName("Suco não aceita uma terceira fruta")
	void sucoNaoAceitaTerceiraFruta() {
		Suco suco = new Suco(EFruta.LARANJA);
		suco.adicionar(EFruta.MORANGO);

		int quantidade = suco.adicionar(EFruta.MANGA);

		assertEquals(2, quantidade);
		assertEquals(2.50, suco.preco(), DELTA);
	}

	@Test
	@DisplayName("Relato do suco traz tipo, frutas e preço")
	void relatoDoSuco() {
		Suco suco = new Suco(EFruta.LARANJA);
		suco.adicionar(EFruta.MORANGO);

		String relato = suco.toString();

		assertTrue(relato.contains("Suco"));
		assertTrue(relato.contains("LARANJA"));
		assertTrue(relato.contains("MORANGO"));
		assertTrue(relato.contains("R$"));
	}

}
