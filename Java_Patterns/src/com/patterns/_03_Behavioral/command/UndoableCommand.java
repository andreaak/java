package com.patterns._03_Behavioral.command;

public interface UndoableCommand extends Command{
    public void undo();
    public void redo();
}