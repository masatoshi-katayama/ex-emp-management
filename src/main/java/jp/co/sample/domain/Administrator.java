package jp.co.sample.domain;

public class Administrator {

	private Integer Id;
	private String name;
	private String mailAddress;
	private String password;
	
	 public Administrator(){
	//	処理は何も記述しなくてよい
	//←左のスラッシュをjavadocコメントという
	}

	public Administrator(Integer id, String name, String mailAddress, String password) {
		//全ての引数に取るコンストラクター
		super();
		Id = id;
		this.name = name;
		this.mailAddress = mailAddress;
		this.password = password;
	}

	
	//get,set
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	//toString()
	@Override
	public String toString() {
		return "Administrator [Id=" + Id + ", name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
