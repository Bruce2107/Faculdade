const list = [
  {
    identity: 128,
    start: 78,
    end: 68,
    type: 'USER_STATUS',
    properties: {
      type: 'watched',
    },
    elementId: '128',
    startNodeElementId: '78',
    endNodeElementId: '68',
  },
  {
    identity: 134,
    start: 84,
    end: 68,
    type: 'USER_STATUS',
    properties: {
      type: 'watched',
    },
    elementId: '134',
    startNodeElementId: '84',
    endNodeElementId: '68',
  },
  {
    identity: 131,
    start: 81,
    end: 68,
    type: 'USER_STATUS',
    properties: {
      type: 'dropped',
    },
    elementId: '131',
    startNodeElementId: '81',
    endNodeElementId: '68',
  },
  {
    identity: 129,
    start: 79,
    end: 68,
    type: 'USER_STATUS',
    properties: {
      type: 'watched',
    },
    elementId: '129',
    startNodeElementId: '79',
    endNodeElementId: '68',
  },
  {
    identity: 132,
    start: 82,
    end: 68,
    type: 'USER_STATUS',
    properties: {
      type: 'plan_to_watch',
    },
    elementId: '132',
    startNodeElementId: '82',
    endNodeElementId: '68',
  },
  {
    identity: 130,
    start: 80,
    end: 68,
    type: 'USER_STATUS',
    properties: {
      type: 'watched',
    },
    elementId: '130',
    startNodeElementId: '80',
    endNodeElementId: '68',
  },
  {
    identity: 133,
    start: 83,
    end: 68,
    type: 'USER_STATUS',
    properties: {
      type: 'watching',
    },
    elementId: '133',
    startNodeElementId: '83',
    endNodeElementId: '68',
  },
];

export function RemoveUnexpectedItems(
  object: any[],
  expectedItems: string[]
): any[] {
  object.forEach((item) => {
    Object.keys(item)
      .filter((toFilter) => !expectedItems.includes(toFilter))
      .forEach((toRemove) => delete item[toRemove]);
  });
  return object;
}

const a = RemoveUnexpectedItems(list, ['properties']);

type Status = 'watched' | 'watching' | 'dropped' | 'plan_to_watch';

const l = a.map(({ properties: { type } }) => type);

export function Counter<R extends string>(
  list: string[],
  counter: { [key in R]: number }
) {
  list.forEach((i) => counter[i as R]++);
  return counter;
}

const count: { [key in Status]: number } = {
  watched: 0,
  watching: 0,
  dropped: 0,
  plan_to_watch: 0,
};

const b = Object.keys(count).map((k) => ({ name: k, v: count[k as Status] }));
console.log(b);

// console.log(Counter(l, count));

// a.forEach(({ properties: { type } }) => {
//   count[type as Status]++;
// });

// console.log(l);
// console.log(count);
