package productmanagement.services.impl;

import java.util.List;

import productmanagement.dao.UserDao;
import productmanagement.dao.impl.UserDaoImpl;
import productmanagement.model.entity.User;
import productmanagement.services.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();

	@Override
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	@Override
	public List<User> searchUser(String name, boolean choice) {
		return userDao.searchUser(name, choice);
	}

	@Override
	public List<User> getAllUsersActive() {
		return userDao.getAllUsersActive();
	}

	@Override
	public List<User> getAllUsersDisable() {
		return userDao.getAllUsersDisable();
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUsers();
	}

	@Override
	public User searchUserById(int id) {
		return userDao.searchUserById(id);
	}
	
	@Override
	public User searchUserByGmail(String gmail) {
		return userDao.getUserByEmail(gmail);
	}

	@Override
	public boolean restoreUser(int id) {
		return userDao.restoreUser(id);
	}
	
	@Override
	public int authenticate(String gmail, String password) {
        // Trả về các trạng thái cụ thể
        if (!userDao.isUserExists(gmail)) {
            return -1; // Tài khoản chưa tồn tại
        } else {
        	if(!userDao.authenticate(gmail, password)) {
        		return 0; // Sai mật khẩu
        	} else {
        		User user = userDao.getUserByEmail(gmail);
                if (user.getStatus() == 0) {
                    return -2; // Tài khoản bị ban
                } else {
                	if(user.getRoleId() == 1) {
                    	return 2; // Đăng nhập với quyền admin
                    } else return 1; // Đăng nhập với quyền user
                }
        	}
        	
        }
        
    }
	
	@Override
    public boolean isUserExists(String gmail) {
        return userDao.isUserExists(gmail);
    }

}
