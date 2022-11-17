package fr.sdv.rsa.automates.entities;

import fr.sdv.rsa.automates.enums.EtatCellule;
import fr.sdv.rsa.automates.exception.NegativeNumberException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CelluleTest {
    private Cellule cellule;

    @BeforeEach
    void setUp() {
        cellule = new Cellule();
    }

    @AfterEach
    void tearDown() {
        cellule = null;
    }

    @Test
    void evoluer_with1CellulesVoisines() throws NegativeNumberException {
        cellule.evoluer(1);
        assertEquals(EtatCellule.inactive,cellule.getEtat());
    }

    @Test
    void evoluer_with2CellulesVoisines() throws NegativeNumberException {
        var initialEtatCellule = cellule.getEtat();
        cellule.evoluer(2);
        assertEquals(initialEtatCellule ,cellule.getEtat());
    }

    @Test
    void evoluer_with3CellulesVoisines() throws NegativeNumberException {
        cellule.evoluer(3);
        assertEquals(EtatCellule.active,cellule.getEtat());

    }

    @Test
    void evoluer_with4CellulesVoisines() throws NegativeNumberException {
        cellule.evoluer(4);
        assertEquals(EtatCellule.inactive,cellule.getEtat());

    }

    @Test
    void evoluer_withMoreThan4CellulesVoisines() throws NegativeNumberException {
        cellule.evoluer(5);
        assertEquals(EtatCellule.inactive,cellule.getEtat());
    }

    @Test
    void evoluer_withNegativeParameters() {
        assertThrows(NegativeNumberException.class, () -> {
            cellule.evoluer(-1);
        });
    }

    @Test
    void generateRandomCelluleEtat() {
        var etatCelluleGenerated = cellule.generateRandomCelluleEtat();
        assertNotNull(etatCelluleGenerated);

    }

    @Test
    void getEtat() {
        var etatCellule = cellule.getEtat();
        assertNotNull(etatCellule);
    }
}