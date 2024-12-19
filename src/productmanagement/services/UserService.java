package productmanagement.services;

import java.util.List;

import productmanagement.model.entity.User;

public interface UserService {
	boolean addUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(int id);

	boolean restoreUser(int id);

	public List<User> searchUser(String name, boolean choice);

	List<User> getAllUsersActive();

	List<User> getAllUsersDisable();

	List<User> getAllUser();

	User searchUserById(int id);
	
	User searchUserByGmail(String gmail);
	
	int authenticate(String gmail, String password);
	
	boolean isUserExists(String gmail);
}
