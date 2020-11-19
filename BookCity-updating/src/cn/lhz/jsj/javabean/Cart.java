package cn.lhz.jsj.javabean;

import java.util.List;

public class Cart {
	
	private String bookId;
	private String bookName;
	private String bookType;
	private String bookStock;
	private String bookPrice;
	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getBookStock() {
		return bookStock;
	}

	public void setBookStock(String bookStock) {
		this.bookStock = bookStock;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(String bookId, String bookName, String bookType, String bookStock, String bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookType = bookType;
		this.bookStock = bookStock;
		this.bookPrice = bookPrice;
	}
	
}
