package org.example.analisismeta3.events;

public class BebidaServidaEvent implements Evento {
    private final String mesaId;
    private final String bebida;

    public BebidaServidaEvent(String mesaId, String bebida) {
        this.mesaId = mesaId;
        this.bebida = bebida;
    }

    public String getMesaId() { return mesaId; }
    public String getBebida() { return bebida; }
}