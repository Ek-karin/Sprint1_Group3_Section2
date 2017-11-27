package User_Story_U5;

public class MailModel {
	
	private String mail;
	private long id;
	
	public MailModel(long id,String mail) {
		this.id = id;
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id + " " + mail;
	}

}
