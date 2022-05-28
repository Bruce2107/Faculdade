function generateVector(length) {
  return Array.from({ length }, (v, k) => Math.floor(Math.random() * 100));
}
const sizes = [10, 30, 50, 70, 90];
const key = Math.floor(Math.random() * 100);

const Arrays = (() => {
  const result = [];
  sizes.forEach((size) => {
    const vector = generateVector(size);
    result.push({ size, vector, key });
  });
  return result;
})();

const resultsBinaria = (() => {
  console.log('Binaria');
  Arrays.forEach((item) => {
    const { size, vector, key } = item;
    const result = {
      size,
      key,
      binaria: `(${size}, ${binaria(
        key,
        vector.sort((a, b) => a - b),
        size
      )})`,
    };
    console.log(result);
  });
})();

const resultsBinariaRecursiva = (() => {
  console.log('Binaria Recursiva');
  Arrays.forEach((item) => {
    const { size, vector, key } = item;
    let count = 0;
    const result = {
      size,
      key,
      binariaRecursiva: `(${size}, ${
        binariaRecursiva(
          key,
          vector.sort((a, b) => a - b),
          0,
          size,
          count
        )[1]
      })`,
    };
    console.log(result);
  });
})();

const resultsSentinela = (() => {
  console.log('Sentinela');
  Arrays.forEach((item) => {
    const { size, vector, key } = item;
    const result = {
      size,
      key,
      sentinela: `(${size}, ${sentinela(key, vector, size)})`,
    };
    console.log(result);
  });
})();

const resultsSequencial = (() => {
  console.log('Sequencial');
  Arrays.forEach((item) => {
    const { size, vector, key } = item;
    const result = {
      size,
      key,
      sequencial: `(${size}, ${sequencial(key, vector, size)})`,
    };
    console.log(result);
  });
})();

const resultInterpolacao = (() => {
  console.log('Interpolacao');
  Arrays.forEach((item) => {
    const { size, vector, key } = item;
    const result = {
      size,
      key,
      interpolacao: `(${size}, ${interpolacao(
        key,
        vector.sort((a, b) => a - b),
        size
      )})`,
    };
    console.log(result);
  });
})();

function binaria(key, vector, length) {
  vector.sort((a, b) => a - b);
  let i = 0,
    m,
    f = length - 1;
  let count = 0;
  while (i <= f) {
    m = Math.trunc((i + f) / 2);
    count++;
    if (key < vector[m]) {
      f = m - 1;
      count += 1;
    } else if (key > vector[m]) {
      i = m + 1;
      count += 2;
    } else {
      return count + 2;
    }
  }
  return count;
}
function binariaRecursiva(key, vector, init, end, count) {
  let m = (init + end) / 2;
  count++;
  if (init > end) return [-1, count];
  count++;
  if (vector[m] == key) return [m, count];
  else {
    count++;
    if (key < vector[m])
      return binariaRecursiva(key, vector, init, m - 1, count);
    else return binariaRecursiva(key, vector, m + 1, end, count);
  }
}
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
function sequencial(key, vector, length) {
  let count = 0;
  for (let i = 0; i < length; i++) {
    count += 2;
    if (vector[i] == key) return count;
  }
  return count;
}
