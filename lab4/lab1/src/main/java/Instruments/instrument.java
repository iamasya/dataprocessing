package Instruments;

import java.io.Serializable;

public class instrument implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String info;
	private float price;
	
	public instrument(int id, String title, String info, float price) {
		super();
		this.id = id;
		this.title = title;
		this.info = info;
		this.price = price;
	}
	public instrument() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "{\"id\": \""+id+"\",\"title\": \""+title+"\", \"info\": \""+info+"\", \"price\": "+price+"}";
	}
	
}
