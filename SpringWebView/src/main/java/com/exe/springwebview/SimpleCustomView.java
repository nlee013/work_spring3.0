package com.exe.springwebview;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class SimpleCustomView extends AbstractView {

	//renderMergedOutputModel는 데이터를 출력하기 위해서 view를 합치는 기능 + rendering
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<body>");
		out.print("<h2>");
		out.print(model.get("message"));
		out.print("</h2>");
		out.print("</body>");
		out.print("</head>");
		out.print("</html>");
	}

}
