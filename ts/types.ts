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
