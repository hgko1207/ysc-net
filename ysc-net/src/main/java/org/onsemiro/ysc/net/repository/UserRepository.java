package org.onsemiro.ysc.net.repository;

import org.onsemiro.ysc.net.domain.db.User;

public interface UserRepository extends DefaultRepository<User, Integer> {

	User findByUserIdAndPassword(String userId, String password);

}
