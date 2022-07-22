#include <stdlib.h>
#include <stdio.h>
#include "util.h"
#define SIZE 10

int count = 0;
int alter = 0;

typedef struct no
{
  struct no *pai;
  struct no *esquerda;
  struct no *direita;
  int valor;
} No;

typedef struct arvore
{
  struct no *raiz;
} Arvore;

void balanceamento(Arvore *, No *);
int altura(No *);
int fb(No *);
No *rsd(Arvore *, No *);
No *rse(Arvore *, No *);
No *rdd(Arvore *, No *);
No *rde(Arvore *, No *);

Arvore *criar()
{
  if (alter == 304)
  {
    printf("hello");
  }
  count++;
  alter++;
  Arvore *arvore = malloc(sizeof(Arvore));
  arvore->raiz = NULL;

  return arvore;
}

int vazia(Arvore *arvore)
{
  count++;
  return arvore->raiz == NULL;
}

No *adicionarNo(No *no, int valor)
{
  count++;
  if (valor > no->valor)
  {
    if (no->direita == NULL)
    {
      No *novo = malloc(sizeof(No));
      novo->valor = valor;
      novo->pai = no;

      no->direita = novo;

      return novo;
    }
    else
    {
      return adicionarNo(no->direita, valor);
    }
  }
  else
  {
    if (no->esquerda == NULL)
    {
      No *novo = malloc(sizeof(No));
      novo->valor = valor;
      novo->pai = no;

      no->esquerda = novo;

      return novo;
    }
    else
    {
      return adicionarNo(no->esquerda, valor);
    }
  }
}

No *adicionar(Arvore *arvore, int valor)
{
  count++;
  if (arvore->raiz == NULL)
  {
    No *novo = malloc(sizeof(No));
    novo->valor = valor;
    arvore->raiz = novo;

    return novo;
  }
  else
  {
    No *no = adicionarNo(arvore->raiz, valor);
    balanceamento(arvore, no);

    return no;
  }
}

void remover(Arvore *arvore, No *no)
{
  count++;
  if (no->esquerda != NULL)
  {
    remover(arvore, no->esquerda);
  }

  if (no->direita != NULL)
  {
    remover(arvore, no->direita);
  }

  if (no->pai == NULL)
  {
    arvore->raiz = NULL;
  }
  else
  {
    if (no->pai->esquerda == no)
    {
      no->pai->esquerda = NULL;
    }
    else
    {
      no->pai->direita = NULL;
    }
  }

  free(no);
}

No *localizar(No *no, int valor)
{
  count++;
  if (no->valor == valor)
  {
    return no;
  }
  else
  {
    if (valor < no->valor)
    {
      if (no->esquerda != NULL)
      {
        return localizar(no->esquerda, valor);
      }
    }
    else
    {
      if (no->direita != NULL)
      {
        return localizar(no->direita, valor);
      }
    }
  }

  return NULL;
}

void percorrerProfundidadeInOrder(No *no, void (*callback)(int))
{
  count++;
  if (no != NULL)
  {
    percorrerProfundidadeInOrder(no->esquerda, callback);
    callback(no->valor);
    percorrerProfundidadeInOrder(no->direita, callback);
  }
}

void percorrerProfundidadePreOrder(No *no, void (*callback)(int))
{
  count++;
  if (no != NULL)
  {
    callback(no->valor);
    percorrerProfundidadePreOrder(no->esquerda, callback);
    percorrerProfundidadePreOrder(no->direita, callback);
  }
}

void percorrerProfundidadePosOrder(No *no, void(callback)(int))
{
  count++;
  if (no != NULL)
  {
    percorrerProfundidadePosOrder(no->esquerda, callback);
    percorrerProfundidadePosOrder(no->direita, callback);
    callback(no->valor);
  }
}

void visitar(int valor)
{
  count++;
  printf("%d ", valor);
}

