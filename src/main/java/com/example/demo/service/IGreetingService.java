package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;

import com.example.demo.model.Greeting;

@Service
public interface IGreetingService {
	Greeting greetingMessage();
	String gettingMessageByName(UserDto userDto);
	Greeting findById(long messId);
	List<Greeting> getMessages();
	Greeting editMessage(Greeting greeting);
	Greeting deleteMessage(Long messId);
}
