package com.recuperacio;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una empresa desenvolupadora de videojocs.
 * te el seu nom, pais i els videojocs que ha desenvolupat.
 */
public class Desenvolupadora {
    private String nom;
    private String pais;
    private List<Videojoc> jocsDesenvolupats;

    /**
     * Crea una nova Desenvolupadora.
     * Cap dels camps pot ser nul ni buit.
     *
     * @param nom  El nom de la desenvolupadora
     * @param pais El pais d'origen de la desenvolupadora 
     * @throws IllegalArgumentException es llença si algun parametre es buit o null
     */
    public Desenvolupadora(String nom, String pais) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("El nom de la desenvolupadora no pot ser nul ni buit.");
        }
        if (pais == null || pais.trim().isEmpty()) {
            throw new IllegalArgumentException("El pais de la desenvolupadora no pot ser nul ni buit.");
        }

        this.nom = nom;
        this.pais = pais;
        this.jocsDesenvolupats = new ArrayList<>();
    }

    /**
     * Retorna el nom de la desenvolupadora.
     *
     * @return el nom.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retorna el pais de la desenvolupadora
     *
     * @return El pais.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Afegeix un videojoc a la llista de jocs desenvolupats per aquesta empresa.
     *
     * @param joc El videojoc a afegir.
     */
    public void afegirVideojoc(Videojoc joc) {
        jocsDesenvolupats.add(joc);
    }

    /**
     * Retorna la llista de videojocs desenvolupats per aquesta empresa.
     *
     * @return Un array de videojocs.
     */
    public List<Videojoc> getJocsDesenvolupats() {
        return jocsDesenvolupats;
    }

    /**
     * Retorna un text amb el nom i el pais de la desenvolupadora.
     *
     * @return Un string amb el nom i el pais.
     */
    @Override
    public String toString() {
        return nom + " (" + pais + ")";
    }
}
