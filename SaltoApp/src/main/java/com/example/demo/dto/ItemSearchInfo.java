package com.example.demo.dto;

import lombok.Data;

/**
 * 商品一覧画面検索用DTOクラス
 *
 */
@Data
public class ItemSearchInfo {

	/** 商品ID */
	private String itemId;
	
	/** 商品名 */
	private String itemName;
	
}
