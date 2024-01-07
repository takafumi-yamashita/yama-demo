package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.constant.db.AuthorityKind;
import com.example.demo.constant.db.UserStatusKind;
import com.example.demo.entity.UserInfoSam;
import com.example.demo.form.SignupForm;
import com.example.demo.repository.UserInfoRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー登録画面 Service
 */
@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService{

	/** ユーザー情報テーブルDAO*/
	private final UserInfoRepository repository;
	
	/** DozerMapper*/
	private final Mapper mapper;

	/** PasswordEncoder */
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<UserInfoSam> resistUserInfo(SignupForm form){
		var userInfoExistedOpt = repository.findById(form.getLoginId());
		if (userInfoExistedOpt.isPresent()) {
			return Optional.empty();
		}
		var userInfo = mapper.map(form, UserInfoSam.class);
		var encodedPassword = passwordEncoder.encode(form.getPassword());
		userInfo.setPassword(encodedPassword);
		userInfo.setUserStatusKind(UserStatusKind.ENABLED);
		userInfo.setAuthorityKind(AuthorityKind.ITEM_WATCHER);
		userInfo.setCreateTime(LocalDateTime.now());
		userInfo.setUpdateTime(LocalDateTime.now());
		userInfo.setUpdateUser(form.getLoginId());
		
		return Optional.of(repository.save(userInfo));
	}
}
