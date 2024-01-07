package com.example.demo.service;

import java.util.Optional;

import com.example.demo.dto.ItemEditResult;
import com.example.demo.dto.ItemUpdateInfo;
import com.example.demo.entity.ItemInfoSam;

/**
 * 商品編集画面Serviceクラス
 * 
 */
public interface ItemEditService {

	/**
	 * 商品IDを使って商品情報テーブルを検索し、検索結果を返却します。
	 * 
	 * @param itemId 商品ID
	 * @return 該当の商品情報テーブル登録情報
	 */
	public Optional<ItemInfoSam> searchItemInfo(String itemId);
	
	/**
	 * 商品情報テーブルを更新します。
	 * 
	 * @param itemUpdateInfo 商品更新情報
	 * @return 更新結果
	 */
	public ItemEditResult updateItemInfo(ItemUpdateInfo itemUpdateInfo);
}
