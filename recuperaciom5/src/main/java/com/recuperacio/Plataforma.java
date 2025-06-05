package com.recuperacio;



/**
 * Es la plataforma on els jocs serán llençats
 * Conté el nom d'aquesta.
 * 
 */
public class Plataforma {
    private String nom;
    /**
     * Crea una nova plataforma.
     * Cap dels camps pot ser nul ni buit.
     *
     * @param nom  El nom de la consola 
     * @throws IllegalArgumentException es llença si algun parametre es buit o null
     */
    public Plataforma(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("El nom de la plataforma no pot ser nul ni buit.");
        }
        this.nom = nom.trim();
    }
    /**
     * Retorna el nom de la plataforma.
     *
     * @return el nom.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retorna un text de la plataforma.
     *
     * @return Un String amb el nom.
     */

    @Override
    public String toString() {
        return nom;
    }

    /**
     * 
     * @param a
     * @return Boolea que indica si aquesta plataforma ha sigut creada o no
     */
    public boolean existeix(Plataforma a) {
    return this.nom.equalsIgnoreCase(a.getNom());
    }



}
