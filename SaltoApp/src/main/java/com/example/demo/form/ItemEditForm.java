package com.example.demo.form;

import lombok.Data;

@Data
public class ItemEditForm {

	/** 商品名 */
	private String itemName;
	
	/** 単価 */
	private int itemPrice;
	
	/** 在庫数量 */
	private int itemStock;
}
