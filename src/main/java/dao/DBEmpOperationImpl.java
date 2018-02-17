package dao;

import java.sql.SQLException;
import java.util.List;

import Entity.Employee;
import dbInterfaces.DAOEmployee;
import dbInterfaces.DBOperations;
import exception.EmployeeNotFoundException;
import exception.InvalidSalaryException;

public class DBEmpOperationImpl implements DBOperations {

	DAOEmployee dao= null;
	
	DBEmpOperationImpl(){
		dao=new DaoEmpImpl();
	}

	public boolean addEmployee(Employee e) throws InvalidSalaryException {
		if(e.getSalary()<5000.0)
			throw new InvalidSalaryException("Invalid Salary Details");
		try {
			return dao.addEmployee(e);
			}
		catch(SQLException e1){
			e1.printStackTrace();
		}
		return false;
	}

	public boolean deleteEmployee(int id) throws EmployeeNotFoundException {
		try {
			return dao.deleteEmployee(id);
		}
		catch(SQLException e) {
			throw new EmployeeNotFoundException("Employee Not Found.");
		}
	
	}

	public Employee getEmployee(int id) {
		
		try {
			return dao.getEmployeeInfo(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Employee> getEmployees() {
		try {
			return dao.getAllEmployeeInfo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public double getEmployeeHRA(int id) {
		try {
			return dao.getEmployeeSalary(id)*0.2;
			}
		catch(SQLException e) {
		 e.printStackTrace();
		}
		return 0.0;
	}

	public double getEmployeeGrossSalary(int id) {
		
		try {
			Employee e=new Employee();
			e.setSalary(dao.getEmployeeSalary(id));
			return e.getGrossSalary(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public List<Employee> getAllEmployeeInfo() {
		try {
			return dao.getAllEmployeeInfo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> getEmployeeBySalary() {
		try {
			return dao.getEmployeeBySalary();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> getEmployeeByNameAndSalary() {
		try {
			return dao.getEmployeeByNameAndSalary();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> getEmployeeByDepartment() {
		try {
			return dao.getEmployeeByDepartment();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	
}
