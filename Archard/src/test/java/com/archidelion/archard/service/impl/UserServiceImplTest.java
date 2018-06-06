package com.archidelion.archard.service.impl;

import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.archidelion.archard.bean.User;
import com.archidelion.archard.controller.exception.InvalidDataException;
import com.archidelion.archard.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Mock
	private UserService userServiceMock;

	@Spy
	private UserService userServiceSpy = new UserServiceImpl();

	@Test
	public void login_shouldThrowException_whenThereIsInvalidLogin() {
		exception.expect(InvalidDataException.class);
		exception.expectMessage("Incorrect login or password");
		userServiceSpy.login(null, "testPassword123");
	}

	@Test
	public void login_shouldThrowException_whenThereIsInvalidPassword() {
		exception.expect(InvalidDataException.class);
		exception.expectMessage("Incorrect login or password");
		userServiceSpy.login("testLogin", null);
	}

	@Test
	public void login_shouldThrowException_whenThereIsInvalidLoginAndPassword() {
		exception.expect(InvalidDataException.class);
		exception.expectMessage("Incorrect login or password");
		userServiceSpy.login(null, null);
	}

	@Test
	public void login_shouldReturnUser_whenThereIsValidData() {
		when(userServiceMock.login("testLogin123", "testPassword123")).thenReturn(new User());
	}

}
