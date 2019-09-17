package com.basic.dao;

import java.util.List;

import com.basic.model.Dean;
import com.basic.model.User;
import com.basic.util.Pager;

public interface IUser {
	public void addUser(User user);
	public User loadUser(String username,String password);
	public List<User> loadUser(String username);
	public Pager<User> load(String content,int pageIndex,int pageSize);
	public User loadUser(int id);
	public List<User> load();
	public Pager<User> load(String content);
}
