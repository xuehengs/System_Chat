package com.pojo;

import java.util.Date;

public class User {
	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column user.id
	 *
	 * @mbg.generated
	 */
	private Integer id;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column user.username
	 *
	 * @mbg.generated
	 */
	private String username;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column user.password
	 *
	 * @mbg.generated
	 */
	private String password;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column user.creat_time
	 *
	 * @mbg.generated
	 */
	private Date creatTime;
	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column user.creat_time
	 *
	 * @mbg.generated
	 */
	private String img;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column user.id
	 *
	 * @return the value of user.id
	 *
	 * @mbg.generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column user.id
	 *
	 * @param id the value for user.id
	 *
	 * @mbg.generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column user.username
	 *
	 * @return the value of user.username
	 *
	 * @mbg.generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column user.username
	 *
	 * @param username the value for user.username
	 *
	 * @mbg.generated
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column user.password
	 *
	 * @return the value of user.password
	 *
	 * @mbg.generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column user.password
	 *
	 * @param password the value for user.password
	 *
	 * @mbg.generated
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column user.creat_time
	 *
	 * @return the value of user.creat_time
	 *
	 * @mbg.generated
	 */
	public Date getCreatTime() {
		return creatTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column user.creat_time
	 *
	 * @param creatTime the value for user.creat_time
	 *
	 * @mbg.generated
	 */
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
}