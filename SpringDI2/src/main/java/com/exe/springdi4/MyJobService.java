package com.exe.springdi4;

import org.springframework.stereotype.Component;

@Component("jobService")
public class MyJobService implements JobService{

	public void getJob() {
		
		System.out.println("난 말이야~ 프로그래머야~ 후훗");
	}

}
