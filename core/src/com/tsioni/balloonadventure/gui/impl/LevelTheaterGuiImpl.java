package com.tsioni.balloonadventure.gui.impl;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.tsioni.balloonadventure.debug.Debug;
import com.tsioni.balloonadventure.gui.api.LevelTheaterGui;
import com.tsioni.balloonadventure.input.api.InputProcessorRegistry;
import com.tsioni.balloonadventure.level.api.Level;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

class LevelTheaterGuiImpl implements LevelTheaterGui
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
    private final TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
    {
        buttonStyle.font = skin.getFont("default");
        skin.add("default", buttonStyle);
    }
    private final TextButton pauseButton = new TextButton("Pause", skin);
    {
        table.add(pauseButton);
        pauseButton.addListener(new ClickListener()
        {
            public void clicked (
                final InputEvent event,
                final float x,
                final float y)
            {
                Debug.out.println("Pause button pressed!");
                pauseMenuIsOpen = true;
                pauseMenu.setVisible(true);
            }
        });
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

    private final Table pauseMenu = new Table();
    {
        pauseMenu.setVisible(false);
        pauseMenu.setFillParent(true);
    }
    private final TextButton resumeButton = new TextButton("Resume", skin);
    {
        pauseMenu.center();
        pauseMenu.add(resumeButton);
        resumeButton.addListener(new ClickListener()
        {
            public void clicked (
                final InputEvent event,
                final float x,
                final float y)
            {
                Debug.out.println("Resume button pressed!");
                pauseMenuIsOpen = false;
                pauseMenu.setVisible(false);
            }
        });
    }
    private final TextButton backToLevelSelect = new TextButton("Back to level select", skin);
    {
        pauseMenu.row();
        pauseMenu.add(backToLevelSelect);
        backToLevelSelect.addListener(new ClickListener()
        {
            public void clicked (
                final InputEvent event,
                final float x,
                final float y)
            {
                Debug.out.println("Back to level select button pressed!");
                levelWasExited = true;
            }
        });
    }

    private boolean pauseMenuIsOpen = false;
    private boolean levelWasExited = false;
    private int numberOfMinorGoalsCollected;

    @Inject
    LevelTheaterGuiImpl(
        @Assisted final Level level,
        @Assisted final LevelGameState levelGameState,
        final Batch batch,
        final GuiStageFactory guiStageFactory,
        final InputProcessorRegistry inputProcessorRegistry)
    {
        this.level = level;
        this.levelGameState = levelGameState;
        this.stage = guiStageFactory.createGuiStage(batch);

        numberOfMinorGoalsCollected = levelGameState.numberOfMinorGoalsCollected();
        stage.addActor(table);
        stage.addActor(pauseMenu);
        inputProcessorRegistry.registerInputProcessor(stage);
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
        return "You have collected "
            + numberOfMinorGoalsCollected
            + "/"
            + level.getLevelInitialState().getNumberOfMinorGoals()
            + " silver stars.";
    }

    @Override
    public boolean pauseMenuIsOpen()
    {
        return pauseMenuIsOpen;
    }

    @Override
    public boolean levelWasExited()
    {
        return levelWasExited;
    }
}
