package com.cts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.feign.StoryFeignClient;
import com.cts.model.Story;
import com.cts.service.IStoryService;

@RestController
@Validated
public class StoryController {
	
	
	@Autowired
	IStoryService iStoryService;
	
	@Autowired
	StoryFeignClient storyFeignClient;
	
	
	@PostMapping("/access/insertstory")
	public String addStory(@Valid @RequestBody Story story) {
		return iStoryService.addStory(story);		
		
	}
	
	@GetMapping("/access/allstories")
	public List<Story> getAllStory(){
		return iStoryService.getAllStory();
	}
	

	@PutMapping(value = "/access/updatestory")
	public String updateStory(@RequestBody Story story,@RequestParam Long updateid) {
		return iStoryService.updateStory(story,updateid);
	}
	
	
	@RequestMapping(value = "/access/deletestory", method = RequestMethod.DELETE)
	public String deleteStory(@RequestParam Long deleteid) {
		return iStoryService.deleteStory(deleteid);
		
	}

//...........Method to view assigned stories (using Feign client).............
	@GetMapping("/assignedstory/{username}")
	public List<Story> getStoryByUserId(@PathVariable String username) {
	    return iStoryService.getStoryByUsername(username) ;
	}
	
}