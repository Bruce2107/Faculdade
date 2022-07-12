let todo = [
  69.98 * 3,
  108.33 * 4,
  89 * 3,
  105 * 3,
  69.95,
  79.95,
  98 * 4,
  70,
  67.23,
  80 * 3,
  100 * 2,
];

let um = [69.98, 108.33, 89, 105, 69.95, 79.95, 98, 70, 67.23, 80, 100];

let agosto: number[] = [];
todo.forEach((element, index) => {
  agosto.push(element - um[index]);
});

console.log(agosto.reduce((a, b) => a + b));

let setembro: number[] = [];
agosto.forEach((element, index) => {
  setembro.push(element - um[index] > 0 ? element - um[index] : 0);
});
console.log(setembro.reduce((a, b) => a + b));

let outubro: number[] = [];
setembro.forEach((element, index) => {
  outubro.push(element - um[index] > 0 ? element - um[index] : 0);
});
console.log(outubro.reduce((a, b) => a + b));

let novembro: number[] = [];
outubro.forEach((element, index) => {
  novembro.push(element - um[index] > 0 ? element - um[index] : 0);
});
console.log(novembro.reduce((a, b) => a + b));
