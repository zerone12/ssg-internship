package ssg.prototype.ssginternshipwebapp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository rep;
	
	@Override
	public List<User> getAllUsers() {
		return rep.findAll();
	}
	
	@Override
	public User getUserById(long id) {
		Optional<User> userDb = rep.findById(id);
		
		if (userDb.isPresent()) {
			return userDb.get();
		}else {
			return null;
		}
	}

	@Override
	public User createUser(User user) {
		return rep.save(user);
	}

	@Override
	public User updateUser(User user) {
		Optional<User> userDb = rep.findById(user.getId());
		
		if (userDb.isPresent()) {
			User update = userDb.get();
			
			update.setId(user.getId());
			update.setFirstName(user.getFirstName());
			update.setLastName(user.getLastName());
			update.setEmail(user.getEmail());
			update.setCity(user.getCity());
			update.setStreet(user.getStreet());
			update.setZipCode(user.getZipCode());
			return update;
		} else {
			return null;
		}
	}

	@Override
	public void deleteUser(long id) {
		Optional<User> userDb = rep.findById(id);
		
		if (userDb.isPresent()) {
			rep.delete(userDb.get());
		}
	}
	
}
