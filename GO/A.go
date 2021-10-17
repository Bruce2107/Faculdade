func fatorial(n int) (int, error) {
	switch {
	case n < 0:
			return -1, fmt.Errorf("Numero invalido: %d", n)
	case n == 0:
			return 1, nil
	default:
			fatorialAnterior, _ := fatorial(n - 1)
			return n * fatorialAnterior, nil
	}
}

