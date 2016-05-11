package com.connie.flappygame.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Connie on 5/8/2016.
 */
 public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    protected State(GameStateManager gs) {
        gsm = gs;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }
    /**
     * detects when user interacts with the game
     */
    protected abstract void handleInput();

    /**
     * updates the game based on input
     * @param dt delta time
     */
    public abstract void update(float dt);

    /**
     * renders all the images into the app
     * @param sb default background
     */
    public abstract void render(SpriteBatch sb);

    /**
     * refreshes the screen to reduce memory usage
     */
    public abstract void dispose();
}
