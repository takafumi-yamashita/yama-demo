package com.example.demo.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.ItemEditMessage;
import com.example.demo.constant.MessageConst;
import com.example.demo.constant.SessionKeyConst;
import com.example.demo.constant.UrlConst;
import com.example.demo.constant.ViewNameConst;
import com.example.demo.dto.ItemEditInfo;
import com.example.demo.dto.ItemUpdateInfo;
import com.example.demo.entity.ItemInfoSam;
import com.example.demo.form.ItemEditForm;
import com.example.demo.service.ItemEditService;
import com.example.demo.util.AppUtil;
import com.github.dozermapper.core.Mapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

/**
 * 商品編集画面Controllerクラス
 * 
 */
@Controller
@RequiredArgsConstructor
public class ItemEditController {

	/** 商品編集画面Serviceクラス */
	private final ItemEditService service;
	
	/** セッションオブジェクト */
	private final HttpSession session;
	
	/** Dozer Mapper */
	private final Mapper mapper;
	
	/** メッセージソース */
	private final MessageSource messageSource;
	
	/**
	 * 前画面で選択された商品IDに紐づく商品情報を画面に表示します。
	 * 
	 * @param model モデル
	 * @return 表示画面
	 * @throws Exception 
	 */
	@GetMapping(UrlConst.ITEM_EDIT)
	public String view(Model model, ItemEditForm form)throws Exception{
		var itemId = (String)session.getAttribute(SessionKeyConst.SELECTED_ITEM_ID);
		var itemInfoOpt = service.searchItemInfo(itemId);
		if (itemInfoOpt.isEmpty()) {
			model.addAttribute("message", AppUtil.getMessage(messageSource, MessageConst.ITEMEDIT_NON_EXISTED_ITEM_ID));
			return ViewNameConst.ITEM_EDIT_ERROR;
		}
		setupCommonInfo(model, itemInfoOpt.get());
		
		return ViewNameConst.ITEM_EDIT;
	}
	
	/**
	 * 画面の入力情報を元に商品情報を更新します。
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@PostMapping(value = UrlConst.ITEM_EDIT, params = "update")
	public String updateItem(Model model, ItemEditForm form) {
		var updateDto = mapper.map(form, ItemUpdateInfo.class);
		updateDto.setItemId((String)session.getAttribute(SessionKeyConst.SELECTED_ITEM_ID));
		
		var updateResult = service.updateItemInfo(updateDto);
		var updateMessage = updateResult.getUpdateMessage();
		if (updateMessage == ItemEditMessage.FAILED) {
			model.addAttribute("message", AppUtil.getMessage(messageSource, updateMessage.getMessageId()));
			return ViewNameConst.ITEM_EDIT_ERROR;
		}
		setupCommonInfo(model, updateResult.getUpdateItemInfo());
		
		model.addAttribute("isError", false);
		model.addAttribute("message", AppUtil.getMessage(messageSource, updateMessage.getMessageId()));
		
		return ViewNameConst.ITEM_EDIT;
	}
	
	/**
	 * 画面表示に必要な共通項目の設定を行います。
	 * 
	 * @param model モデル
	 * @param editedForm 入力済みのフォーム情報
	 */
	private void setupCommonInfo(Model model, ItemInfoSam ItemInfo) {
		model.addAttribute("itemEditForm", mapper.map(ItemInfo, ItemEditForm.class));
		model.addAttribute("itemEditInfo", mapper.map(ItemInfo, ItemEditInfo.class));
	}
}
