package org.example.analisismeta3.components;

import org.example.analisismeta3.eventbus.EventBus;
import org.example.analisismeta3.events.PedidoRealizadoEvent;
import java.util.List;

public class SistemasDePedidos {
    private final EventBus eventBus;

    public SistemasDePedidos(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void realizarPedido(String mesaId, String pedidoId, List<String> items) {
        System.out.println("[SISTEMA DE PEDIDOS] Registrando pedido " + pedidoId + " para " + mesaId);
        eventBus.publicar(new PedidoRealizadoEvent(mesaId, pedidoId, items));
    }
}