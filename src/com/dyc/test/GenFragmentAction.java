package com.dyc.test;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class GenFragmentAction  extends BaseAction {

	/**
	 * Constructor for Action1.
	 */
	public GenFragmentAction() {
		super();
	}

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        super.actionPerformed(anActionEvent);
        EditDialog wd = new EditDialog(path, 3);
        wd.setSize(400, 335);
        wd.setVisible(true);
    }

}
