function reduce(a: number, b: number) {
  return a + b;
}

const nubank = [100.2, 22352.67].reduce(reduce);
const santander = [0].reduce(reduce);
const bb = [72.47].reduce(reduce);
const itau = [0].reduce(reduce);
const easy = [11075.61].reduce(reduce);
const negative = [1526.31, 2730 - 2374.68, 11000 - 9619.66, 2000 - 1102.33]
  .map((i) => -i)
  .reduce(reduce);
const waiting = [5000, 3000, 1300, 2000].reduce(reduce); // carro, celio, licenciamento

const sum = Number((nubank + santander + bb + itau + easy).toFixed(2));

const sub = Number(negative.toFixed(2));
const total = sum + sub;
const withWaiting = total + waiting;

console.table({
  nubank,
  santander,
  bb,
  itau,
  easy,
  sum,
  sub,
  total,
  withWaiting,
});
