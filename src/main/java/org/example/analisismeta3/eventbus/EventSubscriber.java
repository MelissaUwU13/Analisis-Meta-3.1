package org.example.analisismeta3.eventbus;

@FunctionalInterface
public interface EventSubscriber<T> {
    void onEvent(T event);
}