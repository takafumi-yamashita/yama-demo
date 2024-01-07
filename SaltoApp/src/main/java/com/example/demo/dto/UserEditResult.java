package com.example.demo.dto;

import com.example.demo.constant.UserEditMessage;
import com.example.demo.entity.UserInfoSam;

import lombok.Data;

/**
 * ユーザー編集結果DTOクラス
 * 
 */
@Data
public class UserEditResult {

	/** ユーザー更新結果 */
	private UserInfoSam updateUserInfo;
	
	/** ユーザー更新結果メッセージEnum */
	private UserEditMessage updateMessage;
}
