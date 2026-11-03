module org.example.analisismeta3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens org.example.analisismeta3 to javafx.fxml;
    exports org.example.analisismeta3;
    exports org.example.analisismeta3.events;
    opens org.example.analisismeta3.events to javafx.fxml;
    exports org.example.analisismeta3.eventbus;
    opens org.example.analisismeta3.eventbus to javafx.fxml;
    exports org.example.analisismeta3.components;
    opens org.example.analisismeta3.components to javafx.fxml;
}