package com.exe.springdi4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTimeService implements TimeService{

	public String getTimeString() {
		
		//calendar 시간,날짜를 유지관리
		//new date 현재 날짜를 오로지 출력만 가능
		
		//날짜를 format 형식으로 만들겟다
		SimpleDateFormat sdf =
				(SimpleDateFormat)SimpleDateFormat.getDateTimeInstance(SimpleDateFormat.LONG, SimpleDateFormat.LONG);
		
		String now = sdf.format(new Date());
		
		return now;
	}

}
