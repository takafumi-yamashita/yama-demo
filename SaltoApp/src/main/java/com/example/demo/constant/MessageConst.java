package com.example.demo.constant;

/**
 * エラーメッセージID定数クラス
 */
public class MessageConst {
	
	/** 共通：入力内容誤り */
	public static final String FORM_ERROR = "common.formError";

	/** ログイン画面：入力内容誤り */
	public static final String LOGIN_WRONG_INPUT = "login.wrongInput";
	
	/** ユーザー登録画面：すでに登録されているログインID */
	public static final String SIGNUP_EXISTED_LOGIN_ID = "signup.existedLoginId";
	
	/** ユーザー登録画面：ユーザー登録完了 */
	public static final String SIGNUP_RESIST_SUCCEED = "signup.resistSucceed";
	
	/** ユーザー一覧画面：存在しないログインID */
	public static final String USERLIST_NON_EXISTED_LOGIN_ID = "userList.nonExistedLoginId";
	
	/** ユーザー一覧画面：ユーザー削除完了 */
	public static final String USERLIST_DELETE_SUCCEED = "userList.deleteSucceed";
	
	/** ユーザー情報編集画面：存在しないログインID */
	public static final String USEREDIT_NON_EXISTED_LOGIN_ID = "userEdit.nonExistedLoginId";
	
	/** ユーザー情報編集画面：ユーザー更新失敗 */
	public static final String USEREDIT_UPDATE_FAILED = "userEdit.updateFailed";

	/** ユーザー情報編集画面：ユーザー更新完了 */
	public static final String USEREDIT_UPDATE_SUCCEED = "userEdit.updateSucceed";
	
	/** 商品一覧画面：存在しないログインID */
	public static final String ITEMLIST_NON_EXISTED_ITEM_ID = "itemList.nonExistedItemId";
	
	/** 商品一覧画面：商品削除完了 */
	public static final String ITEMLIST_DELETE_SUCCEED = "itemList.deleteSucceed";
	
	/** 商品情報編集画面：商品更新失敗 */
	public static final String ITEMEDIT_UPDATE_FAILED = "itemEdit.updateFailed";

	/** 商品情報編集画面：商品更新完了 */
	public static final String ITEMEDIT_UPDATE_SUCCEED = "itemEdit.updateSucceed";
	
	/**  商品情報編集画面：存在しない商品ID */
	public static final String ITEMEDIT_NON_EXISTED_ITEM_ID = "itemEdit.nonExistedItemId";
	
	/** 商品登録画面：商品登録完了 */
	public static final String ITEM_REGIST_SUCCEED = "itemRegist.resistSucceed";
}
