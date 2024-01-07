package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * 商品情報テーブル Entity
 */
@Entity
@Table(name = "item_info_sam")
@Data
@AllArgsConstructor
public class ItemInfoSam {
	
	/** 商品ID */
	@Id
	@Column(name = "item_id")
	private String itemId;
	
	/** 商品名 */
	@Column(name = "item_name")
	private String itemName;
	
	/** 単価 */
	@Column(name = "item_price")
	private int itemPrice;
	
	/** 在庫数量 */
	@Column(name = "item_stock")
	private int itemStock;
	
	/** 登録日時 */
	@Column(name = "create_time")
	private LocalDateTime createTime;
	
	/** 最終更新日時 */
	@Column(name = "update_time")
	private LocalDateTime updateTime;
	
	/** 最終更新商品 */
	@Column(name = "update_item")
	private String updateItem;
	
	/**
	 * デフォルトコンストラクタ
	 */
	public ItemInfoSam() {	
	}

}
