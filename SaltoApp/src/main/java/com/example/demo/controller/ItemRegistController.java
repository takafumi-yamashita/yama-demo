package com.example.demo.controller;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.ItemRegistMessage;
import com.example.demo.constant.MessageConst;
import com.example.demo.constant.UrlConst;
import com.example.demo.constant.ViewNameConst;
import com.example.demo.entity.ItemInfoSam;
import com.example.demo.form.ItemRegistForm;
import com.example.demo.service.ItemRegistService;
import com.example.demo.util.AppUtil;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー登録画面 Controller
 * 
 */
@Controller
@RequiredArgsConstructor
@Service
public class ItemRegistController {

	/** 商品登録画面 service */
	private final ItemRegistService service;

	/** メッセージソース */
	private final MessageSource messageSource;

	/**
	 * 初期表示
	 * @param model モデル
	 * @param form 入力画面
	 * @return 表示
	 */
	@GetMapping(UrlConst.ITEM_REGIST)
	public String view(Model model, ItemRegistForm form) {
		return ViewNameConst.ITEM_REGIST;
	}
	
	/**
	 * 商品情報登録
	 * @param model モデル
	 * @param form 入力情報
	 * @param bdResult 入力チェック結果
	 * @return 表示
	 */
	@PostMapping(UrlConst.ITEM_REGIST)
	public void itemRegist(Model model, @Validated ItemRegistForm form, BindingResult bdResult) {
		if(bdResult.hasErrors()) {
			editGuideMessage(model, MessageConst.FORM_ERROR, true);
			return;
		}
		var itemInfoOpt = service.registItemInfo(form);
		var itemMessage = judgeMessageKey(itemInfoOpt);
		editGuideMessage(model, itemMessage.getMessageId(), itemMessage.isError());
	}

	/**
	 * 画面に表示するガイドメッセージを設定する
	 * 
	 * @param model モデル
	 * @param messageId メッセージId
	 * @param isError エラーの有無
	 */
	public void editGuideMessage(Model model, String messageId, boolean isError) {
		var message = AppUtil.getMessage(messageSource, messageId);
		model.addAttribute("message", message);
		model.addAttribute("isError", isError);
	}

	/**
	 * 商品情報登録の結果メッセージキーを判断する
	 * 
	 * @param itemInfoOpt 商品登録結果(登録済みだった場合はEmpty)
	 * @return メッセージキー
	 */
	public ItemRegistMessage judgeMessageKey(Optional<ItemInfoSam> itemInfoOpt) {
		return ItemRegistMessage.SUCCEED;
	}
}
