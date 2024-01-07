package com.example.demo.constant;

/**
 * URL 定数クラス
 *
 */
public class UrlConst {
	
	/** ログイン画面 */
	public static final String LOGIN = "/login";
	
	/** ユーザー登録画面 */
	public static final String SIGNUP = "/signup";
	
	/** メニュー画面 */
	public static final String MENU = "/menu";
	
	/** ユーザー一覧画面 */
	public static final String USER_LIST = "/userList";
	
	/** ユーザー編集画面 */
	public static final String USER_EDIT = "/userEdit";
	
	/** 商品一覧画面 */
	public static final String ITEM_LIST = "/itemList";
	
	/** 商品編集画面 */
	public static final String ITEM_EDIT = "/itemEdit";
	
	/** 商品登録画面 */
	public static final String ITEM_REGIST = "/itemRegist";
	
	/** 商品詳細情報画面 */
	public static final String ITEM_DETAIL = "/itemDetail";
	
	/** 認証不要画面 */
	public static final String[] NO_AUTHENTICATION = { LOGIN, SIGNUP, "/webjars/**", "/css/**" };
}
