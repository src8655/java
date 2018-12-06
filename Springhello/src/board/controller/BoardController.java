package board.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ibatis.sqlmap.client.SqlMapClient;

import board.*;
import board.model.Comment_Data;
import board.model.List_Data;
import board.model.List_Data_Xml_List;
import board.service.BoardService;
import board.service.Comment_Del_Validator;
import board.service.Comment_Write_Validator;
import board.service.List_Del_Validator;
import board.service.List_Edit_Validator;
import board.service.List_Write_Validator;

@Controller
public class BoardController {
	public static String savePathd = "/upload/";	//파일저장 상대경로
	public final static String view_cookie = "min_test_board_view";
	
	@Autowired
	BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}




	//리스트
	@RequestMapping("/board/board.do")
	public ModelAndView board(@RequestParam(value="pages", defaultValue="1") int pages) throws SQLException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board");
		mav.addObject("pages", pages);
		
		List<List_Data> list = new ArrayList();
		
		int count = boardService.getList_DataCount();
		Action_Paging paging = new Action_Paging(count, 6, pages);
		list = boardService.getList_Datas(paging.getBoard_starts(), paging.getBoard_ends());
		
		mav.addObject("list", list);
		mav.addObject("paging", paging);
		mav.addObject("board_cnt",0);
		
		return mav;
	}
	//게시글 작성
	@RequestMapping("/board/board_write.do")
	public ModelAndView board_write(@RequestParam(value="pages", defaultValue="1") int pages) {
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_write");
		mav.addObject("pages", pages);
		
		
		return mav;
	}
	//게시글 작성완료
	@RequestMapping("/board/board_write_post.do")
	public ModelAndView board_write_post(@ModelAttribute("ldata") List_Data ldata,
			BindingResult result,@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request,
			@RequestParam(value="files1", required=false) MultipartFile files1,
			@RequestParam(value="files2", required=false) MultipartFile files2,
			@RequestParam(value="lang", defaultValue="kr") String lang) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		new List_Write_Validator().validate(ldata, result);
		if(result.hasErrors()) {
			//ObjectError oerror = (ObjectError)result.getAllErrors().get(0);
			//mav.setViewName("board/error");
			//mav.addObject("msg",oerror.getCode());
			mav.setViewName("board/board_write");
			mav.addObject("pages", pages);
			return mav;
		}
		
		//업로드작업
		String savePaths=request.getRealPath(savePathd);	//저장위치 절대경로
		String filename1 = files1.getOriginalFilename();
		if(!filename1.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//이미 존재하면 카운트 증가
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"("+cnt+")"+filename1);
			}while(files_tmp.exists());
			files1.transferTo(files_tmp);
			ldata.setFile1(files_tmp.getName());
		}
		String filename2 = files2.getOriginalFilename();
		if(!filename2.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//이미 존재하면 카운트 증가
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"("+cnt+")"+filename2);
			}while(files_tmp.exists());
			files2.transferTo(files_tmp);
			ldata.setFile2(files_tmp.getName());
		}
		
		
		
		mav.setViewName("board/post");
		mav.addObject("msg","작성 성공.");
		mav.addObject("url","board.do?lang="+lang);
		
		Calendar cal = Calendar.getInstance();
		int years = cal.get(Calendar.YEAR);
		int months = cal.get(Calendar.MONTH)+1;
		int days = cal.get(Calendar.DATE);
		
		ldata.setDates(years+"-"+months+"-"+days);
		ldata.setPassword(Md5Enc.getEncMD5(ldata.getPassword().getBytes()));
		
		boardService.insertList_Data(ldata);
		
		
		return mav;
	}

	//게시글 보기
	@RequestMapping("/board/board_view.do")
	public ModelAndView board_view(@RequestParam(value="pages", defaultValue="1") int pages, @RequestParam(value="no", defaultValue="-1") int no,
			HttpServletResponse response, @CookieValue(value = view_cookie, defaultValue = "") String cookie) throws SQLException {
		
		
		//쿠키가없으면 새로입력
		if(cookie.equals("")) {
			response.addCookie(new Cookie(view_cookie, Integer.toString(no)));
			boardService.addHit(no);
		}else {
			String[] split = cookie.split("/");
			boolean hasNo = false;
			for(int i=0;i<split.length;i++)
				if(split[i].equals(Integer.toString(no)))
					hasNo = true;
			
			//쿠키에 no가 없으면 쿠키에 추가, 조회수 증가
			if(!hasNo) {
				response.addCookie(new Cookie(view_cookie, cookie+"/"+Integer.toString(no)));
				boardService.addHit(no);
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_view");
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		
		//게시글
		List_Data ldata = new List_Data();
		ldata = boardService.getList_Data(no);
		mav.addObject("ldata", ldata);
		
		//댓글
		List list = boardService.getComments(no);
		mav.addObject("list", list);
		
		return mav;
	}
	
	
	//게시글 삭제
	@RequestMapping("/board/board_del.do")
	public ModelAndView board_del(@RequestParam(value="pages", defaultValue="1") int pages, @RequestParam(value="no", defaultValue="-1") int no) throws SQLException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_del");
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		
		return mav;
	}
	//게시글 삭제 완료
	@RequestMapping("/board/board_del_post.do")
	public ModelAndView board_del_post(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@ModelAttribute("ldata") List_Data ldatas,
			BindingResult result,
			@RequestParam(value="lang", defaultValue="kr") String lang) throws SQLException {
		List_Data ldata = new List_Data();
		if(ldatas.getNo() != -1) ldata = boardService.getList_Data(ldatas.getNo());
		ldatas.setPassword(Md5Enc.getEncMD5(ldatas.getPassword().getBytes()));
		ldatas.setPassword2(ldata.getPassword());
		
		new List_Del_Validator().validate(ldatas, result);
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("board/board_del");
			mav.addObject("pages", pages);
			mav.addObject("no", ldatas.getNo());
			
			return mav;
		}
		
		boardService.delete(ldatas.getNo());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/post");
		mav.addObject("msg","삭제 성공.");
		mav.addObject("url","board.do?lang="+lang+"&pages="+pages);
		
		return mav;
	}
	//게시글 수정
	@RequestMapping("/board/board_edit.do")
	public ModelAndView board_edit(@RequestParam(value="pages", defaultValue="1") int pages, @RequestParam(value="no", defaultValue="-1") int no) throws SQLException {
		
		List_Data ldata = boardService.getList_Data(no);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_edit");
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		mav.addObject("ldata",ldata);
		
		return mav;
	}
	//게시글 수정
	@RequestMapping("/board/board_edit_post.do")
	public ModelAndView board_edit_post(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") int no,
			@ModelAttribute("ldata") List_Data ldata,
			BindingResult result,
			HttpServletRequest request,
			@RequestParam(value="files1", required=false) MultipartFile files1,
			@RequestParam(value="files2", required=false) MultipartFile files2,
			@RequestParam(value="del1", defaultValue="-1") int del1,
			@RequestParam(value="del2", defaultValue="-1") int del2,
			@RequestParam(value="lang", defaultValue="kr") String lang) throws SQLException, IllegalStateException, IOException {
		
		List_Data ldatas = boardService.getList_Data(no);
		ldata.setPassword(Md5Enc.getEncMD5(ldata.getPassword().getBytes()));
		ldata.setPassword2(ldatas.getPassword());

		ModelAndView mav = new ModelAndView();
		new List_Edit_Validator().validate(ldata, result);
		if(result.hasErrors()) {
			ObjectError oerror = (ObjectError)result.getAllErrors().get(0);
			mav.setViewName("board/error");
			mav.addObject("msg",oerror.getCode());
			return mav;
		}
		
		
		//업로드된 정보 삭제 요청시 삭제
		if(del1 == 1) ldata.setFile1("");
		else ldata.setFile1(ldatas.getFile1());
		if(del2 == 1) ldata.setFile2("");
		else ldata.setFile2(ldatas.getFile2());
		
		
		
		//업로드작업
		String savePaths=request.getRealPath(savePathd);	//저장위치 절대경로
		
		if(files1 != null) {
			String filename1 = files1.getOriginalFilename();
			if(!filename1.equals("")) {
				int cnt = 0;
				File files_tmp = null;
				//이미 존재하면 카운트 증가
				do {
					cnt++;
					files_tmp = new File(savePaths+"/"+"("+cnt+")"+filename1);
				}while(files_tmp.exists());
				files1.transferTo(files_tmp);
				ldata.setFile1(files_tmp.getName());
			}
		}
		if(files2 != null) {
			String filename2 = files2.getOriginalFilename();
			if(!filename2.equals("")) {
				int cnt = 0;
				File files_tmp = null;
				//이미 존재하면 카운트 증가
				do {
					cnt++;
					files_tmp = new File(savePaths+"/"+"("+cnt+")"+filename2);
				}while(files_tmp.exists());
				files2.transferTo(files_tmp);
				ldata.setFile2(files_tmp.getName());
			}
		}	
				
				
		mav.setViewName("board/post");
		mav.addObject("msg","수정 성공.");
		mav.addObject("url","board_view.do?lang="+lang+"&pages="+pages+"&no="+no);
		
		boardService.update(ldata);
		
		return mav;
	}

	//댓글작성
	@RequestMapping("/board/board_comment_post.do")
	public ModelAndView board_comment_post(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@ModelAttribute("cdata") Comment_Data cdata,
			BindingResult result,
			@RequestParam(value="lang", defaultValue="kr") String lang) throws SQLException, IllegalStateException, IOException {
		

		ModelAndView mav = new ModelAndView();
		new Comment_Write_Validator().validate(cdata, result);
		if(result.hasErrors()) {
			ObjectError oerror = (ObjectError)result.getAllErrors().get(0);
			mav.setViewName("board/error");
			mav.addObject("msg",oerror.getCode());
			return mav;
		}
		
		Calendar cal = Calendar.getInstance();
		int years = cal.get(Calendar.YEAR);
		int months = cal.get(Calendar.MONTH)+1;
		int days = cal.get(Calendar.DATE);
		
		cdata.setDates(years+"-"+months+"-"+days);
		cdata.setPassword(Md5Enc.getEncMD5(cdata.getPassword().getBytes()));
		
		//답답글이면
		if(!cdata.getRt_no().equals("-1")) {
			Comment_Data cdata_tmp = boardService.getArticleComment(cdata.getRt_no());	//답글대상 댓글 가져오기
			int levels = cdata_tmp.getLevels()+1;										//레벨은 현 답글의 다음레벨
			
			int add = 1;	//단위
			for(int i=0;i<levels;i++)
				add *= 10;
			
			String no_tmp = cdata.getRt_no();
			List list = boardService.getArticle_rtComment(cdata);						//같은 댓글을 답변하는 리스트
			if(list.size() != 0) no_tmp = ((Comment_Data)list.get(0)).getNo();			//같은 댓글을 답변하는 리스트가 있다면

			System.out.println(no_tmp);
			String[] splt = no_tmp.split(":");
			System.out.println(splt.length);
			if(splt.length == 2) {						//소수점이 있을경우
				String tmp = reverseString(splt[1]);	//소수점 뒤를 리버스
				int tmp_int = Integer.parseInt(tmp);	//정수로바꾸고
				tmp_int += add;							//단위를 더함
				tmp = Integer.toString(tmp_int);		//문자열로바꾸고
				tmp = reverseString(tmp);				//다시 리버스
				no_tmp = splt[0]+":"+tmp;
			}else {
				int tmp_int = add;
				String tmp = Integer.toString(tmp_int);
				tmp = reverseString(tmp);
				no_tmp = no_tmp+":"+tmp;
			}
			
			cdata.setNo(no_tmp);
			cdata.setLevels(levels);
			
			
			boardService.insertComment_No(cdata);
		}else {
			boardService.insertComment(cdata);
		}
		
		mav.setViewName("board/post");
		mav.addObject("msg","댓글등록 성공.");
		mav.addObject("url","board_view.do?lang="+lang+"&pages="+pages+"&no="+cdata.getBoard_no());
		
		return mav;
	}
	String reverseString(String tmp) {
		StringBuffer sb = new StringBuffer();
		char[] array = tmp.toCharArray();
		for(int i=array.length-1;i>=0;i--)
			sb.append(array[i]);
		return sb.toString();
	}
	//댓글삭제
	@RequestMapping("/board/board_comment_del.do")
	public ModelAndView board_comment_del(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") String no,
			@RequestParam(value="board_no", defaultValue="-1") int board_no) throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/board_comment_del");
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		mav.addObject("board_no",board_no);
		
		return mav;
	}
	//댓글삭제 완료
	@RequestMapping("/board/board_comment_del_post.do")
	public ModelAndView board_comment_del_post(
			@ModelAttribute("cdata") Comment_Data cdata,
			BindingResult result,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") String no,
			@RequestParam(value="board_no", defaultValue="-1") int board_no,
			@RequestParam(value="password", defaultValue="") String password,
			@RequestParam(value="lang", defaultValue="") String lang) throws SQLException {
		
		Comment_Data cdatas = boardService.getArticleComment(no);
		cdata.setPassword(Md5Enc.getEncMD5(cdata.getPassword().getBytes()));
		cdata.setPassword2(cdatas.getPassword());

		ModelAndView mav = new ModelAndView();
		new Comment_Del_Validator().validate(cdata, result);
		if(result.hasErrors()) {
			ObjectError oerror = (ObjectError)result.getAllErrors().get(0);
			mav.setViewName("board/error");
			mav.addObject("msg",oerror.getCode());
			return mav;
		}
		
		boardService.deleteComment(no);
		
		mav.setViewName("board/post");
		mav.addObject("msg", "삭제 완료");
		mav.addObject("url", "board_view.do?no="+board_no+"&pages="+pages+"&lang="+lang);
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//다운로드
	@RequestMapping("/board/download.do")
	public ModelAndView down(@RequestParam("filename") String filename, HttpServletRequest request) {
		String savePaths = request.getRealPath(savePathd);
		File file = new File(savePaths + "/" + filename);
		ModelAndView mav = new ModelAndView("down", "downloadfile", file);
		return mav;
	}
	//엑셀로 다운로드
	@RequestMapping("/board/download_excel.do")
	public ModelAndView down_excel(@RequestParam(value="pages", defaultValue="1") int pages) throws SQLException {
		List list = new ArrayList();
		
		int count = boardService.getList_DataCount();
		Action_Paging paging = new Action_Paging(count, 6, pages);
		list = boardService.getList_Datas(paging.getBoard_starts(), paging.getBoard_ends());
		
		Map map = new HashMap();
		map.put("list_data", list);
		map.put("paging", paging);
		map.put("pages", pages);
		
		ModelAndView mav = new ModelAndView("list_data_excel_class", "map", map);
		return mav;
	}
	
	
	//AJAX (비밀번호 제외하고 가져오기)
	//json으로 변환(MappingJacksonJsonView)
	@RequestMapping("/board/ajax_test22.do")
	public ModelAndView ajax_test22(@RequestParam(value="search_value", defaultValue="") String search_value) throws SQLException{
		List list = boardService.getList_Datas_Ajax(search_value);
		ModelAndView mav = new ModelAndView("pageJsonReport","list",list);
		return mav;
	}
	//XML로 변환(MappingJacksonJsonView)
	@RequestMapping("/board/toxml.do")
	public ModelAndView toxml(@RequestParam(value="pages", defaultValue="1") int pages) throws SQLException{
		List list = new ArrayList();
		
		int count = boardService.getList_DataCount();
		
		Action_Paging paging = new Action_Paging(count, 6, pages);
		list = boardService.getList_Datas_Xml(paging.getBoard_starts(), paging.getBoard_ends());
		
		List_Data_Xml_List ldxl = new List_Data_Xml_List();
		ldxl.setList(list);
		
		ModelAndView mav = new ModelAndView("pageXmlReport","ldxl",ldxl);
		return mav;
	}
	
	//AJAX
	//json으로 변환(MappingJacksonHttpMessageConverter)
	@RequestMapping("/board/ajax_test2.do")
	@ResponseBody
	public List ajax_test2(@RequestParam(value="search_value", defaultValue="") String search_value) throws SQLException{
		List list = boardService.getList_Datas_Ajax(search_value);
		return list;
	}
	
	//XML로변환
	@RequestMapping("/board/ajax_test3.do")
	@ResponseBody
	public List_Data_Xml_List ajax_test3(@RequestParam(value="search_value", defaultValue="") String search_value) throws SQLException{
		List list = boardService.getList_Datas_Ajax(search_value);
		List_Data_Xml_List ldxl = new List_Data_Xml_List();
		ldxl.setList(list);
		return ldxl;
	}
	
	
}
