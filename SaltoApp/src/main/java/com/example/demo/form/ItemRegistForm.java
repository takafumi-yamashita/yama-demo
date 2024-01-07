package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 商品登録画面Formクラス
 *
 */
@Data
public class ItemRegistForm {
	
	/** 商品ID */
	@Length(max = 10)
	private String itemId;
	
	/** 商品名 */
	@Length(max = 10)
	private String itemName;
	
	/** 単価 */
	@NotBlank
	private int itemPrice;
	
	/** 在庫数量 */
	@NotBlank
	private int itemStock;
	
}
