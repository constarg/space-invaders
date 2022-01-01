package com.game.space_invaders.event.impl;

import com.game.space_invaders.entities.bullet.Bullet;
import com.game.space_invaders.entities.invaders.Invader;
import com.game.space_invaders.event.events.GameEvent;

import java.util.HashSet;

public class InvaderKilledEvent implements GameEvent {
    public InvaderKilledEvent() {}

    @Override
    public void emit(HashSet<Invader> invaders, Invader invader,
                     Bullet bullet) {

        if (invaders.isEmpty()) return;
        invaders.remove(invader);

        bullet.getBulletShape().setVisible(false);
    }
}
