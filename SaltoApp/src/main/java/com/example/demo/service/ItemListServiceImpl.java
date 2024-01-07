package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.constant.ItemDeleteResult;
import com.example.demo.dto.ItemListInfo;
import com.example.demo.dto.ItemSearchInfo;
import com.example.demo.entity.ItemInfoSam;
import com.example.demo.repository.ItemInfoRepository;
import com.example.demo.util.AppUtil;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemListServiceImpl implements ItemListService{

	/** 商品情報テーブルDAO */
	private final ItemInfoRepository repository;
	
	/** Dozer Mapper */
	private final Mapper mapper;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ItemListInfo> editItemList(){
		return toItemListInfos(repository.findAll());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ItemListInfo> editItemListByParam(ItemSearchInfo dto){
		return toItemListInfos(findItemInfoByParam(dto));
	}
	
	/**
	 * 商品情報の条件検索を行い、検索結果を返却します。
	 * 
	 * @param form 入力情報
	 * @return 検索結果
	 */
	private List<ItemInfoSam> findItemInfoByParam(ItemSearchInfo dto){
		var itemIdParam = AppUtil.addWildcard(dto.getItemId());
		var itemNameParam = AppUtil.addWildcard(dto.getItemName());
		
		
		if (dto.getItemName() != null) {
			return repository.findByItemIdLikeAndItemNameLike(itemIdParam, itemNameParam);
		}else {
			return repository.findByItemIdLike(itemIdParam);
		}
	}
	
	/**
	 * 商品情報EntityのListを商品一覧情報DTOのListに変換します。
	 * 
	 * @param itemInfos 商品情報EntityのList
	 * @return 商品一覧情報DTOのList
	 */
	private List<ItemListInfo> toItemListInfos(List<ItemInfoSam> itemInfos) {
		var itemListInfos = new ArrayList<ItemListInfo>();
		for (ItemInfoSam itemInfo : itemInfos) {
			var itemListInfo = mapper.map(itemInfo, ItemListInfo.class);
			itemListInfos.add(itemListInfo);
		}

		return itemListInfos;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItemDeleteResult deleteItemInfoById(String itemId) {
		var itemInfo = repository.findById(itemId);
		if(itemInfo.isEmpty()) {
			return ItemDeleteResult.ERROR;
		}
		
		repository.deleteById(itemId);
		
		return ItemDeleteResult.SUCCEED;
	}
	
}
