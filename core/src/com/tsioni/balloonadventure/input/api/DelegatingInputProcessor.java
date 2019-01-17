package com.tsioni.balloonadventure.input.api;

import com.badlogic.gdx.InputProcessor;
import com.tsioni.balloonadventure.util.api.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Delegates input to many input processors.
 *
 * This is needed because the InputMultiplexer stops when one input processor accepts the input.
 * This component will make sure that every input processor handles the input.
 */
public class DelegatingInputProcessor implements InputProcessor
{
    final List<InputProcessor> inputProcessors = new ArrayList<InputProcessor>();

    public DelegatingInputProcessor(
        final InputProcessor... inputProcessors)
    {
        this.inputProcessors.addAll(Arrays.asList(inputProcessors));
    }

    @Override
    public boolean keyDown(final int keycode)
    {
        return forEachInputProcessor(new Predicate<InputProcessor>()
        {
            @Override
            public boolean test(final InputProcessor inputProcessor)
            {
                return inputProcessor.keyDown(keycode);
            }
        });
    }

    @Override
    public boolean keyUp(final int keycode)
    {
        return forEachInputProcessor(new Predicate<InputProcessor>()
        {
            @Override
            public boolean test(final InputProcessor inputProcessor)
            {
                return inputProcessor.keyUp(keycode);
            }
        });
    }

    @Override
    public boolean keyTyped(final char character)
    {
        return forEachInputProcessor(new Predicate<InputProcessor>()
        {
            @Override
            public boolean test(final InputProcessor inputProcessor)
            {
                return inputProcessor.keyTyped(character);
            }
        });
    }

    @Override
    public boolean touchDown(
        final int screenX,
        final int screenY,
        final int pointer,
        final int button)
    {
        return forEachInputProcessor(new Predicate<InputProcessor>()
        {
            @Override
            public boolean test(final InputProcessor inputProcessor)
            {
                return inputProcessor.touchDown(screenX, screenY, pointer, button);
            }
        });
    }

    @Override
    public boolean touchUp(
        final int screenX,
        final int screenY,
        final int pointer,
        final int button)
    {
        return forEachInputProcessor(new Predicate<InputProcessor>()
        {
            @Override
            public boolean test(final InputProcessor inputProcessor)
            {
                return inputProcessor.touchUp(screenX, screenY, pointer, button);
            }
        });
    }

    @Override
    public boolean touchDragged(
        final int screenX,
        final int screenY,
        final int pointer)
    {
        return forEachInputProcessor(new Predicate<InputProcessor>()
        {
            @Override
            public boolean test(final InputProcessor inputProcessor)
            {
                return inputProcessor.touchDragged(screenX, screenY, pointer);
            }
        });
    }

    @Override
    public boolean mouseMoved(
        final int screenX,
        final int screenY)
    {
        return forEachInputProcessor(new Predicate<InputProcessor>()
        {
            @Override
            public boolean test(final InputProcessor inputProcessor)
            {
                return inputProcessor.mouseMoved(screenX, screenY);
            }
        });
    }

    @Override
    public boolean scrolled(final int amount)
    {
        return forEachInputProcessor(new Predicate<InputProcessor>()
        {
            @Override
            public boolean test(final InputProcessor inputProcessor)
            {
                return inputProcessor.scrolled(amount);
            }
        });
    }

    private boolean forEachInputProcessor(
        final Predicate<InputProcessor> inputProcessorPredicate)
    {
        boolean result = false;

        for (final InputProcessor inputProcessor : inputProcessors)
        {
            result |= inputProcessorPredicate.test(inputProcessor);
        }

        return result;
    }
}
