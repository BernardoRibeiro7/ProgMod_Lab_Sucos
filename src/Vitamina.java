
public class Vitamina extends Bebida {

	private static final double ACRESCIMO = 2.5;

	private static final int MAX_FRUTAS = 3;

	private enum ETamanho {

		PEQUENA("Pequena", 0.0),
		MEDIA("Média", 0.4),
		GRANDE("Grande", 0.6);

		private final String descricao;
		private final double percentual;

		ETamanho(String descricao, double percentual) {
			this.descricao = descricao;
			this.percentual = percentual;
		}

		private double ajustar(double valor) {
			return valor * (1.0 + percentual);
		}

		private String descricao() {
			return descricao;
		}
	}

	public Vitamina(EFruta fruta) {
		super("Vitamina");
		frutas.add(fruta);
	}

	@Override 
	public int adicionar(EFruta fruta) {
		if (fruta != null && frutas.size() < MAX_FRUTAS) {
			frutas.add(fruta);
		}
		return frutas.size();
	}

	private ETamanho tamanho() {
		return switch (frutas.size()) {
			case 2 -> ETamanho.MEDIA;
			case 3 -> ETamanho.GRANDE;
			default -> ETamanho.PEQUENA;
		};
	}

	@Override 
	public double preco() {
		double media = frutas.stream().mapToDouble(EFruta::valor).average().orElse(0.0);
		return tamanho().ajustar(media + ACRESCIMO);
	}

	@Override 
	public String toString() {
		return String.format("%s (%s) - R$ %.2f", super.toString(), tamanho().descricao(), preco());
	}

}
