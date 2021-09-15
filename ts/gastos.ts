function reduce(a: number, b: number) {
  return a + b;
}

const nubank = [1017.77, 9513.6].reduce(reduce);
const santander = [1076.1, 5901.66].reduce(reduce);
const bb = [69.29].reduce(reduce);
const itau = [263.35, 2672.45].reduce(reduce);
const easy = [302.65].reduce(reduce);
const negative = [-318.75, -860.28, -458.79].reduce(reduce);
const waiting = [5000, 477.49].reduce(reduce);

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
