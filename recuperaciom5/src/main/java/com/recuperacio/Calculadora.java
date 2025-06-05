package com.recuperacio;

/**
 * Classe que representa una calculadora basica capaç que realitza operacions basiques.
 */
public class Calculadora {

    /**
     * Suma dos nombres enters.
     *
     * @param a primer numero enter
     * @param b segon numero enter
     * @return el resultat de a + b
     */
    public int suma(int a, int b) {
        return a + b;
    }

    /**
     * Resta dos nombres enters.
     *
     * @param a primer numero enter
     * @param b segon numero enter
     * @return el resultat de a - b
     */
    public int restar(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dos nombres enters.
     *
     * @param a primer numero enter
     * @param b segon numero enter
     * @return el resultat de a * b
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divideix dos nombres enters.
     *
     * @param a dividend 
     * @param b divisor
     * @return el resultat de a / b
     * @throws ArithmeticException si b és zero
     */
    public int divisio(int a, int b) throws ArithmeticException {
        if (b == 0){
            throw new ArithmeticException("No es pot dividir entre 0.");
        }
        return a / b;
    }
}
