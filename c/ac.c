#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main (void) {
  char menu;
  int num_real, palpite, tentativas;
  int Jogos[5];
  int Jogo = 0;
  srand (time(NULL));
  printf("Bem Vindo! Escolha uma das opções abaixo: \n");

  do {
    printf("\n\nMenu: \n\n(1) Novo jogo, \n(2) Ver últimos 5 Jogos, \n(3) Limpar \n(4) Sair\n\n");
    scanf("\n %c", &menu);      
    if(menu == '1') {
      tentativas = 0;
      num_real = rand () % 100;
      for (;;) {
        printf("Chute um valor entre 1 e 100");
        scanf("%d", &palpite);
        if (palpite == num_real) {
          tentativas++;
          printf("\n Você acertou em %d tentativas.\n", tentativas);
          if(Jogo < 5) Jogos[Jogo] = tentativas;
          else {
            for(int i = 1; i < 5; i++) 
              Jogos[i-1] = Jogos[i];
            Jogos[4] = tentativas;  
          }
          Jogo++;
          break;   
        } else if ( palpite < num_real) {
          tentativas++;
          printf("Tente um valor mais alto.");
        } else if ( palpite > num_real){
          tentativas++;
          printf("Tente um valor mais baixo");
        }
      }
    }         
    if (menu == '2'){
      for ( int i= 1 ; i <=5 ; i++)
      printf("\nJogo %d: %d tentativas\n",i, Jogos[i]);           
    }
  }while (menu != 4);
}