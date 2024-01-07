package com.example.demo.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.ItemDeleteResult;
import com.example.demo.constant.SessionKeyConst;
import com.example.demo.constant.UrlConst;
import com.example.demo.constant.ViewNameConst;
import com.example.demo.dto.ItemSearchInfo;
import com.example.demo.form.ItemListForm;
import com.example.demo.service.ItemListService;
import com.example.demo.util.AppUtil;
import com.github.dozermapper.core.Mapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

/**
 * 商品一覧画面Controllerクラス
 *
 */
@Controller
@RequiredArgsConstructor
public class ItemListController {
	
	/** 商品一覧画面 */
	private final ItemListService service;
	
	/** Dozer Mapper */
	private final Mapper mapper;
	
	/** メッセージソース */
	private final MessageSource messageSource;
	
	/** セッションオブジェクト */
	private final HttpSession session;
	
	/** モデルキー:商品情報リスト */
	private static final String KEY_ITEMLIST = "itemList";

	/**
	 * 初期表示
	 * @param model モデル
	 * @param form 入力画面
	 * @return 表示
	 */
	@GetMapping(UrlConst.ITEM_LIST)
	public String view(Model model, ItemListForm form) {
		session.removeAttribute(SessionKeyConst.SELECTED_ITEM_ID);
		
		var itemInfos = service.editItemList();
		model.addAttribute(KEY_ITEMLIST, itemInfos);
		return ViewNameConst.ITEM_LIST;
	}
	
	/**
	 * 検索条件に合致するユーザー情報を画面に表示する
	 * 
	 * @param model
	 * @return 表示画面
	 */
	@PostMapping(value = UrlConst.ITEM_LIST, params = "search")
	public String searchItem(Model model, ItemListForm form) {
		var searchDto = mapper.map(form, ItemSearchInfo.class);
		var itemInfos = service.editItemListByParam(searchDto);
		model.addAttribute(KEY_ITEMLIST, itemInfos);
		return ViewNameConst.ITEM_LIST;
	}
	
	/**
	 * 商品情報の新規登録画面を表示する
	 * 
	 * @param model
	 * @return 表示画面
	 */
//	@PostMapping(value = UrlConst.ITEM_LIST, params = "regist")
//	public String registItem(Model model, ItemRegistForm registForm) {
//		return ViewNameConst.ITEM_REGIST;
//	}
	
	/**
	 * 選択行の商品情報を削除して、最新情報で画面を再表示します。
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return リダイレクトURL
	 */
	@PostMapping(value = UrlConst.ITEM_LIST, params = "edit")
	public String updateItem(ItemListForm form) {
		session.setAttribute(SessionKeyConst.SELECTED_ITEM_ID,form.getSelectedItemId());
		return AppUtil.doRedirect(UrlConst.ITEM_EDIT);
	}
	
	/**
	 * 選択行のユーザー情報を削除して、最新情報で画面を再表示します。
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@PostMapping(value = UrlConst.ITEM_LIST, params = "delete")
	public String deleteUser(Model model, ItemListForm form) {
		var executeResult = service.deleteItemInfoById(form.getSelectedItemId());
		model.addAttribute("isError", executeResult == ItemDeleteResult.ERROR);
		model.addAttribute("message", AppUtil.getMessage(messageSource, executeResult.getMessageId()));
		
		// 削除後、フォーム情報の「選択された商品ID」は不要になるため、クリアします。
		return searchItem(model, form.clearSelectedItemId());
	}
}
