import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PedidoTest {

	private static final double DELTA = 0.001;

	@Test
	@DisplayName("Pedido sem itens não tem preço")
	void pedidoVazio() {
		Pedido pedido = new Pedido();

		assertEquals(0.0, pedido.preco(), DELTA);
	}

	@Test
	@DisplayName("Preço do pedido é a soma do preço das bebidas")
	void precoDoPedidoComVariasBebidas() {
		Pedido pedido = new Pedido();
		Suco suco = new Suco(EFruta.LARANJA);
		suco.adicionar(EFruta.MORANGO);
		Vitamina vitamina = new Vitamina(EFruta.MANGA);

		pedido.adicionar(suco);
		int quantidade = pedido.adicionar(vitamina);

		assertEquals(2, quantidade);
		assertEquals(7.50, pedido.preco(), DELTA);
	}

	@Test
	@DisplayName("Relato do pedido traz as bebidas e o total")
	void relatoDoPedido() {
		Pedido pedido = new Pedido();
		pedido.adicionar(new Suco(EFruta.LARANJA));
		pedido.adicionar(new Vitamina(EFruta.MANGA));

		String relato = pedido.toString();

		assertTrue(relato.contains("Pedido"));
		assertTrue(relato.contains("Suco"));
		assertTrue(relato.contains("Vitamina"));
		assertTrue(relato.contains("Total"));
	}

}
