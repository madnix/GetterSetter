package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.CommentBean;

import utils.SqlMapLocator;

public class CommentDao {

	/* 전체 글수 얻기 */
	public int getTotalCnt(String pro_id) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer)SqlMapLocator.getMapper().queryForList("totalComment", pro_id ).get(0);
	}

	/* 댓글 전체목록 뿌리기 */
	@SuppressWarnings("unchecked")
	public List<CommentBean> commentListGet(Map<String, Object> pageRow) throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().queryForList("commentListGet", pageRow);
	}

	/* 댓글 작성 */
	public int insertComment(CommentBean commentBean) throws SQLException {
		// TODO Auto-generated method stub
		return (int) SqlMapLocator.getMapper().update("insertComment", commentBean);
	}

	public int commentDel(CommentBean comment_del) throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().update("commentDel", comment_del);
	}


//	/* 상품해당하는 시퀀스 만들기 */
//	public int createSequence(CommentBean commentBean) throws SQLException {
//		// TODO Auto-generated method stub
//		return (int)SqlMapLocator.getMapper().update("createSequence", commentBean);
//	}



}
