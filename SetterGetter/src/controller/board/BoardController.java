package controller.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardBean;
import model.MemberBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.BoardDao;
import dao.MemberDao;

@Controller
public class BoardController {

		private BoardDao boardService;
		private MemberDao memberService;
		
		public void setMemberService(MemberDao memberService) {
			this.memberService = memberService;
		}	// 회원 정보 DB

		public void setBoardService(BoardDao boardService) {
			this.boardService = boardService;
		}	// 게시판 정보 DB
		
		/* ==============  페이징 관련  ============== */
		private final static int pageSize = 10;			// 한 페이지 당 보여줄 글 갯수
		private final static int pageGroupSize = 5;		// 페이지그룹안의 페이지 갯수
														// ex) [이전] 1 2 3 4 5 [다음]  일 경우 페이지 갯수는 5	

		/* ==============  게시판 목록  ============== */
		@RequestMapping(value="board_list.do", method=RequestMethod.GET)
		public ModelAndView board_list(HttpServletRequest request,
				HttpServletResponse response) throws Exception{

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			
			String no = request.getParameter("pageNum");	// 페이징 번호를 받아서  정보가 없으면 1값을 줘서 int  타입으로 다시저장 
			if(no == null){ // 기본적으로 페이징 첫페이지 위한 번호
				no = "1";
			}

			int pageNum = Integer.parseInt(no);				// 현재 페이징유지 위한 번호
			int startRow = (pageNum - 1) * pageSize + 1;	// 한 페이지의 시작글 번호
			int endRow = pageNum * pageSize; 	// 한 페이지의 마지막 글 번호
			int count = 0;						// 총게시물 수 
			int number = 0;			// 총게시물 수 에서 해당 페이징의 마지막 게시물 수
			

		String search = request.getParameter("search");	//검색하기위한 문자열
		
		List<BoardBean> boardList = new ArrayList<BoardBean>();  
		//DB 에서 게시판 내용을 가져 와 BoardBean 타입으로 가져온다.
		System.out.println("GET search : " + search);
		if(search != null){
//			if(search.equals("")!= false){
			
				count = this.boardService.getSearchCnt(search);	// 총게시물수 파악 DB

				if(count > 0){
					if(endRow > count)
						endRow = count;
					
				Map<String, Object> pageRow = new HashMap<String, Object>();
				
				pageRow.put("startRow", startRow);
				pageRow.put("endRow", endRow);
				pageRow.put("search", search);
				
				boardList = this.boardService.searchCont(pageRow);
				request.setAttribute("search", search);
//			}
			}
		}else{
			count = this.boardService.getTotalCnt();	// 총게시물수 파악 DB


			if(count > 0){
				if(endRow > count)
					endRow = count;
				
				Map<String, Object> pageRow = new HashMap<String, Object>();
				
					pageRow.put("startRow", startRow);
					pageRow.put("endRow", endRow);
				
				boardList = this.boardService.boardListGet(pageRow);		// 현재 페이지에 해당하는 글 목록

			}else{
				boardList = null;
			}
		}
			number = count - (pageNum - 1) * pageSize;		// 글목록에 표시할 글번호
			
			// 페이지 그룹의 갯수
			// ex) pageGroupSize 가 3일 경우 '[1][2][3]'가 pageGroupCount 개 만큼 있다.
			int pageGroupCount = count / (pageSize * pageGroupSize) + (count % (pageSize * pageGroupSize) == 0 ? 0 : 1);
			
			// 페이지그룹 번호
			// ex) pageGroupSize가 3일 경우 '[1][2][3]'의 페이지 그룹번호는 1이고 '[2][3][4]' 의 페이지그룹번호는 2이다.
			int numPageGroup = (int)Math.ceil((double)pageNum / pageGroupSize);
			
			// 오늘 날자 불러오기 위한 함수
			SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd"); //yyyy-MM-dd HH:mm:ss 년-월-일-시간-분-초 출력 
			Date toDay = new Date(); 
			String nowDay = day.format(toDay);
			
			// 해당 뷰에서 사용할 속성
			request.setAttribute("startRow", new Integer(startRow));
			request.setAttribute("endRow", new Integer(endRow));
			request.setAttribute("count", new Integer(count));
			request.setAttribute("pageSize", new Integer(pageSize));
			request.setAttribute("number", new Integer(number));
			request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
			request.setAttribute("numPageGroup", new Integer(numPageGroup));
			request.setAttribute("pageGroupCount", new Integer(pageGroupCount));
			request.setAttribute("pageNum", new Integer(pageNum));
			request.setAttribute("boardList", boardList);
			request.setAttribute("toDay", nowDay);
			request.setAttribute("search", search);
			

			System.out.println("========= 각페이지 정보숫자 =========");
			System.out.println("pageNum : " + pageNum);					// 현재 페이징유지 위한 번호
			System.out.println("startRow : " + startRow);				// 한 페이지의 시작글 번호
			System.out.println("endRow : " + endRow);					// 한 페이지의 마지막 글 번호
			System.out.println("count : " + count);						// 총게시물 수
			System.out.println("number : " + number);					// 총게시물 수 에서 해당 페이징의 마지막 게시물 수
			System.out.println("pageSize : " + pageSize);				// 한 페이지 당 보여줄 글 갯수
			System.out.println("pageGroupSize : " + pageGroupSize);		// 페이지그룹안의 페이지 갯수
			System.out.println("numPageGroup : " + numPageGroup);		// 페이지그룹 번호
			System.out.println("pageGroupCount : " + pageGroupCount);	// 페이지 그룹의 갯수
			System.out.println("=====================================");
			
			if(boardList == null){
				out.println("<script>");
				out.println("alert('리스트가 없습니다.')");
				out.println("location.href='board_write.do'");
				out.println("</script>");
				return null;
			} // 게시물이 없을시 글쓰기로 들어가기
			
			ModelAndView modelAndView = new ModelAndView();
			
			modelAndView.addObject("boardList",boardList);
			modelAndView.setViewName("board_list");

			return modelAndView;
		}
		@RequestMapping(value="board_list.do", method=RequestMethod.POST)
		public ModelAndView board_search(HttpServletRequest request,
				HttpServletResponse response,  HttpSession session) throws Exception{
			
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();

			String search = request.getParameter("search").trim();
			System.out.println("POST search : " + search);
			String id = (String) session.getAttribute("id");

			
			
			out.println("<script>");
			out.println("location.href='board_list.do?search="+search+"'");
			out.println("</script>");
			
			

			return null;
		}


