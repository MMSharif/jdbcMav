package dbInterfaces;

import java.util.List;

import Entity.Employee;
import exception.EmployeeNotFoundException;
import exception.InvalidSalaryException;

public interface DBOperations {

	public boolean addEmployee(Employee e) throws InvalidSalaryException;

	public boolean deleteEmployee(int id) throws EmployeeNotFoundException;
	
	public Employee getEmployee(int id);

	public List<Employee> getEmployees();
	
	public double getEmployeeHRA(int id);
	
	public double getEmployeeGrossSalary(int id);
	
	public List<Employee> getAllEmployeeInfo();
	
	public List<Employee> getEmployeeBySalary();
	
	public List<Employee> getEmployeeByNameAndSalary();
	
	public List<Employee> getEmployeeByDepartment();
	
}
