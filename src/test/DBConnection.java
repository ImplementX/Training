package test;


 class person{
	private int id;
	private String name;
	public int getNo() {
		return id;
	}
	public void setNo(int no) {
		this.id = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
 
 class student extends person{
	 private int classid;
	 private int grade;
 }
 class teacher extends person{
	 private String department;
	 private String title;
 }