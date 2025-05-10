package it.unibo.deathnote.impl;

import java.util.HashMap;

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImplementation implements DeathNote{

    private static final String DEFAULT_DEATH_CAUSE = "Heart Attack";
    private static final byte CAUSE_TIMER = 40;
    private static final short DETAIL_TIMER = 6000 + CAUSE_TIMER;
    private HashMap<String, DeathCause> deathMap = new HashMap<>();
    private String currentName;

    @Override
    public String getRule(int ruleNumber) {
        if(ruleNumber < 1 || ruleNumber > RULES.size()) {
            throw new IllegalArgumentException("Number Invalid");
        }
        return RULES.get(ruleNumber);
    }

    @Override
    public void writeName(String name) {
        if(name == null) {
            throw new NullPointerException("Name is null");
        }
        currentName = name;
        deathMap.put(name, new DeathCause());
    }

    @Override
    public boolean writeDeathCause(String cause) {
        if(currentName != null || cause != null) {
            if(System.currentTimeMillis() - deathMap.get(currentName).getTimeOfDeath() < CAUSE_TIMER) {
                deathMap.get(currentName).setCause(cause);
                return true;
            } else {
                deathMap.get(currentName).setCause(DEFAULT_DEATH_CAUSE);
                return false;
            }
        }
        throw new IllegalStateException("Name or Cause is null");
    }

    @Override
    public boolean writeDetails(String details) {
        if(currentName != null) {
            if(System.currentTimeMillis() - deathMap.get(currentName).getTimeOfDeath() < DETAIL_TIMER) {
                deathMap.get(currentName).setDetails(details);
                return true;
            } else {
                return false;
            }
        }
        throw new IllegalStateException("Name or Details is null");
    }

    @Override
    public String getDeathCause(String name) {
        if(isNameWritten(name)) {
            return deathMap.get(name).getCause();
        }
        throw new IllegalArgumentException("Name not in death note");
    }

    @Override
    public String getDeathDetails(String name) {
        if(isNameWritten(name)) {
            return deathMap.get(name).getDetails();
        }
        throw new IllegalArgumentException("Name not in death note");
    }

    @Override
    public boolean isNameWritten(String name) {
        if(deathMap.containsKey(name)) {
            return true;
        } else {
            return false;
        }
    }


}