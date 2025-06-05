package com.recuperacio;

import java.util.List;


/**
 * Representa un videojoc del gènere d'aventura on es pot especificar si te coop o no.
 * Aquesta classe s'exten de la classe Videojoc.
 */
public class VideojocAventura extends Videojoc {
    private boolean modeCooperatiu;

    /**
     * Crea un videojoc d'aventura amb una sola plataforma.
     *
     * @param nom              Nom del videojoc.
     * @param plataforma       Plataforma per a la qual esta disponible.
     * @param preu             Preu del videojoc.
     * @param desenvolupadora  Desenvolupadora que ha creat el videojoc.   
     * @param modeCooperatiu   Indica si el videojoc inclou mode cooperatiu.
     */
    public VideojocAventura(String nom, Plataforma plataforma, int preu, Desenvolupadora desenvolupadora, boolean modeCooperatiu) {
        super(nom, plataforma, preu, desenvolupadora);
        this.modeCooperatiu = modeCooperatiu;
    }

    /**
     * Crea un videojoc d'aventura multiplataforma.
     *
     * @param nom              Nom del videojoc.
     * @param plataformes      Llista de plataformes compatibles.
     * @param preu             Preu del videojoc.
     * @param desenvolupadora  Desenvolupadora que ha creat el videojoc.   
     * @param modeCooperatiu   Indica si el videojoc inclou mode cooperatiu.
     */
    public VideojocAventura(String nom, List<Plataforma> plataformes, int preu, Desenvolupadora desenvolupadora, boolean modeCooperatiu) {
        super(nom, plataformes, preu, desenvolupadora);
        this.modeCooperatiu = modeCooperatiu;
    }

    /**
     * Retorna si el videojoc ofereix mode cooperatiu.
     *
     * @return true si te cooperatiu,false si no.
     */
    public boolean isModeCooperatiu() {
        return modeCooperatiu;
    }

    /**
     * Retorna una string del videojoc amb el cooperatiu.
     *
     * @return String amb les dades del videojoc.
     */
    @Override
    public String toString() {
        return super.toString() + "  - Mode cooperatiu: " + (modeCooperatiu ? "Si" : "No");
    }
}
