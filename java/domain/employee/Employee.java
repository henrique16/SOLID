package domain.employee;
import domain.employee.IEmployee;

public class Employee {
  private IEmployee employee;
  public Float hoursWorked
  public Float payPerHour

  public Employee(IEmployee employee, Float hoursWorked, Float payPerHour) {
    this.employee = employee;
    this.hoursWorked = hoursWorked;
    this.payPerHour = payPerHour;
  }

  public Float calculatePay() {
    return this.employee.calculatePay(this.hoursWorked, this.payPerHour);
  }

  public Float reportHours() {
    return this.employee.reportHours(this.hoursWorked);
  }
}
