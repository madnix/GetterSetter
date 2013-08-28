package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.MemberBean;
import model.OrderBean;
import model.ProductInsertBean;
import utils.SqlMapLocator;

public class AdminDao {

	/* ��� �Ǹ��� �ݳ� */
	public int getAdminTotalCont() throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultpusercount");
	}

	/* �Ǹ��� �ݳ� ����¡ */
	@SuppressWarnings("unchecked")
	public List<MemberBean> selectAdminPage(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("selectpagepuserlist", pageRow);
	}

	/* ��� ������ �ݳ� */
	public int getAdminTotalCont2() throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultcusercount");
	}

	/* ������ �ݳ�����¡ */
	@SuppressWarnings("unchecked")
	public List<MemberBean> selectAdminPage2(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("selectpagecuserlist", pageRow);
	}

	/* ��ǰ ����Ʈ */
	public int getProCont() throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultprocount");
	}

	/* ��ǰ ����Ʈ ����¡ */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getProListMethod(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultprolist", pageRow);
	}

	/* ��ǰ ��� ��û */
	public int getRboxCont() throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultrboxcount");
	}

	/* ��ǰ ��� ����¡ */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getReceptionListMethod(
			Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultreceptionlist",pageRow);
	}

	/* ������ ��ǰ ���� ���� */
	public int getCheckOutCont() throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultcheckoutcont");
	}

	/* ������ ��ǰ ���� ���� ����¡ */
	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getCheckOutListMethod(
			Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultcheckoutlistmethod", pageRow);
	}

	/* ������ ���� ������ */
	public MemberBean getAllUserList(String puserid) throws SQLException {
		return (MemberBean) SqlMapLocator.getMapper().queryForObject("getAllUserList" ,puserid);
	}

	/* ������ ���� ��� ��ǰ ī��Ʈ */
	public int getAllProductCont(String puserid) throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultallproductcount",puserid);
	}

	@SuppressWarnings("unchecked")
	public List<ProductInsertBean> getAllProductlist(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultallproductlist",pageRow);
	}

	/* ������ ������ �󼼺��� */
	public int getAllProductCont2(String cuserid) throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultallproductcount2",cuserid);
	}

	/* ������ ������ ����¡ */
	@SuppressWarnings("unchecked")
	public List<OrderBean> getAllProductlist2(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultallproductlist2",pageRow);
	}

	/* ������ ������ ���� ��û �󼼺��� */
	public int getAllProCont3(String cuserid) throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultallproductcount3",cuserid);
	}

	@SuppressWarnings("unchecked")
	public List<OrderBean> getAllProductlist3(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultallproductlist3",pageRow);
	}

	/* ��ǰ ���  */
	public ProductInsertBean getprolist(String pro_id) throws SQLException {
		return (ProductInsertBean) SqlMapLocator.getMapper().queryForObject("resutlproductmethod",pro_id);
	}

	/* ��ǰ ��� �󼼺��� ���� ����¡ */
	public int getProListokCont(String pro_id) throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultprolistokcont",pro_id);
	}

	@SuppressWarnings("unchecked")
	public List<OrderBean> getProListOk(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultadminproductlist",pageRow);
	}
	
	/* ��ǰ ��� �󼼺��� ���� ����¡ */
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

	/* ������ �����ݾ� Ȯ�ν� ���� ���� */
	public void updateDealCheck(String cart_no) throws SQLException {
		SqlMapLocator.getMapper().update("updatedealcheck",cart_no);
	}

	/* ��ǰ���� ��û ����Ʈ ����¡ */
	public int getProListokCont2(String pro_id) throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("resultprolistokcont1",pro_id);
	}

	@SuppressWarnings("unchecked")
	public List<OrderBean> getProListOk2(Map<String, Object> pageRow) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("resultadminproductlist1",pageRow);
	}

	/* ������ ȸ�� ���� Żơ */
	public void deleteMember(String user_id) throws SQLException {
		SqlMapLocator.getMapper().update("adminupdatemember",user_id);
	}

	/* ������ ȸ��Żơ ���� ���ǰ ���� */
	public void deleteOrder(String user_id) throws SQLException {
		SqlMapLocator.getMapper().update("adminupdateorder",user_id);
	}
	
	/* ������ ��ǰ ��� ���� */
	public int insertproductok(String pro_id) throws SQLException {
		return (int)SqlMapLocator.getMapper().update("insertproductok",pro_id);
	}

	/* ������ ��ǰ ��� ��� */
	public void receptproduct(Map<String, Object> map) throws SQLException {
		SqlMapLocator.getMapper().update("receptproduct",map);
	}

	/* ������ ��ǰ/���� �󼼺���  */
	public ProductInsertBean getProductMethod(String pro_id) throws SQLException {
		return (ProductInsertBean) SqlMapLocator.getMapper().queryForObject("resultProdctDetail",pro_id);
	}

	/* ������ ��ǰ ���� ������ */
	public OrderBean getOrderMethod(String order_no) throws SQLException {
		return (OrderBean) SqlMapLocator.getMapper().queryForObject("resultorderdate",order_no);
	}

//	������ ���� ���
	public void deletesomedate(String order_no) throws SQLException {
		SqlMapLocator.getMapper().update("deletesomedate",order_no);
	}

}
