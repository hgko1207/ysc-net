package org.onsemiro.ysc.net.service;

import java.util.List;

import org.onsemiro.ysc.net.domain.db.User;
import org.onsemiro.ysc.net.domain.param.SearchParam;

public interface UserService extends CRUDService<User, Integer> {

	User login(String username, String password);

	List<User> getList(SearchParam param);
}