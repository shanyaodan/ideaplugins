package com.dyc.test;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.diff.impl.patch.formove.PathMerger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vcs.VcsDataKeys;
import com.intellij.openapi.vfs.LocalFileSystem;

import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.io.LocalFileFinder;

public class GenActivityAction extends BaseAction {
	/**
	 * Constructor for Action1.
	 */
	public GenActivityAction() {
		super();
	}




	@Override
	public void actionPerformed(AnActionEvent anActionEvent) {
		super.actionPerformed(anActionEvent);
		EditDialog wd = new EditDialog(path, 1);
		wd.setSize(400, 335);
		wd.setVisible(true);

	}
}
