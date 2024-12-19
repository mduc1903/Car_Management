package productmanagement.dao;

import java.util.List;

import productmanagement.model.entity.User;

public interface UserDao {
	boolean addUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(int id);

	boolean restoreUser(int id);

	List<User> getAllUsers();

	List<User> getAllUsersActive();

	List<User> getAllUsersDisable();

	List<User> searchUser(String name, boolean choice);

	User searchUserById(int id);
	
	boolean isUserExists(String gmail);
	
	boolean authenticate(String gmail, String password);
	
	User getUserByEmail(String email);
}
