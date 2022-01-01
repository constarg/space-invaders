package com.game.space_invaders.event.events;

import com.game.space_invaders.entities.bullet.Bullet;
import com.game.space_invaders.entities.invaders.Invader;


public interface GameEvent {
    void emit(Invader invader, Bullet bullet);
}
