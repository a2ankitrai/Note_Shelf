package com.ank.noteshelf.model;
// Generated Nov 11, 2018 10:39:00 PM by Hibernate Tools 5.2.11.Final


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * NsUser generated by hbm2java
 */
@Entity
@Table(name = "NS_USER", catalog = "Note_shelf_DB",
    uniqueConstraints = @UniqueConstraint(columnNames = "USER_NAME"))
public class NsUser implements java.io.Serializable {


  private byte[] userId;
  private String userName;
  private String email;
  private Date createdDate;
  private Date updatedDate;

  public NsUser() {}


  public NsUser(byte[] userId, String userName) {
    this.userId = userId;
    this.userName = userName;
  }

  public NsUser(byte[] userId, String userName, String email, Date createdDate, Date updatedDate) {
    this.userId = userId;
    this.userName = userName;
    this.email = email;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  @Id


  @Column(name = "USER_ID", unique = true, nullable = false)
  public byte[] getUserId() {
    return this.userId;
  }

  public void setUserId(byte[] userId) {
    this.userId = userId;
  }


  @Column(name = "USER_NAME", unique = true, nullable = false, length = 100)
  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  @Column(name = "EMAIL", length = 100)
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "CREATED_DATE", length = 19)
  public Date getCreatedDate() {
    return this.createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "UPDATED_DATE", length = 19)
  public Date getUpdatedDate() {
    return this.updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }



}


