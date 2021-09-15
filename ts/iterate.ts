import { Cards, B, C } from './data';

const code = 12
const a = Object.keys(Cards)
  .map((card) => Cards[card as B].some((e) => e.code === code) && card)
  .filter((b) => typeof b === 'string');
console.log(a);
