function reduce(a: number, b: number) {
  return a + b;
}

const nubank = [370.85, 35815.35].reduce(reduce);
const santander = [21.5].reduce(reduce);
const bb = [72.06].reduce(reduce);
const itau = [12.6].reduce(reduce);
const easy = [7621.63].reduce(reduce);
const negative = [927.62,227.38,139.59, 1214.14,341.74*2].map((i) => -i).reduce(reduce);
const waiting = [5000, 5000, 1300,2000].reduce(reduce); // carro, celio, licenciamento

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