		/* ==============  게시판 작성  =============== */
		@RequestMapping(value="board_write.do", method=RequestMethod.GET)
		public ModelAndView board_write(HttpServletRequest request, 
				HttpServletResponse response, HttpSession session) 
						throws SQLException, IOException{
			ModelAndView modelAndView = new ModelAndView();
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			String id = (String) session.getAttribute("id");			// 로그인 아이디
			int pageNum = 0;
			
			/* 현재 페이지 번호가 없을때 임의로 번호를 넣주는 작업 */
			if(request.getParameter("pageNum")==null){		
				pageNum = 1; 	
			}else if(request.getParameter("pageNum")!=null){
				pageNum = Integer.parseInt(request.getParameter("pageNum"));	// 현재 페이징 번호
			}
			
			if(id == null){	// 로그인 해야 작성가능
				out.println("<script>");
				out.println("alert('로그인 후 이용가능합니다.')");
				out.println("location.href='login.do?pageNum=" + pageNum + "'");
				out.println("</script>");
				return null;
			}
			
			MemberBean info = new MemberBean();
			info = (MemberBean)this.memberService.boardInfo(id);	// 로그인했을시 개인정보 불러오기.
			
			modelAndView.addObject("pageNum", pageNum);
			modelAndView.addObject("boardInfo", info);	// 작성시 기본 이름, 이메일 불러오기
			modelAndView.setViewName("board_write");
			return modelAndView;
		}
		
