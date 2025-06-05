package com.recuperacio;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un videojoc amb un nom, preu, desenvolupadora, plataformes compatibles i valoracions.
 */
public class Videojoc {
    private String nom;
    private List<Plataforma> plataformes;
    private double preu;
    private Desenvolupadora desenvolupadora;
    private List<Valoracio> valoracions = new ArrayList<>();

    /**
     * Constructor que crea un videojoc amb una única plataforma.
     *
     * @param nom             Nom del videojoc.
     * @param plataforma      Plataforma on es pot jugar.
     * @param preu            Preu del videojoc.
     * @param desenvolupadora Desenvolupadora del videojoc.
     * @throws IllegalArgumentException es llença si algun parametre es buit o null o si la puntuacio es menor que 0 o major que 10
     */
    public Videojoc(String nom, Plataforma plataforma, double preu, Desenvolupadora desenvolupadora) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("El nom del videojoc no pot ser nul ni buit.");
        }
        if (plataforma == null) {
            throw new IllegalArgumentException("La plataforma no pot ser null.");
        }
        if (preu <= 0) {
            throw new IllegalArgumentException("El preu no pot ser 0 o negatiu.");
        }
        if (desenvolupadora == null) {
            throw new IllegalArgumentException("La desenvolupadora no pot ser nul·la.");
        }

        this.nom = nom;
        this.plataformes = new ArrayList<>();
        this.plataformes.add(plataforma);
        this.preu = preu;
        this.desenvolupadora = desenvolupadora;
        this.desenvolupadora.afegirVideojoc(this);
    }

    /**
     * Constructor que crea un videojoc 
     *
     * @param nom             Nom del videojoc.
     * @param plataformes     Llista de plataformes compatibles.
     * @param preu            Preu del videojoc.
     * @param desenvolupadora Desenvolupadora responsable del videojoc.
     * @throws IllegalArgumentException es llença si algun parametre es buit o null o si la puntuacio es menor que 0 o major que 10
     */
    public Videojoc(String nom, List<Plataforma> plataformes, double preu, Desenvolupadora desenvolupadora) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("El nom del videojoc no pot ser nul ni buit.");
        }
        if (plataformes == null || plataformes.isEmpty()) {
            throw new IllegalArgumentException("La plataforma no pot ser null ni buida.");
        }
        if (preu <= 0) {
            throw new IllegalArgumentException("El preu no pot ser 0 o negatiu.");
        }
        if (desenvolupadora == null) {
            throw new IllegalArgumentException("La desenvolupadora no pot ser nul·la.");
        }

        this.nom = nom;
        this.plataformes = new ArrayList<>(plataformes);
        this.preu = preu;
        this.desenvolupadora = desenvolupadora;
        this.desenvolupadora.afegirVideojoc(this);
    }

    /**
     * Retorna el nom del videojoc.
     *
     * @return Nom del videojoc.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retorna la llista de plataformes del videojoc.
     *
     * @return Llista de plataformes.
     */
    public List<Plataforma> getPlataformes() {
        return plataformes;
    }

    /**
     * Retorna la primera plataforma del videojoc.
     *
     * @return Plataforma principal.
     */
    public Plataforma getPlataforma() {
        return plataformes.get(0);
    }

    /**
     * Retorna el preu del videojoc.
     *
     * @return Preu.
     */
    public double getPreu() {
        return preu;
    }

    /**
     * Retorna la desenvolupadora del videojoc.
     *
     * @return Desenvolupadora del joc.
     */
    public Desenvolupadora getDesenvolupadora() {
        return desenvolupadora;
    }

    /**
     * Afegeix una nova valoracio al videojoc.
     *
     * @param val Valoracio a afegir.
     */
    public void afegirValoracio(Valoracio val) {
        valoracions.add(val);
    }

    /**
     * Retorna la llista de valoracions del videojoc.
     *
     * @return Llista de valoracions.
     */
    public List<Valoracio> getValoracions() {
        return valoracions;
    }

    /**
     * Retorna una String del videojoc.
     *
     * @return String amb el nom, plataformes, preu i desenvolupadora.
     */
    @Override
    public String toString() {
        return nom + " - Plataformes: " + plataformes + " - " + preu + " euros - Desenvolupadora: " + desenvolupadora;
    }
}
