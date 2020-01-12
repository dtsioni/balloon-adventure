package com.tsioni.balloonadventure.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.google.inject.Inject;
import com.tsioni.balloonadventure.Drawable;
import com.tsioni.balloonadventure.input.api.AbstractBaseInputProcessor;
import com.tsioni.balloonadventure.input.api.InputProcessorRegistry;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Entry point for debug capabilities.
 */
public class Debug implements Drawable
{
    /**
     * Print stream for printing to the on-screen debug console.
     */
    public static final PrintStream out = new PrintStream(new DebugOutputStream());

    private static final int DEBUG_CONSOLE_MAX_LINES = 30;
    private static final int DEBUG_CONSOLE_MAX_WIDTH = 50;

    private static List<String> bufferRows = new ArrayList<String>();

    static {
        bufferRows.add("");
    }

    private final BitmapFont bitmapFont = new BitmapFont();

    {
        bitmapFont.getData().setScale(0.85f);
    }

    private final Batch batch;

    private final Camera guiCamera = new OrthographicCamera();
    {
        guiCamera.combined.setToOrtho2D(
            0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public static boolean visible = false;

    @Inject
    public Debug(
        final Batch batch,
        final InputProcessorRegistry inputProcessorRegistry)
    {
        this.batch = batch;
        
        inputProcessorRegistry.registerInputProcessor(new DebutInputProcessor());
    }

    @Override
    public void draw()
    {
        if (!visible)
        {
            return;
        }

        String output = "DEBUG CONSOLE:\n";

        for (int i = 0; i < DEBUG_CONSOLE_MAX_WIDTH; i++)
        {
            output += "-";
        }

        output += "\n";

        for (final String row : bufferRows)
        {
            output +=  row + "\n";
        }

        batch.setProjectionMatrix(guiCamera.combined);

        batch.begin();
        bitmapFont.draw(batch, output, 0, Gdx.graphics.getHeight());
        batch.end();
    }

    /**
     * The output stream which outputs to the debug console.
     */
    static class DebugOutputStream extends OutputStream
    {
        @Override
        public void write(
            final int i)
            throws IOException
        {
            int lastRow = Math.max(0, bufferRows.size() - 1);

            if (bufferRows.size() > DEBUG_CONSOLE_MAX_LINES)
            {
                final int numberOfExcessRows = Math.max(0, lastRow - DEBUG_CONSOLE_MAX_LINES);

                bufferRows.subList(0, numberOfExcessRows).clear();

                lastRow = bufferRows.size() - 1;
            }

            if (i != '\n' && bufferRows.get(lastRow).length() < DEBUG_CONSOLE_MAX_WIDTH - 1)
            {
                bufferRows.set(lastRow, bufferRows.get(lastRow) + (char) i);
            }
            else if (i != '\n')
            {
                bufferRows.add("");
                bufferRows.set(lastRow, bufferRows.get(lastRow) + (char) i);
            }
            else
            {
                bufferRows.add("");
            }

            //Delegate to the system out as well, to keep a longer record of debug statements.
            System.out.write(i);
        }
    }

    class DebutInputProcessor extends AbstractBaseInputProcessor
    {
        @Override
        public boolean keyDown(final int keycode)
        {
            if (keycode == Input.Keys.D)
            {
                visible = !visible;
            }
            return true;
        }
    }
}
