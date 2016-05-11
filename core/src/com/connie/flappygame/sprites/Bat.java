package com.connie.flappygame.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;

/**
 * Created by Connie on 5/8/2016.
 */
public class Bat {
    private final static int GRAVITY = -15;
    private final static int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velocity;
    private Texture bat;

    //collision detection will be here

    public Bat(int x, int y) {
        position= new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);
        bat= new Texture("bat5.png");
    }

    /**
     * calculates the effect of gravity on the bat/
     * @param dt delta time
     */
    public void update (float dt) {
        if(position.y>0)
             velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);
        if(position.y < 0) {
            position.y = 0;
        }
        //resets gravity for next frame
        velocity.scl(1/dt);
    }

    /**
     * getter for bat texture
     * @return Texture for Bat
     */
    public Texture getTexture() {
        return bat;
    }

    /**
     * getter for position vector
     * @return Vector for position of bat
     */
    public Vector3 getPosition() {
        return position;
    }

    /**
     * makes the bird jump
     */
    public void jump() {
        velocity.y=300;
    }
}
