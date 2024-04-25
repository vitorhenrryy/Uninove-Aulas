// Esta é a CLASSE

package veiculos;

public class Carro {
	public Carro(String marca, String modelo, String cor, int km, int capacidadeTanque, int kmPorLitro, double preco) {
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.km = km;
		this.capacidadeTanque = capacidadeTanque;
		this.kmPorLitro = kmPorLitro;
		this.preco = preco;
		Carro.qtCarros++;
		this.precosDosCaros = Carro.precosDosCaros + preco;
	}

	// Propriedade ou Atributo
	// PRIVATE SÓ CONVERSA COM OS METODOS QUE ESTA NA MESMA CLASS QUE ELE




	
	private  String marca;
    private String modelo;
    private String cor;
	private int km;
	private  int capacidadeTanque;
	private int kmPorLitro;
	private double preco;
    private double valorDesconto;
    private static int qtCarros;
    private static double precosDosCaros;
    

	 
	
	public String getMarca() {
		return marca;
				
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(int capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public int getKmPorLitro() {
		return kmPorLitro;
	}

	public void setKmPorLitro(int kmPorLitro) {
		this.kmPorLitro = kmPorLitro;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public static double getPrecosDosCaros() {
		return precosDosCaros;
	}

	public static void setPrecosDosCaros(double precosDosCaros) {
		Carro.precosDosCaros = precosDosCaros;
	}

	public static int getQtCarros() {
		return qtCarros;
	}

	public static void setQtCarros(int qtCarros) {
		Carro.qtCarros = qtCarros;
	}

	int calcularKm() {
		return this.capacidadeTanque * this.kmPorLitro;
	}
	
	double calcularDesconto(double percentualDescontoVendedor) {

		
		if(percentualDescontoVendedor>=0 && percentualDescontoVendedor<=100) {
			return preco * (percentualDescontoVendedor/100);
			
		}else if(percentualDescontoVendedor<0) {
		return 0;
		}else {
			return preco * 0.04;
		}
		
	}
	
	double calcularDesconto(double percentualDescontoVendedor,double percentualDescontoGerente) {
		if(percentualDescontoVendedor<0) {
			percentualDescontoVendedor=0;
		}else if(percentualDescontoVendedor>4){
			percentualDescontoVendedor=4;
			
		}
	if(percentualDescontoGerente>0) {
		percentualDescontoGerente=0;
	}else if(percentualDescontoGerente>2) {
		percentualDescontoGerente=2;
	}
	return this.preco *((percentualDescontoVendedor/100)+(percentualDescontoGerente/100));
	}

}
