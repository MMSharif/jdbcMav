package dbInterfaces;

import java.sql.SQLException;
import java.util.List;

import Entity.Employee;

public interface DAOEmployee {
	
	public boolean addEmployee(Employee employee)throws SQLException;
	public boolean deleteEmployee(int id)throws SQLException;
	public boolean updateEmployeeInfo(Employee employee)throws SQLException;
	public Employee getEmployeeInfo(int id)throws SQLException;
	public int getEmployeeSalary(int id)throws SQLException;
	public List<Employee> getAllEmployeeInfo()throws SQLException;
	public List<Employee> getEmployeeBySalary()throws SQLException;
	public List<Employee> getEmployeeByNameAndSalary()throws SQLException;
	public List<Employee> getEmployeeByDepartment()throws SQLException;
}
