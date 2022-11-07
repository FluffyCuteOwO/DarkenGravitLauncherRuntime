package pro.gravit.launcher.client.gui.scenes.login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import pro.gravit.launcher.client.gui.JavaFXApplication;

import java.net.URL;

public class LoginVBoxAuthButtonComponent {
    private final JavaFXApplication application;
    private final Pane layout;
    private final Pane authUnActive;
    private final Pane authActive;
    //private final SVGPath authBorder;
    private final Button button;
    private boolean isDisabled;

    public LoginVBoxAuthButtonComponent(String name, String displayName, JavaFXApplication application) {
        Pane block = new Pane();
        block.setId("authButtonBlock");

        Pane authUnactive = new Pane();
        authUnactive.setId("authUnactive");
        authUnactive.setMaxSize(282.0, 44.0);
        authUnactive.setMinSize(282.0, 44.0);
        authUnactive.setPrefSize(282.0, 44.0);

        Pane authActive = new Pane();
        authActive.setId("authActive");
        authActive.getStyleClass().add("authActive");
        authActive.setMaxSize(282.0, 44.0);
        authActive.setMinSize(282.0, 44.0);
        authActive.setPrefSize(282.0, 44.0);

        Button authButton = new Button();
        authButton.setId("authButton");
        authButton.setAlignment(Pos.CENTER);
        authButton.setCacheShape(false);
        authButton.setCancelButton(true);
        authButton.setCenterShape(false);
        authButton.setContentDisplay(ContentDisplay.CENTER);
        authButton.setDefaultButton(true);
        authButton.setGraphicTextGap(0.0);
        authButton.setMaxSize(282.0, 44.0);
        authButton.setMinSize(282.0, 44.0);
        authButton.setPrefSize(282.0, 44.0);
        authButton.setScaleShape(false);
        authButton.setSnapToPixel(false);
        authButton.getStyleClass().add("wow");

        Pane paneButtonAuth = new Pane();
        paneButtonAuth.setMaxSize(282.0, 44.0);
        paneButtonAuth.setMinSize(282.0, 44.0);
        paneButtonAuth.setPrefSize(282.0, 44.0);
        paneButtonAuth.setId("panebuttonauth");

        Pane logoButton = new Pane();
        logoButton.setLayoutX(14.0);
        logoButton.setLayoutY(13.0);
        logoButton.setPrefSize(18.0, 18.0);
        logoButton.setId("logobutton");
        URL image = application.tryResource("images/buttonicons/" + name + ".png");
        if(image != null) logoButton.setStyle("-fx-background-image: url(" + image + ");");

        Label authButtonText = new Label(displayName);
        authButtonText.setLayoutX(43.0);
        authButtonText.setLayoutY(13.0);
        authButtonText.setId("authbuttontext");

        paneButtonAuth.getChildren().add(logoButton);
        paneButtonAuth.getChildren().add(authButtonText);
        authButton.setGraphic(paneButtonAuth);
        authActive.getChildren().add(authButton);
        block.getChildren().add(authUnactive);
        block.getChildren().add(authActive);
        this.application = application;
        this.layout = block;
        this.authUnActive = authUnactive;
        this.authActive = authActive;
        this.button = authButton;
    }

    public void setOnAction(EventHandler<ActionEvent> eventHandler) {
        this.button.setOnAction(eventHandler);
    }

    public void setActive(boolean value) {
        authUnActive.setVisible(true);
        authActive.setVisible(true);
    }

    public void fire() {
        button.fire();
    }

    public void disable() {
        isDisabled = true;
        this.button.setDisable(true);
    }

    public void enable() {
        isDisabled = false;
        this.button.setDisable(false);
    }

    public Pane getLayout() {
        return layout;
    }

    public String getText() {
        return button.getText();
    }

    public void setText(String text) {
        button.setText(text);
    }

    public void unsetError() {
    }

    public void setError() {
    }
}