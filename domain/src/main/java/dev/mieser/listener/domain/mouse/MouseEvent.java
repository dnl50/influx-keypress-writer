package dev.mieser.listener.domain.mouse;

import dev.mieser.listener.domain.KeyTransition;

import java.time.ZonedDateTime;

public record MouseEvent(MouseButton button, KeyTransition transition, ZonedDateTime timestamp) {
}
