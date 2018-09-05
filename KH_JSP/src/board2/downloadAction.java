package board2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class downloadAction
 */
public class downloadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public downloadAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("file");	// filename�� getParameter()�޼���� ���´�.
		
		String directory = this.getServletContext().getRealPath("/upload/");
		File file = new File(directory + "/" + fileName);
		
		String mimeType = getServletContext().getMimeType(file.toString());
		if(mimeType == null) {	// ������ �߻������ʵ��� ó���ϴºκ���.
			response.setContentType("application/octet-stream");	// 2�������� ���޽� octet-stream���
		}
		
		String downloadName = null;	// ������ �ٿ�ε� ���� ����
		if (request.getHeader("user-agent").indexOf("MSIE") == -1) {	// �������� ���� �ٸ��� ����
			downloadName = new String(fileName.getBytes("UTF-8"), "8859_1");
		} else {
			downloadName = new String(fileName.getBytes("EUC-KR"), "8859_1");
		}
		
		response.setHeader("content-Disposition", "attachment;filename=\""+ downloadName + "\";");

		FileInputStream fileInputStream = new FileInputStream(file);
		ServletOutputStream servletOutputStream = response.getOutputStream();
		
		byte b[] = new byte[1024];
		int data = 0;
		
		while ((data = (fileInputStream.read(b, 0, b.length))) != -1) {
			servletOutputStream.write(b,0,data);
		}
		
		servletOutputStream.flush();
		servletOutputStream.close();
		fileInputStream.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
