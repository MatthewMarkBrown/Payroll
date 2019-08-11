package ac.za.Payroll.model.user;
import java.util.Objects;

public class Employee {
    private String employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private int age;

    private Employee(){}

    private Employee(Builder builder){
        this.employeeId = builder.employeeId;
        this.employeeFirstName = builder.employeeFirstName;
        this.employeeLastName = builder.employeeLastName;
        this.age = builder.age;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public int getAge() {
        return age;
    }

    public static class Builder {

        private String employeeId, employeeFirstName, employeeLastName;
        private int age;

        public Builder employeeId( String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder employeeFirstName( String employeeFirstName) {
            this.employeeFirstName = employeeFirstName;
            return this;
        }

        public Builder employeeLastName( String employeeLastName) {
            this.employeeLastName = employeeLastName;
            return this;
        }

        public Builder age( int age) {
            this.age = age;
            return this;
        }

        public Builder copy(Employee employee){
            this.employeeId = employee.employeeId;
            this.employeeFirstName = employee.employeeFirstName;
            this.employeeLastName = employee.employeeLastName;

            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId);

    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
