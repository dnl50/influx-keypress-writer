package dev.mieser.heatmap.domain;

import java.util.Optional;

public record KeyInfo(int virtualKeyCode, char keyChar, boolean menuPressed, boolean shiftPressed,
                      boolean controlPressed, boolean winPressed, boolean extendedKey) {

}
