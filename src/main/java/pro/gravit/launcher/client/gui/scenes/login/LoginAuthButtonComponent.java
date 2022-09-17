package pro.gravit.launcher.client.gui.scenes.login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import pro.gravit.launcher.client.gui.JavaFXApplication;
import pro.gravit.launcher.client.gui.helper.LookupHelper;

public class LoginAuthButtonComponent {
    private final JavaFXApplication application;
    private final Pane layout;
    private final Pane authUnActive;
    private final Pane authActive;
    //private final SVGPath authBorder;
    private final Button button;
    private boolean isDisabled;

    public LoginAuthButtonComponent(Pane authButton, JavaFXApplication application, EventHandler<ActionEvent> eventHandler) {
        this.application = application;
        this.layout = authButton;
        this.authUnActive = LookupHelper.lookup(layout, "#authUnactive");
        this.authActive = LookupHelper.lookup(layout, "#authActive");
        this.button = LookupHelper.lookup(authActive, "#authButton");
        this.button.setOnAction(eventHandler);
    }

    public void setActive(boolean value) {
        authUnActive.setVisible(true);
        authActive.setVisible(true);
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