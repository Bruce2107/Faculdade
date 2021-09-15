#include <stdio.h>
#define n 2
int main(int argc, char const *argv[])
{
  int m1[n][n],m2[n][n],soma[n][n];
  for(int i =0; i<n; i++)
    for(int j=0;j<n;j++)
      scanf("%i",&m1[i][j]);
  for(int i =0; i<n; i++)
    for(int j=0;j<n;j++)
      scanf("%i",&m2[i][j]);
  for(int i =0; i<n; i++)
    for(int j=0;j<n;j++)
      soma[i][j] = m1[i][j] + m2[i][j];
  
  for(int i =0; i<n; i++){
    for(int j=0;j<n;j++)
      printf("%i\t",soma[i][j]);
    printf("\n");
  }
  return 0;
}
