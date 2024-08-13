import java.util.Objects;

public class Employee {

    private static int idCounter = 0;
    private int id;
    private String initials;
    private int department;
    private int salary;


    public Employee(String initials, int department, int salary) {
        this.id = idCounter++;
        this.initials = initials;
        this.department = department;
        this.salary = salary;
    }

    //set
    public void setId(int id) {
        this.id = id;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    //get
    public int getId(){
        return this.id;
    }

    public int getSalary(){
        return this.salary;
    }

    public int getDepartment(){
        return this.department;
    }

    public String getInitials(){
        return this.initials;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", initials='" + initials + '\'' + // Изменено в toString
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                initials.equals(employee.initials) &&
                department == employee.department &&
                Double.compare(employee.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, initials, department, salary);
    }





}