		@RequestMapping(value="board_write.do", method=RequestMethod.POST)
		public ModelAndView board_write_ok(HttpServletRequest request, 
				HttpServletResponse response, HttpSession session) 
						throws SQLException, IOException{
			ModelAndView modelAndView = new ModelAndView();
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			String id = (String) session.getAttribute("id");				int section = Integer.parseInt((String) session.getAttribute("section"));
			String title = request.getParameter("title").trim();			String name = request.getParameter("name").trim(); 
			String email1 = request.getParameter("email1").trim();			String email2 = request.getParameter("email2").trim(); 
			String cont = request.getParameter("cont").trim();				String pwd = request.getParameter("pwd").trim(); 
			String secret= request.getParameter("secret");	
			// secret = 0 : 공개글 
			// secret = 1 : 비밀글
			int comment_total = 0;		// 댓글 수
			// reply_select_no 답글 할때 필요한 번호 board_no 같으면 됨. 
			int reply_level = 0; 		// 일반글 = 0, 댓글 = 1이상
			int reply_seq = 0; 			// 댓글 번호
			int hit = 0;				// 조회수
			
			BoardBean boardBean = new BoardBean();
			
			boardBean.setBoard_id(id);							boardBean.setBoard_section(section);
			boardBean.setBoard_title(title);					boardBean.setBoard_name(name);
			boardBean.setBoard_email1(email1);					boardBean.setBoard_email2(email2);
			boardBean.setBoard_cont(cont);						boardBean.setBoard_pwd(pwd);
			boardBean.setBoard_secret(secret);					boardBean.setcomment_total(comment_total);
			boardBean.setReply_level(reply_level);				boardBean.setReply_seq(reply_seq);					
			boardBean.setHit(hit);
			
			int save = this.boardService.insertBoard(boardBean);	// 저장 메서드
			
			if(save == 1){
				out.println("<script>");
				out.println("alert('게시판 작성에 성공하셨습니다. 목록으로 넘어갑니다.')");
				out.println("location.href='board_list.do'");
				out.println("</script>");
				return null;
			}
			return modelAndView;
		}

