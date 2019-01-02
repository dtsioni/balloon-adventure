package com.tsioni.balloonadventure.actors.api;

public interface EntityVisitor
{
    void visit(BalloonEntity balloonEntity);

    void visit(SquareWallEntity squareWallEntity);

    void visit(WindEntity windEntity);
}
