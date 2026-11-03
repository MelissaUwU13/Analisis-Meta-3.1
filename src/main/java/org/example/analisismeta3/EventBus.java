package org.example.analisismeta3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {
    private final Map<Class<?>, List<EventSubscriber<?>>> subscribers = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> void suscribir(Class<T> eventType, EventSubscriber<T> subscriber) {
        subscribers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(subscriber);
    }

    public <T> void desuscribir(Class<T> eventType, EventSubscriber<T> subscriber) {
        List<EventSubscriber<?>> eventSubscribers = subscribers.get(eventType);
        if (eventSubscribers != null) {
            eventSubscribers.remove(subscriber);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> void publicar(T event) {
        List<EventSubscriber<?>> eventSubscribers = subscribers.get(event.getClass());
        if (eventSubscribers != null) {
            for (EventSubscriber<?> subscriber : new ArrayList<>(eventSubscribers)) {
                ((EventSubscriber<T>) subscriber).onEvent(event);
            }
        }
    }
}