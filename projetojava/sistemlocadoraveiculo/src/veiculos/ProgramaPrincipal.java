package veiculos;

import java.util.List;
import java.util.ArrayList;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// trabalhando com vetores
		List<Carro> carros = new ArrayList<>();
		carros.add( new Carro("Ferrari","458","Vermelho",15560,60,15,300000));
		carros.add(new Carro("Mercedez Benz","GLA","Preto",22350,50,12,1500000));
		carros.add( new Carro("Porsche","Macan","Prata",380,70,6,200000));
		carros.add( new Carro("Huracan","Lamborghini","Preta",780,90,5,50000));
		
		for(Carro carro:carros) {
		
		System.out.println("Marca: " + carro.getMarca());
		System.out.println("Modelo: " + carro.getModelo());
		System.out.println("Cor: " + carro.getCor());
		System.out.println("Km: " + carro.getKm());
		System.out.println("Rodagem:" + carro.calcularKm());
		System.out.println("km Por Litro:" + carro.getKmPorLitro());
		System.out.println("preco:" +carro.getPreco());
		System.out.println("capacidade Tanque:" + carro.getCapacidadeTanque());
		System.out.println("Desconto:" + carro.calcularDesconto(20.2,5));
		System.out.println("Qt de Carros:" + Carro.getQtCarros());
		System.out.println("============================================");
		System.out.println("Qt de Carros: " + Carro.getQtCarros());
		System.out.println("Soma Total Preços: " + Carro.getPrecosDosCaros());
		
		}

		System.out.println();
	
		System.out.println("============================================");
		System.out.println("Qt de Carros: " + Carro.getQtCarros());
		System.out.println("Soma Total Preços: " + Carro.getPrecosDosCaros());
		

	}

}
