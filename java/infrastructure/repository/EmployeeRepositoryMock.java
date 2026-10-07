package infrastructure.repository;
import repository.EmployeeRepository;

public class EmployeeRepositoryMock implements EmployeeRepository {
  public void save(Employee employee) {
    System.out.println("Saving employee to mock repository");
  }

  public Employee getById(String id) {
    System.out.println("Getting employee from mock repository");
    return new EmployeeData(100, 10);
  }
}
