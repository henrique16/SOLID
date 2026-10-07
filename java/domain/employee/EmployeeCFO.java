package domain.employee;
import domain.employee.IEmployee;

public class EmployeeCFO implements IEmployee {
  public Float calculatePay(Float hoursWorked, Float payPerHour) {
    return hoursWorked * payPerHour;
  }

  public Float reportHours(Float hoursWorked) {
    return hoursWorked;
  }
}
