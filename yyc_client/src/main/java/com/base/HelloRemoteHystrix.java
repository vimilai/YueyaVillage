package com.base;

import org.springframework.stereotype.Component;

@Component
public class HelloRemoteHystrix implements HelloRemote{


	public ResultMessage getRankTop10() {
		 return ResultMessage.createErrorsMessage("111", "thsi is eroor");
	}
}