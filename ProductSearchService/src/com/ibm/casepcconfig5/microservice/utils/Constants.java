package com.ibm.casepcconfig5.microservice.utils;

public class Constants {
	private static String ip = (System.getenv("EJBServiceIP") == null ? "169.44.18.102":System.getenv("EJBServiceIP"));
	public static final String PRODUCT_ID_URL = "http://" + ip + "/ProductSearchServiceWeb/jaxrs/Product/";
	public static final String PRODUCT_CATEGORY_ID_URL = "http://" + ip + "/ProductSearchServiceWeb/jaxrs/Product/?categoryId=";
	public static final String CATEGORY_URL = "http://" + ip + "/ProductSearchServiceWeb/jaxrs/Category/";
	public static final String CATEGORY_ID_URL = "http://" + ip + "/ProductSearchServiceWeb/jaxrs/Category/";
}
