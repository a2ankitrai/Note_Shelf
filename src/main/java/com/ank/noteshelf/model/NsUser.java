package com.ank.noteshelf.model;
// Generated Jun 16, 2018 12:30:45 AM by Hibernate Tools 5.2.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * NsUser generated by hbm2java
 */
@Entity
@Table(name = "NS_USER", catalog = "Note_shelf_DB", uniqueConstraints = @UniqueConstraint(columnNames = "USER_NAME"))
public class NsUser implements java.io.Serializable {

	private Integer userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private Date createdDate;
	private Date updatedDate;

	public NsUser() {
	}

	public NsUser(String userName) {
		this.userName = userName;
	}

	public NsUser(String userName, String firstName, String lastName, String email, Date createdDate,
			Date updatedDate) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "USER_ID", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME", unique = true, nullable = false, length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "FIRST_NAME", length = 50)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", length = 50)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 26)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", length = 26)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
