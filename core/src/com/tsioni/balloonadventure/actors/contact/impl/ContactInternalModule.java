package com.tsioni.balloonadventure.actors.contact.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.tsioni.balloonadventure.actors.contact.api.ContactListenerFactory;

public class ContactInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(ContactListenerFactory.class)
            .to(ContactListenerFactoryImpl.class)
            .in(Scopes.SINGLETON);
    }
}
