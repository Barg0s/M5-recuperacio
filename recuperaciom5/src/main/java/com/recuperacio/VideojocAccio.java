package com.recuperacio;

import java.util.List;

/**
 * Representa un videojoc del gènere d'accio on es pot especificar el subgenere.
 * Aquesta classe s'exten de la classe Videojoc.
 */
public class VideojocAccio extends Videojoc {
    private String subgenere;

    /**
     * Crea un videojoc d'acció amb una única plataforma.
     *
     * @param nom             Nom del videojoc.
     * @param plataforma      Plataforma per a la qual esta disponible.
     * @param preu            Preu del videojoc.
     * @param desenvolupadora Desenvolupadora que ha creat el videojoc.
     * @param subgenere       subgenere del videojoc d'accio.
     */
    public VideojocAccio(String nom, Plataforma plataforma, int preu, Desenvolupadora desenvolupadora, String subgenere) {
        super(nom, plataforma, preu, desenvolupadora);
        this.subgenere = subgenere;
    }

    /**
     * Crea un videojoc d'accio multiplataforma.
     *
     * @param nom             Nom del videojoc.
     * @param plataformes     Llista de plataformes compatibles.
     * @param preu            Preu del videojoc.
     * @param desenvolupadora Desenvolupadora que ha creat el videojoc.
     * @param subgenere       subgenere del videojoc d'accio.
     */
    public VideojocAccio(String nom, List<Plataforma> plataformes, int preu, Desenvolupadora desenvolupadora, String subgenere) {
        super(nom, plataformes, preu, desenvolupadora);
        this.subgenere = subgenere;
    }

    /**
     * Retorna el subgenere del videojoc d'acció.
     *
     * @return String del subgenere.
     */
    public String getSubgenere() {
        return subgenere;
    }

    /**
     * Retorna una string del videojoc amb el subgenere.
     *
     * @return String amb les dades del videojoc.
     */
    @Override
    public String toString() {
        return super.toString() + " - subgenere: " + subgenere;
    }
}
