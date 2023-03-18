package dev.mieser.listener.domain.keyboard;

public record KeyInfo(int virtualKeyCode, char keyChar, boolean menuPressed, boolean shiftPressed,
                      boolean controlPressed, boolean winPressed, boolean extendedKey) {

}
