package lab5.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instrument1")
public class Instrument {
	@Id
	@GeneratedValue
	int id;
	String title;
	String info;
	int price;
	
	
	public Instrument() {
		
	}
	
	
	public Instrument(int id, String title, String info, int price) {
		this.id = id;
		this.title = title;
		this.info = info;
		this.price = price;
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
	public int getPrice() {
		return price;
	}
	public void setAge(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "{\"id\":"+id+",\"title\":\""+title+"\", \"info\":\""+info+"\", \"price\":"+price+"}";
	}
	

}
