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
		
		//���߿� ȸ�翡�� �ʿ�� �����ϸ� �ȴ�~�⺻ ���ø� ���� �ϸ� �ȴ�~
		Chapter chapter = new Chapter(new Paragraph("Spring PDF Message"), 1);//(�޼���, �������� ������)
		chapter.add(new Paragraph((String)model.get("message")));//object�� �ٲ���
		
		document.add(chapter);
	}

}