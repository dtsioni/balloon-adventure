package com.tsioni.balloonadventure.entity.api;

public interface EntityDefinitionVisitor
{
    void visit(BalloonEntityDefinition balloonEntityDefinition);

    void visit(SquareWallEntityDefinition squareWallEntityDefinition);

    void visit(WindEntityDefinition windEntityDefinition);

    void visit(GoalEntityDefinition goalEntityDefinition);

    void visit(DeathEntityDefinition deathEntityDefinition);
}
