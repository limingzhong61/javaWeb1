package pojo;

public class User {
	private Integer userId;

	private String username;

	private String password;

	private String phone;

	private String address;

	public Integer getuserId() {
		return this.userId;
	}

	public void setuserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "user [userId=" + userId + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", address=" + address + "]";
	}
}
