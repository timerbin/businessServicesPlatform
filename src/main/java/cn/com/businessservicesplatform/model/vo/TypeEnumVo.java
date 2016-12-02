package cn.com.businessservicesplatform.model.vo;

public class TypeEnumVo {
	
	public TypeEnumVo(){}
	
	public TypeEnumVo(int id,String des){
		this.id = id;
		this.des = des;
	}
	
	private int id;
	
	private String des;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
}
