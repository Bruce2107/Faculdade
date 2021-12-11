const phrases = [
  'Poeminho do contra',
  '',
  'Todos esses que ai estao',
  'Atravancando meu caminho',
  'Eles passarao...',
  'Eu passarinho!',
  '',
  'Mario Quintana',
];

const Word = 'marca';

// const tamanho = 1
// const phrases = ["pEnSo, LoGo ExIsTo"]
// const Word = "oi"

let letterIndex = 0;
let countWord = 0;

phrases.forEach((phrase) => {
  if (phrase.length) {
    phrase.split(' ').forEach((word) => {
      countWord++;
      const letter = Word[letterIndex];
      if (word.toLocaleLowerCase().includes(letter)) {
        console.log(
          `${letter}: palavra ${countWord}, letra ${word.indexOf(letter) + 1}`
        );
        letterIndex++;
      }
    });
  }
});
