/**
 * 
 */
package cn.me.bean;

import java.math.BigDecimal;

/**
 * @author WS
 *
 */
public class Cart {
	public Cart() {
		
	}
	public Cart(String id, String bid, String bname, String author, int amount, BigDecimal sum) {
		super();
		this.id = id;
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.amount = amount;
		this.sum = sum;
	}
	private String id;
	private String bid;
	private String bname;
	private String author;
	private int amount;
	private BigDecimal sum;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public BigDecimal getSum() {
		return sum;
	}
	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	
	
	
	
	
}
