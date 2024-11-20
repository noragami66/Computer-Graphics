module com.cgvsu.rasterizationfxapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ru.vsu.cs.kodintsev to javafx.fxml;
    exports ru.vsu.cs.kodintsev;
}