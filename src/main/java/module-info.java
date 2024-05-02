module luke.strazzera.strazzeracsc211dogdoor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens luke.strazzera.strazzeracsc211dogdoor to javafx.fxml;
    exports luke.strazzera.strazzeracsc211dogdoor;
}