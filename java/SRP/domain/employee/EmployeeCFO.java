package domain.employee;
import domain.employee.IEmployee;

public class EmployeeCFO implements IEmployee {
  public Double calculatePay(Double hoursWorked, Double payPerHour) {
    return hoursWorked * payPerHour;
  }

  public Double reportHours(Double hoursWorked) {
    return hoursWorked;
  }
}
