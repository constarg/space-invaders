package com.game.space_invaders.event.impl;

import com.game.space_invaders.entities.bullet.Bullet;
import com.game.space_invaders.entities.invaders.Invader;
import com.game.space_invaders.event.events.GameEvent;

import java.util.ArrayList;
import java.util.HashSet;

public class InvaderKilledEvent implements GameEvent {
    public InvaderKilledEvent() {}

    @Override
    public void emit(Invader invader, Bullet bullet) {
        invader.setIsKilled(true);
        bullet.setIsHit(true);
        bullet.getBulletShape().setVisible(false);
    }
}