void balanceamento(Arvore *arvore, No *no)
{
  while (no != NULL)
  {
    count++;
    int fator = fb(no);

    if (fator > 1)
    { //árvore mais pesada para esquerda
      // rotação para a direita
      if (fb(no->esquerda) > 0)
      {
        rsd(arvore, no); // rotação simples a direita, pois o FB do filho tem sinal igual
      }
      else
      {
        rdd(arvore, no); // rotação dupla a direita, pois o FB do filho tem sinal diferente
      }
    }
    else if (fator < -1)
    { //árvore mais pesada para a direita
      // rotação para a esquerda
      if (fb(no->direita) < 0)
      {
        rse(arvore, no); // rotação simples a esquerda, pois o FB do filho tem sinal igual
      }
      else
      {
        rde(arvore, no); // rotação dupla a esquerda, pois o FB do filho tem sinal diferente
      }
    }
    no = no->pai;
  }
}

int altura(No *no)
{
  count++;
  int esquerda = 0, direita = 0;

  if (no->esquerda != NULL)
  {
    esquerda = altura(no->esquerda) + 1;
  }

  if (no->direita != NULL)
  {
    direita = altura(no->direita) + 1;
  }

  return esquerda > direita ? esquerda : direita;
}

int fb(No *no)
{
  count++;
  int esquerda = 0, direita = 0;

  if (no->esquerda != NULL)
  {
    esquerda = altura(no->esquerda) + 1;
  }

  if (no->direita != NULL)
  {
    direita = altura(no->direita) + 1;
  }

  return esquerda - direita;
}

No *rse(Arvore *arvore, No *no)
{
  count++;
  No *pai = no->pai;
  No *direita = no->direita;

  no->direita = direita->esquerda;
  no->pai = direita;

  direita->esquerda = no;
  direita->pai = pai;

  if (pai == NULL)
  {
    arvore->raiz = direita;
  }
  else
  {
    if (pai->esquerda == no)
    {
      pai->esquerda = direita;
    }
    else
    {
      pai->direita = direita;
    }
  }

  return direita;
}

No *rsd(Arvore *arvore, No *no)
{
  count++;
  No *pai = no->pai;
  No *esquerda = no->esquerda;

  no->esquerda = esquerda->direita;
  no->pai = esquerda;

  esquerda->direita = no;
  esquerda->pai = pai;

  if (pai == NULL)
  {
    arvore->raiz = esquerda;
  }
  else
  {
    if (pai->esquerda == no)
    {
      pai->esquerda = esquerda;
    }
    else
    {
      pai->direita = esquerda;
    }
  }

  return esquerda;
}

No *rde(Arvore *arvore, No *no)
{
  count++;
  no->direita = rsd(arvore, no->direita);
  return rse(arvore, no);
}

No *rdd(Arvore *arvore, No *no)
{
  count++;
  no->esquerda = rse(arvore, no->esquerda);
  return rsd(arvore, no);
}

void deallocate(No *p)
{
  if (p == NULL)
    return;

  deallocate(p->direita);
  deallocate(p->esquerda);

  free(p);
}

int main()
{

  int size = SIZE, sum = 0;
  int log = 0;
  for (int i = 1; i <= 1000; i++)
  { // quantidade de chaves
    // Caso médio
    while (size > 0)
    { // quantidade para media
      count = 0;
      printf("Loop %d - %d\n", i, size);
      Arvore *arvore = criar();
      printf("created tree");
      int *values = generateRandomArray(i);
      for (int j = 0; j < i; j++)
      {
        printf("%d\t", values[j]);
      }
      for (int j = 0; j < i; j++)
      {
        log = values[j];
        adicionar(arvore, values[j]);
      }
      sum += count;
      size--;
      printf("\n");
    }
    size = SIZE;
    float result = sum / 10;
    sum = 0;
    printf("AVL;%d;%.0f\n", i, result);
  }

  // for (int i = 1; i <= 1000; i++) {
  //   Arvore* a = criar();
  //   count = 0;
  //   int *values = generateOrderedArray(i);
  //   for(int j = 0; j < i; j++) {
  //     adicionar(a, values[j]);
  //   }
  //   printf("AVL;%d;%d\n", i, count);
  // }
}