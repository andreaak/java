package com.patterns._01_Creational.factoryMethod;

import javax.swing.JComponent;
public interface ItemEditor {
    public JComponent getGUI();
    public void commitChanges();
}