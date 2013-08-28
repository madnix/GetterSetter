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
		}	// ȸ�� ���� DB

		public void setBoardService(BoardDao boardService) {
			this.boardService = boardService;
		}	// �Խ��� ���� DB
		
		/* ==============  ����¡ ����  ============== */
		private final static int pageSize = 10;			// �� ������ �� ������ �� ����
		private final static int pageGroupSize = 5;		// �������׷���� ������ ����
														// ex) [����] 1 2 3 4 5 [����]  �� ��� ������ ������ 5	

		/* ==============  �Խ��� ���  ============== */
		@RequestMapping(value="board_list.do", method=RequestMethod.GET)
		public ModelAndView board_list(HttpServletRequest request,
				HttpServletResponse response) throws Exception{

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			
			String no = request.getParameter("pageNum");	// ����¡ ��ȣ�� �޾Ƽ�  ������ ������ 1���� �༭ int  Ÿ������ �ٽ����� 
			if(no == null){ // �⺻������ ����¡ ù������ ���� ��ȣ
				no = "1";
			}

			int pageNum = Integer.parseInt(no);				// ���� ����¡���� ���� ��ȣ
			int startRow = (pageNum - 1) * pageSize + 1;	// �� �������� ���۱� ��ȣ
			int endRow = pageNum * pageSize; 	// �� �������� ������ �� ��ȣ
			int count = 0;						// �ѰԽù� �� 
			int number = 0;			// �ѰԽù� �� ���� �ش� ����¡�� ������ �Խù� ��
			

		String search = request.getParameter("search");	//�˻��ϱ����� ���ڿ�
		
		List<BoardBean> boardList = new ArrayList<BoardBean>();  
		//DB ���� �Խ��� ������ ���� �� BoardBean Ÿ������ �����´�.
		System.out.println("GET search : " + search);
		if(search != null){
//			if(search.equals("")!= false){
			
				count = this.boardService.getSearchCnt(search);	// �ѰԽù��� �ľ� DB

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
			count = this.boardService.getTotalCnt();	// �ѰԽù��� �ľ� DB


			if(count > 0){
				if(endRow > count)
					endRow = count;
				
				Map<String, Object> pageRow = new HashMap<String, Object>();
				
					pageRow.put("startRow", startRow);
					pageRow.put("endRow", endRow);
				
				boardList = this.boardService.boardListGet(pageRow);		// ���� �������� �ش��ϴ� �� ���

			}else{
				boardList = null;
			}
		}
			number = count - (pageNum - 1) * pageSize;		// �۸�Ͽ� ǥ���� �۹�ȣ
			
			// ������ �׷��� ����
			// ex) pageGroupSize �� 3�� ��� '[1][2][3]'�� pageGroupCount �� ��ŭ �ִ�.
			int pageGroupCount = count / (pageSize * pageGroupSize) + (count % (pageSize * pageGroupSize) == 0 ? 0 : 1);
			
			// �������׷� ��ȣ
			// ex) pageGroupSize�� 3�� ��� '[1][2][3]'�� ������ �׷��ȣ�� 1�̰� '[2][3][4]' �� �������׷��ȣ�� 2�̴�.
			int numPageGroup = (int)Math.ceil((double)pageNum / pageGroupSize);
			
			// ���� ���� �ҷ����� ���� �Լ�
			SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd"); //yyyy-MM-dd HH:mm:ss ��-��-��-�ð�-��-�� ��� 
			Date toDay = new Date(); 
			String nowDay = day.format(toDay);
			
			// �ش� �信�� ����� �Ӽ�
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
			

			System.out.println("========= �������� �������� =========");
			System.out.println("pageNum : " + pageNum);					// ���� ����¡���� ���� ��ȣ
			System.out.println("startRow : " + startRow);				// �� �������� ���۱� ��ȣ
			System.out.println("endRow : " + endRow);					// �� �������� ������ �� ��ȣ
			System.out.println("count : " + count);						// �ѰԽù� ��
			System.out.println("number : " + number);					// �ѰԽù� �� ���� �ش� ����¡�� ������ �Խù� ��
			System.out.println("pageSize : " + pageSize);				// �� ������ �� ������ �� ����
			System.out.println("pageGroupSize : " + pageGroupSize);		// �������׷���� ������ ����
			System.out.println("numPageGroup : " + numPageGroup);		// �������׷� ��ȣ
			System.out.println("pageGroupCount : " + pageGroupCount);	// ������ �׷��� ����
			System.out.println("=====================================");
			
			if(boardList == null){
				out.println("<script>");
				out.println("alert('����Ʈ�� �����ϴ�.')");
				out.println("location.href='board_write.do'");
				out.println("</script>");
				return null;
			} // �Խù��� ������ �۾���� ����
			
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


		/* ==============  �Խ��� �ۼ�  =============== */
		@RequestMapping(value="board_write.do", method=RequestMethod.GET)
		public ModelAndView board_write(HttpServletRequest request, 
				HttpServletResponse response, HttpSession session) 
						throws SQLException, IOException{
			ModelAndView modelAndView = new ModelAndView();
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			String id = (String) session.getAttribute("id");			// �α��� ���̵�
			int pageNum = 0;
			
			/* ���� ������ ��ȣ�� ������ ���Ƿ� ��ȣ�� ���ִ� �۾� */
			if(request.getParameter("pageNum")==null){		
				pageNum = 1; 	
			}else if(request.getParameter("pageNum")!=null){
				pageNum = Integer.parseInt(request.getParameter("pageNum"));	// ���� ����¡ ��ȣ
			}
			
			if(id == null){	// �α��� �ؾ� �ۼ�����
				out.println("<script>");
				out.println("alert('�α��� �� �̿밡���մϴ�.')");
				out.println("location.href='login.do?pageNum=" + pageNum + "'");
				out.println("</script>");
				return null;
			}
			
			MemberBean info = new MemberBean();
			info = (MemberBean)this.memberService.boardInfo(id);	// �α��������� �������� �ҷ�����.
			
			modelAndView.addObject("pageNum", pageNum);
			modelAndView.addObject("boardInfo", info);	// �ۼ��� �⺻ �̸�, �̸��� �ҷ�����
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
			// secret = 0 : ������ 
			// secret = 1 : ��б�
			int comment_total = 0;		// ��� ��
			// reply_select_no ��� �Ҷ� �ʿ��� ��ȣ board_no ������ ��. 
			int reply_level = 0; 		// �Ϲݱ� = 0, ��� = 1�̻�
			int reply_seq = 0; 			// ��� ��ȣ
			int hit = 0;				// ��ȸ��
			
			BoardBean boardBean = new BoardBean();
			
			boardBean.setBoard_id(id);							boardBean.setBoard_section(section);
			boardBean.setBoard_title(title);					boardBean.setBoard_name(name);
			boardBean.setBoard_email1(email1);					boardBean.setBoard_email2(email2);
			boardBean.setBoard_cont(cont);						boardBean.setBoard_pwd(pwd);
			boardBean.setBoard_secret(secret);					boardBean.setcomment_total(comment_total);
			boardBean.setReply_level(reply_level);				boardBean.setReply_seq(reply_seq);					
			boardBean.setHit(hit);
			
			int save = this.boardService.insertBoard(boardBean);	// ���� �޼���
			
			if(save == 1){
				out.println("<script>");
				out.println("alert('�Խ��� �ۼ��� �����ϼ̽��ϴ�. ������� �Ѿ�ϴ�.')");
				out.println("location.href='board_list.do'");
				out.println("</script>");
				return null;
			}
			return modelAndView;
		}

		/* ==============  �Խ��� ���뺸��  =============== */
		@RequestMapping(value = "board_view.do", method = RequestMethod.GET)
		public ModelAndView board_view(HttpServletRequest request, 
				HttpServletResponse response, HttpSession session) 
						throws IOException, SQLException, Exception {
			ModelAndView modelAndView = new ModelAndView();

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			
			String id = (String)session.getAttribute("id");						// �������� ������ ȸ�� ���̵�

			int no = Integer.parseInt(request.getParameter("no"));				// �ش� �Խ��� ���� ��ȣ
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));	// ����¡ ���� ������ ��ȣ			

			this.boardService.boardHit(no);	//��ȸ�� ���� �޼���
			
			BoardBean boardViewBean = new BoardBean();			// BoardBean Ÿ������ ��Ƽ�
			boardViewBean = this.boardService.boardViewGet(no);	// ���뺸�� �޼���
			
			String org_id = boardViewBean.getBoard_id();	 	// ������� ������ DB ���̵�
			int secret = Integer.parseInt(boardViewBean.getBoard_secret());
			
			if(secret == 1){	// 0:������ 1:��б�
				if(id == null){ // �α������������� id�������Ƿ� ����������.
					out.println("<script>");
					out.println("alert('����� ���Դϴ�.')");
					out.println("location.href='board_list.do?pageNum=" + pageNum + "'");
					out.println("</script>");
					return null;
				}
				if(id.equals(org_id)==false){	
					out.println("<script>");
					out.println("alert('����� ���Դϴ�.')");
					out.println("location.href='board_list.do?pageNum=" + pageNum + "'");
					out.println("</script>");
					return null;
				// DB�� ������ִ� ������̵� : org_id
				// ���ǰ����� ������ ȸ������(�α���) ���̵� :id
				// �ξ��̵� ���� ���ƾ߸� ������ �����ִ�.
				}
			}
			modelAndView.addObject("pageNum",pageNum);	// ����¡ ��ȣ ����	
			modelAndView.addObject("boardLoginId",id);	// �Խù�id ȸ��id �� �ϱ� ���� ������
			modelAndView.addObject("boardView",boardViewBean);
			modelAndView.setViewName("board_view");
			return modelAndView;
		}
		
		
		/* ==============  �Խ��� ����  =============== */
		@RequestMapping(value = "board_edit.do", method = RequestMethod.GET)
		public ModelAndView board_edit(HttpServletRequest request) throws SQLException{
			ModelAndView modelAndView = new ModelAndView();
			
			int no = Integer.parseInt(request.getParameter("no"));
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));	// ����¡ ���� ������ ��ȣ
			
			BoardBean boardEditBean = new BoardBean();
			boardEditBean = this.boardService.boardEditGet(no);	// ���� ���� ���̱����� �޼���
			
			modelAndView.addObject("pageNum",pageNum); // ����¡ ��ȣ ����	
			modelAndView.addObject("boardEdit",boardEditBean);
			modelAndView.setViewName("board_edit");
			
			return modelAndView;
		}
		@RequestMapping(value = "board_edit.do", method = RequestMethod.POST)
		public ModelAndView board_edit_ok(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			ModelAndView modelAndView = new ModelAndView();

			int pageNum = Integer.parseInt(request.getParameter("pageNum"));	// ����¡ ���� ������ ��ȣ
			int no = Integer.parseInt(request.getParameter("no"));			String title = request.getParameter("title").trim();		
			String name = request.getParameter("name").trim();				String email1 = request.getParameter("email1").trim();		
			String email2 = request.getParameter("email2").trim();			String cont = request.getParameter("cont").trim();
			String pwd = request.getParameter("pwd").trim();				String secret = request.getParameter("secret");
			
			/*	��й�ȣ Ȯ�� */
			BoardBean pwdCheck = new BoardBean();	
			pwdCheck = this.boardService.pwdCheck(no); 	//����DB�� ���� ȣ�� 
			String org_pwd = pwdCheck.getBoard_pwd();	//����DB�� ��й�ȣ ����
			
			if(pwd.equals(org_pwd)==false){				//String Ÿ�� if�� ����
				out.println("<script>");
				out.println("alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.��й�ȣ�� Ȯ���ϼ���.')");
				out.println("history.back()");
				out.println("</script>");
				return null;
			}// ��й�ȣ Ȯ�γ� 
			
			BoardBean boardEditBean = new BoardBean();
			boardEditBean.setBoard_no(no);
			boardEditBean.setBoard_title(title);						boardEditBean.setBoard_name(name);
			boardEditBean.setBoard_email1(email1);						boardEditBean.setBoard_email2(email2);
			boardEditBean.setBoard_cont(cont);							boardEditBean.setBoard_pwd(pwd);
			boardEditBean.setBoard_secret(secret);
			
			int edit = this.boardService.boardEditOk(boardEditBean); // ���� ���� ���� ����
			
			if(edit == 1){
				out.println("<script>");
				out.println("alert('���������� ���� �Ǿ����ϴ�.')");
				out.println("location.href='board_view.do?no=" + no + "&pageNum=" + pageNum + "'");
				out.println("</script>");
				return null;
			}
			return modelAndView;
		}
		
		/* ==============  �Խ��� ���� ����  =============== */
		@RequestMapping(value = "board_del.do", method = RequestMethod.GET)
		public ModelAndView board_del(HttpServletRequest request, 
				HttpServletResponse response, HttpSession session) throws IOException, SQLException{
			ModelAndView modelAndView = new ModelAndView();
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			int no = Integer.parseInt(request.getParameter("no"));
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));	// ����¡ ���� ������ ��ȣ
			int section = Integer.parseInt((String) session.getAttribute("section"));
			
			if(section == 3){
				int del = this.boardService.boardDel(no);	// ���� �޼���
				if(del != 0){
					out.println("<script>");
					out.println("alert('���� �Ǿ����ϴ�.')");
					out.println("location.href='board_list.do?pageNum=" + pageNum + "'");
					out.println("</script>");
					return null;
				}
			}
			
			modelAndView.addObject("pageNum",pageNum); // ����¡ ��ȣ ����	
			modelAndView.addObject("no", no);
			modelAndView.setViewName("board_del");
			
			return modelAndView;
		}
		
		@RequestMapping(value = "board_del.do", method = RequestMethod.POST)
		public ModelAndView board_del_ok(HttpServletRequest request, HttpServletResponse response ) throws IOException, SQLException{
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));	// ����¡ ���� ������ ��ȣ
			String del_pwd = request.getParameter("del_pwd");	// �Է� â�� �Է��� ��й�ȣ
			int no = Integer.parseInt(request.getParameter("no"));

			BoardBean pwdCheck = this.boardService.boardPwd(no);

			String org_pwd = pwdCheck.getBoard_pwd();
			
			if(del_pwd.equals(org_pwd)==false){
				out.println("<script>");
				out.println("alert('��й�ȣ�� ���� �ʽ��ϴ�..')");
				out.println("history.back()");
				out.println("</script>");
				return null;
			}
			
			int del = this.boardService.boardDel(no);	// ���� �޼���
			if(del != 0){
				out.println("<script>");
				out.println("alert('���� �Ǿ����ϴ�.')");
				out.println("location.href='board_list.do?pageNum=" + pageNum + "'");
				out.println("</script>");
				return null;
			}
			
			return null;
		}
		
		/* ==============  �Խ��� ���  =============== */
		@RequestMapping(value = "board_reply.do", method = RequestMethod.GET)
		public ModelAndView board_reply(HttpServletRequest request, 
				HttpServletResponse response, HttpSession session) throws SQLException, IOException{
			ModelAndView modelAndView = new ModelAndView();

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			int no = Integer.parseInt(request.getParameter("no"));
			String id = (String) session.getAttribute("id");
			
			if(id == null){	// �α��� �ؾ� �ۼ�����
				out.println("<script>");
				out.println("alert('�α��� �� �̿밡���մϴ�.')");
				out.println("location.href='login.do?pageNum=" + pageNum + "'");
				out.println("</script>");
				return null;
			}
			
			MemberBean replyInfo = new MemberBean();
			replyInfo = (MemberBean)this.memberService.boardReplyInfo(id); // ���� ���� ���̱����� �޼���
			
			
			BoardBean board_cont = this.boardService.boardGetcont(no);	// �Խ��� ���� 

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
			// secret = 0 : ������ 
			// secret = 1 : ��б�
			int comment_total = 0;		// ��� ��
			int reply_select_no = Integer.parseInt(request.getParameter("reply_select_no")); 	// ��� ����
			int reply_level = Integer.parseInt(request.getParameter("reply_level")); 	// ��� ����
			int reply_seq = Integer.parseInt(request.getParameter("reply_seq")); 		// ��� ��ȣ
			int hit = 0;				// ��ȸ��
						
			BoardBean board_reply = new BoardBean();
			
			board_reply.setBoard_id(id);							board_reply.setBoard_section(section);
			board_reply.setBoard_title(title);						board_reply.setBoard_name(name);
			board_reply.setBoard_email1(email1);					board_reply.setBoard_email2(email2);
			board_reply.setBoard_cont(cont);						board_reply.setBoard_pwd(pwd);
			board_reply.setBoard_secret(secret);					board_reply.setcomment_total(comment_total);
			board_reply.setReply_select_no(reply_select_no); // ��۴� �۹�ȣ ����		
			board_reply.setReply_level(reply_level);				board_reply.setReply_seq(reply_seq);					
			board_reply.setHit(hit);
			
			int board_reply_update = boardService.boardReplyUpdate(board_reply);		// ��� ���� �����Ҷ� �޼ҵ�
			
			board_reply.setReply_level(reply_level + 1);				
			board_reply.setReply_seq(reply_seq + 1);
			
			int board_reply_save = boardService.boardReply(board_reply);	// ���� �޼���
			if(board_reply_save == 1){
				out.println("<script>");
				out.println("alert('��� �ۼ��� �����ϼ̽��ϴ�. ������� �Ѿ�ϴ�.')");
				out.println("location.href='board_list.do?pageNum="+pageNum+"'");
				out.println("</script>");
				return null;
			}
			
			return null;
		}
}
