module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; // Required for JDBC (e.g., java.sql.Connection, ResultSet)
    requires transitive java.sql;
river

    opens com.example to javafx.fxml;
    exports com.example;
}
