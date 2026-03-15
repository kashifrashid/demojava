package d.kash.training.shuffling;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class BookingService {

	private final Queue<Driver> availableDrivers = new ArrayDeque<>(Arrays.asList(
			new Driver("D-101", "Arun", "+91-900000001"),
			new Driver("D-102", "Mira", "+91-900000002"),
			new Driver("D-103", "Ravi", "+91-900000003")));

	private final Map<String, BookingResponse> bookings = new ConcurrentHashMap<>();

	public BookingResponse createBooking(BookingRequest request) {
		String bookingId = "BK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
		List<String> imageUrls = request.getImageUrls() == null ? Collections.emptyList() : new ArrayList<>(request.getImageUrls());
		Driver driver = allocateDriver();
		BookingStatus status = driver == null ? BookingStatus.PENDING : BookingStatus.DRIVER_ALLOCATED;

		BookingResponse response = new BookingResponse(
				bookingId,
				request.getCustomerName(),
				request.getPickupAddress(),
				request.getDropAddress(),
				buildMapUrl(request.getPickupAddress(), request.getDropAddress()),
				imageUrls,
				status,
				driver,
				Instant.now());

		bookings.put(bookingId, response);
		return response;
	}

	public List<BookingResponse> getBookings() {
		return new ArrayList<>(bookings.values());
	}

	public BookingResponse getBooking(String bookingId) {
		return bookings.get(bookingId);
	}

	private synchronized Driver allocateDriver() {
		return availableDrivers.poll();
	}

	private String buildMapUrl(String pickupAddress, String dropAddress) {
		return "https://www.google.com/maps/dir/?api=1&origin=" + encode(pickupAddress)
				+ "&destination=" + encode(dropAddress);
	}

	private String encode(String input) {
		return URLEncoder.encode(input, StandardCharsets.UTF_8);
	}
}
