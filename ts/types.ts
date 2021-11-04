enum Root {
  colors,
  size,
}

type Colors = "greyscale" | "branding";
type Values = "080" | "090" | "100";

type C = Exclude<
  `${keyof typeof Root}.${Colors | Values}${`.${Values}` | ""}`,
  `size.${Colors}.${Values}`
>;

const A: C = "colors.080";

// type Awaited<T> = T extends PromiseLike<infer U> ? Awaited<U> : T;
// /// Like `promise.then(...)`, but more accurate in types.
// declare function customThen<T, U>(
//   p: Promise<T>,
//   onFulfilled: (value: Awaited<T>) => U
// ): Promise<Awaited<U>>;

export type Flow = "setup" | "duplicate" | "default";

export type CustomCard = {
  id: string;
  code: string;
  name: string;
  price: number;
  createdAt: Date;
  updatedAt: Date;
  status: boolean;
  preSales: boolean;
  company: string;
  role?: string[];
  flows?: Flow[];
};

export type CustomCardForm = Omit<
  CustomCard,
  "id" | "createdAt" | "updatedAt" | "price"
> & {
  altImage: string;
  price: string;
  image: string | null;
  description: string;
};

async function getCustomCard(
  id: string,
  channelKey?: string
): Promise<{ data: CustomCardForm }> {
  const a: CustomCardForm = {
    altImage: "df",
    code: "006",
    company: "Ubsofit",
    description: "dfds",
    image: null,
    name: "sdf",
    preSales: false,
    price: "1.2",
    status: false,
    flows: ["duplicate"],
    role: [],
  };
  const myPromise = new Promise<CustomCardForm>((resolve, reject) => {
    setTimeout(() => {
      resolve(a);
    }, 2000);
  });
  return await myPromise.then((b) => ({ data: b }));
}
getCustomCard("qw").then((r) => {
  console.log(r.data);
});
