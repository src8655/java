package com.myjob.ext;

import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView  {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//다운로드할 파일을 받아옴
		File file = (File)model.get("downloadfile");
		
		response.setContentType("application/download;charset=utf-8");
		response.setContentLength((int) file.length());
		String fname = URLEncoder.encode(file.getName(), "utf-8");
		response.setHeader("Content-disposition", "attachment;filename=\""+fname+"\";");
		response.setHeader("Content-Transfer-encoding", "binary");
		
		try {
			OutputStream os = response.getOutputStream();
			InputStream is = new FileInputStream(file);
			FileCopyUtils.copy(is, os);
			is.close();
			os.flush();
		} catch (Exception e) {}
	}

}
