// melhor caso -> Primeiro item
// caso médio -> qualquer outra posição
// pior caso -> ultimo item ou nao encontrado

function generateVector(length) {
  return Array.from({ length }, (v, k) => Math.floor(Math.random() * 100));
}
const sizes = [10, 100, 1000, 10000, 100000];
const key = Math.floor(Math.random() * 100);

const results = (() => {
  const result = [];
  sizes.forEach((size) => {
    const vector = generateVector(size);
    result.push({ l: size, c: sentinela(key, vector, size) });
  });
  return result;
})();

function sentinela(key, vector, length) {
  let i = 0,
    count = 0;
  vector[length] = key;
  while (vector[i] != key) {
    i++;
    count++;
  }
  return count + 1;
}

console.log(key);
results.forEach((r) => console.log(`${r.l} -> ${r.c}`));
