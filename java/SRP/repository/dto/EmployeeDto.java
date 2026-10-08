package repository.dto;

public class EmployeeDto {
  public String id;
  public Double hoursWorked;
  public Double payPerHour;

  public EmployeeDto(String id, Double hoursWorked, Double payPerHour) {
    this.id = id;
    this.hoursWorked = hoursWorked;
    this.payPerHour = payPerHour;
  }
}
