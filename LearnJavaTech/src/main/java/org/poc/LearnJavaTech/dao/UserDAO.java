package org.poc.LearnJavaTech.dao;

import java.util.List;
import org.poc.LearnJavaTech.model.User;
import org.poc.LearnJavaTech.model.Employee;

public interface UserDAO {
	List<User> getUsers();
}
