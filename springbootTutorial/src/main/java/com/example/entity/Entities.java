package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Entities {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
//	@NotBlank(message="can't be null")
	private String sname;
	private String dept;
//	public int getSid() {
//		return sid;
//	}
//	public void setSid(int sid) {
//		this.sid = sid;
//	}
//	public String getSname() {
//		return sname;
//	}
//	public void setSname(String sname) {
//		this.sname = sname;
//	}
//	public String getDept() {
//		return dept;
//	}
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
//	
//	@Override
//	public String toString() {
//		return "Entities [sid=" + sid + ", sname=" + sname + ", dept=" + dept + "]";
//	}
}
