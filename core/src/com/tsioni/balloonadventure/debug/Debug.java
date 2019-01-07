package com.tsioni.balloonadventure.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.tsioni.balloonadventure.Drawable;
import com.tsioni.balloonadventure.input.AbstractBaseInputProcessor;

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
    {
        Gdx.input.setInputProcessor(
            new InputMultiplexer(Gdx.input.getInputProcessor(), new DebutInputProcessor()));
    }

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

    private boolean visible = true;

    @Override
    public void draw(
        final Batch batch)
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

        bitmapFont.draw(batch, output, 0, Gdx.graphics.getHeight());
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
                final int fromRow = Math.max(0, lastRow - DEBUG_CONSOLE_MAX_LINES);

                bufferRows = bufferRows.subList(fromRow, lastRow + 1);

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
            return false;
        }
    }
}
