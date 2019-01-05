package com.tsioni.balloonadventure.entity.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.entity.body.guice.BodyFactoryModule;
import com.tsioni.balloonadventure.entity.contact.guice.ContactModule;
import com.tsioni.balloonadventure.entity.impl.TheaterInstantiatorInternalModule;

public class TheaterInstantiatorModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new ContactModule());
        install(new BodyFactoryModule());

        install(new TheaterInstantiatorInternalModule());
    }
}
