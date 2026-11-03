package org.example.analisismeta3.components;

import org.example.analisismeta3.eventbus.EventBus;
import org.example.analisismeta3.events.ComidaPreparadaEvent;
import org.example.analisismeta3.events.PedidoRealizadoEvent;

public class Cocina {
    private final EventBus eventBus;

    public Cocina(EventBus eventBus) {
        this.eventBus = eventBus;
        this.eventBus.suscribir(PedidoRealizadoEvent.class, this::onPedidoRealizado);
    }

    private void onPedidoRealizado(PedidoRealizadoEvent event) {
        for (String item : event.getItems()) {
            if (esComida(item)) {
                new Thread(() -> {
                    try {
                        Thread.sleep(5000); // Simula 5 segundos de cocina
                        System.out.println("[COCINA] Plato '" + item + "' cocinado.");
                        eventBus.publicar(new ComidaPreparadaEvent(event.getPedidoId(), item));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            }
        }
    }

    private boolean esComida(String item) {
        String lower = item.toLowerCase();
        return lower.contains("hamburguesa") || lower.contains("papas") || lower.contains("pizza");
    }
}