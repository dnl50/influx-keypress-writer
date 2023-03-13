package dev.mieser.listener.persistence.api;

import dev.mieser.listener.domain.KeyEvent;

public interface KeyEventRepository {

    void save(KeyEvent event);

}
