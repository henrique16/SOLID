package repository;
import repository.dto.EmployeeDto;

public interface EmployeeRepository {
  void save(EmployeeDto employee);
  EmployeeDto getById(String id);
}
