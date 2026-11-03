package org.example.analisismeta3;

@FunctionalInterface
public interface EventSubscriber<T> {
    void onEvent(T event);
}