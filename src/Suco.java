
public class Suco extends Bebida {

	private static final int MAX_FRUTAS = 2;

	public Suco(EFruta fruta) {
		super("Suco");
		frutas.add(fruta);
	}

	@Override 
	public int adicionar(EFruta fruta) {
		if (fruta != null && frutas.size() < MAX_FRUTAS && combinaComLaranja(fruta)) {
			frutas.add(fruta);
		}
		return frutas.size();
	}

	private boolean combinaComLaranja(EFruta nova) {
		return nova == EFruta.LARANJA || frutas.contains(EFruta.LARANJA);
	}

	@Override 
	public double preco() {
		return frutas.stream().mapToDouble(EFruta::valor).average().orElse(0.0);
	}

	@Override 
	public String toString() {
		return String.format("%s - R$ %.2f", super.toString(), preco());
	}

}
