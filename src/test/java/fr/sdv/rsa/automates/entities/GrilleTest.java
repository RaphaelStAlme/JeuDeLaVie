package fr.sdv.rsa.automates.entities;

import fr.sdv.rsa.automates.exception.NegativeNumberException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class GrilleTest {

    private static int MAX_LIGNES = 4;
    private static int MAX_COLONNES = 4;
    private Grille grille;

    @BeforeEach
    void setUp() {
        grille = new Grille(MAX_LIGNES,MAX_COLONNES);
    }

    @AfterEach
    void tearDown() {
        grille = null;
    }

    @Test
    void afficher() {
    }

    @Test
    void grilleShouldBeMaxL() {
        assertEquals(MAX_LIGNES, grille.getGrille().length);
    }

    @Test
    void grilleShouldBeMaxC() {
        assertEquals(MAX_COLONNES, grille.getGrille()[0].length);
    }

    @Test
    void evoluer_grilleShouldEvolved() throws NegativeNumberException{
        var grilleIsEvolved = false;

        grille.afficher();
        grille.evoluer();
        grille.afficher();
        var previousGrille = grille.getPreviousGrille();
        var actualGrille = grille.getGrille();

        assertFalse(Arrays.deepEquals(previousGrille, actualGrille));
    }

}