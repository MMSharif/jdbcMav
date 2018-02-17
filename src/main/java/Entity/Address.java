package Entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Address implements Serializable{
		private String city;
		private String country;
		private int id;
		private String postalCode;
		private String state;
		private String street;
		private long version;

		public Address(String street, String city, String state, String country , String postalCode) {
				this.street=street;
				this.city=city;
				this.state=state;
				this.country=country;
				this.postalCode=postalCode;
		}

		public Address(int id, String street, String city, String state, String country, String postalCode,
				long version) {
			super();
			this.id = id;
			this.street = street;
			this.city = city;
			this.state = state;
			this.country = country;
			this.postalCode = postalCode;
			this.version = version;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		
		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public long getVersion() {
			return version;
		}

		public void setVersion(long version) {
			this.version = version;
		}

		@Override
		public String toString() {
			return new StringBuilder().append("Address [id=").append(id).append(", street=").append(street).append(", city=")
			.append(city).append(", State=").append(state).append(", country=").append(country).append(", postalCode=")
			.append(postalCode).append(", version=").append(version).append("]").toString();
		}

	}



