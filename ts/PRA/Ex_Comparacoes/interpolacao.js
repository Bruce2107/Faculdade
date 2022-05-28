function generateVector(length) {
  return Array.from(Array(length).keys());
}
const sizes = [10, 100, 1000, 10000, 100000];
const key = (n) => Math.floor(Math.random() * n);

const results = (() => {
  const result = [];
  sizes.forEach((size) => {
    const vector = generateVector(size);
    let k = key(size);
    result.push({ l: size, c: interpolacao(k, vector, size), k });
  });
  return result;
})();

function interpolacao(key, vector, length) {
  let init = 0,
    middle,
    end = length - 1,
    count = 0;
  while (init <= end) {
    count++;
    middle =
      init +
      Math.floor(
        ((end - init) * (key - vector[init])) / (vector[end] - vector[init])
      );
    if (key < vector[middle]) {
      end = middle - 1;
      count++;
    } else if (key > vector[middle]) {
      init = middle + 1;
      count += 2;
    } else return count + 2;
  }
}

results.forEach((r) => console.log(`${r.k}: ${r.l} -> ${r.c}`));
