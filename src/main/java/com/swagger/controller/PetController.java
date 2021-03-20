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

import com.swagger.entity.Pet;
import com.swagger.entity.UserDemo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value = "/pets")
public class PetController {
	Map<Long, Pet> pets = Collections.synchronizedMap(new HashMap<Long, Pet>());

	@ApiOperation(value = "Get a list of pets", notes = "Get a list of pets")
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public List<Pet> getPets() {
		List<Pet> pet = new ArrayList<>(pets.values());
		return pet;
	}

	@ApiOperation(value = "Create a pet", notes = "Create a pet")
	@ApiImplicitParam(name = "pet", value = "Pet entity", required = true, dataType = "Pet")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postPet(@RequestBody Pet pet) {
		pets.put(pet.getId(), pet);
		return "success";
	}

	@ApiOperation(value = "Get pet details", notes = "Get detailed information according to the id of the url")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long", paramType = "path")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Pet getPet(@PathVariable Long id) {
		return pets.get(id);
	}

	@ApiOperation(value = "Update information", notes = "According to the id of the url to specify to update the pet information")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "Long", paramType = "path"),
			@ApiImplicitParam(name = "pet", value = "Pet entity", required = true, dataType = "Pet") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updatePet(@PathVariable Long id, @RequestBody Pet pet) {
		Pet pet1 = pets.get(id);
		pet1.setName(pet.getName());
		pet1.setAge(pet.getAge());
		pet1.setDateOfBirth(pet.getDateOfBirth());
		pet1.setGender(pet.getGender());
		pets.put(id, pet1);
		return "success";
	}

	@ApiOperation(value = "Delete pet", notes = "According to the url to specify to delete the pet")
	@ApiImplicitParam(name = "id", value = "Pet ID", required = true, dataType = "Long", paramType = "path")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deletePet(@PathVariable Long id) {
		pets.remove(id);
		return "success";
	}

	@ApiIgnore
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String jsonTest() {
		return " hi you!";
	}
}
