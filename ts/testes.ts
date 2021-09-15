export const ORIENTATION = {
  LANDSCAPE: 'LANDSCAPE',
  PORTRAIT: 'PORTRAIT',
};
export const ProgramName = {
  CARTAO_BRANCO: 'cartaobranco',
  CREDICARD: 'credicard',
  SAMSUNG: 'samsungitaucard',
  MERCADO_LIVRE: 'mercadolivre',
  ITI: 'iticartãodecrédito',
};

const BRANDING_MAP = new Map([
  [
    ProgramName.CARTAO_BRANCO,
    { image: 'cb', orientation: ORIENTATION.LANDSCAPE },
  ],
  [ProgramName.CREDICARD, { image: 'on', orientation: ORIENTATION.PORTRAIT }],
  [ProgramName.ITI, { image: 'iti', orientation: ORIENTATION.LANDSCAPE }],
  [
    ProgramName.MERCADO_LIVRE,
    { image: 'ml', orientation: ORIENTATION.LANDSCAPE },
  ],
  [ProgramName.SAMSUNG, { image: 'sam', orientation: ORIENTATION.PORTRAIT }],
]);

const obj = (program: string) =>
  ({
    [ProgramName.CARTAO_BRANCO]: {
      image: 'cb',
      orientation: ORIENTATION.LANDSCAPE,
    },
    [ProgramName.CREDICARD]: {
      image: 'credicard',
      orientation: ORIENTATION.PORTRAIT,
    },
    [ProgramName.ITI]: {
      image: 'iti',
      orientation: ORIENTATION.LANDSCAPE,
    },
    [ProgramName.MERCADO_LIVRE]: {
      image: 'mercadoLivre',
      orientation: ORIENTATION.LANDSCAPE,
    },
    [ProgramName.SAMSUNG]: {
      image: 'samsung',
      orientation: ORIENTATION.PORTRAIT,
    },
  }[program] || null);

console.time('MAP');
console.log(
  BRANDING_MAP.has('credicardasd') ? BRANDING_MAP.get('credicardasd') : null
);
console.log(BRANDING_MAP.get(ProgramName.CARTAO_BRANCO));
console.timeEnd('MAP');

console.time('OBJ');
console.log(obj('credicardasd'));
console.log(obj(ProgramName.CARTAO_BRANCO));
console.timeEnd('OBJ');

// console.table(BRANDING_MAP)

// for1: for(let i = 0; i < 4; i++) {
//   for2: for(let j =0; j < 3; j++) {
//     if(i == 1) {
//       continue for1
//     }
//     console.log(`${i} - ${j}`)
//   }
// }
