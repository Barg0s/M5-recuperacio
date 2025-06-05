package com.recuperacio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestMain {


    // ---------- TESTS DE VIDEOJOCS BASE I ESPECIALITZATS ----------

    @Test
    public void TestPlataformes() {
        Plataforma p1 = new Plataforma("PC");
        Plataforma p2 = new Plataforma("pc");
        Plataforma p3 = new Plataforma("PS4 ");

        Exception e = assertThrows(IllegalArgumentException.class, () -> 
            new Plataforma(null));
        assertEquals("El nom de la plataforma no pot ser nul ni buit.", e.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> 
            new Plataforma(" "));
        assertEquals("El nom de la plataforma no pot ser nul ni buit.", e2.getMessage());


        assertTrue(p1.existeix(p2));

        assertFalse(p1.existeix(p3));
        System.out.println("TestPlataformes esta be");
    }

    @Test
    public void testVideojocBase() {

        Plataforma switchP = new Plataforma("Nintendo Switch");
        Desenvolupadora sega = new Desenvolupadora("Sega", "Japó");
        Desenvolupadora askiisoft = new Desenvolupadora("askiisoft", "Japó");
        Plataforma ps4 = new Plataforma("PlayStation 4");
        Plataforma ps5 = new Plataforma("PlayStation 5");
        Plataforma xbox = new Plataforma("Xbox One");
        Plataforma pc = new Plataforma("PC");
        // Crear lista con una plataforma válida
        List<Plataforma> plataformes = new ArrayList<>();
        Plataforma gameCube = new Plataforma("GameCube");

        plataformes.addAll(Arrays.asList(ps4, ps5, xbox, pc));


        // Crear videojoc con lista plataformas
        Videojoc joc = new Videojoc("Sonic Heroes", gameCube, 25, sega);
        Videojoc joc2 = new Videojoc("Katana Zero", plataformes, 10, askiisoft);

        // Comprobaciones básicas
        assertEquals("Sonic Heroes", joc.getNom());

        // El getter getPlataformes() devuelve una lista, por eso comparamos la lista completa
        assertEquals("GameCube", joc.getPlataforma().getNom());
        assertEquals(plataformes, joc2.getPlataformes());

        assertEquals(25, joc.getPreu());
        assertEquals(sega, joc.getDesenvolupadora());

        // Comprobamos que la desarrolladora tiene el juego en su lista
        assertNotNull(sega.getJocsDesenvolupats());
        assertEquals(1, sega.getJocsDesenvolupats().size());
        assertTrue(sega.getJocsDesenvolupats().contains(joc));

        assertEquals("Sega", sega.getNom());
        assertEquals("Japó", sega.getPais());

        // Excepciones para validaciones de constructor:

        // Nom null
        Exception e1 = assertThrows(IllegalArgumentException.class, () -> 
            new Videojoc(null, switchP, 20, sega));
        assertEquals("El nom del videojoc no pot ser nul ni buit.", e1.getMessage());

        // Nom buit
        Exception e2 = assertThrows(IllegalArgumentException.class, () -> 
            new Videojoc("   ", switchP, 20, sega));
        assertEquals("El nom del videojoc no pot ser nul ni buit.", e2.getMessage());

        // Plataforma null (usar constructor con plataforma individual)
        Exception e3 = assertThrows(IllegalArgumentException.class, () -> 
            new Videojoc("Mario", (Plataforma) null, 20, sega));
        assertEquals("La plataforma no pot ser null.", e3.getMessage());

        // Plataforma buida: En tu código no tienes un constructor que acepte String para plataforma, por lo que no tiene sentido probar plataforma vacía como String.
        // En cambio, para lista vacía:
        Exception e4 = assertThrows(IllegalArgumentException.class, () -> 
            new Videojoc("Mario", new ArrayList<>(), 20, sega));
        assertEquals("La plataforma no pot ser null ni buida.", e4.getMessage());

        // Desenvolupadora null
        Exception e5 = assertThrows(IllegalArgumentException.class, () -> 
            new Videojoc("Mario", switchP, 30, null));
        assertEquals("La desenvolupadora no pot ser nul·la.", e5.getMessage());

        // Preu 0 o negatiu
        Exception e6 = assertThrows(IllegalArgumentException.class, () -> 
            new Videojoc("Mario", switchP, 0, sega));
        assertEquals("El preu no pot ser 0 o negatiu.", e6.getMessage());

        Exception e7 = assertThrows(IllegalArgumentException.class, () -> 
            new Videojoc("Mario", switchP, -1, sega));
        assertEquals("El preu no pot ser 0 o negatiu.", e7.getMessage());

        System.out.println("testVideojoc està bé");
    }


    @Test
    public void testVideojocAccio() {
        Desenvolupadora capcom = new Desenvolupadora("Capcom", "Japó");
        Plataforma ps2 = new Plataforma("PlayStation 2");

        VideojocAccio joc = new VideojocAccio("Devil May Cry", ps2, 40, capcom, "Hack and Slash");

        assertEquals("Devil May Cry", joc.getNom());
        assertEquals("PlayStation 2", joc.getPlataforma().getNom());
        assertEquals(40, joc.getPreu());
        assertEquals(capcom, joc.getDesenvolupadora());
        assertEquals("Hack and Slash", joc.getSubgenere());
        assertEquals(1, capcom.getJocsDesenvolupats().size());
        assertTrue(capcom.getJocsDesenvolupats().contains(joc));
        System.out.println("testVideojocAccio esta be");

    }

    @Test
    public void testVideojocRol() {
        Desenvolupadora square = new Desenvolupadora("Square Enix", "Japó");
        Plataforma ps1 = new Plataforma("PlayStation 1");

        VideojocRol joc = new VideojocRol("Final Fantasy IX", ps1, 35, square, "Per torns");

        assertEquals("Final Fantasy IX", joc.getNom());
        assertEquals("PlayStation 1", joc.getPlataforma().getNom());
        assertEquals(35, joc.getPreu());
        assertEquals(square, joc.getDesenvolupadora());
        assertEquals("Per torns", joc.getTipusCombat());
        assertEquals(1, square.getJocsDesenvolupats().size());
        assertTrue(square.getJocsDesenvolupats().contains(joc));

        System.out.println("testVideojocRol esta be");

    }

    @Test
    public void testVideojocAventura() {
        Desenvolupadora nintendo = new Desenvolupadora("Nintendo", "Japó");
        Plataforma switchP = new Plataforma("Nintendo Switch");

        VideojocAventura joc = new VideojocAventura("The Legend of Zelda: Tears of the Kingdom", switchP, 70, nintendo, true);

        assertEquals("The Legend of Zelda: Tears of the Kingdom", joc.getNom());
        assertEquals("Nintendo Switch", joc.getPlataforma().getNom());
        assertEquals(70, joc.getPreu());
        assertEquals(nintendo, joc.getDesenvolupadora());
        assertTrue(joc.isModeCooperatiu());
        assertEquals(1, nintendo.getJocsDesenvolupats().size());
        assertTrue(nintendo.getJocsDesenvolupats().contains(joc));
        System.out.println("testVideojocAventura esta be");

    }

    // ---------- TESTS DE DESENVOLUPADORA ----------

    @Test
    public void testDesenvolupadora() {
        Desenvolupadora ubisoft = new Desenvolupadora("Ubisoft", "França");
        Plataforma plataforma = new Plataforma("PC");

        assertEquals("Ubisoft", ubisoft.getNom());
        assertEquals("França", ubisoft.getPais());
        assertTrue(ubisoft.getJocsDesenvolupats().isEmpty());

        Videojoc joc = new Videojoc("Assassin's Creed", plataforma, 45, ubisoft);
        assertEquals(1, ubisoft.getJocsDesenvolupats().size());
        assertTrue(ubisoft.getJocsDesenvolupats().contains(joc));

        
        Exception exception = assertThrows(IllegalArgumentException.class,() ->  new Desenvolupadora(null, "Espanya"));
        Exception exception1 = assertThrows(IllegalArgumentException.class,() ->  new Desenvolupadora("Molt be", null));
        Exception exception2 = assertThrows(IllegalArgumentException.class,() ->  new Desenvolupadora("", "Espanya"));
        Exception exception3 = assertThrows(IllegalArgumentException.class,() ->  new Desenvolupadora("A", ""));


        assertEquals("El nom de la desenvolupadora no pot ser nul ni buit.", exception.getMessage());
        assertEquals("El pais de la desenvolupadora no pot ser nul ni buit.", exception1.getMessage());
        assertEquals("El nom de la desenvolupadora no pot ser nul ni buit.", exception2.getMessage());
        assertEquals("El pais de la desenvolupadora no pot ser nul ni buit.", exception3.getMessage());
        System.out.println("testDesenvolupadora esta be");

    }

    // ---------- TEST DE TOSTRING ----------

    @Test
    public void testToString() {
        Plataforma plataforma = new Plataforma("PC");

        Desenvolupadora fromSoftware = new Desenvolupadora("FromSoftware", "Japó");
        Videojoc joc = new Videojoc("Elden Ring", plataforma, 60, fromSoftware);

        String resultat = joc.toString();
        assertNotNull(resultat);
        assertTrue(resultat.contains("Elden Ring"));
        assertTrue(resultat.contains("PC"));
        assertTrue(resultat.contains("60"));
        assertTrue(resultat.contains("FromSoftware"));

        String resultatDev = fromSoftware.toString();
        assertTrue(resultatDev.contains("FromSoftware"));
        assertTrue(resultatDev.contains("Japó"));

        System.out.println("testToString esta be");

    }

    // ---------- TEST DE CALCULADORA ----------

    @Test
    public void testCalculadora() {
        Calculadora calc = new Calculadora();

        assertEquals(5, calc.suma(2, 3));
        assertEquals(0, calc.suma(2, -2));
        assertEquals(-5, calc.suma(-2, -3));

        assertEquals(1, calc.restar(4, 3));
        assertEquals(12, calc.multiplicar(4, 3));
        assertEquals(4, calc.divisio(12, 3));
        Exception exception = assertThrows(ArithmeticException.class,() ->  calc.divisio(2, 0));
        assertEquals("No es pot dividir entre 0.", exception.getMessage());

        System.out.println("testCalculadora esta be");

    }

    // ---------- TESTS DE USUARI ----------

    @Test
    public void testUsuariCreacioIAtributs() {
        Usuari usuari = new Usuari("David", "dbargadosgomez.cf@iesesteveterradas.cat");





        assertEquals("David", usuari.getNomUsuari());
        assertEquals("dbargadosgomez.cf@iesesteveterradas.cat", usuari.getEmail());
        assertNotNull(usuari.getFavorits());
        assertNotNull(usuari.getValoracionsFetes());
        assertTrue(usuari.getFavorits().isEmpty());
        assertTrue(usuari.getValoracionsFetes().isEmpty());



        Exception e = assertThrows(IllegalArgumentException.class, () -> new Usuari("David", null));
        assertEquals("El email no pot estar buit.", e.getMessage());

        // Plataforma buida
        Exception e1 = assertThrows(IllegalArgumentException.class, () -> new Usuari("David", " "));
        assertEquals("El email no pot estar buit.", e1.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> new Usuari(null, "David"));
        assertEquals("El nom d'usuari no pot estar buit.", e2.getMessage());

        Exception e3 = assertThrows(IllegalArgumentException.class, () -> new Usuari(" ", "David"));
        assertEquals("El nom d'usuari no pot estar buit.", e3.getMessage());

        System.out.println("testUsuariCreacioIAtributs esta be");
    }

    @Test
    public void TestFavorits() {
        Plataforma plataforma = new Plataforma("PC");
        Desenvolupadora dev = new Desenvolupadora("The Game Kitchen", "Espanya");
        Videojoc joc = new Videojoc("Blasphemous", plataforma, 24.99, dev);
        Usuari usuari = new Usuari("HobbyConsolas", "HobbyConsolas@gmail.com");

        usuari.afegirFavorit(joc);
        assertEquals(1, usuari.getFavorits().size());
        assertTrue(usuari.getFavorits().contains(joc));
        usuari.afegirFavorit(joc);
        assertEquals(1, usuari.getFavorits().size(), "El joc no s'hauria d'afegir dues vegades");

        usuari.treureFavorit(joc);
        assertTrue(usuari.getFavorits().isEmpty());
        System.out.println("TestFavorits esta be");
    }

    @Test
    public void testFerValoracio() {
        Desenvolupadora dev = new Desenvolupadora("Team Cherry", "Australia");
        Plataforma pc = new Plataforma("PC");
        Videojoc joc = new Videojoc("Hollow Knight", pc, 15, dev);
        Usuari usuari = new Usuari("Vandal", "Vandal@vandal.com");

        usuari.ferValoracio(joc, "Molt entretingut!", 9);

        assertEquals(1, joc.getValoracions().size(), "Hauria d’haver una valoració al joc");
        assertEquals(1, usuari.getValoracionsFetes().size(), "Hauria d’haver una valoració feta per l’usuari");

        Valoracio val = joc.getValoracions().get(0);
        assertEquals("Vandal", val.getUsuari());
        assertEquals("Molt entretingut!", val.getComentari());
        assertEquals(9, val.getPuntuacio());

        usuari.ferValoracio(joc, "Molt entretingut!", 9);

        assertEquals(1, joc.getValoracions().size(), "No s’hauria d’afegir una segona valoració del mateix usuari");
        assertEquals(1, usuari.getValoracionsFetes().size(), "L’usuari no hauria de tenir més d’una valoració per joc");

        System.out.println("testFerValoracio està bé");
    }

    @Test
    public void testValoracioError() {
        Desenvolupadora dev = new Desenvolupadora("Team Cherry", "Australia");
        Plataforma pc = new Plataforma("PC");
        Videojoc joc = new Videojoc("Hollow Knight", pc, 15, dev);
        Usuari usuari = new Usuari("Vandal", "Vandal@vandal.com");

        Exception e = assertThrows(IllegalArgumentException.class, () -> new Valoracio("David", "Molt be", -1));
        assertEquals("La puntuació ha d'estar entre 0 i 10.", e.getMessage());

        Exception e1 = assertThrows(IllegalArgumentException.class, () -> new Valoracio("David", "Molt be", 11));
        assertEquals("La puntuació ha d'estar entre 0 i 10.", e1.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> new Valoracio("David", "", 10));
        assertEquals("El comentari no pot estar buit.", e2.getMessage());

        Exception e3 = assertThrows(IllegalArgumentException.class, () -> new Valoracio("David", null, 10));
        assertEquals("El comentari no pot estar buit.", e3.getMessage());

        Exception e4 = assertThrows(IllegalArgumentException.class, () -> new Valoracio("", "Molt be", 10));
        assertEquals("El nom d'usuari no pot estar buit.", e4.getMessage());

        Exception e5 = assertThrows(IllegalArgumentException.class, () -> new Valoracio(null, "Molt be", 10));
        assertEquals("El nom d'usuari no pot estar buit.", e5.getMessage());

        System.out.println("testValoracioError està bé");
    }


    // ---------- TEST DE VALORACIÓ ----------

    @Test
    public void testValoracioToString() {
        Valoracio val = new Valoracio("Tester", "Molt bon joc", 9);
        String result = val.toString();

        assertTrue(result.contains("Tester"));
        assertTrue(result.contains("Molt bon joc"));
        assertTrue(result.contains("9"));
        System.out.println("testValoracioToString esta be");

    }
}
