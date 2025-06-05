package com.recuperacio;

import java.util.List;

/**
 * Representa un videojoc del gènere de rol amb un tipus de combat específic.
 * Aquesta classe extén {@link Videojoc}.
 */
public class VideojocRol extends Videojoc {
    private String TipusCombat;

    /**
     * Crea un videojoc de rol amb una sola plataforma.
     *
     * @param nom              Nom del videojoc.
     * @param plataforma      Plataforma per a la qual esta disponible.
     * @param preu             Preu del videojoc.
     * @param desenvolupadora  Desenvolupadora que ha creat el videojoc.
     * @param TipusCombat      Tipus de combat que ofereix el joc.
     */
     public VideojocRol(String nom, Plataforma plataforma, int preu, Desenvolupadora desenvolupadora, String TipusCombat) {
        super(nom, plataforma, preu, desenvolupadora);
        this.TipusCombat = TipusCombat;
    }

    /**
     * Crea un videojoc de rol amb múltiples plataformes.
     *
     * @param nom              Nom del videojoc.
     * @param plataformes      Llista de plataformes compatibles.
     * @param preu             Preu del videojoc.
     * @param desenvolupadora  Desenvolupadora que ha creat el videojoc.
     * @param TipusCombat      Tipus de combat que ofereix el joc.
     */
    public VideojocRol(String nom, List<Plataforma> plataformes, int preu, Desenvolupadora desenvolupadora, String TipusCombat) {
        super(nom, plataformes, preu, desenvolupadora);
        this.TipusCombat = TipusCombat;
    }

    /**
     * Retorna el tipus de combat del videojoc.
     *
     * @return String del tipus de combat.
     */
    public String getTipusCombat() {
        return TipusCombat;
    }

    /**
     * Retorna una string del videojoc amb el tipus de combat.
     *
     * @return String amb les dades del videojoc.
     */
    @Override
    public String toString() {
        return super.toString() + " - Subgènere: " + TipusCombat;
    }
}
