package com.ank.noteshelf.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ank.noteshelf.resource.ProfileInput;
import com.ank.noteshelf.resource.UserLoginDetail;
import com.ank.noteshelf.service.ProfileService;
import com.ank.noteshelf.vo.ProfileVO;

@RequestMapping("/profile")
@RestController
public class ProfileController {

	/**
	 * To support following api's
	 * 
	 * PUT /profile/deactivate
	 * */
	
	@Autowired
	ProfileService profileService;
	
	public static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@GetMapping
	public ResponseEntity<ProfileVO> getProfileByUserId(HttpSession session){
		
		ProfileVO profileVO = null;
		ResponseEntity<ProfileVO> response = null;
		
		UserLoginDetail userLoginDetail = (UserLoginDetail) session.getAttribute("userLoginDetail");
		profileVO = profileService.getProfileByUserId(userLoginDetail.getUserId());
		HttpStatus status = profileVO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		response = new ResponseEntity<>(profileVO, status);
		return response;
	}
	
	@PutMapping
	public ResponseEntity<ProfileVO> updateProfileByUserId(@RequestBody @Valid ProfileInput profileInput, HttpSession session){
		
		ResponseEntity<ProfileVO> response = null;
		UserLoginDetail userLoginDetail = (UserLoginDetail) session.getAttribute("userLoginDetail");
		ProfileVO profileVo = profileService.updateProfile(profileInput, userLoginDetail.getUserId());
		
		HttpStatus status = profileVo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		response = new ResponseEntity<>(profileVo, status);
		return response;
	}
	
	/**
	 * <code>deleteProfileByUserId</code> - Delete Profile from the user id
	 * @return ResponseEntity<Boolean>
	 * */
	@DeleteMapping
	public ResponseEntity<Boolean> deleteProfileByUserId(HttpSession session) {

		/**
		 * If the delete target doesn't exist, return 404(Not Found). 
		 * In some special case, the server take the delete request, 
		 * but will delete the resource in async way, 
		 * which means return client a 202(Accept) before the resource really get deleted.
		 * */
		
		Boolean isDeleted = null;
		ResponseEntity<Boolean> response = null;

		UserLoginDetail userLoginDetail = (UserLoginDetail) session.getAttribute("userLoginDetail");
		isDeleted = profileService.deleteProfileByUserId(userLoginDetail.getUserId());

		HttpStatus status = isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		response = new ResponseEntity<>(isDeleted, status);
		return response;
	}
	
	
	
	
	
}
