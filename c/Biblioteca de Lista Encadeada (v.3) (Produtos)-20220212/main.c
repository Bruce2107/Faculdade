#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Lista.h"
#include "Musica.h"

int main(int argc, char *argv[]) {
	Lista l1;
	inicializa_lista( &l1, sizeof( Musica ) );
	Musica musica;

	int escolha, min, max;

	do {
		printf("O que voce deseja fazer?\n1. Cadastrar\n2. Mostrar todas as musicas\n3. Buscar músicas por nome\n4. Buscar músicas por artista\n5. Buscar músicas por estilo\n6. Remover música\n7. Finalizar programa\n");
		scanf("%d", &escolha);

		switch(escolha) {
			case 1: {
				le_musica(&musica);
				if(insere_musica(&l1, &musica)) {
					printf("Musica adicionada a lista\n");
				}else {
					printf("A musica ja esta cadastrada\n");
				}
				
				break;
			}
			case 2: {
				printf("Listando músicas:\n");
				mostra_lista(l1, mostra_music);

				break;
			}
			case 3: {
				char aux[30];
				printf("Digite um nome para buscar: ");
				scanf(" %[^\n]", aux);
				busca_musica_por_nome(&l1, aux);

				break;
			}
			case 4: {
				char aux[30];
				printf("Digite um artista para buscar: ");
				scanf(" %[^\n]", aux);
				busca_musica_por_artista(&l1, aux);
				
				break;
			}
			case 5: {
				char aux[30];
				printf("Digite um estilo para buscar: ");
				scanf(" %[^\n]", aux);
				busca_musica_por_artista(&l1, aux);
				
				break;
			}
			case 6: {
				int input;
				printf("Digite a posicao da musica que deseja remover: ");
				scanf("%d", &input);
				remove_musica(&l1, input);

				break;
			}
			case 7: {
				salva_arquivo(&l1);
				printf("Salvando as musicas cadastradas...\n");
				printf("Saindo...\n");

				break;
			}
			default: printf("Essa opção não existe\n");
		}
	} while(escolha != 7);

	return 0;
}
