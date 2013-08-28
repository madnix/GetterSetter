package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.MemberBean;
import model.OrderBean;
import model.ProductInsertBean;
import utils.SqlMapLocator;

public class AdminDao {

	/* 모든 판매자 반납 */
	public int getAdminTotalCont() throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultpusercount");
	}

	/* 판매자 반납 페이징 */
	@SuppressWarnings("unchecked")
	public List<MemberBean> selectAdminPage(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("selectpagepuserlist", pageRow);
	}

	/* 모든 구매자 반납 */
	public int getAdminTotalCont2() throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultcusercount");
	}

	/* 구매자 반납페이징 */
	@SuppressWarnings("unchecked")
	public List<MemberBean> selectAdminPage2(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("selectpagecuserlist", pageRow);
	}

	/* 제품 리스트 */
	public int getProCont() throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultprocount");
	}

	/* 제품 리스트 페이징 */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProListMethod(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultprolist", pageRow);
	}

	/* 제품 등록 신청 */
	public int getRboxCont() throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultrboxcount");
	}

	/* 제품 등록 페이징 */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getReceptionListMethod(
			Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultreceptionlist",pageRow);
	}

	/* 관리자 제품 구매 결제 */
	public int getCheckOutCont() throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultcheckoutcont");
	}

	/* 관리자 제품 구매 결제 페이징 */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getCheckOutListMethod(
			Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultcheckoutlistmethod", pageRow);
	}

	/* 관리자 유저 상세정보 */
	public MemberBean getAllUserList(String puserid) throws SQLException {
		return (MemberBean) SqlMapLocator.getMapper().queryForObject("getAllUserList" ,puserid);
	}

	/* 관리자 유저 등록 제품 카운트 */
	public int getAllProductCont(String puserid) throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultallproductcount",puserid);
	}

	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getAllProductlist(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultallproductlist",pageRow);
	}

	/* 관리자 구매자 상세보기 */
	public int getAllProductCont2(String cuserid) throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultallproductcount2",cuserid);
	}

	/* 관리자 구매자 페이징 */
	@SuppressWarnings("unchecked")
	public List<OrderBean> getAllProductlist2(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultallproductlist2",pageRow);
	}

	/* 관리자 구매자 구매 신청 상세보기 */
	public int getAllProCont3(String cuserid) throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultallproductcount3",cuserid);
	}

	@SuppressWarnings("unchecked")
	public List<OrderBean> getAllProductlist3(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultallproductlist3",pageRow);
	}

	/* 제품 등록  */
	public ProductInsertBean getprolist(String pro_id) throws SQLException {
		return (ProductInsertBean) SqlMapLocator.getMapper().queryForObject("resutlproductmethod",pro_id);
	}

	/* 제품 등록 상세보기 내부 페이징 */
	public int getProListokCont(String pro_id) throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultprolistokcont",pro_id);
	}

	@SuppressWarnings("unchecked")
	public List<OrderBean> getProListOk(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultadminproductlist",pageRow);
	}
	
	/* 제품 등록 상세보기 내부 페이징 */
	public int getProListokCont1(String pro_id) throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultprolistokcont1",pro_id);
	}

	@SuppressWarnings("unchecked")
	public List<OrderBean> getProListOk1(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultadminproductlist1",pageRow);
	}

	public OrderBean getProductRegistration(String cart_no) throws SQLException {
		return (OrderBean) SqlMapLocator.getMapper().queryForObject("productregistration",cart_no);
	}

	/* 관리자 결제금액 확인시 레벌 수정 */
	public void updateDealCheck(String cart_no) throws SQLException {
		SqlMapLocator.getMapper().update("updatedealcheck",cart_no);
	}

	/* 제품구매 신청 리스트 페이징 */
	public int getProListokCont2(String pro_id) throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultprolistokcont1",pro_id);
	}

	@SuppressWarnings("unchecked")
	public List<OrderBean> getProListOk2(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultadminproductlist1",pageRow);
	}

	/* 관리자 회원 강제 탈퉤 */
	public void deleteMember(String user_id) throws SQLException {
		SqlMapLocator.getMapper().update("adminupdatemember",user_id);
	}

	/* 관리자 회원탈퉤 관련 등록품 삭제 */
	public void deleteOrder(String user_id) throws SQLException {
		SqlMapLocator.getMapper().update("adminupdateorder",user_id);
	}
	
	/* 관리자 제품 등록 승인 */
	public int insertproductok(String pro_id) throws SQLException {
		return (int)SqlMapLocator.getMapper().update("insertproductok",pro_id);
	}

	/* 관리자 제품 등록 취소 */
	public void receptproduct(Map<String, Object> map) throws SQLException {
		SqlMapLocator.getMapper().update("receptproduct",map);
	}

	/* 관리자 제품/구매 상세보기  */
	public ProductInsertBean getProductMethod(String pro_id) throws SQLException {
		return (ProductInsertBean) SqlMapLocator.getMapper().queryForObject("resultProdctDetail",pro_id);
	}

	/* 관리자 제품 구매 상세정보 */
	public OrderBean getOrderMethod(String order_no) throws SQLException {
		return (OrderBean) SqlMapLocator.getMapper().queryForObject("resultorderdate",order_no);
	}

//	관리자 삭제 기능
	public void deletesomedate(String order_no) throws SQLException {
		SqlMapLocator.getMapper().update("deletesomedate",order_no);
	}

}
