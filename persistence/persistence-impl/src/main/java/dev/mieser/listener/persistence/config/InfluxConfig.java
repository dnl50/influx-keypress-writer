package dev.mieser.listener.persistence.config;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

@Slf4j
@Dependent
class InfluxConfig {

    @Produces
    @ApplicationScoped
    InfluxDBClient influxClient(InfluxProperties influxProperties) {
        var connectionProperties = influxProperties.connection();

        var client = InfluxDBClientFactory.create(
                connectionProperties.url(),
                connectionProperties.token().toCharArray(),
                connectionProperties.org(),
                connectionProperties.bucket()
        );

        if(connectionProperties.enableCompression()) {
            client.enableGzip();
        }

        return client;
    }

    @Produces
    @ApplicationScoped
    WriteApi influxWriter(InfluxDBClient client) {
        return client.makeWriteApi();
    }

    void closeClientAndWriter(@Disposes AutoCloseable closeable) {
        try {
            closeable.close();
            log.info("Influx resource closed successfully.");
        } catch (Exception e) {
            log.warn("Error while closing Influx resource", e);
        }
    }

}
