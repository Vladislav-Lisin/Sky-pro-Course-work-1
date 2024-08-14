public class Main {

    private static Employee[] employees = new Employee[10];

    public static void allEmployees() {
        System.out.println("Список сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static void allInitials() {
        System.out.println("Список инициалов сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getInitials());
            }
        }
    }


    public static int totalСost() {
        int totalSum = 0;
        for (Employee employee : employees) {
            if (employee != null) { // Проверка на null
                totalSum += employee.getSalary();
            }
        }
        return totalSum;
    }

    public static void maxSalary() {
        int maxSalary = -1;
        int nowSelery;
        int idMaxSalary = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                nowSelery = employee.getSalary();
                if (nowSelery > maxSalary) { // Проверка на null
                    maxSalary = employee.getSalary();
                    idMaxSalary = employee.getId();
                }
            }
        }
        System.out.println("Работник с наибольшей ЗП: " + employees[idMaxSalary].getInitials());
    }

    public static void minSalary() {
        int minSalary = 2_000_000_000;
        int nowSelery;
        int idMinSalary = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                nowSelery = employee.getSalary();
                if (nowSelery < minSalary) { // Проверка на null
                    minSalary = employee.getSalary();
                    idMinSalary = employee.getId();
                }
            }
        }
        System.out.println("Работник с наименьшей ЗП: " + employees[idMinSalary].getInitials());
    }

    public static int averageValues() {
        int sumSalary = totalСost();
        int countEmpoyees = employees.length;
        int averageValue = sumSalary / countEmpoyees;
        return averageValue;

    }

    public static void indexSalary(int percentage) {
        for (Employee employee : employees) {
            if (employee != null) {
                int raise = (int) (employee.getSalary() * (percentage / 100.0)); // Приведение к int
                employee.setSalary(employee.getSalary() + raise);
            }
        }
    }

    // Методы для работы с отделом
    public static Employee findEmployeeWithMinSalary(int department) {
        Employee minSalaryEmployee = null;
        int minSalary = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    public static Employee findEmployeeWithMaxSalary(int department) {
        Employee maxSalaryEmployee = null;
        int maxSalary = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (employee.getSalary() > maxSalary) {
                    maxSalary = employee.getSalary();
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    public static int totalSalaryByDepartment(int department) {
        int totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public static int averageSalaryByDepartment(int department) {
        int countEmployees = 0;
        int totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                countEmployees++;
                totalSalary += employee.getSalary();
            }
        }
        if (countEmployees > 0) {
            return totalSalary / countEmployees;
        } else {
            return 0; // Или другое значение по умолчанию
        }
    }

    public static void indexSalaryByDepartment(int department, int percentage) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                int raise = (int) (employee.getSalary() * (percentage / 100.0)); // Приведение к int
                employee.setSalary(employee.getSalary() + raise);
            }
        }
    }

    public static void EmployeesByDepartment(int department) {
        System.out.println("Сотрудники отдела " + department + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println(employee.toString().replaceAll(", department=" + department, "")); // Удаляем "department"
            }
        }
    }

    // Методы для сравнения зарплаты
    public static void EmployeesWithSalaryLessThan(int salary) {
        System.out.println("Сотрудники с зарплатой меньше " + salary + ":");
        boolean availability = true;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                availability = false;
                System.out.println("ID: " + employee.getId() + ", ФИО: " + employee.getInitials() + ", Зарплата: " + employee.getSalary());
            }
        }
        if (availability) {
            System.out.println("Таких сотрудников не нашлось");
        }
    }

    public static void EmployeesWithSalaryGreaterThanOrEqualTo(int salary) {
        System.out.println("Сотрудники с зарплатой больше или равно " + salary + ":");
        boolean availability = true;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                availability = false;
                System.out.println("ID: " + employee.getId() + ", ФИО: " + employee.getInitials() + ", Зарплата: " + employee.getSalary());
            }
        }
        if (availability) {
            System.out.println("Таких сотрудников не нашлось");
        }
    }


    public static void main(String[] args) {

        employees[0] = new Employee("И.И.", 1, 50000);
        employees[1] = new Employee("А.П.", 1, 60000);
        employees[2] = new Employee("С.Н.", 2, 45000);

        // Выводим список всех сотрудников
        allEmployees();
        System.out.println("Сумма затрат на ЗП в месяц равна: " + totalСost()); // Исправлено
        maxSalary();
        minSalary();
        System.out.println("Среднее значение зарплат равняется: " + averageValues());
        allInitials();
        indexSalary(10);
        EmployeesByDepartment(1);
        EmployeesWithSalaryLessThan(500_00);
        EmployeesWithSalaryGreaterThanOrEqualTo(500_000);
        indexSalaryByDepartment(1, 10);
        allEmployees();
        System.out.println(totalSalaryByDepartment(1));
        System.out.println(averageSalaryByDepartment(1));


    }

}
