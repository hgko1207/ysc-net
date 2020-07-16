package org.onsemiro.ysc.net.service;

import org.onsemiro.ysc.net.domain.db.User;

public interface UserService extends CRUDService<User, Integer> {

	User login(String username, String password);
}