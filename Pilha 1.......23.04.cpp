#include <stdio.h>
#include <stdlib.h>
#define MAX 4
 
//prototipos das funcoes
void push (int pilha [MAX], int x);
int pop (int pilha [MAX]);
void exibe (int pilha [MAX]);
 
int topo;
 
main(){
    
    int pilha [MAX], n, r;
    topo = 0;
 
    printf("\n Digite o numero na base decimal=");
    scanf("%d", &n);
    while (n!=0){
       r = n%2;     
       push (pilha, r);
       n = n/2;
    }  
       printf ("\n Numero correspondente ao binario=");
       while (topo!=0){       
             r = pop (pilha);
             printf("%d", r);
       }
    system ("PAUSE");
}
 
void exibe (int pilha [MAX])
{
     int i;
 
     if (topo >= 1){
         for (i=0; i<topo; i++) 
             printf ("\n Pilha [%d] = %d",i,pilha [i]);  
     } 
  else printf ("\n Pilha vazia");
}
 
int pop (int pilha [MAX])
{
     int x;
 
     if (topo >= 1)
     {
          x = pilha [topo - 1];
          topo--;
     }
     else printf ("\n Pilha vazia");
 
    return (x);
}
void push (int pilha [MAX], int x)
{
    if (topo == MAX)
          printf ("\n Pilha Cheia");
    else{
          pilha [topo] = x;
          topo++;
    }
}
