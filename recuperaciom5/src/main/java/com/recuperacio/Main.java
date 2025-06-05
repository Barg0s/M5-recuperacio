package com.recuperacio;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Desenvolupadora capcom = new Desenvolupadora("Capcom", "Japó");
        Desenvolupadora nintendo = new Desenvolupadora("Nintendo", "Japó");
        Desenvolupadora sega = new Desenvolupadora("Sega", "Japó");
        Desenvolupadora square = new Desenvolupadora("Square Enix", "Japó");
        Desenvolupadora crystal = new Desenvolupadora("Crystal Dynamics", "EUA");

        Plataforma ps1 = new Plataforma("PlayStation 2");
        Plataforma ps2 = new Plataforma("PlayStation 2");
        Plataforma ps3 = new Plataforma("PlayStation 3");        
        Plataforma ps4 = new Plataforma("PlayStation 4");
        Plataforma ps5 = new Plataforma("PlayStation 5");
        Plataforma xbox = new Plataforma("Xbox One");
        Plataforma pc = new Plataforma("PC");
        Plataforma switchP = new Plataforma("Nintendo Switch");
        Plataforma superNintendo = new Plataforma("Super Nintendo");  

        List<Plataforma> varios = new ArrayList<>();
        List<Plataforma> varios2 = new ArrayList<>();
        varios.addAll(Arrays.asList(ps4, ps5, xbox, pc));
        varios2.addAll(Arrays.asList(ps3, ps4, xbox, pc));

        Videojoc joc1 = new VideojocAccio("Resident Evil 4", ps2, 40, capcom, "Survival Horror");
        Videojoc joc2 = new VideojocRol("Final Fantasy VII", ps1, 30, square, "Per torns");
        Videojoc joc3 = new VideojocAventura("The Legend of Zelda: Breath of the Wild", switchP, 60, nintendo, false);
        Videojoc joc4 = new VideojocAccio("Devil May Cry 5", varios, 50, capcom, "Hack and Slash");
        Videojoc joc5 = new VideojocRol("Persona 5", varios, 45, sega, "JRPG");
        Videojoc joc6 = new VideojocAventura("Tomb Raider", varios2, 40, crystal, true);
        Videojoc joc7 = new VideojocAccio("Bayonetta 2", switchP, 45, nintendo, "Hack n' slash");
        Videojoc joc8 = new VideojocRol("Chrono Trigger", superNintendo, 35, square, "RPG clàssic");
        Videojoc joc9 = new VideojocAventura("Sonic Frontiers", ps5, 50, sega, true);


        System.out.println("Informació de les desenvolupadores:");
        Desenvolupadora[] devs = {capcom, nintendo, sega, square, crystal};
        for (Desenvolupadora dev : devs) {
            System.out.println("- " + dev);
        }

        for (Desenvolupadora dev : devs) {
            System.out.println("\nVideojocs desenvolupats per " + dev.getNom() + ":");
            for (Videojoc joc : dev.getJocsDesenvolupats()) {
                System.out.println("- " + joc);
            }
        }

        Calculadora calculadora = new Calculadora();
        int rst = calculadora.suma(2, 3);
        System.out.println(String.format("\nEl resultat de calcular %d + %d és %d", 2, 3, rst));

        Usuari david = new Usuari("DavidGamer", "david@gmail.com");

        david.afegirFavorit(joc2); 
        david.afegirFavorit(joc9);  

        david.ferValoracio(joc2, "Molt bon joc", 10);
        david.ferValoracio(joc9, "Bon joc del Sonic!", 8);

        System.out.println("\n Favorits de David:");
        for (Videojoc fav : david.getFavorits()) {
            System.out.println("- " + fav.getNom());
        }


        System.out.println("\n Valoracions de David:");
        for (Valoracio v : david.getValoracionsFetes()) {
            System.out.println("- " + v);
        }



        System.out.println("\nValoracions de 'Final Fantasy VII':");
        for (Valoracio v : joc2.getValoracions()) {
            System.out.println("- " + v);
        }

    }
}
