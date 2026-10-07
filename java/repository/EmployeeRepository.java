package repository;

public interface EmployeeRepository {
  void save(Employee employee);
  Employee getById(String id);
}
