package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.MemberBean;
import model.PostBean;
import model.ProductInsertBean;
import utils.SqlMapLocator;

public class MemberDao {

	/* =================== 아이디체크 =================== */
	public String idcheckMember(String idcheck) throws SQLException {
		String id = null;
		id = (String) SqlMapLocator.getMapper().queryForObject("idcheckMember",
				idcheck);
		return id;
	}

	/* =================== 우편번호 찾기 =================== */
	@SuppressWarnings("unchecked")
	public List<PostBean> searchZipcode(String dong) throws SQLException {
		List<PostBean> zipcodeList = new ArrayList<PostBean>();
		zipcodeList = SqlMapLocator.getMapper().queryForList("searchZipcode",dong);
		return zipcodeList;
	}

	/* =================== 구매자 회원가입 등록하기 =================== */
	public int insertMember(MemberBean memberBean) throws SQLException {
		// TODO Auto-generated method stub

		return SqlMapLocator.getMapper().update("insertMember", memberBean);

	}

	/* =================== 로그인 하기 =================== */
	public MemberBean getLoginCheck(String id) throws SQLException {
		// TODO Auto-generated method stub
		return (MemberBean) SqlMapLocator.getMapper().queryForObject("idcheck",	id);
	}

	/* =================== 판매자 회원가입 등록하기 =================== */
	public int insertMember2(MemberBean memberBean) throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().update("insertMember2", memberBean);
	}
	
	/* ================== 물품 등록하기 =================== */
	public void productInsert(ProductInsertBean pib) throws Exception {
		SqlMapLocator.getMapper().insert("insertUserProduct", pib);
	}

	/* ================== 아이디 갑 반납하기 ============== */
	@SuppressWarnings("unchecked")
	public List<MemberBean> getUserListMethod(String id) throws Exception {
		return SqlMapLocator.getMapper().queryForList("getUserList",id);
	}

	public MemberBean serchId(String email1, String email2) throws SQLException {
		// TODO Auto-generated method stub
		Map paramMap = new HashMap();
		paramMap.put("email1", email1);
		paramMap.put("email2", email2);
		return (MemberBean) SqlMapLocator.getMapper().queryForObject(
				"namecheck", paramMap);
	}
	
	
/* =================== id 기준으로 회원정보 가져오기 =================== */
	public MemberBean getMemberInfo(String id) throws SQLException {
		// TODO Auto-generated method stub
		return (MemberBean) SqlMapLocator.getMapper().queryForObject("getMemberInfo", id);
	}

/* ================= 판매자 물품등록시 관리자 확인 ============================== */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductList() throws Exception {
		return SqlMapLocator.getMapper().queryForList("resultProdutList");
	}
/* ======================= 상세함 물품 리스트 ======================*/
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getAdminUserList(String id) throws Exception {
		return SqlMapLocator.getMapper().queryForList("resultUserList",id);
	}
/* =================== 관리자 물품확인시 레벌 엎데이트 ====================*/
	public void getAdminUserUpdate(String id) throws Exception {
		SqlMapLocator.getMapper().update("AdminUpdate",id);		
	}

/* =================== 구매자 회원정보 수정 =================== */	
	public int editBuyerMember(MemberBean afterBean) throws SQLException {
		return SqlMapLocator.getMapper().update("editBuyerMember", afterBean);
	}

/* =================== 판매자 회원정보 수정 =================== */
	public int editSellerMember(MemberBean afterBean) throws SQLException {
		return SqlMapLocator.getMapper().update("editSellerMember", afterBean);
	}

/* =================== 게시판 작성시 id 기준으로 회원정보 가져오기 =================== */
	public MemberBean boardInfo(String id) throws SQLException {
		// TODO Auto-generated method stub
		return (MemberBean) SqlMapLocator.getMapper().queryForObject("boardInfo2", id);
	}
	
/* =================== 답글 작성시 id 기준으로 회원정보 가져오기 =================== */
	public MemberBean boardReplyInfo(String id) throws SQLException {
		// TODO Auto-generated method stub
		return (MemberBean) SqlMapLocator.getMapper().queryForObject("boardReplyInfo", id);
	}
	
/* =================== 댓글 작성시 id 기준으로 회원정보 가져오기 =================== */
	public MemberBean getName(String id) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(id);	
		return (MemberBean) SqlMapLocator.getMapper().queryForObject("getName", id);
	}
}
