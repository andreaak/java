package com.patterns._03_Behavioral.mediator;

public interface ContactMediator{
    public void setContactDisplayPanel(ContactDisplayPanel displayPanel);
    public void setContactEditorPanel(ContactEditorPanel editorPanel);
    public void setContactSelectorPanel(ContactSelectorPanel selectorPanel);
    public void createContact(String firstName, String lastName, String title, String organization);
    public void updateContact(String firstName, String lastName, String title, String organization);
    public Contact [] getAllContacts();
    public void selectContact(Contact contact);
}