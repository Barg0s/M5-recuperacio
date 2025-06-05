package com.recuperacio;

/**
 * Classe que representa una pel·lícula.
 */
public class Pelicula {
    private String titol;
    private String director;
    private int anyEstrena;
    private int duradaMinuts;

    /**
     * Constructor per defecte.
     */
    public Pelicula() {
        this.titol = "Desconeguda";
        this.director = "Anònim";
        this.anyEstrena = 0;
        this.duradaMinuts = 0;
    }

    /**
     * Constructor amb paràmetres.
     * 
     * @param titol         Títol de la pel·lícula
     * @param director      Nom del director
     * @param anyEstrena    Any d'estrena
     * @param duradaMinuts  Durada en minuts
     */
    public Pelicula(String titol, String director, int anyEstrena, int duradaMinuts) {
        this.titol = titol;
        this.director = director;
        this.anyEstrena = anyEstrena;
        this.duradaMinuts = duradaMinuts;
    }

    // Getters
    public String getTitol() {
        return titol;
    }

    public String getDirector() {
        return director;
    }

    public int getAnyEstrena() {
        return anyEstrena;
    }

    public int getDuradaMinuts() {
        return duradaMinuts;
    }


    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setAnyEstrena(int anyEstrena) {
        this.anyEstrena = anyEstrena;
    }

    public void setDuradaMinuts(int duradaMinuts) {
        this.duradaMinuts = duradaMinuts;
    }

    /**
     * Mostra informació de la pel·lícula.
     */
    public void mostrarInformacio() {
        System.out.println("Títol: " + titol);
        System.out.println("Director: " + director);
        System.out.println("Any d'estrena: " + anyEstrena);
        System.out.println("Durada: " + duradaMinuts + " minuts");
    }


}
