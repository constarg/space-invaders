package com.game.space_invaders.event.events;

import com.game.space_invaders.entities.bullet.Bullet;
import com.game.space_invaders.entities.invaders.Invader;
import java.util.HashSet;

public interface GameEvent {
    void emit(HashSet<Invader> invaders, Invader invader, Bullet bullet);
}
