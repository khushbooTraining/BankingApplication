package com.khushboo.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class UserDaoService {
	
	//jpa/hibernate/  ->database
	//DAoservise > static list
	//private User u;
	
	private static List<User> user=new ArrayList<>();
	private static int count=0;
	
	static{
				user.add(new User(++count,"khushboo",LocalDate.now().minusYears(30)));
				user.add(new User(++count,"Madhu",LocalDate.now().minusYears(20)));
				user.add(new User(++count,"Rakhi",LocalDate.now().minusYears(25)));
				user.add(new User(++count,"Nitu",LocalDate.now().minusYears(60)));
				
	}
	
	public List<User> findAll(){
		return user;
	
}
	
	public User saveUser(User user1) {
		user1.setId(++count);
		user.add(user1);
		return user1;
	}
	
	
	public User findOne(int id) {
		
		/*if(u.getId().equals(id)) {
			p.add(u);
		}
		return p.get(0);*/
		Predicate <? super User> predicate=user->user.getId().equals(id);
	return	user.stream().filter(predicate).findFirst().orElse(null);
	}	
	
	
	public void delete(int id) {
		Predicate <? super User> predicate=user->user.getId().equals(id);
		user.removeIf(predicate);
	}
	
	
}
