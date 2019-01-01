package com.springmvc.domain;

import javax.validation.constraints.Size;
import  org.hibernate.validator.constraints.NotEmpty;
import com.springmvc.validator.MemberId;
import org.springframework.web.multipart.MultipartFile;

public class Member {

	@MemberId 
	@NotEmpty(message= "{NotEmpty.Member.id.validation}")
	private String id;
	
	@Size(min=4, max=50, message="{Size.Member.passwd.validation}")
	private String passwd;	
	
	@NotEmpty(message= "{NotEmpty.Member.passwd.validation}")
	private String passwd_confirm;			

	@NotEmpty(message= "{NotEmpty.Member.name.validation}")
	private String name;

	private String sex;	
	private String tel;
	private String address;	
	private String role;		

    private MultipartFile  image;
	
	private String  filename;
	
	public Member() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPasswd_confirm() {
		return passwd_confirm;
	}

	public void setPasswd_confirm(String passwd_confirm) {
		this.passwd_confirm = passwd_confirm;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + "]";
	}	
}
