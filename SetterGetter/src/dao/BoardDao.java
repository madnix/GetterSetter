package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.BoardBean;
import utils.SqlMapLocator;


public class BoardDao {

	/* =================== 게시판 전체 글 수 =================== */
	public int getTotalCnt() throws SQLException {
		// TODO Auto-generated method stub
		return (Integer) SqlMapLocator.getMapper().queryForList("totalCnt", new Integer(1)).get(0);
	}
	/* =================== 게시판 리스트 =================== */
	public List<BoardBean> boardListGet(Map<String, Object> pageRow) throws SQLException{
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().queryForList("boardListGet", pageRow);
	}

	
	/* =================== 게시판 작성 =================== */
	public int insertBoard(BoardBean boardBean) throws SQLException {
		// TODO Auto-generated method stub
		return (int) SqlMapLocator.getMapper().update("insertBoard", boardBean);
	}


	/* =================== 게시판 내용 보기 =================== */
	public BoardBean boardViewGet(int no) throws SQLException {
		// TODO Auto-generated method stub
		return (BoardBean) SqlMapLocator.getMapper().queryForObject("boardViewGet", no);
	}
	/* =================== 조회수 증가 =================== */
	public void boardHit(int no) throws SQLException {
		// TODO Auto-generated method stub
		SqlMapLocator.getMapper().update("boardHit", no);
	}


	/* =================== 게시판 내용 수정 =================== */
	/*	수정보기	*/
	public BoardBean boardEditGet(int no) throws SQLException {
		// TODO Auto-generated method stub
		return (BoardBean) SqlMapLocator.getMapper().queryForObject("board_edit", no);
	}
	/*	수정 비밀번호 검사	*/
	public BoardBean pwdCheck(int no) throws SQLException {
		// TODO Auto-generated method stub
		return (BoardBean) SqlMapLocator.getMapper().queryForObject("pwd_check", no);
	}
	/*	수정 완료	*/
	public int boardEditOk(BoardBean boardEditBean) throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().update("board_edit_ok",boardEditBean);
	}
	
	
	
	/* =================== 게시판 내용 삭제 =================== */
	/*	해당 게시판 비밀번호 정보 호출	*/
	public BoardBean boardPwd(int no) throws SQLException {
		// TODO Auto-generated method stub
		return (BoardBean) SqlMapLocator.getMapper().queryForObject("boardPwd", no);
	}
	/*	해당 게시판 내용 삭제	*/
	public int boardDel(int no) throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().update("board_del", no);
	}
	
	/* =================== 게시판 답글 =================== */
	/* 게시판 제목 가져오기 */
	public BoardBean boardGetcont(int no) throws SQLException {
		// TODO Auto-generated method stub
		return (BoardBean) SqlMapLocator.getMapper().queryForObject("boardGetcont", no);
	}
	/* 답변글 저장전 댓글 seq 없데이트 */
	public int boardReplyUpdate(BoardBean board_reply) throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().update("boardReplyUpdate", board_reply);
	}
	/* 답변글 저장 */
	public int boardReply(BoardBean board_reply) throws SQLException {
		// TODO Auto-generated method stub
		return (int) SqlMapLocator.getMapper().update("boardReply", board_reply);
	}
	
	/* =================== 게시판 내용 검색 =================== */
	@SuppressWarnings("unchecked")
	public List<BoardBean> searchCont(Map<String, Object> pageRow) throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().queryForList("searchCont",pageRow);
	}
	public int getSearchCnt(String search) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer) SqlMapLocator.getMapper().queryForList("getSearchCnt", search).get(0);
	}
}
