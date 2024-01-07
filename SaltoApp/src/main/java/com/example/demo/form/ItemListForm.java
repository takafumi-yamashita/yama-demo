package com.example.demo.form;

import lombok.Data;

/**
 * 商品一覧画面Formクラス
 *
 */
@Data
public class ItemListForm {
	
	/** 商品ID */
	private String itemId;
	
	/** 商品名 */
	private String itemName;
	
	/** 商品一覧情報から選択された商品ID */
	private String selectedItemId;
	
	public ItemListForm clearSelectedItemId() {
		this.selectedItemId = null;
		
		return this;
	}
	
}
