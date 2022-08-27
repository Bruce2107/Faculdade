let agosto = [
  2 * 69.98,
  3 * 108.33,
  2 * 89,
  2 * 105,
  3 * 98,
  1 * 79.99,
  1 * 100,
  5 * 53.35,
  5 * 130.3,
  5 * 44.5,
];
let setembro = [
  1 * 69.98,
  2 * 108.33,
  1 * 89,
  1 * 105,
  2 * 98,
  0 * 79.99,
  0 * 100,
  4 * 53.35,
  4 * 130.3,
  4 * 44.5,
];
let outubro = [
  0 * 69.98,
  1 * 108.33,
  0 * 89,
  0 * 105,
  1 * 98,
  0 * 79.99,
  0 * 100,
  3 * 53.35,
  3 * 130.3,
  3 * 44.5,
];
let novembro = [
  0 * 69.98,
  0 * 108.33,
  0 * 89,
  0 * 105,
  0 * 98,
  0 * 79.99,
  0 * 100,
  2 * 53.35,
  2 * 130.3,
  2 * 44.5,
];
let dezembro = [
  0 * 69.98,
  0 * 108.33,
  0 * 89,
  0 * 105,
  0 * 98,
  0 * 79.99,
  0 * 100,
  1 * 53.35,
  1 * 130.3,
  1 * 44.5,
];
let janeiro = [
  0 * 69.98,
  0 * 108.33,
  0 * 89,
  0 * 105,
  0 * 98,
  0 * 79.99,
  0 * 100,
  0 * 53.35,
  0 * 130.3,
  0 * 44.5,
];

console.group();
console.log(agosto.reduce((a, b) => a + b));
console.log(setembro.reduce((a, b) => a + b));
console.log(outubro.reduce((a, b) => a + b));
console.log(novembro.reduce((a, b) => a + b));
console.log(dezembro.reduce((a, b) => a + b));
console.log(janeiro.reduce((a, b) => a + b));
console.groupEnd();
