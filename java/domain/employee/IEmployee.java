package domain.employee;

public interface IEmployee {
  Double calculatePay(Double hoursWorked, Double payPerHour);
  Double reportHours(Double hoursWorked);
}