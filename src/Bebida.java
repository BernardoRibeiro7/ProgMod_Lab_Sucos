import java.util.ArrayList;
import java.util.List;

public abstract class Bebida {

	private String descricao;
	protected List<EFruta> frutas;

	public Bebida(String descricao) {
		this.descricao = descricao;
		this.frutas = new ArrayList<>();
	}

	public abstract int adicionar(EFruta fruta);

	public abstract double preco();

	@Override
	public String toString() {
		StringBuilder relato = new StringBuilder(descricao);
		relato.append(" de ");
		for (int i = 0; i < frutas.size(); i++) {
			if (i > 0) {
				relato.append(" com ");
			}
			relato.append(frutas.get(i));
		}
		return relato.toString();
	}

}
