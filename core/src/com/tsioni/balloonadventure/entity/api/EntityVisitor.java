package com.tsioni.balloonadventure.entity.api;

public interface EntityVisitor
{
    void visit(BalloonEntity balloonEntity);

    void visit(SquareWallEntity squareWallEntity);

    void visit(WindEntity windEntity);
}
