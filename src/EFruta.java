public enum EFruta {

	CUPUACU(4.00),
	GRAVIOLA(3.50),
	LARANJA(2.00),
	MANGA(2.50),
	MORANGO(3.00);

	private double valor;
	
	EFruta(double preco){
		this.valor = preco;
	}

	public double valor(){
		return valor;
	}
}
