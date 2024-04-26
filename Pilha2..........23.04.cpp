#include <stdio.h>
#include <stdlib.h>
#define MAX 50
 
int n;
char vet[MAX];
 
void cria (void)
{
    n = 0; /* inicializa com zero elementos */
}
 
void push ( char v )
{
    if (n == MAX)
    { /* capacidade esgotada */
        printf("Capacidade da pilha estourou.\n");
        exit(1); /* aborta programa */
    }
    /* insere elemento na próxima posição livre */
    vet[n] = v;
    n++;
}

int vazia()
{
    return (n == 0);
}

char pop ()
{
    char v;
    if (vazia())
    {
        printf("Pilha vazia.\n");
        exit(1); /* aborta programa */
    }
    /* retira elemento do topo */
    v = vet[n-1];
    n--;
    return v;
}
 

 
void libera ()
{
    int a =0;
    n = 0;
    for( a = 0; a < MAX; a++) //Limpa a pilha
    {
        pop();
    }
}
 
main()
{
    int a = 0;
    char exp[50], car, tcar;
    system("cls");
    scanf("%s", &exp);
    while( 1 )
    {
        if(exp[a] == '\0') break;
        car = exp[a];
        if( car == '(' || car == '[' || car == '{') push( car );
        if( car == ')' || car == ']' || car == '}')
        {
           tcar = pop();
           if( !(car == ')' && tcar == '(' || \
                 car == ']' && tcar == '[' || \
                 car == '}' && tcar == '{' ))
              push( car );
        }
        a++;
    }
    if( vazia() ) printf("\nExpressao valida !!!");
    else printf("\nExpressao invalida !!!");
    system("pause");
}

