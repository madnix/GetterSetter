package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.OrderBean;
import utils.SqlMapLocator;

public class CartDao {

	/* ��ٱ��Ͽ� ���� ��� */
	public void insertCartInfo(OrderBean cart_bean) throws SQLException {
		SqlMapLocator.getMapper().insert("insertCartInfo", cart_bean);
	}

	/* User �� �´� ��ٱ��� ���� �������� */
	public List<OrderBean> getUserCartInfo(String id) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("getUserCartInfo", id);
	}

	/* DB�� ��ٱ��� �ߺ� ��ǰ �ִ��� üũ */
	public int checkCartInfo(OrderBean cart_bean) throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("checkCartInfo",
				cart_bean);
	}

	/* �ߺ� ��ǰ�� ��ٱ��Ͽ� ���� �� ������ �߰� */
	public void addCartProduct(OrderBean cart_bean) throws SQLException {
		SqlMapLocator.getMapper().update("addCartProduct", cart_bean);
	}

	/* ��ٱ��� �ϳ� ��ǰ �����ϱ� */
	public int cartOneDelete(Map<String, Object> map) throws SQLException {
		return (int) SqlMapLocator.getMapper().delete("cartOneDelete", map);
	}

	/* ��ٱ��� ������ ��ǰ �����ϱ� */
	public int cartCheckDelete(Map<String, Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return (int) SqlMapLocator.getMapper().delete("cartCheckDelete", map);
	}

	/* orderProduct ���̺� key ���� ���� ��ǰ ���� */
	public OrderBean getCartProductInfo(int order_no) throws SQLException {
		return (OrderBean) SqlMapLocator.getMapper().queryForObject(
				"getCartProductInfo", order_no);
	}

	/* ��ٱ��Ͽ��� ���� ���� */
	public int CartCountModify(Map<String, Object> map) throws SQLException {
		return (int) SqlMapLocator.getMapper().update("CartCountModify", map);
	}

	/* ��ٱ��Ͽ� ��ǰ ���� ���� */
	public int getUserCartTotal(String id) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer) SqlMapLocator.getMapper().queryForObject(
				"getUserCartTotal", id);
	}

	// --------------------------------------------------------
	// ��ٱ��Ͽ��� �ֹ��� �� ��������� ���� ^ deal_check ����
	// --------------------------------------------------------
	public int Order_dealcheck_Edit(Map<String, Object> map) throws SQLException {
		return SqlMapLocator.getMapper().update("Order_dealcheck_Edit", map);
	}

	// -------------
	// ���Ÿ�� ��Ȳ
	// -------------
	public List<OrderBean> getOrderSearchList(String id) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("getOrderSearchList", id);
	}

	//	-------------------------------------------
	//  ��ٱ��Ͽ� �ִ� ���� buy_and_cart=Y �� ����
	//  -------------------------------------------
	public void changeBuyCart(String order_no) throws SQLException {
		SqlMapLocator.getMapper().update("changeBuyCart", order_no);		
	}

	// --------------------------
	// �ٷα����̿��ؼ� ��ǰ ����
	// --------------------------
	public int InsertOrderProduct(OrderBean orderBean) throws SQLException {
		return (int) SqlMapLocator.getMapper().update("InsertOrderProduct", orderBean);
	}

}








