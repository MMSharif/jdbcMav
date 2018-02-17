package dao;

import java.util.List;
import java.util.Scanner;

import Entity.Employee;
import exception.EmployeeNotFoundException;
import exception.InvalidSalaryException;


public class DAOEmployeeApp {

	

		static Scanner scan=null;
		static DBEmpOperationImpl imp = null;
		

		public static void main(String[] args) throws Exception {
			imp = new DBEmpOperationImpl();
			scan=  new Scanner(System.in);
		
			while(true) 
			{
				System.out.println("Select the options below");
				System.out.println("1.Add a Employee");
				System.out.println("2.Show Employee Details");
				System.out.println("3.Delete a Employee");
				System.out.println("4.Display Employee HRA");
				System.out.println("5.Display Employee Gross Salary");
				System.out.println("6.getEmployeeBySalary");
				System.out.println("7.getEmployeeByNameAndSalary");
				System.out.println("8.getEmployeeByDepartment");
				System.out.println("9.Show all employee");
				System.out.println("10.Exit");
				int choice = scan.nextInt();
				
				
				
				switch(choice) {
						case 1: System.out.println("Employee ID");
								int id = scan.nextInt();
								System.out.println("Employee Name");
								String name = scan.next();
								System.out.println("Employee Salary");
								double salary = scan.nextDouble();
								System.out.println("Employee Age");
								int age = scan.nextInt();
								System.out.println("Deptment No");
								int deptnum=scan.nextInt();
								Employee emp = new Employee(id, name, salary, age, deptnum);
								
								try {
									imp.addEmployee(emp);
									System.out.println("Employee ID"+id);
								} catch (InvalidSalaryException e) {
									System.out.println("Exception occured:"+e.getMessage());
								}
								break;
								
								
						case 2: System.out.println("Employee ID");
								id = scan.nextInt();
								System.out.println(imp.getEmployee(id));
								break;
								
						case 3: System.out.println("Employee ID");
								id = scan.nextInt();
								
								try {
									imp.deleteEmployee(id);
								} catch (EmployeeNotFoundException e) {
									System.out.println(e);
								}
								break;
								
						case 4: System.out.println("Employee ID");
								id = scan.nextInt();
								double hra=imp.getEmployeeHRA(id);
								if(hra==0)
								{
									System.out.println("Given Employee Id is not correct");
								}
								else
								{
									System.out.println("Given Employee Id HRA is : "+hra);
								}
								
								break;
								
								
								
						case 5: System.out.println("Employee ID");
								id = scan.nextInt();
								salary = imp.getEmployeeGrossSalary(id);
								if(salary==0)
								{
									System.out.println("Given Employee Id is not correct");
								}else
								{
									System.out.println("Given Employee salary is : "+salary);
								}
								break;
								
						case 6: List<Employee> employeeList = imp.getEmployeeBySalary();
								for(Employee employee : employeeList)
								if(employee!=null)
									System.out.println(employee);
								break;
						
						case 7: List<Employee> employeeList1 = imp.getEmployeeByNameAndSalary();
								for(Employee employee : employeeList1)
								if(employee!=null)
									System.out.println(employee);
								break;
								
						case 8: List<Employee> employeeList2 = imp.getEmployeeByDepartment();
								for(Employee employee : employeeList2)
								if(employee!=null)
									System.out.println(employee);
								break;
								
						case 9: List<Employee> employeeList3 = imp.getAllEmployeeInfo();
								for(Employee employee : employeeList3)
								if(employee!=null)
									System.out.println(employee);
								break;
								
						case 10:System.exit(0);
								break;
				}
			}
		}
		
	}


