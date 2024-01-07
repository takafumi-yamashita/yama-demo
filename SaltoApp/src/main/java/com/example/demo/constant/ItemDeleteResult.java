package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 処理結果種別
 * 
 */
@Getter
@AllArgsConstructor
public enum ItemDeleteResult {

	/* エラーなし */
	SUCCEED(MessageConst.ITEMLIST_DELETE_SUCCEED),
	
	/* エラーあり */
	ERROR(MessageConst.ITEMLIST_NON_EXISTED_ITEM_ID);
	
	/** メッセージID */
	private String messageId;
}
