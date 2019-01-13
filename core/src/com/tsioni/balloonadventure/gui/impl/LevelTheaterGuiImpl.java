package com.tsioni.balloonadventure.gui.impl;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.tsioni.balloonadventure.debug.Debug;
import com.tsioni.balloonadventure.gui.api.Gui;
import com.tsioni.balloonadventure.level.api.Level;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

class LevelTheaterGuiImpl implements Gui
{
    private final Stage stage;
    private final LevelGameState levelGameState;
    private final Level level;

    private final Table table = new Table();
    private final Skin skin = new Skin();
    {
        skin.add("default", new BitmapFont());
    }
    private final Label.LabelStyle labelStyle = new Label.LabelStyle();
    {
        labelStyle.font = skin.getFont("default");
        labelStyle.fontColor = Color.WHITE;
        skin.add("default", labelStyle);
    }
    private final Label levelIdLabel = new Label("empty", skin);
    private final Label minorGoalsLabel = new Label("empty", skin);
    {
        table.setFillParent(true);
        table.right().top();

        table.add(levelIdLabel).right();
        table.row();
        table.add(minorGoalsLabel).right();
    }

    private int numberOfMinorGoalsCollected;

    LevelTheaterGuiImpl(
        final Stage stage,
        final Level level,
        final LevelGameState levelGameState)
    {
        this.stage = stage;
        this.level = level;
        this.levelGameState = levelGameState;

        numberOfMinorGoalsCollected = levelGameState.numberOfMinorGoalsCollected();
        stage.addActor(table);
    }

    @Override
    public void draw()
    {
        stage.draw();
    }

    @Override
    public void step(final float delta)
    {
        numberOfMinorGoalsCollected = levelGameState.numberOfMinorGoalsCollected();

        if (Debug.visible)
        {
            table.setDebug(true);
        }
        else
        {
            table.setDebug(false);
        }

        minorGoalsLabel.setText(stateString());
        levelIdLabel.setText("You are playing level " + level.getLevelId());
    }

    private String stateString()
    {
        String stateString;

        if (numberOfMinorGoalsCollected == 1)
        {
            stateString = "You have collected " + numberOfMinorGoalsCollected + " silver star.";
        }
        else
        {
            stateString = "You have collected " + numberOfMinorGoalsCollected + " silver stars.";
        }

        return stateString;
    }
}
