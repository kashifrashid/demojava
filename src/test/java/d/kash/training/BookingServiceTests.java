package d.kash.training;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;

import d.kash.training.shuffling.BookingRequest;
import d.kash.training.shuffling.BookingResponse;
import d.kash.training.shuffling.BookingService;
import d.kash.training.shuffling.BookingStatus;

public class BookingServiceTests {

	@Test
	public void shouldCreateBookingWithMapImagesAndDriver() {
		BookingService bookingService = new BookingService();
		BookingRequest request = new BookingRequest();
		request.setCustomerName("Rohit");
		request.setPickupAddress("Mumbai Central");
		request.setDropAddress("Pune Station");
		request.setImageUrls(Arrays.asList("https://img.example.com/box1.jpg", "https://img.example.com/box2.jpg"));

		BookingResponse booking = bookingService.createBooking(request);

		assertNotNull(booking.getBookingId());
		assertEquals(BookingStatus.DRIVER_ALLOCATED, booking.getStatus());
		assertNotNull(booking.getDriver());
		assertEquals(2, booking.getImageUrls().size());
		assertNotNull(booking.getMapUrl());
	}
}
