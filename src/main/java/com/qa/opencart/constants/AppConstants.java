package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final String ACCOUNTS_PAGE_TITLE  = "My Account";
	public static final int ACCOUNTS_PAGE_HEADER_COUNT  = 4;
	
	public static final String USER_REGISTER_SUCCESS_MSG = "Your Account Has Been Created!";
	
	public static final List<String> EXPTD_ACCTS_PAGE_HEADERS_LIST 
	= Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
	
	//***********************default time out**************
	public static final int SHORT_TIME_OUT = 5;
	public static final int MEDIUM_TIME_OUT = 10;
	public static final int LONG_TIME_OUT = 20;
	
	//*********************sheet-Name*******************//
	public static final String REGISTER_SHEET_NAME = "register";

}
