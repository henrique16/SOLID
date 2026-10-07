package domain.employee;
import domain.employee.IEmployee;

public class EmployeeCTO implements IEmployee {
  private static final Float TAX_RATE = 0.3f;
  private static final Float OVERTIME_RATE = 1.5f;

  public Double calculatePay(Double hoursWorked, Double payPerHour) {
    return hoursWorked * payPerHour * TAX_RATE;
  }

  public Double reportHours(Double hoursWorked) {
    return hoursWorked * OVERTIME_RATE;
  }
}
