package dev.mieser.listener.app;


import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class ListenerApplication {

    public static void main(String[] args) {
        Quarkus.run(args);
    }

}
