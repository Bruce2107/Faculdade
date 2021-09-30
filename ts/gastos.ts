function reduce(a: number, b: number) {
  return a + b;
}

const nubank = [228.11,17.21, 12915.16].reduce(reduce);
const santander = [1659.11, 4221.89].reduce(reduce);
const bb = [69.67].reduce(reduce);
const itau = [55.4535, 2684.65].reduce(reduce);
const easy = [603.70].reduce(reduce);
const negative = [-889.26,-267.39].reduce(reduce);
const waiting = [5000, 477.49,1300,27000].reduce(reduce);

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
