package com.tsioni.balloonadventure.actors.api;

public interface EntityFactoryVisitorHost
{
    /**
     * Host the given entity factory visitor and returns the entity that it creates.
     */
    void hostFactoryVisitor(EntityFactoryVisitor entityFactoryVisitor);
}
