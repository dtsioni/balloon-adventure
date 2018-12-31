package com.tsioni.balloonadventure.actors.api;

/**
 * A visitor for creating entities based on different entity definitions.
 */
public interface EntityDefinitionVisitor
{
    void visit(BalloonEntityDefinition balloonEntityDefinition);

    void visit(SquareWallEntityDefinition squareWallEntityDefinition);

    void visit(WindEntityDefinition windEntityDefinition);
}
