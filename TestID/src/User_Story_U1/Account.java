package User_Story_U1;

public class Account {
	
	private String id,password,status;
	
	public Account() {
		id = "";
		password ="";
		status = "";
	}
	public Account(String id,String password,String status) {
		this.id = id;
		this.password = password;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return "ID:"+id+" PASSWORD:"+password+" STATUS:"+status;
	}

}
