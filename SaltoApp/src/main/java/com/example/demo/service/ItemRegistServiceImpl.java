package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ItemInfoSam;
import com.example.demo.form.ItemRegistForm;
import com.example.demo.repository.ItemInfoRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー登録画面 Service
 */
@Service
@RequiredArgsConstructor
public class ItemRegistServiceImpl implements ItemRegistService{

	/** 商品情報テーブルDAO*/
	private final ItemInfoRepository repository;
	
	/** DozerMapper*/
	private final Mapper mapper;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<ItemInfoSam> registItemInfo(ItemRegistForm form){
		var ItemInfoExistedOpt = repository.findById(form.getItemId());
		if (ItemInfoExistedOpt.isPresent()) {
			return Optional.empty();
		}
		var ItemInfo = mapper.map(form, ItemInfoSam.class);
		ItemInfo.setUpdateItem(form.getItemId());
		
		return Optional.of(repository.save(ItemInfo));
	}
}
