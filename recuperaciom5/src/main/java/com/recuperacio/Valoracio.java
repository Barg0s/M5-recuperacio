package com.recuperacio;

/**
 * Representa una valoracio que ha fet un usuari per a un joc
 * Inclou qui l'ha fet, el comentari i la nota.
 */
public class Valoracio {
    private String usuari;
    private String comentari;
    private int puntuacio;

    /**
     * Crea una Valoracio.
     *
     * @param usuari    Nom de l'usuari que ha fet la valoracio.
     * @param comentari Comentari sobre el videojoc.
     * @param puntuacio puntuacio entre 0 i 10.
     */
    public Valoracio(String usuari, String comentari, int puntuacio) {
        this.usuari = usuari;
        this.comentari = comentari;
        this.puntuacio = puntuacio; 
       validar();

    }

    /**
     * Retorna la puntuacio.
     *
     * @return puntuacio numerica.
     */
    public int getPuntuacio() {
        return puntuacio;
    }

    /**
     * Retorna el nom del usuari que ha fet la valoracio
     *
     * @return Nom de l'usuari.
     */
    public String getUsuari() {
        return usuari;
    }

    /**
     * Retorna el comentari de la valoracio.
     *
     * @return String del comentari
     */
    public String getComentari() {
        return comentari;
    }

    /**
     * Verifica si la valoracio es correcte
     * Comprova que el comentari no estigui buit i que la puntuació estigui entre 0 i 10.
     *
     * @throws IllegalArgumentException es llença si algun parametre es buit o null o si la puntuacio es menor que 0 o major que 10
     */
    public void validar() throws IllegalArgumentException {
        if (usuari == null || usuari.trim().isEmpty()) {
            throw new IllegalArgumentException("El nom d'usuari no pot estar buit.");
        }
        if (comentari == null ||comentari.trim().isEmpty()) {
            throw new IllegalArgumentException("El comentari no pot estar buit.");
        }
        if (puntuacio < 0 || puntuacio > 10) {
            throw new IllegalArgumentException("La puntuació ha d'estar entre 0 i 10.");
        }
    }


    /**
     * Retorna una representació textual de la valoració.
     *
     * @return Cadena amb el nom d'usuari, puntuació i comentari.
     */
    @Override
    public String toString() {
        return usuari + " (" + puntuacio + "/10): " + comentari;
    }
}
