#!/usr/bin/env node

const csvFilePath = './input.csv';
const csv = require('csvtojson');
const fs = require('fs');

const writeFile = async () => {
  const a = await csv().fromFile(csvFilePath);
  fs.writeFileSync('./output.json', JSON.stringify(a));
}

writeFile()

// if (typeof 'a' === '')
// const a = (i) => {
//   switch (typeof i) {
//     case 'number':
//     case 'bigint':
//       return 'Inteiro';
//     case 'boolean':
//       return 'bool';
//     case 'string':
//       return 'string';
//     case 'function':
//       return 'função';
//     case 'object':
//       return 'objeto';
//     default:
//       return 'não sei';
//   }
// };

// console.log(a('a'));
// console.log(a(1));
// console.log(a(false));
// console.log(a({}));
// console.log(a(() => 1));
