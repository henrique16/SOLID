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
    IEmployee employeeCFOImpl = new EmployeeCFO();
    Employee employeeCFO = new Employee(employeeCFOImpl, 100d, 10d);

    IEmployee employeeCTOImpl = new EmployeeCTO();
    Employee employeeCTO = new Employee(employeeCTOImpl, 100d, 10d);

    System.out.println(employeeCFO.calculatePay());
    System.out.println(employeeCTO.calculatePay());
  }
}
