package it.unibo.deathnote.impl;

public class DeathCause {

    private String cause;
    private String details;
    private long deathTime;

    public DeathCause() {
        this.cause = null;
        this.details = null;
        this.deathTime = System.currentTimeMillis();
    }
    public String getCause() {
        return this.cause;
    }
    public String getDetails() {
        return this.details;
    }
    public long getTimeOfDeath() {
        return this.deathTime;
    }
    void setCause(String cause) {
        if(this.cause == null) {
            this.cause = cause;
        }
    }
    void setDetails(String details) {
        if(this.details == null) {
            this.details = details;
        }
    }
    void setDeathTime(Long deathTime) {
        this.deathTime = deathTime;
    }
}
