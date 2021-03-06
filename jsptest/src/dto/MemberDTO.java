package dto;

public class MemberDTO {
	// 테이블내 1개 레코드 행이 memberDTO. 우리가 보려는 테이블은 member_table인데, 이 테이블에서 1개 레코드 행은 6개의 컬럼으로 구성되어 있다.
	String id, password, name, phone, email, address;
	
	// 기본생성자. jsp useBean에서 사용하려고.
	public MemberDTO() {	
	}
	
	public MemberDTO(String id, String password, String name, String phone, String email, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return id + " 회원의 암호는 " + password + " 이고 이름은 "
				+ name + ", 폰번호는 " + phone + " , 이메일은 "
				+ email + ", 주소는 " + address + " 입니다.";
	}
	
	
}