		/* ==============  게시판 내용보기  =============== */
		@RequestMapping(value = "board_view.do", method = RequestMethod.GET)
		public ModelAndView board_view(HttpServletRequest request, 
				HttpServletResponse response, HttpSession session) 
						throws IOException, SQLException, Exception {
			ModelAndView modelAndView = new ModelAndView();

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			
			String id = (String)session.getAttribute("id");						// 세션으로 가져온 회원 아이디

			int no = Integer.parseInt(request.getParameter("no"));				// 해당 게시판 내용 번호
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));	// 페이징 숫자 페이지 번호			

			this.boardService.boardHit(no);	//조회수 증가 메서드
			
			BoardBean boardViewBean = new BoardBean();			// BoardBean 타입으로 담아서
			boardViewBean = this.boardService.boardViewGet(no);	// 내용보기 메서드
			
			String org_id = boardViewBean.getBoard_id();	 	// 비공개글 을위한 DB 아이디
			int secret = Integer.parseInt(boardViewBean.getBoard_secret());
			
			if(secret == 1){	// 0:공개글 1:비밀글
				if(id == null){ // 로그인하지않으면 id가없으므로 읽을수없다.
					out.println("<script>");
					out.println("alert('비공개 글입니다.')");
					out.println("location.href='board_list.do?pageNum=" + pageNum + "'");
					out.println("</script>");
					return null;
				}
				if(id.equals(org_id)==false){	
					out.println("<script>");
					out.println("alert('비공개 글입니다.')");
					out.println("location.href='board_list.do?pageNum=" + pageNum + "'");
					out.println("</script>");
					return null;
				// DB에 저장되있는 보드아이디 : org_id
				// 세션값으로 가져온 회원정보(로그인) 아이디 :id
				// 두아이디를 비교해 같아야만 내용을 볼수있다.
				}
			}
			modelAndView.addObject("pageNum",pageNum);	// 페이징 번호 유지	
			modelAndView.addObject("boardLoginId",id);	// 게시물id 회원id 비교 하기 위한 값전달
			modelAndView.addObject("boardView",boardViewBean);
			modelAndView.setViewName("board_view");
			return modelAndView;
		}
		
		
		/* ==============  게시판 수정  =============== */
		@RequestMapping(value = "board_edit.do", method = RequestMethod.GET)
		public ModelAndView board_edit(HttpServletRequest request) throws SQLException{
			ModelAndView modelAndView = new ModelAndView();
			
			int no = Integer.parseInt(request.getParameter("no"));
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));	// 페이징 숫자 페이지 번호
			
			BoardBean boardEditBean = new BoardBean();
			boardEditBean = this.boardService.boardEditGet(no);	// 기존 내용 보이기위한 메서드
			
			modelAndView.addObject("pageNum",pageNum); // 페이징 번호 유지	
			modelAndView.addObject("boardEdit",boardEditBean);
			modelAndView.setViewName("board_edit");
			
			return modelAndView;
		}
		@RequestMapping(value = "board_edit.do", method = RequestMethod.POST)
		public ModelAndView board_edit_ok(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			ModelAndView modelAndView = new ModelAndView();

			int pageNum = Integer.parseInt(request.getParameter("pageNum"));	// 페이징 숫자 페이지 번호
			int no = Integer.parseInt(request.getParameter("no"));			String title = request.getParameter("title").trim();		
			String name = request.getParameter("name").trim();				String email1 = request.getParameter("email1").trim();		
			String email2 = request.getParameter("email2").trim();			String cont = request.getParameter("cont").trim();
			String pwd = request.getParameter("pwd").trim();				String secret = request.getParameter("secret");
			
			/*	비밀번호 확인 */
			BoardBean pwdCheck = new BoardBean();	
			pwdCheck = this.boardService.pwdCheck(no); 	//기존DB의 정보 호출 
			String org_pwd = pwdCheck.getBoard_pwd();	//기존DB의 비밀번호 저장
			
			if(pwd.equals(org_pwd)==false){				//String 타입 if문 적용
				out.println("<script>");
				out.println("alert('비밀번호가 일치하지 않습니다.비밀번호를 확인하세요.')");
				out.println("history.back()");
				out.println("</script>");
				return null;
			}// 비밀번호 확인끝 
			
			BoardBean boardEditBean = new BoardBean();
			boardEditBean.setBoard_no(no);
			boardEditBean.setBoard_title(title);						boardEditBean.setBoard_name(name);
			boardEditBean.setBoard_email1(email1);						boardEditBean.setBoard_email2(email2);
			boardEditBean.setBoard_cont(cont);							boardEditBean.setBoard_pwd(pwd);
			boardEditBean.setBoard_secret(secret);
			
			int edit = this.boardService.boardEditOk(boardEditBean); // 수정 저장 내용 저장
			
			if(edit == 1){
				out.println("<script>");
				out.println("alert('정상적으로 수정 되었습니다.')");
				out.println("location.href='board_view.do?no=" + no + "&pageNum=" + pageNum + "'");
				out.println("</script>");
				return null;
			}
			return modelAndView;
		}
		
		/* ==============  게시판 내용 삭제  =============== */
		@RequestMapping(value = "board_del.do", method = RequestMethod.GET)
		public ModelAndView board_del(HttpServletRequest request, 
				HttpServletResponse response, HttpSession session) throws IOException, SQLException{
			ModelAndView modelAndView = new ModelAndView();
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			int no = Integer.parseInt(request.getParameter("no"));
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));	// 페이징 숫자 페이지 번호
			int section = Integer.parseInt((String) session.getAttribute("section"));
			
			if(section == 3){
				int del = this.boardService.boardDel(no);	// 삭제 메서드
				if(del != 0){
					out.println("<script>");
					out.println("alert('삭제 되었습니다.')");
					out.println("location.href='board_list.do?pageNum=" + pageNum + "'");
					out.println("</script>");
					return null;
				}
			}
			
			modelAndView.addObject("pageNum",pageNum); // 페이징 번호 유지	
			modelAndView.addObject("no", no);
			modelAndView.setViewName("board_del");
			
			return modelAndView;
		}
		
		@RequestMapping(value = "board_del.do", method = RequestMethod.POST)
		public ModelAndView board_del_ok(HttpServletRequest request, HttpServletResponse response ) throws IOException, SQLException{
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));	// 페이징 숫자 페이지 번호
			String del_pwd = request.getParameter("del_pwd");	// 입력 창에 입력할 비밀번호
			int no = Integer.parseInt(request.getParameter("no"));

			BoardBean pwdCheck = this.boardService.boardPwd(no);

			String org_pwd = pwdCheck.getBoard_pwd();
			
			if(del_pwd.equals(org_pwd)==false){
				out.println("<script>");
				out.println("alert('비밀번호가 맞지 않습니다..')");
				out.println("history.back()");
				out.println("</script>");
				return null;
			}
			
			int del = this.boardService.boardDel(no);	// 삭제 메서드
			if(del != 0){
				out.println("<script>");
				out.println("alert('삭제 되었습니다.')");
				out.println("location.href='board_list.do?pageNum=" + pageNum + "'");
				out.println("</script>");
				return null;
			}
			
			return null;
		}
		
		/* ==============  게시판 답글  =============== */
		@RequestMapping(value = "board_reply.do", method = RequestMethod.GET)
		public ModelAndView board_reply(HttpServletRequest request, 
				HttpServletResponse response, HttpSession session) throws SQLException, IOException{
			ModelAndView modelAndView = new ModelAndView();

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			int no = Integer.parseInt(request.getParameter("no"));
			String id = (String) session.getAttribute("id");
			
			if(id == null){	// 로그인 해야 작성가능
				out.println("<script>");
				out.println("alert('로그인 후 이용가능합니다.')");
				out.println("location.href='login.do?pageNum=" + pageNum + "'");
				out.println("</script>");
				return null;
			}
			
			MemberBean replyInfo = new MemberBean();
			replyInfo = (MemberBean)this.memberService.boardReplyInfo(id); // 기존 내용 보이기위한 메서드
			
			
			BoardBean board_cont = this.boardService.boardGetcont(no);	// 게시판 정보 

			modelAndView.addObject("board_cont", board_cont);
			modelAndView.addObject("replyInfo", replyInfo);
			modelAndView.addObject("pageNum", pageNum);
			modelAndView.addObject("no", no);
			modelAndView.setViewName("board_reply");
			return modelAndView;
		}
		
		@RequestMapping(value = "board_reply.do", method = RequestMethod.POST)
		public ModelAndView board_reply_ok(HttpServletRequest request, 
				HttpServletResponse response, HttpSession session ) throws SQLException, IOException{

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			String id = (String) session.getAttribute("id");				int section = Integer.parseInt((String) session.getAttribute("section"));
			String title = request.getParameter("title").trim();			String name = request.getParameter("name").trim(); 
			String email1 = request.getParameter("email1").trim();			String email2 = request.getParameter("email2").trim(); 
			String cont = request.getParameter("cont").trim();				String pwd = request.getParameter("pwd").trim(); 
			String secret= request.getParameter("secret");	
			// secret = 0 : 공개글 
			// secret = 1 : 비밀글
			int comment_total = 0;		// 댓글 수
			int reply_select_no = Integer.parseInt(request.getParameter("reply_select_no")); 	// 댓글 깊이
			int reply_level = Integer.parseInt(request.getParameter("reply_level")); 	// 댓글 깊이
			int reply_seq = Integer.parseInt(request.getParameter("reply_seq")); 		// 댓글 번호
			int hit = 0;				// 조회수
						
			BoardBean board_reply = new BoardBean();
			
			board_reply.setBoard_id(id);							board_reply.setBoard_section(section);
			board_reply.setBoard_title(title);						board_reply.setBoard_name(name);
			board_reply.setBoard_email1(email1);					board_reply.setBoard_email2(email2);
			board_reply.setBoard_cont(cont);						board_reply.setBoard_pwd(pwd);
			board_reply.setBoard_secret(secret);					board_reply.setcomment_total(comment_total);
			board_reply.setReply_select_no(reply_select_no); // 답글달 글번호 저장		
			board_reply.setReply_level(reply_level);				board_reply.setReply_seq(reply_seq);					
			board_reply.setHit(hit);
			
			int board_reply_update = boardService.boardReplyUpdate(board_reply);		// 답글 순서 정의할때 메소드
			
			board_reply.setReply_level(reply_level + 1);				
			board_reply.setReply_seq(reply_seq + 1);
			
			int board_reply_save = boardService.boardReply(board_reply);	// 저장 메서드
			if(board_reply_save == 1){
				out.println("<script>");
				out.println("alert('답글 작성에 성공하셨습니다. 목록으로 넘어갑니다.')");
				out.println("location.href='board_list.do?pageNum="+pageNum+"'");
				out.println("</script>");
				return null;
			}
			
			return null;
		}
}
