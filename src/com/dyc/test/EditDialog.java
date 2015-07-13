/* 
 * Created on 2004-9-23 
 * */
package com.dyc.test;


import com.dyc.test.utils.*;
import com.intellij.openapi.module.ResourceFileUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.util.ResourceUtil;
import jdk.internal.jfr.events.FileReadEvent;
import org.apache.velocity.runtime.resource.loader.FileResourceLoader;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.util.Properties;

public class EditDialog extends JDialog {
    private JPanel jEditorPane = null;
    private String path = "";
    private int type;

    /**
     * This method initializes / public WatherDialog(String city) { super();
     * this.city=city; initialize(); } /** This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setContentPane(getJEditorPane());

        this.setSize(400, 166);
    }

    /**
     *
     * @param path 选中文件路径
     * @param type 生成文件类型
     *
     */
    public EditDialog(String path, int type) {
        if (!path.endsWith(".xml")) {

        }
        this.path = path;
        this.type = type;
        initialize();

    }

    /**
     * This method initializes jEditorPane
     *
     * @return javax.swing.JEditorPane
     */
    private JPanel getJEditorPane() {
        if (jEditorPane == null) {
            jEditorPane = new JPanel();

            JPanel activitypackagepath = new JPanel();
            activitypackagepath.setLayout(new BoxLayout(activitypackagepath, BoxLayout.X_AXIS));

            JPanel buttonpannel = new JPanel();
            buttonpannel.setLayout(new BoxLayout(buttonpannel, BoxLayout.X_AXIS));
            JPanel entitypathpannel = new JPanel();
            entitypathpannel.setLayout(new BoxLayout(entitypathpannel,BoxLayout.X_AXIS));
            JPanel entityNamePannel = new JPanel();
            entityNamePannel.setLayout(new BoxLayout(entityNamePannel,
                    BoxLayout.X_AXIS));
            JPanel adapterNamePannel = new JPanel();
            adapterNamePannel.setLayout(new BoxLayout(adapterNamePannel,
                    BoxLayout.X_AXIS));

            JLabel activitypackage = new JLabel("activityPackage:");
            final JTextField activitypackageNameStr = new JTextField(20);
            activitypackagepath.add(activitypackage);
            activitypackagepath.add(activitypackageNameStr);

            JLabel entityPath = new JLabel("  entityPackage:");
            final JTextField entityPath_data = new JTextField(20);
            entitypathpannel.add(entityPath);
            entitypathpannel.add(entityPath_data);

            JLabel entityName = new JLabel("  entityName:");
            final JTextField entityName_data = new JTextField(20);
            entityNamePannel.add(entityName);
            entityNamePannel.add(entityName_data);

            JLabel adapterName = new JLabel("    adapterName:");
            final JTextField adapterName_data = new JTextField(20);
            adapterNamePannel.add(adapterName);
            adapterNamePannel.add(adapterName_data);
            final JButton obkbut = new JButton(" 确定  ");
            JButton cancelbut = new JButton(" 取消  ");
            buttonpannel.add(obkbut);
            buttonpannel.add(cancelbut);
            Resource res = new Resource();
            try {
            } catch (Exception e1) {
                entityName_data.setText("error_data");
                e1.printStackTrace();
            }
            obkbut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CommUtitl.entityName = getStr(entityName_data);
                    Properties props = new Properties();
                    try {
                        FileReader fr = new FileReader(new File(CommUtitl.projPath + "andgen.properties"));
                        props.load(fr);
                        fr.close();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    CommUtitl.projPackage = props.getProperty("projpackage", "com.dyc.test");
                    CommUtitl.fragmentpackagename = props.getProperty("fragmentpackagename",CommUtitl.projPackage + "/fragment");
                    CommUtitl.entityppackage = props.getProperty("entityppackage", CommUtitl.projPackage + "/entity");
                    CommUtitl.activitypackageName = props.getProperty("activitypackageName", CommUtitl.projPackage + "/activity");
                    CommUtitl.adapterPackageName = props.getProperty("adapterPackageName", CommUtitl.projPackage + "/adapter");
                    CommUtitl.adapterName = getStr(adapterName_data);
                    if (null != CommUtitl.activitypackageName) {
                        CommUtitl.activitypackageName = CommUtitl.activitypackageName.replace(".", "/");
                    }
                    if (null != CommUtitl.entityppackage) {
                        CommUtitl.entityppackage = CommUtitl.entityppackage.replace(".", "/");
                    }
                    if (null != CommUtitl.fragmentpackagename) {
                        CommUtitl.fragmentpackagename = CommUtitl.fragmentpackagename.replace(".", "/");
                    }
                    if (null != CommUtitl.adapterPackageName) {
                        CommUtitl.adapterPackageName = CommUtitl.adapterPackageName.replace(".", "/");
                    }

                    String manifestPath = CommUtitl.projPath + "app\\src\\main\\"+"AndroidManifest.xml";
                    if (type == 1) {
                        try {
                            String viewxmlname = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
                            Test.genActivity(path, CommUtitl.entityName);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                            entityName_data.setText(path + ":error");
                        }
                    } else if (type == 2) {
                        Test.genadapter(path);
                    } else if (type == 3) {
                        Test.getFragment(path);
                    }
                }
            });
            cancelbut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    EditDialog.this.setVisible(false);
                }
            });
            jEditorPane.add(entityNamePannel);
            if (type == 2) {
                jEditorPane.add(adapterNamePannel);
            }
            jEditorPane.add(buttonpannel);
        }
        return jEditorPane;
    }


    public String getStr(JTextField jf) {
        if (null != jf && null != jf.getText()) {
            return jf.getText().toString().trim();
        } else {
            return "";
        }

    }

}