import { Statistic, WeightedData } from './Statistic';
import { Discount, InterestRate } from './Financial';

let dados = [4.01, 4.03, 4.03, 4.02, 4.01];
const pounded: WeightedData[] = [
  { value: 62, pound: 2 },
  { value: 87, pound: 2 },
  { value: 34, pound: 2 },
  { value: 56, pound: 4 },
];

const data = new Statistic(dados, pounded);

console.log(data.mode());

const discount = new Discount();

console.log(discount.DCC(undefined, 4500, 0.025, 2));
console.log(discount.DCC(227.81249999999963, undefined, 0.025, 2));
console.log(discount.DCC(227.81249999999963, 4500, undefined, 2));
console.log(discount.DCC(227.81249999999963, 4500, 0.025));

const rate = new InterestRate();
console.log(rate.TA(undefined, 0.043478, 0.15));
console.log(rate.TA(0.2, undefined, 0.15));
console.log(rate.TA(0.2, 0.043478));

