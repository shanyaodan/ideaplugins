package com.dyc.test;


import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.codehaus.groovy.tools.shell.Shell;

public class GenAdapterAction extends BaseAction {
	public GenAdapterAction() {
		super();
	}
    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
     super.actionPerformed(anActionEvent);
        EditDialog wd = new EditDialog(path,2);
        wd.setSize(400, 335);
        wd.setVisible(true);
    }
}
