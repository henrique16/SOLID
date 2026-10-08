package domain.employee;
import domain.employee.IEmployee;

public class Employee {
  private IEmployee employee;
  public Double hoursWorked;
  public Double payPerHour;

  public Employee(IEmployee employee, Double hoursWorked, Double payPerHour) {
    this.employee = employee;
    this.hoursWorked = hoursWorked;
    this.payPerHour = payPerHour;
  }

  public Double calculatePay() {
    return this.employee.calculatePay(this.hoursWorked, this.payPerHour);
  }

  public Double reportHours() {
    return this.employee.reportHours(this.hoursWorked);
  }
}
