package com.app.travel.Booking;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.app.travel.models.Booking;
import com.app.travel.service.BookingService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class BookingServiceApplicationTests {
	@Autowired
	private BookingService service;
	private static Booking b1 = null, b2 = null;
	@BeforeAll
	static void setUp(){
		 b1 = new Booking(2,"R8092", "Booking Num1", "First booking this year","Region 1", 1,1,10,2393,30, true, LocalDate.now(), LocalDate.of(2023,1,1), null,null);
		 b2 = new Booking(3,"R8092", "B11", "First booking this year","Region 1", 1,1,10,2393,30, true, LocalDate.now(), LocalDate.of(2023,1,1), null,null);

	}
	@Test
	void testCreatingBookingNotThrowingException(){
		assertDoesNotThrow( () -> service.insert(b1));
	}
	@Test
	void tt2() {
		try {
			service.insert(b1);
			service.insert(b2);
			assertEquals(3, service.getAll(0,20).size());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
