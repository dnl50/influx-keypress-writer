package dev.mieser.heatmap.persistence.impl;

import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import dev.mieser.heatmap.domain.KeyEvent;
import dev.mieser.heatmap.persistence.api.KeyEventRepository;
import dev.mieser.heatmap.persistence.config.InfluxProperties;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = {@Inject})
public class KeyEventRepositoryImpl implements KeyEventRepository {

    private final WriteApi writer;

    private final InfluxProperties properties;

    @Override
    public void save(KeyEvent event) {
        var point = Point.measurement(properties.point().name())
                .addTag(InfluxConstants.TYPE_TAG, event.type().name())
                .addTag(InfluxConstants.HOST_IDENTIFIER_TAG, properties.point().hostIdentifier())
                .addField(InfluxConstants.CODE_FIELD, event.keyInfo().virtualKeyCode())
                .time(event.timestamp().toInstant(), WritePrecision.NS);

        writer.writePoint(point);
    }

}
