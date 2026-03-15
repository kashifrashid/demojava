package d.kash.training.shuffling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookingNotFoundException extends RuntimeException {
	public BookingNotFoundException(String bookingId) {
		super("Booking not found: " + bookingId);
	}
}
