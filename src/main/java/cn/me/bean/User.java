/**
 * 
 */
package cn.me.bean;

/**
 * @author WS
 *
 */
public class User {
	public User() {
		
	}
	public User(String id, String name, String psw, int age, String phone, String address, String city) {
		super();
		this.id = id;
		this.name = name;
		this.psw = psw;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.city = city;
	}
	public User(String name, String psw, int age, String phone, String address, String city) {
		super();
		
		this.name = name;
		this.psw = psw;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.city = city;
	}
	private String id;
	private String name;
	private String psw;
	private int age;
	private String phone;
	private String address;
	private String city;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
