package dev.mieser.heatmap.domain;

import java.time.ZonedDateTime;

public record KeyEvent(KeyInfo keyInfo, KeyEventType type, ZonedDateTime timestamp) {

}
