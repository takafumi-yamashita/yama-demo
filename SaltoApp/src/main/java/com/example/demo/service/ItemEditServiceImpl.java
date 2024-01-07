package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.constant.ItemEditMessage;
import com.example.demo.dto.ItemEditResult;
import com.example.demo.dto.ItemUpdateInfo;
import com.example.demo.entity.ItemInfoSam;
import com.example.demo.repository.ItemInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * 商品編集画面Service実装クラス
 */
@Service
@RequiredArgsConstructor
public class ItemEditServiceImpl implements ItemEditService{

	/** 商品情報テーブルRepository */
	private final ItemInfoRepository repository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<ItemInfoSam> searchItemInfo(String itemId) {
		return repository.findById(itemId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItemEditResult updateItemInfo(ItemUpdateInfo itemUpdateInfo) {
		var itemUpdateResult = new ItemEditResult();
		
		// 現在の登録情報を取得
		var updateInfoOpt = repository.findById(itemUpdateInfo.getItemId());
		if (updateInfoOpt.isEmpty()) {
			itemUpdateResult.setUpdateMessage(ItemEditMessage.FAILED);
			return itemUpdateResult;
		}
		
		// 画面の入力情報等をセット
		var updateInfo = updateInfoOpt.get();
		updateInfo.setItemName(itemUpdateInfo.getItemName());
		updateInfo.setItemPrice(itemUpdateInfo.getItemPrice());
		updateInfo.setItemStock(itemUpdateInfo.getItemStock());
		updateInfo.setUpdateTime(LocalDateTime.now());
		updateInfo.setUpdateItem(itemUpdateInfo.getUpdateItemId());
		
		try {
			repository.save(updateInfo);
		} catch (Exception e) {
			itemUpdateResult.setUpdateMessage(ItemEditMessage.FAILED);
			return itemUpdateResult;
		}
		
		itemUpdateResult.setUpdateItemInfo(updateInfo);
		itemUpdateResult.setUpdateMessage(ItemEditMessage.SUCCEED);
		return itemUpdateResult;
	}
	
}
