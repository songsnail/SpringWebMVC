package com.springmvc.repository.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.springmvc.domain.Cart;
import com.springmvc.repository.CartRepository;

@Repository
public class CartRepositoryImpl implements CartRepository{
	
	private Map<String, Cart> listOfCarts;
	

	public CartRepositoryImpl() {
		listOfCarts = new HashMap<String,Cart>();		
	}
	
	
	public Cart create(Cart cart) {
		if(listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("��ٱ��ϸ� ������ �� �����ϴ�. ��ٱ��� id(%)�� �����մϴ�",	cart.getCartId()));			
		}

		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}
	
	
	public Cart read(String cartId) {
		return listOfCarts.get(cartId);
	}

	public void update(String cartId, Cart cart) {
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("��ٱ��� ����� ������ �� �����ϴ�. ��ٱ���  id(%)�� �������� �ʽ��ϴ�",cartId));			
		}

		listOfCarts.put(cartId, cart);
	}

	
	public void delete(String cartId) {
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("��ٱ��� ����� ������ �� �����ϴ�. ��ٱ���  id(%)�� �������� �ʽ��ϴ�",cartId));			
		}
		

		listOfCarts.remove(cartId);
	}

}
