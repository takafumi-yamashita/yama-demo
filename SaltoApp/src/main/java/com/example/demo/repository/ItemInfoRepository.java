package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ItemInfoSam;

/**
 * ユーザー情報テーブルRepositoryクラス
 */
public interface ItemInfoRepository extends JpaRepository<ItemInfoSam,String>{

	/**
	 * 商品IDの部分一致検索を行います。
	 * 
	 * @param itemId 商品ID
	 * @return 検索でヒットした商品情報のリスト
	 */
	List<ItemInfoSam> findByItemIdLike(String itemId);
	
	/**
	 * 商品ID、商品名を使って検索を行います。
	 * 
	 * <p>■検索条件
	 * <lu>
	 * <li>商品ID：部分一致</li>
	 * <li>商品名：部分一致</li>
	 * </lu>
	 * </p>
	 * 
	 * @param itemId 商品ID
	 * @param itemName 商品名
	 * @return 検索でヒットした商品情報のリスト
	 */
	List<ItemInfoSam> findByItemIdLikeAndItemNameLike(String itemId, String itemName);
	
}