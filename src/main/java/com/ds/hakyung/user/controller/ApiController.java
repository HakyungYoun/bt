package com.ds.hakyung.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ds.hakyung.user.DeptService;
import com.ds.hakyung.user.HobbyService;
import com.ds.hakyung.user.UserService;
import com.ds.hakyung.user.domain.DeptDto;
import com.ds.hakyung.user.domain.HobbyDataDto;
import com.ds.hakyung.user.domain.HobbyDto;
import com.ds.hakyung.user.domain.UserDto;

@RestController
public class ApiController {
	@Resource(name="UserService")
	UserService service;
	
	@Resource(name="DeptService")
	DeptService service2;
	
	@Resource(name="HobbyService")
	HobbyService service3;
	
	@GetMapping("/deptList")
	public List<DeptDto> getDeptList(DeptDto dto){
		return service2.getList(dto);
	}
	@GetMapping("/hobbyList")
	public List<HobbyDto> getHobbyList(HobbyDto dto2){
		return service3.getList(dto2);
	}
	@PostMapping("/userInsert")
	public ResponseEntity<UserDto> insertUser(@RequestBody UserDto dto3) {
        service.insert(dto3);
        return ResponseEntity.ok(dto3);
	}
	@PostMapping("/hobbyDataInsert")
	public ResponseEntity<HobbyDataDto> hobbyInsert(@RequestBody HobbyDataDto dto4) {
		service3.insertHobby(dto4);
        return ResponseEntity.ok(dto4);
	}
	@GetMapping("/userIdCheck")
	public boolean userIdCheck(UserDto dto3) {
		return service.userIdCheck(dto3);
	}
	@GetMapping("/userList")
	public List<UserDto> userList(UserDto dto3) {
		return service.getList(dto3);
	}
	@GetMapping("/userSearchList")
	public List<UserDto> userSearchList(UserDto dto3) {
		return service.getSearchList(dto3);
	}
	@GetMapping("/userInfo")
	public UserDto userInfo1(UserDto dto3) {
		return service.getInfo(dto3);
	}
	@GetMapping("/userHobbyInfo")
	public List<UserDto> userHobbyInfo(UserDto dto3) {
		return service.getHobbyList(dto3);
	}
	@PostMapping("/userUpdate")
	public ResponseEntity<UserDto> userUpdate(@RequestBody UserDto dto3) {
		service.update(dto3);
        return ResponseEntity.ok(dto3);
}
	@PostMapping("/userHobbyDelete")
	public ResponseEntity<HobbyDataDto> userHobbyDelete(@RequestBody HobbyDataDto dto4) {
		service3.delete(dto4);
        return ResponseEntity.ok(dto4);
}
	@PostMapping("/userDelete")
	public ResponseEntity<UserDto> userDelete(@RequestBody UserDto dto3) {
		service.delete(dto3);
        return ResponseEntity.ok(dto3);
}
}
