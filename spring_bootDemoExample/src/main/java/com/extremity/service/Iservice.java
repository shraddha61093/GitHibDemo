package com.extremity.service;

import java.util.ArrayList;
import java.util.List;

import com.extremity.model.User;

public interface Iservice {

	public void saveUser(User user);
	public int loginCheck(User user);
	public int deleteUser(User user);
	public ArrayList<User> displayAll(User user);
	public User editUser(User user);
	public int updateUser(User user);
}
