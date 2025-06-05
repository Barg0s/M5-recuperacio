package com.recuperacio;

import java.util.*;

/**
 * Classe que representa un usuari.
 * Un usuari pot tenir videojocs favorits i fer valoracions.
 */
public class Usuari {
    private String nomUsuari;
    private String email;
    private List<Videojoc> favorits;
    private List<Valoracio> valoracionsFetes;

    /**
     * Crea un nou usuari amb nom i email
     * 
     * @param nomUsuari Nom d'usuari
     * @param email Email de l'usuari
     * @throws IllegalArgumentException si el nom o l'email són nuls o buits.
     */
    public Usuari(String nomUsuari, String email) throws IllegalArgumentException {
        if (nomUsuari == null || nomUsuari.trim().isEmpty()) {
            throw new IllegalArgumentException("El nom d'usuari no pot estar buit.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no pot estar buit.");
        }

        this.nomUsuari = nomUsuari;
        this.email = email;
        this.favorits = new ArrayList<>();
        this.valoracionsFetes = new ArrayList<>();
    }

    /**
     * Retorna el nom de l'usuari.
     * 
     * @return Nom d'usuari.
     */
    public String getNomUsuari() {
        return nomUsuari;
    }

    /**
     * Retorna el mail de l'usuari.
     * 
     * @return mail de l'usuari.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retorna la llista de videojocs favorits de l'usuari.
     * 
     * @return Array de videojocs favorits.
     */
    public List<Videojoc> getFavorits() {
        return favorits;
    }

    /**
     * Afegeix un videojoc als favorits de l'usuari si no es troba a la llista.
     * 
     * @param joc Videojoc a afegir.
     */
    public void afegirFavorit(Videojoc joc) {
        if (!favorits.contains(joc)) {
            favorits.add(joc);
        }
    }

    /**
     * Elimina un videojoc dels favorits de l'usuari.
     * 
     * @param joc Videojoc a eliminar.
     */
    public void treureFavorit(Videojoc joc) {
        favorits.remove(joc);
    }

    /**
     * Permet a l'usuari fer una valoració si aquest no te una per el mateix usuari.
     * 
     * @param joc Videojoc a valorar.
     * @param comentari Comentari del usuari.
     * @param puntuacio Puntuació del videojoc.
     */
    public void ferValoracio(Videojoc joc, String comentari, int puntuacio) {
        for (Valoracio v : joc.getValoracions()) {
            if (v.getUsuari().equals(this.nomUsuari)) {
                return; 
            }
        }
        Valoracio val = new Valoracio(this.nomUsuari, comentari, puntuacio);
        val.validar(); 
        joc.afegirValoracio(val);
        valoracionsFetes.add(val);
    }


    /**
     * Retorna les valoracions que ha fet l'usuari.
     * 
     * @return Llista de valoracions fetes.
     */
    public List<Valoracio> getValoracionsFetes() {
        return valoracionsFetes;
    }

    /**
     * Retorna una representació textual de l'usuari.
     * 
     * @return String amb el nom i l'email de l'usuari.
     */
    @Override
    public String toString() {
        return "Usuari: " + nomUsuari + " (" + email + ")";
    }
}
