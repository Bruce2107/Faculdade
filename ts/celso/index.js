const csvFilePath = './input.csv';
const csv = require('csvtojson');
const fs = require('fs');

const writeFile = async () => {
  const a = await csv().fromFile(csvFilePath);
  fs.writeFileSync('./output.json', JSON.stringify(a));
}

writeFile()