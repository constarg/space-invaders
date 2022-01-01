package com.game.space_invaders;

import com.game.space_invaders.costants.Messages;
import com.game.space_invaders.entities.gun.Gun;
import com.game.space_invaders.user_interface.UserInterface;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpaceInvaders extends Application {
    private Scene scene;
    private Group root;
    private Gun gun;

    private void initializeComponents() throws IOException {
        this.gun = new Gun();
        this.root = new Group();
    }

    private void configureUserInterface() {
        this.scene = UserInterface.configureScene(root, null);
    }

    private void configureStage(Stage stage) {
        stage.setTitle(Messages.GAME_TITLE.getMessage());
        stage.setScene(this.scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
        initializeComponents();
        configureUserInterface();
        configureStage(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
