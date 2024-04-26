//pesquisaseq.c: implementa o metodo de pesquisa sequencial em vetor
#include <stdlib.h>
#include <stdio.h>
#include <conio.h>
 
#define FALSO 0
#define VERDADEIRO 1
#define N 10
 
int vet[N+1];
int i, k, achou;
 
int main()
{  
   printf("\nMetodo de Pesquisa Sequencial\n");  
   printf("\nForneca os elementos do vetor a ser pesquisado \n");
   for (i=1; i<=N; i++)
   { printf("vet[%d]= ",i);
     scanf("%d",&vet[i]);
   }
    
   while (VERDADEIRO)
   { 
     printf("\nChave a ser procurada  (digite -1 para terminar): ");
     scanf("%d",&k);
      
     if (k==-1)
       break;    
          
     achou = FALSO;
     i = 1;
     while ( achou==FALSO && i<=N )
     { if (vet[i] == k)
       { printf("\nA chave %d esta na posicao %d do vetor \n",k,i);
         achou = VERDADEIRO;
       }
       else    ++i;
     }
     if (achou==FALSO)
          printf("\nA chave %d nao se encontra no vetor \n",k);
      
   }
    
   printf("\n\n\nFim do programa");
   getch();
   return 0;
    
}
