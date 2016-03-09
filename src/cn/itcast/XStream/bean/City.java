package cn.itcast.XStream.bean;

public class City {
	private String name;//市名
	private String description;//介绍
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public City(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public City(String name) {
		super();
		this.name = name;
	}
	
	public City() {
		super();
	}
	
	
}
