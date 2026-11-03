package org.example.analisismeta3;

import java.util.Collections;
import java.util.List;

public class PedidoRealizadoEvent implements Evento {
    private final String mesaId;
    private final String pedidoId;
    private final List<String> items;

    public PedidoRealizadoEvent(String mesaId, String pedidoId, List<String> items) {
        this.mesaId = mesaId;
        this.pedidoId = pedidoId;
        this.items = Collections.unmodifiableList(items);
    }

    public String getMesaId() { return mesaId; }
    public String getPedidoId() { return pedidoId; }
    public List<String> getItems() { return items; }
}