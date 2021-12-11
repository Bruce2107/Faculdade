import { Statistic, WeightedData } from './Statistic';
import { Discount, InterestRate } from './Financial';
import * as values from './data';

const A1 = new Statistic(values.bancoA);
const A2 = new Statistic(values.bancoB);
const B1 = new Statistic(values.d4);
const B2 = new Statistic(values.d15);
const C = new Statistic(values.volts);

// console.log('C',C.standardDeviation())
// console.log('C',C.mean())
// const X = C.standardDeviation()*-2.56
// console.log(X+C.mean())

const Q = new InterestRate()
console.log(Q.JCP(48,undefined,640,0.006))