package com.tsioni.balloonadventure.actors.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.actors.contact.guice.ContactModule;
import com.tsioni.balloonadventure.actors.impl.TheaterInstantiatorInternalModule;

public class TheaterInstantiatorModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new ContactModule());

        install(new TheaterInstantiatorInternalModule());
    }
}
