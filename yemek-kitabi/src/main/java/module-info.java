module com.yazlab.yazlab {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;
    
    opens com.yazlab to javafx.fxml;
    exports com.yazlab;
}