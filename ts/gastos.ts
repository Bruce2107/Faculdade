function reduce(a: number, b: number) {
  return a + b;
}

const nubank = [834.21,30821.99].reduce(reduce);
const santander = [404.21, 4349.92].reduce(reduce);
const bb = [70.13].reduce(reduce);
const itau = [3597.56, 2701.23].reduce(reduce);
const easy = [610.68].reduce(reduce);
const negative = [-1179.91,-1060.69,-7.02].reduce(reduce);
const waiting = [5000, 477.49,1300].reduce(reduce);

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
