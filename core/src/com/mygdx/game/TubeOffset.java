package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;


public class TubeOffset extends ApplicationAdapter {
    SpriteBatch batch;
    Texture background;
    Texture topTube;
    Texture bottomTube;
    float gap = 400;
    float tubeVelocity = 8;
    int numberOfTubes = 4;
    float maxTubeOffset;
    float tubeOffset;
    Random randomGenerator;
    float tubeX;
    float[] tubeoffset = new float[numberOfTubes];
    float distanceBetweenTubes;

    public void create() {
        batch = new SpriteBatch();
        background = new Texture("bg.png");
        topTube = new Texture("bottomtube.png");
        bottomTube = new Texture("bottomtube.png");
        maxTubeOffset = Gdx.graphics.getHeight() / 2 - gap / 2 - 100;
        randomGenerator = new Random();
        distanceBetweenTubes = Gdx.graphics.getWidth() * 3 / 4;
        tubeX = Gdx.graphics.getWidth() / 2 - topTube.getWidth() / 2;
    }

    public void render() {

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        if (Gdx.input.justTouched()) {
            tubeOffset = (randomGenerator.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - gap - 200);
        }
        batch.draw(topTube, tubeX, Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset);
        batch.draw(bottomTube, tubeX, Gdx.graphics.getHeight() / 2 - gap / 2 - bottomTube.getHeight() + tubeOffset);
        batch.end();

    }
}