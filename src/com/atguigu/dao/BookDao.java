package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 减用户余额
	 * @param userName
	 * @param price
	 */
	public void updateBalance(String userName,int price) {
		String sql = "update account set balance = balance - ? where username = ?";
		jdbcTemplate.update(sql,price,userName);
	}
	
	/**
	 * 按图书isbn获取书价格
	 * @param isbn
	 * @return
	 */
	public int getPrice(String isbn) {
		String sql = "select price from book where isbn = ?";
		return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
	}
	
	/**
	 * 按书减库存
	 * @param isbn
	 */
	public void updateStock(String isbn) {
		String sql = "update book_stock set stock = stock - 1 where isbn = ?";
		jdbcTemplate.update(sql,isbn);
	}
}
