package dev.mieser.listener.domain;

public record KeyInfo(int virtualKeyCode, char keyChar, boolean menuPressed, boolean shiftPressed,
                      boolean controlPressed, boolean winPressed, boolean extendedKey) {

}
