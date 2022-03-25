enum LETTERS {
  "A",
  "B",
  "C",
  "D",
  "E",
  "F",
  "G",
  "H",
  "I",
  "J",
  "K",
  "L",
  "M",
  "N",
  "O",
  "P",
  "Q",
  "R",
  "S",
  "T",
  "U",
  "V",
  "W",
  "X",
  "Y",
  "Z",
}

const ALPHABET_LENGTH = Object.keys(LETTERS).length / 2;

type LETTER = keyof typeof LETTERS;
function vigenere(
  input: string,
  key: string,
  mode: "encode" | "decode"
): string {
  const words = input.split(" ");
  const encodedWords = [];
  for (let word of words) {
    const letters = word.split("");
    let count = 0;
    const encodedWord = [];
    for (let letter in letters) {
      const Mi = LETTERS[letters[letter].toUpperCase() as LETTER];
      const Ki = LETTERS[key[count % key.length].toUpperCase() as LETTER];
      const Ci = (Mi + (mode === "encode" ? Ki : -Ki)) % ALPHABET_LENGTH;
      encodedWord.push(LETTERS[Ci]);
      count++;
    }
    encodedWords.push(encodedWord.join(""));
  }
  return encodedWords.join(" ");
}

console.log(vigenere("attackatdawn attackatdawn", "LEMONLEMONLE", "encode"));
console.log(vigenere("LXFOPVEFRNHR LXFOPVEFRNHR", "LEMONLEMONLE", "decode"));
