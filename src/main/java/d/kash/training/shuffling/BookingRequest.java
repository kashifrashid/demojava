package d.kash.training.shuffling;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookingRequest {
	@NotNull
	@Size(min = 2)
	private String customerName;

	@NotNull
	@Size(min = 3)
	private String pickupAddress;

	@NotNull
	@Size(min = 3)
	private String dropAddress;

	private List<String> imageUrls;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public String getDropAddress() {
		return dropAddress;
	}

	public void setDropAddress(String dropAddress) {
		this.dropAddress = dropAddress;
	}

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
}
