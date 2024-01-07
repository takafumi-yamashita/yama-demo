package com.example.demo.dto;

import com.example.demo.constant.ItemEditMessage;
import com.example.demo.entity.ItemInfoSam;

import lombok.Data;

/**
 * 商品編集結果DTOクラス
 * 
 */
@Data
public class ItemEditResult {

	/** 商品更新結果 */
	private ItemInfoSam updateItemInfo;
	
	/** 商品更新結果メッセージEnum */
	private ItemEditMessage updateMessage;
}
