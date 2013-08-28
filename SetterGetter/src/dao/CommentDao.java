package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.CommentBean;

import utils.SqlMapLocator;

public class CommentDao {

	/* ��ü �ۼ� ��� */
	public int getTotalCnt(String pro_id) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer)SqlMapLocator.getMapper().queryForList("totalComment", pro_id ).get(0);
	}

	/* ��� ��ü��� �Ѹ��� */
	@SuppressWarnings("unchecked")
	public List<CommentBean> commentListGet(Map<String, Object> pageRow) throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().queryForList("commentListGet", pageRow);
	}

	/* ��� �ۼ� */
	public int insertComment(CommentBean commentBean) throws SQLException {
		// TODO Auto-generated method stub
		return (int) SqlMapLocator.getMapper().update("insertComment", commentBean);
	}

	public int commentDel(CommentBean comment_del) throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().update("commentDel", comment_del);
	}


//	/* ��ǰ�ش��ϴ� ������ ����� */
//	public int createSequence(CommentBean commentBean) throws SQLException {
//		// TODO Auto-generated method stub
//		return (int)SqlMapLocator.getMapper().update("createSequence", commentBean);
//	}



}
