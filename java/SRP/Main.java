import repository.EmployeeRepository;
import domain.employee.IEmployee;
import domain.employee.Employee;
import domain.employee.EmployeeCFO;
import domain.employee.EmployeeCTO;
import infrastructure.repository.EmployeeRepositoryMock;

public class Main {
  public static void main(String[] args) {
    // Dependency Injection
    //EmployeeRepository employeeRepository = new EmployeeRepositoryMock();

    // Instances

    // SRP (Single Responsibility Principle): The `Employee` class acts as a facade, 
    // allowing the `calculatePay` and `reportHours` implementations 
    // to differ for each role. 
    // This keeps the calculations and reports specific to each role. 
    // Here, we test the `calculatePay` method with the same values 
    // for different roles. 
    // Notice that the results are different because the CTO 
    // applies an additional fee and rate.

    // This solution uses interfaces, polymorphism, and delegation to achieve
    // the separation of responsibilities required by the SRP.
    IEmployee employeeCFOImpl = new EmployeeCFO();
    Employee employeeCFO = new Employee(employeeCFOImpl, 100d, 10d);

    IEmployee employeeCTOImpl = new EmployeeCTO();
    Employee employeeCTO = new Employee(employeeCTOImpl, 100d, 10d);

    System.out.println(employeeCFO.calculatePay());
    System.out.println(employeeCTO.calculatePay());
  }
}
