package org.example.analisismeta3.components;

import org.example.analisismeta3.eventbus.EventBus;
import org.example.analisismeta3.events.BandaTocandoEvent;

public class Banda {
    private final EventBus eventBus;
    private final String nombreBanda;

    public Banda(EventBus eventBus, String nombreBanda) {
        this.eventBus = eventBus;
        this.nombreBanda = nombreBanda;
    }

    public void tocarCancion(String nombreCancion, int duracionSegundos) {
        System.out.println("[BANDA " + nombreBanda + "] Empieza a tocar: " + nombreCancion);
        eventBus.publicar(new BandaTocandoEvent(nombreBanda, nombreCancion, duracionSegundos));
    }
}