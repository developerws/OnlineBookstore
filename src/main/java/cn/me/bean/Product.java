/**
 * 
 */
package cn.me.bean;

import java.math.BigDecimal;

/**
 * @author WS
 *
 */
public class Product {
	public Product() {
		
	}
	/**
	 * @param bid
	 * @param author
	 * @param bname
	 * @param price
	 * @param image
	 * @param pintro
	 */
	
	public Product(String bid, String author, String bname, BigDecimal price, String image, String pintro) {
		super();
		this.bid = bid;
		this.author = author;
		this.bname = bname;
		this.price = price;
		this.image = image;
		this.pintro = pintro;
	}
	private String bid;
	private String author;
	private String bname;
	private BigDecimal price;
	private String image;
	private String pintro;
	/**
	 * @return the bid
	 */
	public String getBid() {
		return bid;
	}
	/**
	 * @param bid the bid to set
	 */
	public void setBid(String bid) {
		this.bid = bid;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the bname
	 */
	public String getBname() {
		return bname;
	}
	/**
	 * @param bname the bname to set
	 */
	public void setBname(String bname) {
		this.bname = bname;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the pintro
	 */
	public String getPintro() {
		return pintro;
	}
	/**
	 * @param pintro the pintro to set
	 */
	public void setPintro(String pintro) {
		this.pintro = pintro;
	}
	
		
	
}
