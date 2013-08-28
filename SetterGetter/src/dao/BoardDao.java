package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.BoardBean;
import utils.SqlMapLocator;


public class BoardDao {

	/* =================== �Խ��� ��ü �� �� =================== */
	public int getTotalCnt() throws SQLException {
		// TODO Auto-generated method stub
		return (Integer) SqlMapLocator.getMapper().queryForList("totalCnt", new Integer(1)).get(0);
	}
	/* =================== �Խ��� ����Ʈ =================== */
	public List<BoardBean> boardListGet(Map<String, Object> pageRow) throws SQLException{
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().queryForList("boardListGet", pageRow);
	}

	
	/* =================== �Խ��� �ۼ� =================== */
	public int insertBoard(BoardBean boardBean) throws SQLException {
		// TODO Auto-generated method stub
		return (int) SqlMapLocator.getMapper().update("insertBoard", boardBean);
	}


	/* =================== �Խ��� ���� ���� =================== */
	public BoardBean boardViewGet(int no) throws SQLException {
		// TODO Auto-generated method stub
		return (BoardBean) SqlMapLocator.getMapper().queryForObject("boardViewGet", no);
	}
	/* =================== ��ȸ�� ���� =================== */
	public void boardHit(int no) throws SQLException {
		// TODO Auto-generated method stub
		SqlMapLocator.getMapper().update("boardHit", no);
	}


	/* =================== �Խ��� ���� ���� =================== */
	/*	��������	*/
	public BoardBean boardEditGet(int no) throws SQLException {
		// TODO Auto-generated method stub
		return (BoardBean) SqlMapLocator.getMapper().queryForObject("board_edit", no);
	}
	/*	���� ��й�ȣ �˻�	*/
	public BoardBean pwdCheck(int no) throws SQLException {
		// TODO Auto-generated method stub
		return (BoardBean) SqlMapLocator.getMapper().queryForObject("pwd_check", no);
	}
	/*	���� �Ϸ�	*/
	public int boardEditOk(BoardBean boardEditBean) throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().update("board_edit_ok",boardEditBean);
	}
	
	
	
	/* =================== �Խ��� ���� ���� =================== */
	/*	�ش� �Խ��� ��й�ȣ ���� ȣ��	*/
	public BoardBean boardPwd(int no) throws SQLException {
		// TODO Auto-generated method stub
		return (BoardBean) SqlMapLocator.getMapper().queryForObject("boardPwd", no);
	}
	/*	�ش� �Խ��� ���� ����	*/
	public int boardDel(int no) throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().update("board_del", no);
	}
	
	/* =================== �Խ��� ��� =================== */
	/* �Խ��� ���� �������� */
	public BoardBean boardGetcont(int no) throws SQLException {
		// TODO Auto-generated method stub
		return (BoardBean) SqlMapLocator.getMapper().queryForObject("boardGetcont", no);
	}
	/* �亯�� ������ ��� seq ������Ʈ */
	public int boardReplyUpdate(BoardBean board_reply) throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().update("boardReplyUpdate", board_reply);
	}
	/* �亯�� ���� */
	public int boardReply(BoardBean board_reply) throws SQLException {
		// TODO Auto-generated method stub
		return (int) SqlMapLocator.getMapper().update("boardReply", board_reply);
	}
	
	/* =================== �Խ��� ���� �˻� =================== */
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
