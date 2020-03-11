package homework8.part1;

@FunctionalInterface
interface MyTriFunctional<W, X, Y, Z> {
    Z get(W w, X x, Y y);
}