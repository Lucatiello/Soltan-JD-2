package by.htp.ex.bean;

import java.util.Objects;

public class NewUserInfo {
	
	private int userID;
	private String name;
	private String surname;
	private String login;
	private String password;
	private String email;
	
	private String role;
	
	public NewUserInfo() {
		super();
	}

	public NewUserInfo(int userID, String name, String surname, String login, String password, String email, String role) {
		super();
		
		this.userID = userID;
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	public NewUserInfo(String name, String surname, String login, String password, String email, String role) {
		super();
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	public NewUserInfo(int userID, String login, String role) {
		super();
		this.userID = userID;
		this.login = login;
		this.role = role;
	}

	
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, login, name, password, role, surname, userID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewUserInfo other = (NewUserInfo) obj;
		return Objects.equals(email, other.email) && Objects.equals(login, other.login)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && Objects.equals(surname, other.surname) && userID == other.userID;
	}

	@Override
	public String toString() {
		return "NewUserInfo [userID=" + userID + ", name=" + name + ", surname=" + surname + ", login=" + login
				+ ", password=" + password + ", email=" + email + ", role=" + role + "]";
	}

	
	
	
	
	
}
