package d.kash.training.shuffling;

import java.time.Instant;
import java.util.List;

public class BookingResponse {
	private final String bookingId;
	private final String customerName;
	private final String pickupAddress;
	private final String dropAddress;
	private final String mapUrl;
	private final List<String> imageUrls;
	private final BookingStatus status;
	private final Driver driver;
	private final Instant createdAt;

	public BookingResponse(String bookingId, String customerName, String pickupAddress, String dropAddress,
			String mapUrl, List<String> imageUrls, BookingStatus status, Driver driver, Instant createdAt) {
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.pickupAddress = pickupAddress;
		this.dropAddress = dropAddress;
		this.mapUrl = mapUrl;
		this.imageUrls = imageUrls;
		this.status = status;
		this.driver = driver;
		this.createdAt = createdAt;
	}

	public String getBookingId() {
		return bookingId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getPickupAddress() {
		return pickupAddress;
	}

	public String getDropAddress() {
		return dropAddress;
	}

	public String getMapUrl() {
		return mapUrl;
	}

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public Driver getDriver() {
		return driver;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}
}
