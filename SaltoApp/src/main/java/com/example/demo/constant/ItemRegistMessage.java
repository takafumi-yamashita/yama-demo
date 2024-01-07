package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザー登録結果メッセージEnumクラス
 * 
 */
@Getter
@AllArgsConstructor
public enum ItemRegistMessage {

	/** 登録成功 */
	SUCCEED(MessageConst.ITEM_REGIST_SUCCEED,false);
	
	/** メッセージID */
	private String messageId;

	/** エラー有無 */
	private boolean isError;

}
