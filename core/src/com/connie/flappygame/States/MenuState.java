package com.connie.flappygame.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.connie.flappygame.FlappyGame;

/**
 * Created by Connie on 5/8/2016.
 */
public class MenuState extends State {
    private Texture background;
    private Texture playBtn;
    public MenuState(GameStateManager gs) {
        super(gs);
        background = new Texture("recent.png");
        playBtn = new Texture("playBtn.png");
    }

    /**
     * If user touches, goes into game state
     */
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    /**
     * detects when user inputs
     * @param dt delta time
     */
    public void update(float dt) {
        handleInput();

    }


    /**
     * Draws the background and play button
     * @param sb default background
     */
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, FlappyGame.WIDTH, FlappyGame.HEIGHT);
        sb.draw(playBtn, (FlappyGame.WIDTH /2) - (playBtn.getWidth()/2), FlappyGame.HEIGHT/2);
        sb.end();

    }

    /**
     * clears screen
     */
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
