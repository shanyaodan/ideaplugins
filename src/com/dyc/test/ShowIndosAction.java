
package com.dyc.test;

import com.dyc.test.utils.Resource;
import com.dyc.test.utils.Utils;
import com.dyc.test.utils.ViewCodeUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.codehaus.groovy.tools.shell.Shell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ShowIndosAction extends BaseAction {


	@Override
	public void actionPerformed(AnActionEvent anActionEvent) {
		super.actionPerformed(anActionEvent);
//			Resource res = new Resource();
		String ss[] = ViewCodeUtil.getCode(path);
		try {
//			String strs = Utils.fromInputStreamToString(new FileInputStream(res
//					.getDosCmd()));
			System.out.println("-----"+ss[0]);
			System.out.println("-----"+ss[1]);
//			strs.replace("genStatementdata", ss[0]);
//			strs.replace("genfindviewByIddata", ss[1]);
//			System.out.println("-----"+strs);
//			File file = new File(res.getDosCmd());
//			file.setWritable(true);
//			FileOutputStream fo = new FileOutputStream(file);
//			fo.write(strs.getBytes("utf-8"));
//			fo.flush();
//			fo.close();
//			System.out.println("6@@@@@@@@@@@"+"cmd /k  start " + res.getDosCmd());
//			Runtime.getRuntime().exec(
//					"cmd /k  start echo" + ss[0]+ss[1]);
			FindViewByIdEditDialog dialog = new FindViewByIdEditDialog(ss[0]+""+ "\n"+ss[1]);
			dialog.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// try {
		// Process process =
		// Runtime.getRuntime().exec("cmd /k start echo ==========statement==========echo"+ss[0]+"echo======findviewByid========echo"+ss[1]);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}
}

