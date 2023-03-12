package dev.mieser.heatmap.persistence.api;

import dev.mieser.heatmap.domain.KeyEvent;

public interface KeyEventRepository {

    void save(KeyEvent event);

}
