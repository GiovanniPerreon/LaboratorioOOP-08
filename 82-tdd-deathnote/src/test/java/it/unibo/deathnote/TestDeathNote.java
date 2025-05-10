package it.unibo.deathnote;

import org.junit.jupiter.api.Test;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImplementation;

class TestDeathNote {

    private DeathNote dNote = new DeathNoteImplementation();
    //private static final long millis = 1;

    @Test
    public void RuleTest() {
        dNote.getRule(1);
        // dNote.getRule(0);
        // dNote.getRule(-1);
    }

    @Test
    public void NameTest() {
        dNote.writeName("DH");
        dNote.isNameWritten("DH");
    }

}