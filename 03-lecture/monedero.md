# Monedero

In-class solution for Monedero assigment.

- Unnessary initial value of `saldo = 0`.

  There is no need of it.

- Unused setter for `movimientos`

  Remove it.

- Long message chain `getMovimientos().stream.filter(movimiento -> movimiento.isDeposito()).count() > 3`

  Extract to a private method.

- Long method non cohesive `sacar`

  Divide and conquer!, Exctract logic to methods.

- Repeated code-structure (logic) in `poner` and `sacar`

  Use **LAMBDA**

  ```java
  private void realizarOperacion(double cuanto, boolean isDeposito, Runnable verificacion) {
    verificarMontoNegativo(cuanto);
    verificacion.run();
    agregarMovimiento(LocalDate.now(), cuanto, isDeposito);
  }
  ```

- Not using encapsulation of `movimiento` in `getMontoExtraidoA`

- Missplaced method in `Movimiento`, `agregateA`.

- Long parameters in `agregarMovimiento`, not using class `Movimiento`

- Anti-pattern `isDeposio`.

  Extract sub-classes.
