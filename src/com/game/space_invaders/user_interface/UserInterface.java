package com.game.space_invaders.user_interface;

import com.game.space_invaders.costants.DimensionConstants;
import com.game.space_invaders.costants.GameColors;
import com.game.space_invaders.entities.gun.Gun;
import com.game.space_invaders.utils.KeyBoard;
import javafx.scene.Group;
import javafx.scene.Scene;

public class UserInterface {
    private static Scene scene;

    public static Scene configureScene(Group group, Gun gun) {
        UserInterface.scene = new Scene(
                group,
                DimensionConstants.MAIN_WINDOW_DIMENSION.getEntityDimension().getWidth(),
                DimensionConstants.MAIN_WINDOW_DIMENSION.getEntityDimension().getHeight()
        );
        scene.setFill(GameColors.BACKGROUND_COLOR.getColor());
        scene.setOnKeyPressed(KeyBoard.moveGun(gun));

        return UserInterface.scene;
    }
}
