package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Person {
    Texture img;
    Vector2 pos;
    float vy;
    float gravity;
    public Person(){
        img = new Texture("person.png");
        pos = new Vector2(100,380);
        vy = 0;
        gravity = -0.7f;
    }
    public void render(SpriteBatch batch){
        batch.draw(img,pos.x,pos.y);
    }
    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            vy=4;
        }
        vy += gravity;
        pos.y += vy;
    }
    public void recreate(){
        pos = new Vector2(100,380);
        vy = 0;
    }
}