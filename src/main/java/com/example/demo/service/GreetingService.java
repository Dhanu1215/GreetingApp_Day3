package com.example.demo.service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.Greeting;
import com.example.demo.model.User;
import com.example.demo.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService {
	
	 private static final String template = "Hello world";
	 private final AtomicLong counter = new AtomicLong();
	 
	 @Autowired
	 private GreetingRepository greetingRepository;
	 
	 /**
	  * Call method to save the message in the repository
	  */
	 @Override
	 public Greeting greetingMessage() {
		 return greetingRepository.save(new Greeting(counter.incrementAndGet(), String.format(template)));
	 }
	 
	 @Override
	 public String gettingMessageByName(UserDto userDto) {
		 User user = new User();
		 ModelMapper modelMapper = new ModelMapper();
		 modelMapper.map(userDto, user);
		 return ("Hello" +" "+ user.getFirstName() + " " + user.getLastName()+"...");
	}
	
	 /**
	  * Call method to find the message by message Id
	  */
	@Override
	public Greeting findById(long messId) {
		return greetingRepository.findById(messId).get();
	}
	
	/**
	 * Call method to list all the messages
	 */
	@Override
	public List<Greeting> getMessages() {
		return greetingRepository.findAll();
	}

	/**
	 * Call method to edit message
	 */
	@Override
	public Greeting editMessage(Greeting greeting) {
		return greetingRepository.save(new Greeting(2,"Hello World..."));
	}
	 
}