package com.tsioni.balloonadventure.actors.contact.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.actors.contact.impl.ContactInternalModule;

public class ContactModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new ContactInternalModule());
    }
}
