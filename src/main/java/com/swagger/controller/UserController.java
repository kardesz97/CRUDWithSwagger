package com.swagger.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.entity.UserDemo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	Map<Long, UserDemo> users = Collections.synchronizedMap(new HashMap<Long, UserDemo>());

	@ApiOperation(value = "Get a list of users", notes = "Get a list of users")
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public List<UserDemo> getUsers() {
		List<UserDemo> user = new ArrayList<>(users.values());
		return user;
	}

	@ApiOperation(value = "Create a user", notes = "Create a user")
	@ApiImplicitParam(name = "user", value = "User entity", required = true, dataType = "User")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postUser(@RequestBody UserDemo user) {
		users.put(user.getId(), user);
		return "success";
	}

	@ApiOperation(value = "Get user details", notes = "Get detailed information according to the id of the url")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long", paramType = "path")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDemo getUser(@PathVariable Long id) {
		return users.get(id);
	}

	@ApiOperation(value = "Update information", notes = "According to the id of the url to specify to update the user information")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "Long", paramType = "path"),
			@ApiImplicitParam(name = "user", value = "User entity", required = true, dataType = "User") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateUser(@PathVariable Long id, @RequestBody UserDemo user) {
		UserDemo user1 = users.get(id);
		user1.setUsername(user.getUsername());
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setAge(user.getAge());
		user1.setPlaceOfBirth(user.getPlaceOfBirth());
		user1.setDateOfBirth(user.getDateOfBirth());
		user1.setGender(user.getGender());
		user1.setEmail(user.getEmail());
		users.put(id, user1);
		return "success";
	}

	@ApiOperation(value = "Delete user", notes = "According to the url to specify to delete the user")
	@ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "Long", paramType = "path")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		users.remove(id);
		return "success";
	}

	@ApiIgnore
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String jsonTest() {
		return " hi you!";
	}
}
