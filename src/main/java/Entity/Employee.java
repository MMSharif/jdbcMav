package Entity;

	import java.util.Comparator;
import java.util.List;

	public class Employee implements Comparable<Employee>{
		private Address address;
		private String firstName;
		private Gender gender;
		private int id;
		private int age;
		private int deptNum;

		private String lastName;
		private List<Employee> managedEmployees;
		private Employee manager;
		private EmploymentPeriod employmentPeriod;
		private List<PhoneNumber> phoneNumbers;
		private List<String> responsibilities;
		private double salary;
		private long version;
		private String dateOfJoining;


		public Employee() {

		}
		
		public Employee(int id,String firstName,Double salary,int age,int deptnum) {
			this.id = id;
			this.firstName = firstName;
			this.salary = salary;
			this.age = age;
			this.deptNum = deptnum;
		}

		public Employee(int id, String firstName, String lastName, Gender gender, Address address,
				List<Employee> managedEmployees, Employee manager, EmploymentPeriod employmentPeriod,
				List<PhoneNumber> phoneNumbers, List<String> responsibilities, double salary, long version, int age) {
			super();
			this.id = id;
			this.age = age;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.address = address;
			this.managedEmployees = managedEmployees;
			this.manager = manager;
			this.employmentPeriod = employmentPeriod;
			this.phoneNumbers = phoneNumbers;
			this.responsibilities = responsibilities;
			this.salary = salary;
			this.version = version;
		}
		public int getAge() {
			return age;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		public String getDateOfJoining() {
			return dateOfJoining;
		}
		
		public void setDateOfJoining(String dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
		}

		public int getDeptNum() {
			return deptNum;
		}
		
		public void setDeptNum(int deptNum) {
			this.deptNum = deptNum;
		}
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public List<Employee> getManagedEmployees() {
			return managedEmployees;
		}

		public void setManagedEmployees(List<Employee> managedEmployees) {
			this.managedEmployees = managedEmployees;
		}

		public Employee getManager() {
			return manager;
		}

		public void setManager(Employee manager) {
			this.manager = manager;
		}

		public EmploymentPeriod getEmploymentPeriod() {
			return employmentPeriod;
		}

		public void setEmploymentPeriod(EmploymentPeriod employmentPeriod) {
			this.employmentPeriod = employmentPeriod;
		}

		public List<PhoneNumber> getPhoneNumbers() {
			return phoneNumbers;
		}

		public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}

		public List<String> getResponsibilities() {
			return responsibilities;
		}

		public void setResponsibilities(List<String> responsibilities) {
			this.responsibilities = responsibilities;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public long getVersion() {
			return version;
		}

		public void setVersion(long version) {
			this.version = version;
		}

		public double getGrossSalary(Employee emp) {
			double da;
			double hra;
			
			if(this.getSalary()<10000.0) {
				da = this.getSalary()*(0.08);
				hra = this.getSalary()*(0.15);
			}else if(this.getSalary()<20000.0) {
				da = this.getSalary()*(0.1);
				hra = this.getSalary()*(0.2);
			}else if(this.getSalary()<30000.0) {
				da = this.getSalary()*(0.15);
				hra = this.getSalary()*(0.27);
			}else if(this.getSalary()<30000.0) {
				da = this.getSalary()*(0.13);
				hra = this.getSalary()*(0.25);
			}else {
				da = this.getSalary()*(0.17);
				hra = this.getSalary()*(0.30);
			}
			
			return this.getSalary()+da+hra;

		}
		
		public double getHra() {
			return (0.2)*salary; 
		}

		@Override
		public String toString() {
			 return new StringBuilder().append("Employee [id=").append(id).append(", firstName=").append(firstName).append(", lastName=")
			.append(lastName).append(", gender=").append(gender).append(", address=").append(address).append(", managedEmployees=")
			.append(managedEmployees).append(", manager=").append(manager).append(", employmentPeriod=").append(employmentPeriod)
			.append(", phoneNumbers=").append(phoneNumbers).append(", responsibilities=").append(responsibilities).append(deptNum)
			.append(", salary=").append(salary).append(", version=").append(version).append(", Salary=").append(salary).append("]").toString();
		}
		
		
		public int compareTo(Employee another) {
			final int BEFORE = -1;
		    final int EQUAL = 0;
		    final int AFTER = 1;

		    //Then compare by name
		    if (firstName.compareTo(another.firstName) > 0) return AFTER;
		    if (firstName.compareTo(another.firstName) < 0) return BEFORE;
		    
		    //First compare by studentId
			if (salary > another.salary) return AFTER;
			if (salary < another.salary) return BEFORE;

			return EQUAL;
		}

		public class EmployeeSalaryComparator implements Comparator<Employee> {
		
			public int compare(Employee e1, Employee e2) {
				final int BEFORE = -1;
				final int EQUAL = 0;
				final int AFTER = 1;
		
				// Then compare by name
				if (e1.salary > e2.salary) return AFTER;
				if (e1.salary < e2.salary) return BEFORE;
				return EQUAL;
			}
		}
		
		public class EmployeeDepartmentComparator implements Comparator<Employee> {
			public int compare(Employee e1, Employee e2) {
				final int BEFORE = -1;
				final int EQUAL = 0;
				final int AFTER = 1;
		
				// Then compare by name
				if (e1.deptNum > e2.deptNum) return AFTER;
				if (e1.deptNum < e2.deptNum) return BEFORE;
				return EQUAL;
			}
		}
		
}




