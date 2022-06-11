package entity;

public class instruments {
	
	private String title;
	private String info;
	private float price;
	
	public instruments(String title, String info, float price) {
		super();
		this.title = title;
		this.info = info;
		this.price = price;
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
		return "{\"title\": \""+title+"\", \"info\": \""+info+"\", \"price\": "+price+"}";
	}
	
	
}
