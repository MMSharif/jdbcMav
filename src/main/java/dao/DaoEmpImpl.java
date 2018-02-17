package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Employee;
import dbInterfaces.DAOEmployee;

public class DaoEmpImpl implements DAOEmployee  {
	
	Connection connection;
    {
        try {
            connection = createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcst?useSSL=false", "root", "Muslim@69");
		}catch(Exception e){
			e.printStackTrace();
		}  
		return con;
    }

	public boolean addEmployee(Employee employee) throws SQLException {
		java.sql.PreparedStatement stmt=connection.prepareStatement("Insert into imcst.employee(empid,name,age,salary,deptnum) value(?,?,?,?,?)");
		stmt.setInt(1, employee.getId());
		stmt.setString(2, employee.getFirstName());
		stmt.setInt(3, employee.getAge());
		stmt.setDouble(4, employee.getSalary());
		stmt.setInt(5, employee.getDeptNum());
		return stmt.executeUpdate()>0;
	}

	public boolean deleteEmployee(int id) throws SQLException {
		java.sql.PreparedStatement stmt=connection.prepareStatement("Delete from imcst.employee where empid=?");
		stmt.setInt(1, id);
		return stmt.executeUpdate()>0;
	}

	public boolean updateEmployeeInfo(Employee employee) throws SQLException {
		if (employee==null) return false;
		java.sql.PreparedStatement stmt=connection.prepareStatement("Update imcst.employee set name=?, age=?, salary=? where empid=?");
		stmt.setString(1, employee.getFirstName());
		stmt.setInt(2, employee.getAge());
		stmt.setDouble(3, employee.getSalary());
		stmt.setInt(4, employee.getId());
		int recordsUpdates = stmt.executeUpdate();
		return recordsUpdates>0;
	}

	public Employee getEmployeeInfo(int id) throws SQLException {
		java.sql.PreparedStatement stmt=connection.prepareStatement("Select * from imcst.employee where empid=?");
		stmt.setInt(1, id);
		ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
        	Employee employee = new Employee();
            employee.setId(resultSet.getInt(1));
            employee.setFirstName(resultSet.getString(2));
            employee.setAge(resultSet.getInt(3));
            employee.setSalary(resultSet.getInt(3));
            return employee;
        }

        return null;
	}

	public int getEmployeeSalary(int id) throws SQLException {
		java.sql.PreparedStatement stmt=connection.prepareStatement("Select salary from imcst.employee where empid=?");
		stmt.setInt(1, id);
		ResultSet resultSet = stmt.executeQuery();
		if(resultSet.next()) {
			return resultSet.getInt("salary");
		}
				
		return 0;
	}

	public List<Employee> getAllEmployeeInfo() throws SQLException {
		java.sql.PreparedStatement stmt=connection.prepareStatement("select * from imcst.employee");
		ResultSet resultSet =stmt.executeQuery();
		List<Employee> list= new ArrayList<Employee>();
		while(resultSet.next()) {
			Employee employee=new Employee();
			employee.setId(resultSet.getInt("EmpID"));
			employee.setFirstName(resultSet.getString("name"));
			employee.setAge(resultSet.getInt("age"));
			employee.setSalary(resultSet.getDouble("salary"));
			employee.setDeptNum(resultSet.getInt("deptnum"));
			list.add(employee);
			}
		return list;
	}

	public List<Employee> getEmployeeBySalary() throws SQLException {
		java.sql.PreparedStatement stmt=connection.prepareStatement("select * from imcst.employee order by salary");
		ResultSet resultSet =stmt.executeQuery();
		List<Employee> list= new ArrayList<Employee>();
		while(resultSet.next()) {
			Employee employee=new Employee();
			employee.setId(resultSet.getInt("EmpID"));
			employee.setFirstName(resultSet.getString("name"));
			employee.setAge(resultSet.getInt("age"));
			employee.setSalary(resultSet.getDouble("salary"));
			employee.setDeptNum(resultSet.getInt("deptnum"));
			list.add(employee);
			}
		return list;
	}

	public List<Employee> getEmployeeByNameAndSalary() throws SQLException {
		java.sql.PreparedStatement stmt=connection.prepareStatement("select * from imcst.employee order by name,salary");
		ResultSet resultSet =stmt.executeQuery();
		List<Employee> list= new ArrayList<Employee>();
		while(resultSet.next()) {
			Employee employee=new Employee();
			employee.setId(resultSet.getInt("EmpID"));
			employee.setFirstName(resultSet.getString("name"));
			employee.setAge(resultSet.getInt("age"));
			employee.setSalary(resultSet.getDouble("salary"));
			employee.setDeptNum(resultSet.getInt("deptnum"));
			list.add(employee);
			}
		return list;
	}

	public List<Employee> getEmployeeByDepartment() throws SQLException {
		java.sql.PreparedStatement stmt=connection.prepareStatement("select * from imcst.employee order by deptnum");
		ResultSet resultSet =stmt.executeQuery();
		List<Employee> list= new ArrayList<Employee>();
		while(resultSet.next()) {
			Employee employee=new Employee();
			employee.setId(resultSet.getInt("EmpID"));
			employee.setFirstName(resultSet.getString("name"));
			employee.setAge(resultSet.getInt("age"));
			employee.setSalary(resultSet.getDouble("salary"));
			employee.setDeptNum(resultSet.getInt("deptnum"));
			list.add(employee);
			}
		return list;
	}
}
