package com.dyc.test.utils;

import com.dyc.test.EditDialog;
import com.intellij.openapi.project.ProjectManager;
import org.kohsuke.rngom.util.Uri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
public class Test {
    public static void main(String[] args) {
        File adapterparentfile = new File("temp/TempleteActivity1.txt");
    }
    public static void genadapter(String viewxmlpath) {
        Resource res = new Resource();
        String xmlName = viewxmlpath.substring(viewxmlpath.lastIndexOf("/") + 1, viewxmlpath.lastIndexOf(".xml"));
        File adapterparentfile = new File(CommUtitl.projPath + CommUtitl.ideaPackage + CommUtitl.adapterPackageName);
        if (new File(CommUtitl.projPath + CommUtitl.ideaPackage + CommUtitl.adapterPackageName + "/MyBaseAdapter.java").exists()) {
        } else {
            try {
                if (!adapterparentfile.exists()) {
                    adapterparentfile.mkdirs();
                }
                File baseadapterfile = new File(adapterparentfile, "MyBaseAdapter.java");
                if (!baseadapterfile.exists()) {
                    String strs = Utils.fromInputStreamToString(res.getBaseAdapterResource());
                    String packagname = CommUtitl.adapterPackageName.replace("/", ".");
                    strs = strs.replace("adapterpackageName", packagname + ";\nimport " + CommUtitl.projPackage.replace("/", ".") + ".R;");
                    FileOutputStream fout = new FileOutputStream(baseadapterfile);
                    fout.write(strs.getBytes("utf-8"));
                    fout.flush();
                    fout.close();
                }
            } catch (Exception e) {

            }
        }
        try {
            String strs = Utils.fromInputStreamToString(res.getAdapterResource());
            String ss[] = ViewCodeUtil.getNewAdapterCode(viewxmlpath, CommUtitl.entityName);
            String packagname = CommUtitl.adapterPackageName.replace("/", ".");
            strs = strs.replace("adapterPachagename", packagname);
            strs = strs.replace("entityPath", CommUtitl.entityppackage);
            strs = strs.replace("projPath", CommUtitl.projPackage.replace("/", "."));
            strs = strs.replace("//entitycollection", ss[0]);
            strs = strs.replace("//initAdapterView", ss[1]);
            strs = strs.replace("//itemlayout", xmlName);
            strs = strs.replace("Tempadapter", CommUtitl.adapterName);
            adapterparentfile = new File(CommUtitl.projPath + CommUtitl.ideaPackage + CommUtitl.adapterPackageName);
            if (!adapterparentfile.exists()) {
                adapterparentfile.mkdirs();
            }
            File adapterfile = new File(adapterparentfile, CommUtitl.adapterName + ".java");
            FileOutputStream fo = new FileOutputStream(adapterfile);
            fo.write(strs.getBytes("utf-8"));
            fo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String genActivity(String layoutFil, String entityname) {
        Resource res = new Resource();
        String viewxmlname = layoutFil.substring(layoutFil.lastIndexOf("/") + 1, layoutFil.lastIndexOf("."));
        String activityName = "";
        File manifestFile = null;
        String strs = "";
        try {
            strs = Utils.fromInputStreamToString(res.getActivityResource());
            String ss[] = ViewCodeUtil.getCode(layoutFil);
            strs = strs.replace("//classStatement", ss[0]);
            strs = strs.replace("contentlayout", viewxmlname);
            strs = strs.replace("//findViewByIdscontent", ss[1]);
            String packagname = CommUtitl.activitypackageName.replace("/", ".").substring(0, CommUtitl.activitypackageName.length());
            strs = strs.replace("activityPackageName", packagname + ";\nimport " + CommUtitl.projPackage.replace("/", ".") + ".R;");
            if (null == CommUtitl.activityname || CommUtitl.activityname.trim().equals("")) {
                activityName = getXMLClassName(layoutFil.substring(layoutFil.lastIndexOf("/") + 1, layoutFil.lastIndexOf(".")));
            } else {
                activityName = CommUtitl.activityname;
            }
            strs = strs.replace("TempleteActivity1", activityName);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage() + ">>error1111" + (CommUtitl.projPath + CommUtitl.ideaPackage + CommUtitl.activitypackageName).replace("\\", "/");
        }
        try {
            String dir = CommUtitl.projPath + CommUtitl.ideaPackage + CommUtitl.activitypackageName;
            File f = new File(dir);
            f.mkdirs();
            File f2 = new File(f.getAbsolutePath() + "/" + activityName + ".java");
            f2.createNewFile();
            FileOutputStream fo = new FileOutputStream(f2);
            fo.write(strs.getBytes());
            fo.close();
            System.out.println("finish finish");
            if (null != entityname) {
                ViewCodeUtil.genEntity(layoutFil, entityname);
            }
            String manifestData = Utils.fromInputStreamToString(res.getManifastTag());
            manifestData = manifestData.replace("actvityPackagePath", CommUtitl.activitypackageName.replace("/", ".") + "." + activityName);
            String manifestPath = CommUtitl.projPath + "app\\src\\main\\" + "AndroidManifest.xml";
            manifestFile = new File(manifestPath);
            String manifestFileData = Utils.fromInputStreamToString(new FileInputStream(manifestFile));
            manifestFile.exists();
            manifestFileData = manifestFileData.replace("</application>", manifestData);
            manifestFile = new File(manifestPath);
            FileOutputStream fout = new FileOutputStream(manifestFile);
            fout.write(manifestFileData.getBytes("utf-8"));
            fout.close();
            return manifestFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage() + ">>error2222" + (CommUtitl.projPath + CommUtitl.ideaPackage + CommUtitl.activitypackageName).replace("\\", "/");
        }
    }
    public static void getFragment(String layoutFil) {
        Resource res = new Resource();
        String viewxmlname = layoutFil.substring(layoutFil.lastIndexOf("/") + 1, layoutFil.lastIndexOf("."));
        String packagname = CommUtitl.fragmentpackagename.replace("/", ".");
        try {
            if (new File(CommUtitl.projPath + CommUtitl.ideaPackage + CommUtitl.fragmentpackagename + "/BaseFragment.java").exists()) {
            } else {
                String baseStr = Utils.fromInputStreamToString(res.getBaseFragmentResource());
                baseStr = baseStr.replace("fragmentPackageName", packagname);
                File f = new File(CommUtitl.projPath + CommUtitl.ideaPackage + CommUtitl.fragmentpackagename);
                f.mkdirs();
                File f2 = new File(f.getAbsolutePath() + "/" + "BaseFragment.java");
                f2.createNewFile();
                FileOutputStream fo = new FileOutputStream(f2);

                fo.write(baseStr.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String strs = Utils.fromInputStreamToString(res.getFragmentResource());
            String ss[] = ViewCodeUtil.getCode(layoutFil);
            strs = strs.replace("//classStatement", ss[0]);
            strs = strs.replace("fragmentlayout", viewxmlname);
            strs = strs.replace("//findViewByIdContent", ss[1]);

            strs = strs.replace("fragmentPackageName", packagname);
            strs = strs.replace("//initViewWithDatas", ss[2]);
            strs = strs.replace("projectpackage", CommUtitl.projPackage.replace("/", "."));
            String fragmentName = "";
            if (null == CommUtitl.fragmentname || CommUtitl.fragmentname.trim().equals("")) {
                fragmentName = getXMLClassName(layoutFil.substring(layoutFil.lastIndexOf("/") + 1, layoutFil.lastIndexOf(".")));
                CommUtitl.fragmentname = fragmentName;
            } else {
                fragmentName = CommUtitl.fragmentname;
            }
            strs = strs.replace("TempFragment1", fragmentName);
            strs = strs.replace("findViewById(", "rootView.findViewById(");
            File f = new File(CommUtitl.projPath + CommUtitl.ideaPackage + CommUtitl.fragmentpackagename);
            f.mkdirs();
            File f2 = new File(f.getAbsolutePath() + "/" + fragmentName + ".java");
            f2.createNewFile();
            FileOutputStream fo = new FileOutputStream(f2);
            fo.write(strs.getBytes());
            fo.close();
            if (null != CommUtitl.entityName) {
                ViewCodeUtil.genEntity(layoutFil, CommUtitl.entityName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getXMLClassName(String xmlname) {
        String acitivyname = "";
        try {
            int num = xmlname.lastIndexOf("_");
            String prfix = xmlname.substring(0, num);
            String subfix = xmlname.substring(num + 1);
            acitivyname = CommUtitl.firstToupCast(subfix)
                    + CommUtitl.firstToupCast(prfix);
        } catch (Exception e) {
            acitivyname = CommUtitl.firstToupCast(xmlname);
        }
        return acitivyname;
    }
}