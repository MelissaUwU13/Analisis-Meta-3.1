package org.example.analisismeta3.components;

import org.example.analisismeta3.eventbus.EventBus;
import org.example.analisismeta3.events.BandaTocandoEvent;
import org.example.analisismeta3.events.BebidaServidaEvent;
import org.example.analisismeta3.events.ComidaPreparadaEvent;
import org.example.analisismeta3.events.PedidoRealizadoEvent;

public class PanelLED {
    public PanelLED(EventBus eventBus) {
        eventBus.suscribir(PedidoRealizadoEvent.class, e ->
                System.out.println("\u001B[33m[PANEL LED] Nuevo pedido en la " + e.getMesaId() + "\u001B[0m"));

        eventBus.suscribir(BebidaServidaEvent.class, e ->
                System.out.println("\u001B[36m[PANEL LED] ¡Nueva bebida (" + e.getBebida() + ") servida en la " + e.getMesaId() + "!\u001B[0m"));

        eventBus.suscribir(ComidaPreparadaEvent.class, e ->
                System.out.println("\u001B[32m[PANEL LED] Hamburguesa/Comida (" + e.getPlato() + ") lista para Pedido " + e.getPedidoId() + "\u001B[0m"));

        eventBus.suscribir(BandaTocandoEvent.class, e ->
                System.out.println("\u001B[35m[PANEL LED] " + e.getNombreBanda() + " - " + e.getNombreCancion() + "\u001B[0m"));
    }
}