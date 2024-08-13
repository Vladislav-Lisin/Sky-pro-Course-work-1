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


    public static void totalСost() {
        int totalSum = 0;
        for (Employee employee : employees) {
            if (employee != null) { // Проверка на null
                totalSum += employee.getSalary();
            }
        }
        System.out.println("Сумма затрат на ЗП за месяц составлят: " + totalSum);
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


    public static void main(String[] args) {

        employees[0] = new Employee("И.И.", 1, 50000);
        employees[1] = new Employee("А.П.", 3, 60000);
        employees[2] = new Employee("С.Н.", 2, 45000);

        // Выводим список всех сотрудников
        allEmployees();
        totalСost();
        maxSalary();
    }

}
