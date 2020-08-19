package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.MessageConstants;
import com.cts.exception.StoryNotFoundException;
import com.cts.feign.StoryFeignClient;
import com.cts.model.Story;
import com.cts.repository.StoryRepository;

@Service
@Transactional
public class StoryService implements IStoryService {

	@Autowired
	StoryRepository storyRepository;

	@Autowired
	StoryFeignClient storyFeignClient;
	
	
//........................................view all stories..........................
	public List<Story> getAllStory() {
		List<Story> storyList;
		try {
		storyList= (List<Story>) storyRepository.findAll();
		}
		catch(StoryNotFoundException e)
		{
			throw new StoryNotFoundException();
		}
		return storyList; 	
	}

	

//..........................Insert a new story.................................................

	public String addStory( Story story) {
			storyRepository.save(story);
			return MessageConstants.INSERT;
		}
		
//..............................Update story..........................................

	public String updateStory(Story story, Long updateid) throws StoryNotFoundException {
		
		storyRepository.findById(updateid).orElseThrow(() -> new StoryNotFoundException());
			storyRepository.save(story);
			return MessageConstants.UPDATE;
	}
	
	
//.............................Delete story...........................................
	public String deleteStory(Long deleteid) throws StoryNotFoundException {
			storyRepository.findById(deleteid).orElseThrow(() -> new StoryNotFoundException());
			storyRepository.deleteById(deleteid);
			return MessageConstants.DELETE;
		
	}

//...............................view assigned stories...................
	  public List<Story> getStoryByUsername(String username) {
		  
		  Long userid = storyFeignClient.getId(username);
		  
		  List<Story> storyList = (List<Story>)storyRepository.getstorylist(userid); 
		  if(storyList.isEmpty())
			  throw new StoryNotFoundException();
		  else 
			  return storyList; 	 
	  }

}