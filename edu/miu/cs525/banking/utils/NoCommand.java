package edu.miu.cs525.banking.utils;

import edu.miu.cs525.framework.Command;
import edu.miu.cs525.framework.ui.UIControl;

public class NoCommand implements Command {
    @Override
    public void execute(UIControl uiControl) {}
}