package domain.employee;
import domain.employee.IEmployee;

public class EmployeeCTO implements IEmployee {
  private static final Float TAX_RATE = 0.3;
  private static final Float OVERTIME_RATE = 1.5;

  public Float calculatePay(Float hoursWorked, Float payPerHour) {
    return hoursWorked * payPerHour * TAX_RATE;
  }

  public Float reportHours(Float hoursWorked) {
    return hoursWorked * OVERTIME_RATE;
  }
}
