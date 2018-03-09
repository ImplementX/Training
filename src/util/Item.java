package util;

public class Item {
	private int id;
	private String name;
	private String describe;
	private String path;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public Item() {
		super();
	}
	public Item(String name, String describe, String path) {
		super();
		this.name = name;
		this.describe = describe;
		this.path = path;
	}
	
	
}
