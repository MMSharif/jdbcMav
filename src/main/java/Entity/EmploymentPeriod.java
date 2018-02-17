package Entity;


	import java.util.Calendar;

	public class EmploymentPeriod {
		private Calendar startDate;
		private Calendar endDate;

		public EmploymentPeriod() {

		}

		public EmploymentPeriod(Calendar startDate, Calendar endDate) {
			super();
			this.startDate = startDate;
			this.endDate = endDate;
		}

		public Calendar getStartDate() {
			return startDate;
		}

		public void setStartDate(Calendar startDate) {
			this.startDate = startDate;
		}

		public Calendar getEndDate() {
			return endDate;
		}

		public void setEndDate(Calendar endDate) {
			this.endDate = endDate;
		}

		@Override
		public String toString() {
			return new StringBuilder().append("EmploymentPeriod [startDate=").append(startDate).append(", endDate=")
			.append(endDate).append("]").toString();
		}

	}



