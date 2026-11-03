package org.example.analisismeta3.components;

import org.example.analisismeta3.eventbus.EventBus;
import org.example.analisismeta3.events.BebidaServidaEvent;
import org.example.analisismeta3.events.PedidoRealizadoEvent;

public class Barra {
    private final EventBus eventBus;

    public Barra(EventBus eventBus) {
        this.eventBus = eventBus;
        this.eventBus.suscribir(PedidoRealizadoEvent.class, this::onPedidoRealizado);
    }

    private void onPedidoRealizado(PedidoRealizadoEvent event) {
        for (String item : event.getItems()) {
            if (esBebida(item)) {
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // Simula 2 segundos de preparación
                        System.out.println("[BARRA] Bebida '" + item + "' lista.");
                        eventBus.publicar(new BebidaServidaEvent(event.getMesaId(), item));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            }
        }
    }

    private boolean esBebida(String item) {
        String lower = item.toLowerCase();
        return lower.contains("cerveza") || lower.contains("vino") || lower.contains("agua") || lower.contains("hidromiel");
    }
}