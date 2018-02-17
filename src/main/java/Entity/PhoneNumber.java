package Entity;


	public class PhoneNumber {
		private String areaCode;
		private String number;
		private Employee owner;
		private String type;
		private int id;

		public PhoneNumber() {

		}

		public PhoneNumber(int id, Employee owner, String type, String areaCode, String number) {
			super();
			this.id = id;
			this.owner = owner;
			this.type = type;
			this.areaCode = areaCode;
			this.number = number;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Employee getOwner() {
			return owner;
		}

		public void setOwner(Employee owner) {
			this.owner = owner;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getAreaCode() {
			return areaCode;
		}

		public void setAreaCode(String areaCode) {
			this.areaCode = areaCode;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		@Override
		public String toString() {
			return new StringBuilder().append("PhoneNumber [id=").append(id).append(", owner=").append(owner)
			.append(", type=").append(type).append(", areaCode=").append(areaCode).append(", number=")
			.append(number).append("]").toString();
		}


}
