package productmanagement.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import productmanagement.SystemConstant;
import productmanagement.dao.UserDao;
import productmanagement.model.entity.User;
import productmanagement.utils.CipherUtils;

public class UserDaoImpl implements UserDao{
	private List<User> userList;
	private static final String FILE_NAME = "User.bin";
	private static int currentId;

	public UserDaoImpl() {
		userList = loadUserList();
		if (!userList.isEmpty()) {
			currentId = userList.get(userList.size() - 1).getId();
		} else {
			currentId = 0;
		}
	}

	@Override
	public boolean addUser(User user) {
		user.setId(generateId());
		if (userList.add(user)) {
			saveUserList();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId() == user.getId()) {
				userList.set(i, user);
				saveUserList();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId() == id) {
				User user = userList.get(i);
				user.setStatus(0);
				userList.set(i, user);
				saveUserList();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean restoreUser(int id) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId() == id) {
				User user = userList.get(i);
				user.setStatus(1);
				userList.set(i, user);
				saveUserList();
				return true;
			}
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> result = loadUserList();
		return result;
	}

	@Override
	public List<User> getAllUsersActive() {
		List<User> userList = loadUserList();
		List<User> result = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getStatus() == 1) {
				result.add(userList.get(i));
			}
		}
		return result;
	}

	@Override
	public List<User> getAllUsersDisable() {
		List<User> userList = loadUserList();
		List<User> result = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getStatus() == 0) {
				result.add(userList.get(i));
			}
		}
		return result;
	}

	@Override
	public List<User> searchUser(String name, boolean choice) {
		List<User> result = new ArrayList<>();
		if(choice) {
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getFullName().toLowerCase().contains(name.toLowerCase()) && userList.get(i).getStatus() == 1) {
					result.add(userList.get(i));
				}
			}
		} else {
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getFullName().toLowerCase().contains(name.toLowerCase()) && userList.get(i).getStatus() == 0) {
					result.add(userList.get(i));
				}
			}
		}
		return result;
	}

	@Override
	public User searchUserById(int id) {
		User user = new User();
		for (User element : userList) {
			if (element.getId() == id) {
				user = element;
				return user;
			}
		}
		return null;
	}
	
	@Override
    public boolean isUserExists(String gmail) {
        for (User user : userList) {
            if (user.getGmail().equals(gmail)) {
                return true;
            }
        }
        return false;
    }
	
	@Override
    public boolean authenticate(String gmail, String password) {
        byte[] key = CipherUtils.hexStringToByteArray(SystemConstant.getHexkey());
        for (User user : userList) {
        	String passwordDecypted = CipherUtils.decrypt(user.getPassword(), key);
            if (user.getGmail().equals(gmail) && password.equals(passwordDecypted)) {
                return true;
            }
        }
        return false;
    }
	
	@Override
    public User getUserByEmail(String email) {
        for (User user : userList) {
            if (user.getGmail().equals(email)) {
                return user;
            }
        }
        return null; // Trả về null nếu không tìm thấy user với email tương ứng
    }

	private void saveUserList() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
			for (User user : userList) {
				writer.write(user.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Phương thức này để đọc dữ liệu từ trong file
	 * @return danh sách các tài khoản trong hệ thống
	 */
	private List<User> loadUserList() {
		List<User> userList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String data;
			while ((data = reader.readLine()) != null) {
				User user = User.fromStringToUser(data);
				userList.add(user);
			}
		} catch (IOException e) {
			userList = new ArrayList<>();
		}
		return userList;
	}

	private int generateId() {
		return ++currentId;
	}

}
