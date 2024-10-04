package com.tcs.check_in_check_out_system;

import com.tcs.check_in_check_out_system.repository.PersonRepository;
import com.tcs.check_in_check_out_system.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@SpringBootTest
class CheckInCheckOutSystemApplicationTests {

	@Autowired
	private PersonService personService;

	@MockBean
	private PersonRepository personRepository;

	@Test
	public void testDeleteRecord() {
		Long idToDelete = 1L;

		// Mocking repository behavior

		// Call the delete method in the service
		personService.deleteRecord(idToDelete);

	}}
