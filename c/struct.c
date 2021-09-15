#include <stdio.h>

typedef struct {
  char name[20];
  double price;
  int quantity;
  double discount;
} Product;

double discount(Product product) {
  switch (product.quantity)
  {
  case 0 ... 5:
    return 1;
  case 6 ... 15:
    return 0.9;
  default:
    return 0.8;
  }
}

int main(int argc, char const *argv[])
{
  Product product;
  char name[20];
  double price;
  int quantity;
  do{
    scanf("%d",&price);
    scanf("%i", &quantity);
    scanf("%c",&name);
  }while(product.quantity < 0);
  printf("%s\t%d\t%i",name,price,quantity);
  // product.discount = discount(product);
  // printf("Nome %s\nPreco %d\nQuantidade %i\nTotal %d",
  //   product.name,
  //   product.price,
  //   product.quantity,
  //   product.price*product.discount*product.quantity);
  return 0;
}
