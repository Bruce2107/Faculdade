function reduce(a: number, b: number) {
  return a + b;
}

const nubank = [68.31, 29308.17].reduce(reduce);
const santander = [109.14, 4182.89].reduce(reduce);
const bb = [70.13].reduce(reduce);
const itau = [1331.86, 2756.08].reduce(reduce);
const easy = [893.89].reduce(reduce);
const negative = [206.98, 324.74, 107].map((i) => -i).reduce(reduce);
const waiting = [5000, 6000, 1300].reduce(reduce); // carro, celio, licenciamento

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
