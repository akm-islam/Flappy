package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class movingTubes extends ApplicationAdapter {
    SpriteBatch batch;
    Texture background;
    Texture topTube;
    Texture bottomTube;
    float gap = 400;
    float maxTubeoffset;
    float tubeVelocity=4;
    int numberOfTubes = 4;
    float maxTubeOffset;
    float[] tubeOffset = new float[numberOfTubes];
    Random randomGenerator;
    float[] tubeX = new float[numberOfTubes];
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

        for (int i = 0; i < numberOfTubes; i++) {

            tubeOffset[i] = (randomGenerator.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - gap - 200);

            tubeX[i] = Gdx.graphics.getWidth() / 2 - topTube.getWidth() / 2 + i * distanceBetweenTubes;

        }
    }

    public void render() {

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        for (int i = 0; i < numberOfTubes; i++) {

            if (tubeX[i] < - topTube.getWidth()) {

                tubeX[i] += numberOfTubes * distanceBetweenTubes;

            } else {

                tubeX[i] = tubeX[i] - tubeVelocity;

            }

            batch.draw(topTube, tubeX[i], Gdx.graphics.getHeight() / 2 + gap / 2 + tubeOffset[i]);
            batch.draw(bottomTube, tubeX[i], Gdx.graphics.getHeight() / 2 - gap / 2 - bottomTube.getHeight() + tubeOffset[i]);

        }
        batch.end();

    }
}
