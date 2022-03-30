package com.exe.springwebview;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class CustomPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//나중에 회사에서 필요시 공부하면 된다~기본 샘플링 보고 하면 된다~
		Chapter chapter = new Chapter(new Paragraph("Spring PDF Message"), 1);//(메세지, 보여지는 페이지)
		chapter.add(new Paragraph((String)model.get("message")));//object로 바꿔줌
		
		document.add(chapter);
	}

}
