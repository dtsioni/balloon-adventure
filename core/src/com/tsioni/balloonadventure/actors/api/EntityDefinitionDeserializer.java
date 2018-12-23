package com.tsioni.balloonadventure.actors.api;

import java.util.List;

/**
 * Deserializes entity definitions from their representation on the disk.
 */
public interface EntityDefinitionDeserializer
{
    List<EntityDefinition> deserializeEntityDefinitions();
}
