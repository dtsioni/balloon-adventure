package com.tsioni.balloonadventure.entity.api;

public interface EntityVisitor
{
    void visit(BalloonEntity balloonEntity);

    void visit(SquareWallEntity squareWallEntity);

    void visit(WindEntity windEntity);

    void visit(GoalEntity goalEntity);

    void visit(DeathEntity deathEntity);

    void visit(MovingDeathEntity movingDeathEntity);
    
    void visit(MinorGoalEntity minorGoalEntity);

    void visit(MovingPlatformEntity movingPlatformEntity);
}
