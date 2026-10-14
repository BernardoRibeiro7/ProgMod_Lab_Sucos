import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private List<Bebida> itens;

	public Pedido() {
		this.itens = new ArrayList<>();
	}

	public int adicionar(Bebida item) {
		if (item != null) {
			itens.add(item);
		}
		return itens.size();
	}

	public double preco() {
		return itens.stream().mapToDouble(Bebida::preco).sum();
	}

	@Override 
	public String toString() {
		StringBuilder relato = new StringBuilder("Pedido");
		relato.append(System.lineSeparator());
		for (Bebida item : itens) {
			relato.append(" - ").append(item).append(System.lineSeparator());
		}
		relato.append(String.format("Total: R$ %.2f", preco()));
		return relato.toString();
	}

}
