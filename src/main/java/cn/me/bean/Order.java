/**
 * 
 */
package cn.me.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author WS
 *
 */
public class Order {
	public Order() {
		
	}
	public Order(String oid, String id, String bid, String bname, String name, String phone, String address, int amount,
			BigDecimal sum, Date create_time) {
		super();
		this.oid = oid;
		this.id = id;
		this.bid = bid;
		this.bname = bname;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.amount = amount;
		this.sum = sum;
		this.create_time = create_time;
	}
	private String oid;
	private String id;
	private String bid;
	private String bname;
	private String name;
	private String phone;
	private String address;
	private int amount;
	private BigDecimal sum;
	private Date create_time;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	

	
}
