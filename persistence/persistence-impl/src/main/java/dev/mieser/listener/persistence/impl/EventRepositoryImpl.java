package dev.mieser.listener.persistence.impl;

import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import dev.mieser.listener.domain.keyboard.KeyEvent;
import dev.mieser.listener.domain.mouse.MouseEvent;
import dev.mieser.listener.persistence.api.EventRepository;
import dev.mieser.listener.persistence.config.InfluxProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = {@Inject})
public class EventRepositoryImpl implements EventRepository {

    private final WriteApi writer;

    private final InfluxProperties properties;

    @Override
    public void save(KeyEvent event) {
        var point = Point.measurement(properties.measurement().keyboard())
                .addTag(InfluxConstants.TYPE_TAG, event.transition().name())
                .addTag(InfluxConstants.HOST_IDENTIFIER_TAG, properties.host().identifier())
                .addField(InfluxConstants.CODE_FIELD, event.keyInfo().virtualKeyCode())
                .time(event.timestamp().toInstant(), WritePrecision.NS);

        writer.writePoint(point);
    }

    @Override
    public void save(MouseEvent event) {
        var point = Point.measurement(properties.measurement().mouse())
                .addTag(InfluxConstants.TYPE_TAG, event.transition().name())
                .addTag(InfluxConstants.HOST_IDENTIFIER_TAG, properties.host().identifier())
                .addField(InfluxConstants.BUTTON_FIELD, event.button().name())
                .time(event.timestamp().toInstant(), WritePrecision.NS);

        writer.writePoint(point);
    }

}
