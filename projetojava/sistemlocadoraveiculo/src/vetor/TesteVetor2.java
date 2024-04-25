package vetor;

public class TesteVetor2 {

	public static void main(String[] args) {
		// Criar e insere os valores dentro do vetor
		int[] valores = {200,10,35,52};
		
		// 	Mostra os valores em cada posição(indice) do vetor
		//foreach (para cada)
		
		for(int valor:valores) {
			System.out.println("Posição::" + valor);
		}
//		for(int i=0; i<4;i++) {
//			System.out.println("Posição" + i + ": " + valores[i]);
	//	}
		
	}

}
