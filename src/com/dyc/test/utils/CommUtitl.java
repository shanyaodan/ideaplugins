package com.dyc.test.utils;

public class CommUtitl {


	public static String ideaPackage = "app/src/main/java/";
	/**
	 * ���̸�Ŀ¼
	 */
	public static String projPath = "";

	/**
	 * ���̰���
	 */
	public static String projPackage = "";

	/**
	 * activityname
	 */
	public static String activityname = "";
	/**
	 * activity����
	 */
	public static String activitypackageName = "";

	/**
	 * entity����
	 */
	public static String entityppackage = "";

	/**
	 * entity ����
	 */
	public static String entityName = "";

	/**
	 * adapter����
	 */
	public static String adapterName = "TempAdapter";

	/**
	 * adapter����
	 */
	public static String adapterPackageName = "";

	/**
	 * fragmentpackagename����
	 */
	public static String fragmentpackagename = "";

	/**
	 * adapter����
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
