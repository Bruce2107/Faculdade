function reduce(a: number, b: number) {
  return a + b;
}

const nubank = [5.62, 24481.95].reduce(reduce);
const santander = [676.98].reduce(reduce);
const bb = [72.47].reduce(reduce);
const itau = [87.55].reduce(reduce);
const easy = [10029.98].reduce(reduce);
const negative = [4000 - 1326.94, 2730 - 1470.77, 11000 - 8859.13]
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
