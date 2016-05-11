package com.connie.flappygame.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Connie on 5/8/2016.
 */
public class GameStateManager {
    private Stack<State> states;

    public GameStateManager () {
        states = new Stack<State>();
    }

    /**
     * Adds state to array (add method)
     * @param state
     */
    public void push(State state) {
        states.push(state);
    }

    /**
     * Removes last element in array (remove method)
     */
    public void pop() {
        states.pop();
    }

    /**
     * raplaces last element with state
     * @param state
     */
    public void set(State state) {
        states.pop();
        states.push(state);
    }

    /**
     * The state at top of array has update time changed
     * @param dt
     */
    public void update(float dt) {
        states.peek().update(dt);
    }

    /**
     * top state's render is changed
     * @param sp
     */
    public void render(SpriteBatch sp) {
        states.peek().render(sp);
    }
}
