package vetor;

import java.util.ArrayList;
import java.util.List;

public class TesteVetor3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Criando vetor chamando nomes
			List<String> nomes = new ArrayList<>();
			
			nomes.add("Marcela");
			nomes.add("Mohammed");
			nomes.add("Akin Drogado");
			
			
			System.out.println(nomes);
			
			nomes.remove("marcela");
			System.out.println(nomes);
			
	}

}


//For infinito
			//for(;;) {
			//System.out.println(nomes);
			//}
			