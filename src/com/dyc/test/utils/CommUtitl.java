package com.dyc.test.utils;

public class CommUtitl {


	public static String ideaPackage = "app/src/main/java/";
	/**
	 * 工程根目录
	 */
	public static String projPath = "";

	/**
	 * 工程包名
	 */
	public static String projPackage = "";

	/**
	 * activityname
	 */
	public static String activityname = "";
	/**
	 * activity包名
	 */
	public static String activitypackageName = "";

	/**
	 * entity包名
	 */
	public static String entityppackage = "";

	/**
	 * entity 名字
	 */
	public static String entityName = "";

	/**
	 * adapter名字
	 */
	public static String adapterName = "TempAdapter";

	/**
	 * adapter包名
	 */
	public static String adapterPackageName = "";

	/**
	 * fragmentpackagename包名
	 */
	public static String fragmentpackagename = "";

	/**
	 * adapter名字
	 */
	public static String fragmentname="";
	
//	public String tempPath;


	// private static final String projPath =
	// "D:\\Users\\lenovo\\workspace7\\HomeActivity\\";
	//
	// public static final String activitypath = projPath +
	// "src\\it\\polimi\\promemoria\\";
	// public static final String entityPath = projPath +
	// "src\\it\\polimi\\promemoria\\";
//	public static final String layoutFil = projPath + "res\\layout\\";

	public static String firstToupCast(String prfix) {
		return prfix.substring(0, 1).toUpperCase()
				+ prfix.substring(1, prfix.length());
	}
}
