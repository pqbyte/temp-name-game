package com.pqbyte.coherence;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import static com.badlogic.gdx.Input.Keys.*;

public class PlayerControlListener extends InputListener {
  private Player player;

  public PlayerControlListener(Player player) {
    this.player = player;
  }

  @Override
  public boolean keyDown(InputEvent event, int keycode) {

    switch (keycode) {
      case LEFT:
        player.setGoingLeft(true);
        break;
      case RIGHT:
        player.setGoingRight(true);
        break;
      case UP:
        player.setGoingUp(true);
        break;
      case DOWN:
        player.setGoingDown(true);
        break;
    }

    return false;
  }

  @Override
  public boolean keyUp(InputEvent event, int keycode) {

    switch (keycode) {
      case LEFT:
        player.setGoingLeft(false);
        break;
      case RIGHT:
        player.setGoingRight(false);
        break;
      case UP:
        player.setGoingUp(false);
        break;
      case DOWN:
        player.setGoingDown(false);
        break;
    }

    return false;
  }
}