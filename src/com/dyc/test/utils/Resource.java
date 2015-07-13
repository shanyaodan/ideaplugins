package com.dyc.test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.intellij.openapi.util.io.FileSystemUtil;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.psi.impl.file.impl.FileManagerImpl;
import org.eclipse.jdt.internal.compiler.batch.FileFinder;
import org.jetbrains.io.LocalFileFinder;

public class Resource {


	public InputStream getBaseFragmentResource() throws IOException {
		return	this.getClass().getClassLoader().getResourceAsStream("com/dyc/test/temp/BaseFragment1.txt");
//		return	this.getClass().getClassLoader().getResource("com/dyc/test/temp/TempleteFragment.txt").getFile();
	}

	public InputStream getFragmentResource() throws IOException {
		return	this.getClass().getClassLoader().getResourceAsStream("com/dyc/test/temp/TempFragment1.txt");
//		return	this.getClass().getClassLoader().getResource("com/dyc/test/temp/TempleteFragment.txt").getFile();
	}
	public InputStream getActivityResource() throws IOException {
		return	this.getClass().getClassLoader().getResourceAsStream("com/dyc/test/temp/TempleteActivity1.txt");
//		return	this.getClass().getClassLoader().getResource("com/dyc/test/temp/TempleteActivity1.txt").getFile();
	}

	public InputStream getAdapterResource() throws IOException {
		// 查找指定资源的URL
		return	this.getClass().getClassLoader().getResourceAsStream("com/dyc/test/temp/Tempadapter.txt");
//		this.getClass().getClassLoader().getResource("com/dyc/test/temp/Tempadapter.txt").getFile();
	}

	public InputStream getBaseAdapterResource() throws IOException {
		// 查找指定资源的URL
		return	this.getClass().getClassLoader().getResourceAsStream("com/dyc/test/temp/MyBaseAdapter.txt");
//		return	this.getClass().getClassLoader().getResource("com/dyc/test/temp/SimpleAdapter.txt").getFile();
	}
	public InputStream getDosCmd() throws IOException {
		// 查找指定资源的URL
		return	this.getClass().getClassLoader().getResourceAsStream("com/dyc/test/temp/dos.bat");
//		return	this.getClass().getClassLoader().getResource("com/dyc/test/temp/dos.bat").getFile();
	}
	public InputStream getManifastTag() throws IOException {
		// 查找指定资源的URL
		return	this.getClass().getClassLoader().getResourceAsStream("com/dyc/test/temp/activity_plu.txt");
//		return	this.getClass().getClassLoader().getResource("com/dyc/test/temp/activity_plu.txt").getPath();
	}
	
	
}