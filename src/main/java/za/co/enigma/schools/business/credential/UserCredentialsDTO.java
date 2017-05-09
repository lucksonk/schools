package za.co.enigma.schools.business.credential;

import java.io.Serializable;


public class UserCredentialsDTO implements  Serializable {

	private static final long serialVersionUID = -3352120781946208014L;
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
