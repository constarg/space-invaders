package com.game.space_invaders.utils;

import com.game.space_invaders.entities.bullet.Bullet;
import com.game.space_invaders.entities.gun.Gun;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;

public class KeyBoard {
    public static EventHandler<KeyEvent> moveGun(Gun gun, Group group) {
        return keyEvent -> {
            switch (keyEvent.getCode()) {
                case LEFT -> gun.moveGunLeft();
                case RIGHT -> gun.moveGunRight();
                case SPACE -> GameRefresh.gunFiresBullet(gun, group);
            }
        };
    }
}
