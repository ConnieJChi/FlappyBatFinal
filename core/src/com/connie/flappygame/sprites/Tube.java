package com.connie.flappygame.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Connie on 5/8/2016.
 */
public class Tube {
    public static final int TUBE_WIDTH = 52;

    private static final int FLUCTUATION = 150;
    private static final int TUBE_GAP = 80;
    private static final int LOWEST_OPENING = 100;

    private Texture topTube, bottomTube;
    private Vector2 posTopTube, posBotTube;
    private Random rand;

     public Tube(float x) {
         topTube = new Texture("toptube.png");
         bottomTube = new Texture( "bottomtube.png");
         rand = new Random();

         posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
         posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
     }
    //getters
    public Texture getTopTubeTexture() {
        return topTube;
    }

    public Texture getBottomTubeTexture() {
        return bottomTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public void reposition(float x) {
        posTopTube.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
    }
}
