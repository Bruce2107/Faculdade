// #include <stdio.h>
// #define TAM 7

// int main(int argc, char const *argv[])
// {
//     // int table[TAM][TAM];
//     // for(int i = 0; i < TAM; i++)
//     //     for(int j = 0; j < TAM; j++)
//     //         if(i != j) 
//     //             scanf("%i",&table[i][j]);
//     //         else table[i][j] = 0;

//     int table[TAM][TAM] = {
//         0,2,11,6,15,11,1,
//         2,0,7,12,4,2,15,
//         11,7,0,11,8,3,13,
//         6,12,11,0,10,2,1,
//         15,4,8,10,0,5,13,
//         11,2,3,2,5,0,14,
//         1,15,13,1,13,14
//     };
//     int origem, destino /*,count = 0 */;
//     do{
//         scanf("%i",&origem);
//         scanf("%i",&destino);
//         // if((origem[0] == origem[1]) && (destino[0] == destino[1]) && (count >= 1)) break;
//         // if(count != 0) {
//         //     origem[1] = origem[0];
//         //     destino[1] = destino[0];
//         // }
//         // count++;
//         printf("tempo: %i\n",table[origem][destino]);
//     }while (origem != destino);
    
//     return 0;
// }

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
    char input[1024];      //The input element
    char result[1024];     //The next element
    int length = 0;        //The length of the input
    int resultLength = 0;  //The length of the result

    printf("Enter the element: ");
    do{
        scanf("%c", &input[length]);
    } while(input[length++] != '.');
    length -= 1; //Decrement length because of the length++ that just executed

    //Go through the loop, adding to the result each time the chain stops
    char prev = input[0];   //The previous character
    int count = 1;          //The count in the current chain
    int i, j = 0;
    for(i=1; i < length; i++){
        if(input[i] == prev){
            count++;   //If the chain is unbroken, increment the count
        } else{
            //If the chain breaks, store the count and digit in result and reset count
            result[j++] = count + '0';
            result[j++] = prev;
            count = 1;
        }

        //Set prev to be the current digit
        prev = input[i];
    }

    //Handle the last digit using the current value of count and prev
    result[j++] = count + '0';
    result[j++] = prev;

    //Print out the result
    printf("The next element in the sequence is: ");
    resultLength = j;
    for(i=0; i < resultLength; i++){
        printf("%c", result[i]);
    }
    printf("\n");

    system("pause");
    return 0;
}