package com.example.demo.dto;

import lombok.Data;

@Data
public class ItemListInfo {

	/** 商品ID */
	private String itemId;
	
	/** 商品名 */
	private String itemName;
	
	/** 単価 */
	private int itemPrice;
	
	/** 在庫数量 */
	private int itemStock;
}
