package com.tsioni.balloonadventure.actors.impl;

import com.tsioni.balloonadventure.actors.api.EntityDefinition;
import com.tsioni.balloonadventure.actors.api.EntityDefinitionDeserializer;

import java.util.ArrayList;
import java.util.List;

class EntityDefinitionDeserializerImpl implements EntityDefinitionDeserializer
{
    @Override
    public List<EntityDefinition> deserializeEntityDefinitions()
    {
        final List<EntityDefinition> entityDefinitions = new ArrayList<EntityDefinition>();

        entityDefinitions.add(new SquareWallEntityDefinitionImpl(100, 80, 0));
        entityDefinitions.add(new SquareWallEntityDefinitionImpl(100, 150, 0));
        entityDefinitions.add(new BalloonEntityDefinitionImpl(100,100,0));

        return entityDefinitions;
    }
}
