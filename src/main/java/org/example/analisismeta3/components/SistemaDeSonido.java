package org.example.analisismeta3.components;

import org.example.analisismeta3.eventbus.EventBus;
import org.example.analisismeta3.events.BandaTocandoEvent;

public class SistemaDeSonido {
    public SistemaDeSonido(EventBus eventBus) {
        eventBus.suscribir(BandaTocandoEvent.class, this::onBandaTocando);
    }

    private void onBandaTocando(BandaTocandoEvent event) {
        System.out.println("[SISTEMA DE SONIDO] Ajustando ecualizador para: " + event.getNombreCancion());
    }
}