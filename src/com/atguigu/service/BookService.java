package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.dao.BookDao;

@Service
public class BookService {
	
	@Autowired
	BookDao bookDao;
	
	/**
	 * 用户买书
	 * @param userName
	 * @param isbn
	 */
	@Transactional
	public void checkout(String userName,String isbn) {
		//减库存
		bookDao.updateStock(isbn);
		
		//获取书价
		int price = bookDao.getPrice(isbn);
		
		//减用户余额
		bookDao.updateBalance(userName, price);
	}
}
