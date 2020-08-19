package com.cts.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "userclient", fallback = UserIdFallback.class )
@FeignClient(name = "userclient" )

public interface StoryFeignClient {
	
	
	@GetMapping("/assignedstory/{username}")
	public Long getId(@PathVariable String username);
	

}


