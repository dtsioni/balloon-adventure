package com.tsioni.balloonadventure.entity.api;

public interface MovingDeathEntityDefinition extends DeathEntityDefinition
{
    int getEndX();
    int getEndY();
    int getPeriod();
}
