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

	/* =================== ���̵�üũ =================== */
	public String idcheckMember(String idcheck) throws SQLException {
		String id = null;
		id = (String) SqlMapLocator.getMapper().queryForObject("idcheckMember",
				idcheck);
		return id;
	}

	/* =================== �����ȣ ã�� =================== */
	@SuppressWarnings("unchecked")
	public List<PostBean> searchZipcode(String dong) throws SQLException {
		List<PostBean> zipcodeList = new ArrayList<PostBean>();
		zipcodeList = SqlMapLocator.getMapper().queryForList("searchZipcode",dong);
		return zipcodeList;
	}

	/* =================== ������ ȸ������ ����ϱ� =================== */
	public int insertMember(MemberBean memberBean) throws SQLException {
		// TODO Auto-generated method stub

		return SqlMapLocator.getMapper().update("insertMember", memberBean);

	}

	/* =================== �α��� �ϱ� =================== */
	public MemberBean getLoginCheck(String id) throws SQLException {
		// TODO Auto-generated method stub
		return (MemberBean) SqlMapLocator.getMapper().queryForObject("idcheck",	id);
	}

	/* =================== �Ǹ��� ȸ������ ����ϱ� =================== */
	public int insertMember2(MemberBean memberBean) throws SQLException {
		// TODO Auto-generated method stub
		return SqlMapLocator.getMapper().update("insertMember2", memberBean);
	}
	
	/* ================== ��ǰ ����ϱ� =================== */
	public void productInsert(ProductInsertBean pib) throws Exception {
		SqlMapLocator.getMapper().insert("insertUserProduct", pib);
	}

	/* ================== ���̵� �� �ݳ��ϱ� ============== */
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
	
	
/* =================== id �������� ȸ������ �������� =================== */
	public MemberBean getMemberInfo(String id) throws SQLException {
		// TODO Auto-generated method stub
		return (MemberBean) SqlMapLocator.getMapper().queryForObject("getMemberInfo", id);
	}

/* ================= �Ǹ��� ��ǰ��Ͻ� ������ Ȯ�� ============================== */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProductList() throws Exception {
		return SqlMapLocator.getMapper().queryForList("resultProdutList");
	}
/* ======================= ���� ��ǰ ����Ʈ ======================*/
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getAdminUserList(String id) throws Exception {
		return SqlMapLocator.getMapper().queryForList("resultUserList",id);
	}
/* =================== ������ ��ǰȮ�ν� ���� ������Ʈ ====================*/
	public void getAdminUserUpdate(String id) throws Exception {
		SqlMapLocator.getMapper().update("AdminUpdate",id);		
	}

/* =================== ������ ȸ������ ���� =================== */	
	public int editBuyerMember(MemberBean afterBean) throws SQLException {
		return SqlMapLocator.getMapper().update("editBuyerMember", afterBean);
	}

/* =================== �Ǹ��� ȸ������ ���� =================== */
	public int editSellerMember(MemberBean afterBean) throws SQLException {
		return SqlMapLocator.getMapper().update("editSellerMember", afterBean);
	}

/* =================== �Խ��� �ۼ��� id �������� ȸ������ �������� =================== */
	public MemberBean boardInfo(String id) throws SQLException {
		// TODO Auto-generated method stub
		return (MemberBean) SqlMapLocator.getMapper().queryForObject("boardInfo2", id);
	}
	
/* =================== ��� �ۼ��� id �������� ȸ������ �������� =================== */
	public MemberBean boardReplyInfo(String id) throws SQLException {
		// TODO Auto-generated method stub
		return (MemberBean) SqlMapLocator.getMapper().queryForObject("boardReplyInfo", id);
	}
	
/* =================== ��� �ۼ��� id �������� ȸ������ �������� =================== */
	public MemberBean getName(String id) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(id);	
		return (MemberBean) SqlMapLocator.getMapper().queryForObject("getName", id);
	}
}
