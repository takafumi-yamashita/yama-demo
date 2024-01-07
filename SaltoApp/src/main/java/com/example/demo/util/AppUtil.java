package com.example.demo.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

/*
 * アプリケーション共通クラス
 */
public class AppUtil {
	/**
	 * メッセージIDからメッセージを取得する
	 * 
	 * @param messageSource メッセージソース
	 * @param messageId メッセージID
	 * @param params 置換文字群
	 * @return プロパティファイルから取得したメッセージ
	 * 
	 */
	public static String getMessage(MessageSource messageSource, String messageId, Object...params) {
		return messageSource.getMessage(messageId, params, Locale.JAPAN);
	}
	
	/**
	 * DBのLIKE検索用に、パラメーターにワイルドカードを付与します。
	 * 
	 * @param param パラメーター
	 * @return 前後にワイルドカードが付いたパラメーター
	 */
	public static String addWildcard(String param) {
		return "%" + param + "%";
	}
	
	/**
	 * リダイレクト先のURLを受け取って、リダイレクトURLを作成します。
	 * 
	 * @param url リダイレクト先URL
	 * @return リダイレクトURL
	 */
	public static String doRedirect(String url) {
		return "redirect:" + url;
	}
}
