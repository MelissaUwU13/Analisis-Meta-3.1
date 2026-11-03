package org.example.analisismeta3;

import org.example.analisismeta3.components.*;
import org.example.analisismeta3.eventbus.EventBus;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 1. Inicializar el EventBus
        EventBus eventBus = new EventBus();

        // 2. Inicializar Suscriptores / Publicadores
        SistemasDePedidos sistemaPedidos = new SistemasDePedidos(eventBus);
        Barra barra = new Barra(eventBus);
        Cocina cocina = new Cocina(eventBus);
        SistemaDeSonido sonido = new SistemaDeSonido(eventBus);
        PanelLED panelLED = new PanelLED(eventBus);

        // 3. Demostración de Extensibilidad:
        // Añadimos el SistemaDeHumo SIN modificar el EventBus ni la Banda.
        SistemaDeHumo sistemaHumo = new SistemaDeHumo(eventBus);

        Banda banda = new Banda(eventBus, "Los Seguidores de Dijkstra");

        System.out.println("--- SIMULACIÓN TABERNA 'EL GÓLEM ALQUÍMICO' ---\n");

        // Flujo 1: Pedido
        sistemaPedidos.realizarPedido("Mesa 5", "pedido_123", Arrays.asList("Cerveza", "Hamburguesa"));

        // Flujo 2: Música
        Thread.sleep(1000);
        banda.tocarCancion("El Algoritmo del Amor", 180);

        Thread.sleep(1000);
        // Canción que activa el SistemaDeHumo
        banda.tocarCancion("Through the Fire and Flames", 300);

        // Espera para dar tiempo a los hilos de Cocina y Barra de finalizar
        Thread.sleep(6000);
    }
}