# Persist Key Press Events in an Influx DB

This simple [Quarkus](https://quarkus.io) application registers a keyboard hook using
the [system-hook library by kristian](https://github.com/kristian/system-hook). Every key press is recorded as an Influx
Data Point with a timestamp, key action (press/release), the virtual key code and a host identifier. The application can
utilize the GraalVM native image technology for a standalone executable with a very small footprint.

## Configuration

The application can be configured with
the [Quarkus configuration mechanism](https://quarkus.io/guides/config-reference). The following custom properties can
be used to configure the application:

| Name                                   | Description                                                                                | Default Value |
|----------------------------------------|--------------------------------------------------------------------------------------------|---------------|
| `influx.connection.url`                | The connection URL of the InfluxDB server (e.g. http://localhost:8086).                    |               |
| `influx.connection.token`              | The access token of the influxDB server.                                                   |               |
| `influx.connection.bucket`             | The name of the bucket the data should be written to.                                      |               |
| `influx.connection.org`                | The name of the organization.                                                              |               |
| `influx.connection.enable-compression` | Use gzip compression to compress the data.                                                 | true          |
| `influx.point.measurement-name`        | The name of the measurement the data points belong to.                                     | key_event     |
| `influx.point.host-identifier`         | An identifier to separate different hosts. Used as the value of the `host-identifier` tag. | local         |
| `listener.ignore-releases`             | Ignore key releases.                                                                       | true          |
