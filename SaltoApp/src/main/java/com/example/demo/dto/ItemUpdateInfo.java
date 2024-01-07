package com.example.demo.dto;

import lombok.Data;

/**
 * 商品更新情報DTOクラス
 * 
 */
@Data
public class ItemUpdateInfo {

	/** 商品ID */
	private String itemId;
	
	/** 商品名 */
	private String itemName;
	
	/** 単価 */
	private int itemPrice;
	
	/** 在庫数量 */
	private int itemStock;
	
	/** 更新商品ID */
	private String updateItemId;
}
