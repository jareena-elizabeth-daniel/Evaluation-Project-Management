package com.cts.service;

import java.util.List;
import com.cts.model.Story;

public interface IStoryService {
	
	public List<Story> getAllStory();
	public String addStory(Story story);
	public String updateStory(Story story,Long updateid);
	public String deleteStory(Long deleteid);
	public List<Story> getStoryByUsername(String username);
	
	
	
	

	

}
