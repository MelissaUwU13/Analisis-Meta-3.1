package org.example.analisismeta3.components;

import org.example.analisismeta3.eventbus.EventBus;
import org.example.analisismeta3.events.BandaTocandoEvent;

public class SistemaDeHumo {
    public SistemaDeHumo(EventBus eventBus) {
        eventBus.suscribir(BandaTocandoEvent.class, this::onBandaTocando);
    }

    private void onBandaTocando(BandaTocandoEvent event) {
        if ("Through the Fire and Flames".equalsIgnoreCase(event.getNombreCancion())) {
            System.out.println("\u001B[31m[SISTEMA DE HUMO] ¡¡¡DISPARANDO EFECTOS DE HUMO Y FUEGO!!!\u001B[0m");
        }
    }
}