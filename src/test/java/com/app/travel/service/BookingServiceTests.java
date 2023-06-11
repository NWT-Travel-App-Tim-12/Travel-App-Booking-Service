package com.app.travel.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.app.travel.models.Booking;
import com.app.travel.repositories.BookingRepository;

import com.app.travel.util.BookingStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class BookingServiceTests {
	@TestConfiguration
	static class BookingServiceImplTestContextConfiguration {
		@Bean
		public BaseCrudService<Booking, Integer> testBookingService(BookingRepository bookingRepository) {
			return new BookingService(bookingRepository);
		}
	}
	@Autowired
	private BookingService testBookingService;

	@MockBean
	private BookingRepository bookingRepository;

	private List<Booking> listOfBookings;
	private static Booking b1 = null, b2 = null;
	@BeforeEach
	void setupBeforeEach(){
		MockitoAnnotations.initMocks(this);
		listOfBookings = IntStream.range(1, 10)
				.mapToObj(i -> new Booking( i,"R8092", "Booking Num1", "First booking this year","Region 1", 1,1,10,2393,30, true, LocalDate.now(), LocalDate.of(2023,1,1), null,null, BookingStatus.UnderReview, ""))
				.collect(Collectors.toList());
	}
	@BeforeAll
	static void setUp(){
		 b1 = new Booking(2,"R8092", "Booking Num1", "First booking this year","Region 1", 1,1,10,2393,30, true, LocalDate.now(), LocalDate.of(2023,1,1), null,null, BookingStatus.UnderReview, "");
		 b2 = new Booking(3,"R8092", "B11", "First booking this year","Region 1", 1,1,10,2393,30, true, LocalDate.now(), LocalDate.of(2023,1,1), null,null, BookingStatus.UnderReview, "");
	}
	@Test
	void testCreatingBookingNotThrowingException(){
		assertDoesNotThrow( () -> testBookingService.insert(b1));
	}
	@Test
	void testGetAll() {
		when(bookingRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(listOfBookings));
		List<Booking> result = testBookingService.getAll(0, 10);
		assertEquals(listOfBookings.size(), result.size());
		assertEquals(listOfBookings.get(0), result.get(0));
		assertEquals(listOfBookings.get(listOfBookings.size()-1), result.get(result.size()-1));
	}
	@Test
	void testGet() throws Exception {
		Integer id = 5;
		Booking expectedModel = listOfBookings.get(id - 1);
		when(bookingRepository.findById(id)).thenReturn(Optional.of(expectedModel));
		Booking actualModel = testBookingService.get(id);
		assertEquals(expectedModel, actualModel);
	}

	@Test
	void insert() throws Exception {
		Mockito.when(bookingRepository.save(b1)).thenReturn(b1);
		Booking savedBooking = testBookingService.insert(b1);
		assertEquals(b1, savedBooking);
	}

	@Test
	void update() {
	}

	@Test
	void patch() {
	}

	@Test
	void delete() {
	}

}
