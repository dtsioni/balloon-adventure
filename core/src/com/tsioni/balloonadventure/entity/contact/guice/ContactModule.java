package com.tsioni.balloonadventure.entity.contact.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.entity.contact.impl.ContactInternalModule;

public class ContactModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new ContactInternalModule());
    }
}
