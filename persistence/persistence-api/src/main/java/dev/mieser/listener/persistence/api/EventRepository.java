package dev.mieser.listener.persistence.api;

import dev.mieser.listener.domain.keyboard.KeyEvent;
import dev.mieser.listener.domain.mouse.MouseEvent;

public interface EventRepository {

    void save(KeyEvent event);

    void save(MouseEvent event);

}
