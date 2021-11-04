// import { Cards, B, C } from './data';

// const code = 12
// const a = Object.keys(Cards)
//   .map((card) => Cards[card as B].some((e) => e.code === code) && card)
//   .filter((b) => typeof b === 'string');
// console.log(a);

function repete(a: string,n:number) {
  const len = a.length
  let b: string

  for(let i = 0; i < n; i++) {
    for(let j = 0; j < len; j++) {
      console.log(a[j])
    }
  }
}

repete("abc",4)