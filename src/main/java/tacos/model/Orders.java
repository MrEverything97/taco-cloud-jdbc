package tacos.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Orders {
	private Long id;
	private LocalDateTime placedAt;
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String ccNumber;
	private String ccExpiration;
	private String ccCVV;

	public Orders(Long id, String deliveryName, String deliveryStreet, String deliveryCity, String deliveryState, String deliveryZip, String ccNumber, String ccExpiration, String ccCVV, java.sql.Date timestamp) {
	}
	public Orders(){}
}