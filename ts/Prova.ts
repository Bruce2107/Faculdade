import { Statistic } from './Statistic';
// 1
const casaA = [
  2.471, 2.357, 3.048, 2.566, 676, 1.795, 1.992, 1.401, 1.833, 2.005, 1.833,
];
const casaB = [
  2.4, 2.307, 3.008, 2.466, 546, 2.566, 1.992, 1.411, 1.83, 2.0, 1.546,
];

const CasaA = new Statistic(casaA);
const CasaB = new Statistic(casaB);

// console.log(CasaA.mean()); // 63.39099999999998
// console.log(CasaB.mean()); // 51.59327272727273

// console.log(CasaA.standardDeviation()); // 193.7244577772536
// console.log(CasaB.standardDeviation()); // 156.345761964884

// console.log(CasaA.variationCoefficient()); // 3.056024637208021
// console.log(CasaB.variationCoefficient()); // 3.030351704791893

// console.log(CasaA.zscore(-2.58)); // -0.34054037759059896
// console.log(CasaB.zscore(-2.58)); // -0.3464965858136936

// console.log(CasaA.truncate(10)); // 2.211111111111111
// console.log(CasaB.truncate(10)); // 2.235

// const sete = [12, -4, 20, 5, 3];
// const Sete = new Statistic(sete);
// console.log(Sete.quadratic());

// const oito = [50, 75];
// const Oito = new Statistic(oito);
// console.log(Oito.harmonic());