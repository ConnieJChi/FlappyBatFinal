package com.connie.flappygame.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.connie.flappygame.FlappyGame;
import com.connie.flappygame.sprites.Bat;
import com.connie.flappygame.sprites.Tube;

/**
 * Created by Connie on 5/8/2016.
 */
public class PlayState extends State{
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;

    private Bat bat;
    private Texture bg;
    private Tube tube;

     // Game over pic and ground pic will be here


    private Array<Tube> tubes;

    public PlayState(GameStateManager gs) {
        super(gs);
        bat = new Bat(50, 200);

        cam.setToOrtho(false, FlappyGame.WIDTH/2, FlappyGame.HEIGHT/2);
        bg = new Texture("recent.png");

        tubes = new Array<Tube>();
        for (int i=1; i<=TUBE_COUNT; i++) {
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }
    }

    /**
     * Detects user input (touching screen)
     */
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            bat.jump();
        }
    }

    /**
     * Manages when the game does as time goes on and
     * what happens if there is a user input
     * @param dt delta time
     */
    public void update(float dt) {
        handleInput();
        bat.update(dt);

        cam.position.x = bat.getPosition().x+80;
        for(Tube tube: tubes) {
            if(cam.position.x-(cam.viewportWidth/2)>(tube.getPosTopTube().x + tube.getTopTubeTexture().getWidth())){
                tube.reposition(tube.getPosTopTube().x+((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            }
        }
        cam.update();
    }

    /**
     * Makes screen scroll
     */
    public void updateGround() {

    }
    /**
     * Focuses the camera on a certain area around the bat and spawns the bat, background, and tubes
     * while loading up the background
     */
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(bat.getTexture(), bat.getPosition().x, bat.getPosition().y);
        for (Tube tube: tubes) {
            sb.draw(tube.getTopTubeTexture(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBottomTubeTexture(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }
        sb.end();
    }

    /**
     * Clears screen
     */
    public void dispose() {
        bg.dispose();
    }


}
