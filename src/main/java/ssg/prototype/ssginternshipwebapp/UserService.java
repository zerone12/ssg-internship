package ssg.prototype.ssginternshipwebapp;

import java.util.List;

public interface UserService {
	User createUser(User user);
	
	User updateUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(long id);
	
	void deleteUser(long id);
}
