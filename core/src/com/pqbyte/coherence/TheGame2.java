package com.pqbyte.coherence;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class TheGame2 extends ApplicationAdapter {
  private static final float VIEWPORT_WIDTH = 30;

  private Stage stage;
  private World world;

  @Override
  public void create() {
    world = new World(new Vector2(0, 0), true);

    Map map = new Map(
        new Texture(Gdx.files.internal("wallpaper.jpg")),
        Constants.WORLD_WIDTH,
        Constants.WORLD_HEIGHT,
        world
    );

    Player player = new Player(
        new Texture(Gdx.files.internal("cube128.png")),
        0,
        0,
        world
    );
    player.addListener(new MoveListener(player));

    float screenWidth = Gdx.graphics.getWidth();
    float screenHeight = Gdx.graphics.getHeight();

    stage = new Stage(new ExtendViewport(
        VIEWPORT_WIDTH, VIEWPORT_WIDTH * (screenHeight / screenWidth)));
    stage.addActor(map);
    stage.addActor(player);
    stage.setKeyboardFocus(player);

    Gdx.input.setInputProcessor(stage);
  }

  @Override
  public void dispose() {
    stage.dispose();
    world.dispose();
  }

  @Override
  public void render() {
    Gdx.gl.glClearColor(1, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    world.step(1 / 60f, 6, 2);
    stage.act(Gdx.graphics.getDeltaTime());
    stage.draw();
  }
}