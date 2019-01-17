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
import com.tsioni.balloonadventure.gui.api.LevelSelectGui;
import com.tsioni.balloonadventure.input.api.InputProcessorRegistry;
import com.tsioni.balloonadventure.level.api.LevelId;
import com.tsioni.balloonadventure.level.api.LevelIds;
import com.tsioni.balloonadventure.util.api.Optional;

class LevelSelectGuiImpl implements LevelSelectGui
{
    private final Stage stage;

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
    private final Label balloonAdventureLabel = new Label("Welcome to Balloon Adventure!", skin);
    private final Label levelSelectLabel = new Label("Please select a level:", skin);
    {
        table.setFillParent(true);
        table.center();

        table.add(balloonAdventureLabel);
        table.row();
        table.add(levelSelectLabel);
    }

    private final TextButton button1 = new TextButton("Test 1", skin);
    {
        table.row();
        table.add(button1);
        button1.addListener(new ClickListener()
        {
            public void clicked (
                final InputEvent event,
                final float x,
                final float y)
            {
                selectedLevelId = LevelIds.TEST_1;
            }
        });
    }
    private final TextButton button2 = new TextButton("Test 2", skin);
    {
        table.row();
        table.add(button2);
        button2.addListener(new ClickListener()
        {
            public void clicked (
                final InputEvent event,
                final float x,
                final float y)
            {
                selectedLevelId = LevelIds.TEST_2;
            }
        });
    }
    private final TextButton button3 = new TextButton("Test 3", skin);
    {
        table.row();
        table.add(button3);
        button3.addListener(new ClickListener()
        {
            public void clicked (
                final InputEvent event,
                final float x,
                final float y)
            {
                selectedLevelId = LevelIds.TEST_3;
            }
        });
    }

    private LevelId selectedLevelId;

    @Inject
    LevelSelectGuiImpl(
        @Assisted final Batch batch,
        final GuiStageFactory guiStageFactory,
        final InputProcessorRegistry inputProcessorRegistry)
    {
        this.stage = guiStageFactory.createGuiStage(batch);

        stage.addActor(table);

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
        if (Debug.visible)
        {
            table.setDebug(true);
        }
        else
        {
            table.setDebug(false);
        }
    }

    @Override
    public Optional<LevelId> getSelectedLevelId()
    {
        return Optional.of(selectedLevelId);
    }
}
