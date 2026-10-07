package infrastructure.repository;
import repository.EmployeeRepository;
import repository.dto.EmployeeDto;

public class EmployeeRepositoryMock implements EmployeeRepository {
  public void save(EmployeeDto employee) {
    System.out.println("Saving employee to mock repository");
  }

  public EmployeeDto getById(String id) {
    System.out.println("Getting employee from mock repository");
    return new EmployeeDto(id, 100d, 10d);
  }
}
