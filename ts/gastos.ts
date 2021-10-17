function reduce(a: number, b: number) {
  return a + b;
}

const nubank = [657.12,12213.14].reduce(reduce);
const santander = [695.97, 4284.61].reduce(reduce);
const bb = [69.88].reduce(reduce);
const itau = [44.53, 2692.42].reduce(reduce);
const easy = [607.11].reduce(reduce);
const negative = [-540,79,-756.92,-150.80,-119.37,-78.21,-7.02].reduce(reduce);
const waiting = [5000, 477.49,1300,20000].reduce(reduce);

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
