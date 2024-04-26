#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#define MAX 2
 
int n;
float vet[MAX];
 
void cria (void)
{
    n = 0; /* inicializa com zero elementos */
}
 
void push ( float v)
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

int vazia ()
{
    return (n == 0);
}

float pop ()
{
    float v;
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
 
void ptpilha()
{
    int a;
    system("cls");
    for( a = n; a >= 0; a-- )
        printf("item %3.2f\n", vet[a]);
    getch();
}

 
void libera ()
{
    n = 0;
}
 
main()
{
    int a;
    char op;
    float n1=0, n2=0, tt;
    cria();
    printf("Digite a expressao a ser calculada \nno formato (numero) (operador) (numero)");
    scanf("%f %c %f", &n1, &op, &n2);
     
    push( n1 );
    push( n2 );
     
    n1 = pop();
    n2 = pop();
 
    if( op == '+') tt = n2 + n1;
    if( op == '-') tt = n2 - n1;
    if( op == '*') tt = n2 + n1;
    if( op == '/') tt = n2 / n1;
     
    printf("\n%f\n", tt);
     
    system("pause");
}

