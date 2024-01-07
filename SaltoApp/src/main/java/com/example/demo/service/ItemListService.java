package com.example.demo.service;

import java.util.List;

import com.example.demo.constant.ItemDeleteResult;
import com.example.demo.dto.ItemListInfo;
import com.example.demo.dto.ItemSearchInfo;

/*
 * ユーザー一覧画面Serviceクラス
 */
public interface ItemListService {

	/**
	 * 商品情報テーブルを全件検索し、商品一覧画面に必要な情報へ変換して返却します。
	 * 
	 * @return 商品情報テーブルの全登録情報
	 */
	public List<ItemListInfo> editItemList();
	
	/**
	 * 商品情報を条件検索した結果を画面の表示用に変換して返却します。
	 * 
	 * @param dto 検索に使用するパラメーター
	 * @return 検索結果
	 */
	public List<ItemListInfo> editItemListByParam(ItemSearchInfo dto);
	
	/**
	 * 指定されたIDの商品情報を削除します。
	 * 
	 * @param itemId 商品ID
	 * @return 実行結果(エラー有無)
	 */
	public ItemDeleteResult deleteItemInfoById(String itemId);
}
