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

/**
 * NsUserProfile generated by hbm2java
 */
@Entity
@Table(name = "NS_USER_PROFILE", catalog = "Note_shelf_DB")
public class NsUserProfile implements java.io.Serializable {

	private Integer userProfileId;
	private int userId;
	private String gender;
	private String profileImage;
	private String work;
	private String contactNumber;
	private String birthDate;
	private String birthYear;
	private String language;
	private Date createdDate;
	private Date updatedDate;

	public NsUserProfile() {
	}

	public NsUserProfile(int userId) {
		this.userId = userId;
	}

	public NsUserProfile(int userId, String gender, String profileImage, String work, String contactNumber,
			String birthDate, String birthYear, String language, Date createdDate, Date updatedDate) {
		this.userId = userId;
		this.gender = gender;
		this.profileImage = profileImage;
		this.work = work;
		this.contactNumber = contactNumber;
		this.birthDate = birthDate;
		this.birthYear = birthYear;
		this.language = language;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "USER_PROFILE_ID", unique = true, nullable = false)
	public Integer getUserProfileId() {
		return this.userProfileId;
	}

	public void setUserProfileId(Integer userProfileId) {
		this.userProfileId = userProfileId;
	}

	@Column(name = "USER_ID", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "GENDER", length = 1)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "PROFILE_IMAGE", length = 300)
	public String getProfileImage() {
		return this.profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	@Column(name = "WORK", length = 45)
	public String getWork() {
		return this.work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	@Column(name = "CONTACT_NUMBER", length = 20)
	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name = "BIRTH_DATE", length = 10)
	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "BIRTH_YEAR", length = 5)
	public String getBirthYear() {
		return this.birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	@Column(name = "LANGUAGE", length = 45)
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
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
