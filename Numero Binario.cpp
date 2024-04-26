/* pesqbinaria.c: implementa pesquisa binaria num vetor ordenado */
       
      #include <stdio.h>
      #include <conio.h>
      #define N 10
       
    int vet[N+1];
    int comeco, meio, fim, i, k;
       
    void  OrdenaInsercao (int vet[N], int max);
       
       
       
      int main()
      {  printf ("\n\nMetodo de pesquisa binaria \n");
       
      printf("\nForneca os elementos do vetor a ser pesquisado \n");
      for (i=1; i<=N; i++)
      { printf("vet[%d]= ",i);
      scanf("%d",&vet[i]);
      }
       
      OrdenaInsercao(vet,N);
      printf("\n Vetor ordenado pelo metodo de Insercao: \n");
      for (i=1; i<=N; i++)
      printf("\nvet[%d]= %d \n",i,vet[i]);
       
      for ( ; ; )
      { printf("\nChave a ser procurada (digite -1 para terminar):");
      scanf("%d",&k);
       
      if (k==-1)
      break;
       
      comeco = 1;
      fim = N;
      meio = (comeco+fim)/2;
      while (vet[meio] != k &&comeco< fim)
      { if  (k <vet[meio])
            fim = meio -1;
        else comeco = meio +1;
        meio =  (comeco+fim)/2;
    }
    if (vet[meio] == k)
    printf("\nA chave %d encontra-se na posicao %d do vetor \n", 
k, meio);
    else printf("\nA chave %d nao se encontra no vetor\n",k);
    }
printf ("\n\nFim do metodo de busca binaria ");
getch();
return 0;
 }
 
void OrdenaInsercao(int vet[N], int max)
{      int aux, j, i;
     
for (j=2; j<=max; j++)
     {    aux  = vet[j];
        vet[0] = aux;
         i = j-1;
        while (aux < vet[i])
        {  vet[i+1] = vet[i];
            --i;
        }
        vet[i+1] = aux;
    }
}
