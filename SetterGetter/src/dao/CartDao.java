package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import model.OrderBean;
import utils.SqlMapLocator;

public class CartDao {

	/* 장바구니에 정보 담기 */
	public void insertCartInfo(OrderBean cart_bean) throws SQLException {
		SqlMapLocator.getMapper().insert("insertCartInfo", cart_bean);
	}

	/* User 에 맞는 장바구니 정보 가져오기 */
	public List<OrderBean> getUserCartInfo(String id) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("getUserCartInfo", id);
	}

	/* DB에 장바구니 중복 물품 있는지 체크 */
	public int checkCartInfo(OrderBean cart_bean) throws SQLException {
		return (int) SqlMapLocator.getMapper().queryForObject("checkCartInfo",
				cart_bean);
	}

	/* 중복 물품을 장바구니에 담을 시 수량만 추가 */
	public void addCartProduct(OrderBean cart_bean) throws SQLException {
		SqlMapLocator.getMapper().update("addCartProduct", cart_bean);
	}

	/* 장바구니 하나 물품 삭제하기 */
	public int cartOneDelete(Map<String, Object> map) throws SQLException {
		return (int) SqlMapLocator.getMapper().delete("cartOneDelete", map);
	}

	/* 장바구니 선택한 물품 삭제하기 */
	public int cartCheckDelete(Map<String, Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return (int) SqlMapLocator.getMapper().delete("cartCheckDelete", map);
	}

	/* orderProduct 테이블 key 값에 대한 물품 정보 */
	public OrderBean getCartProductInfo(int order_no) throws SQLException {
		return (OrderBean) SqlMapLocator.getMapper().queryForObject(
				"getCartProductInfo", order_no);
	}

	/* 장바구니에서 수량 수정 */
	public int CartCountModify(Map<String, Object> map) throws SQLException {
		return (int) SqlMapLocator.getMapper().update("CartCountModify", map);
	}

	/* 장바구니에 물품 갯수 정보 */
	public int getUserCartTotal(String id) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer) SqlMapLocator.getMapper().queryForObject(
				"getUserCartTotal", id);
	}

	// --------------------------------------------------------
	// 장바구니에서 주문할 때 배송지정보 수정 ^ deal_check 수정
	// --------------------------------------------------------
	public int Order_dealcheck_Edit(Map<String, Object> map) throws SQLException {
		return SqlMapLocator.getMapper().update("Order_dealcheck_Edit", map);
	}

	// -------------
	// 구매목록 현황
	// -------------
	public List<OrderBean> getOrderSearchList(String id) throws SQLException {
		return SqlMapLocator.getMapper().queryForList("getOrderSearchList", id);
	}

	//	-------------------------------------------
	//  장바구니에 있는 물건 buy_and_cart=Y 로 변경
	//  -------------------------------------------
	public void changeBuyCart(String order_no) throws SQLException {
		SqlMapLocator.getMapper().update("changeBuyCart", order_no);		
	}

	// --------------------------
	// 바로구매이용해서 물품 구매
	// --------------------------
	public int InsertOrderProduct(OrderBean orderBean) throws SQLException {
		return (int) SqlMapLocator.getMapper().update("InsertOrderProduct", orderBean);
	}

}








