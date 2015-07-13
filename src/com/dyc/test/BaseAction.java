package com.dyc.test;

import com.dyc.test.utils.CommUtitl;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;


/**
 * Created by Administrator on 2015/6/24.
 */
public class BaseAction  extends AnAction{

    /**
     * 当前选中文件绝对 路径
     */
  public   String path = "";

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        CommUtitl.projPath = anActionEvent.getProject().getBasePath()+"/";
        path =anActionEvent.getData(DataKeys.VIRTUAL_FILE).getPath();
    }
}
