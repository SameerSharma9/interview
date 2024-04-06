package org.example.stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.util.Pair;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Project {

    private String name;
    private String team;
    private String projectManager;

    Project(){
    }

    public Project(String name, String team, String projectManager) {
        this.name = name;
        this.team = team;
        this.projectManager = projectManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }
}

class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private int salary;
    private int totalLaptopsAssigned;
    // OneToMany
    private List<Project> projects;

    Employee(){
    }

    public Employee(String id, String firstName, String lastName, int salary, int totalLaptopsAssigned,
                    List<Project> projects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.totalLaptopsAssigned = totalLaptopsAssigned;
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", projects="
                + projects + "]";
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public List<Project> getProjects() {
        return projects;
    }
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    public int getTotalLaptopsAssigned() {
        return totalLaptopsAssigned;
    }
    public void setTotalLaptopsAssigned(int totalLaptopsAssigned) {
        this.totalLaptopsAssigned = totalLaptopsAssigned;
    }
}

class EmployeeFactory extends Employee{

    ArrayList<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployee(){

        Project Delta = new Project("Delta Model", "Login", "Robert Downey Jr");
        Project Beta = new Project("Beta Enhancement", "Authentication", "Chris");
        Project TwoFactorAuth = new Project("Two Factor Authentication", "Authentication", "MSD");
        Project CommonUI = new Project("Common UI", "UI", "Robert Downey Jr");
        Project Pegasus = new Project("Pegasus Model", "Data", "Vikram");
        Project CustomerOnboarding = new Project("Customer Onboarding", "Ads", "Vedha");
        Project Verification = new Project("Source Verification", "Data", "Pablo");
        Project RemoveUsers = new Project("Remove Invalid User", "Proxy", "Jeetu");
        Project SiteReliability = new Project("Site Reliability", "Admin", "Zaheer Khan");
        Project DataTransition = new Project("Data Transition", "Data", "Atif Aslam");
        Project TwoPhaseDeployment =new Project("Two Phase Deployment", "Deployment", "Shaktiman");

        employees.add(new Employee("2020Emp0234", "Ahaskar", "Sharan", 900000, 1, Arrays.asList(Delta, Beta)));
        employees.add(new Employee("2012Emp1923", "Dev", "Sharma", 3500000, 3, Arrays.asList(Pegasus, CustomerOnboarding, Beta, SiteReliability)));
        employees.add(new Employee("2017Emp0721", "Priti", "Kabir", 1800000, 3, Arrays.asList(TwoFactorAuth, Beta, CommonUI)));
        employees.add(new Employee("2017Emp00031", "Chris", "Martin", 2200000, 2, Arrays.asList(Delta, TwoFactorAuth)));
        employees.add(new Employee("2013Emp0872", "Sanjay", "Singhania", 2200000, 3, Arrays.asList(Pegasus, Delta, RemoveUsers, DataTransition)));
        employees.add(new Employee("2022Emp0087", "Babu", "Rao", 900000, 1, Arrays.asList(TwoFactorAuth)));
        employees.add(new Employee("2019Emp0050", "Dev", "Anand", 1300000, 1, Arrays.asList(RemoveUsers, CommonUI)));
        employees.add(new Employee("2023Emp0934", "Shruti", "Sen", 1100000, 1, Arrays.asList(Pegasus)));
        employees.add(new Employee("2023Emp1033", "Akshay", "Kumar", 1200000, 0, Arrays.asList(Delta)));
        employees.add(new Employee("2015Emp0009", "Babu", "Dutt", 2600000, 2, Arrays.asList(Verification, RemoveUsers, TwoPhaseDeployment)));

        return employees;
    }
}

public class App {

    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        //List all distinct project in non-ascending order
        List<String> p1 = employeeList.stream()
                .map(Employee::getProjects).flatMap(x->x.stream())
                .map(Project::getName).sorted(Comparator.reverseOrder()).distinct()
                .collect(Collectors.toList());
        //System.out.println(p1);
        List<String> projectName = employeeList.stream().map(Employee::getProjects).flatMap(x -> x.stream())
                .map(Project::getName).distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        //System.out.println(projectName);
        assert(p1.equals(projectName));
        //Print full name of any employee whose firstName starts with ‘A’
        List<String> p2 = employeeList.stream()
                .filter(x-> x.getFirstName().startsWith("A"))
                //.peek(x->System.out.print(x.getFirstName()+" "+x.getLastName()))
                .map(y -> y.getFirstName()+" "+y.getLastName())
                .collect(Collectors.toList());
        List<String> empListWithName = employeeList.stream()
                .filter(x -> x.getFirstName().startsWith("A"))
              //  .peek(x -> System.out.println(x.getFirstName()+" "+x.getLastName()))
                .map(y -> y.getFirstName()+" "+y.getLastName())
                .collect(Collectors.toList());

        assert(p2.equals(empListWithName));

        //List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)
        List<Employee> p3 = employeeList.stream()
                .filter(x->x.getId().startsWith("2023"))
                //.peek(w-> System.out.println(w.getId()))
                .collect(Collectors.toList());

        List<Employee> empListJoin2023 = employeeList.stream()
                .filter(x -> x.getId().substring(0,4).equals("2023"))
                //.peek(x->System.out.println(x.getId()))
                .collect(Collectors.toList());
        //System.out.println(empListJoin2023);
        assert(p3.equals(empListJoin2023));

        //Sort employees based on firstName, for same firstName sort by salary.
        List<Employee> p4 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary))
               // .peek(a-> System.out.println(a.toString()))
                .collect(Collectors.toList());
        List<Employee> empListSorted = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary))
                //.peek(e-> System.out.println(e.getFirstName()+" "+e.getSalary()))
                .collect(Collectors.toList());
        //System.out.println(empListSorted);
        assert (p4.equals(empListSorted));

        //Print names of all employee with 3rd highest salary. (generalise it for nth highest salary)
        Integer nthHSal = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getSalary).distinct()
                .skip(2).findFirst().orElse(0);
        //System.out.println(nthHSal);
        final List<Employee> p5 = employeeList.stream()
                .filter(x->x.getSalary() == nthHSal)
                .collect(Collectors.toList());
        //System.out.println(p5);

        final List<Integer> sal = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getSalary).distinct()
                .limit(3).sorted().limit(1).collect(Collectors.toList());

        List<Employee> nthHighSalList = employeeList.stream().filter(x-> x.getSalary() == sal.get(0))
                //.peek(x -> System.out.println(x.getFirstName()+" "+x.getSalary()))
                .collect(Collectors.toList());

        assert p5.equals(nthHighSalList);

        Map.Entry<Integer, Set<String>> nthHs = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, () -> new TreeMap<>(Comparator.reverseOrder()), Collectors.mapping(Employee::getFirstName, Collectors.toSet())))
                .entrySet().stream()
                //.peek(System.out::println)
                .skip(2)
                .findFirst()
                .get();
        //System.out.println(nthHs.getValue());
       // System.out.println(nthHs.getValue());
        assert p5.get(0).getSalary() == nthHs.getKey();

        //List of people working on more than 2 projects.
        List<Employee> p6 = employeeList.stream()
                .filter(x-> x.getProjects().size() > 2)
                //.peek(System.out::println)
                .collect(Collectors.toList());

        List<String> empList = employeeList.stream()
                .collect(Collectors.groupingBy(x-> x.getProjects().size()))
                .entrySet().stream()
                //.peek(entry -> System.out.println(entry.getKey()+" "+entry.getValue()))
                .filter(entry -> entry.getKey() > 2)
                .map(entry -> entry.getValue())
                .flatMap(x->x.stream())
                .map(Employee::getFirstName)
                .collect(Collectors.toList());
        //System.out.println(empList);
        assert p6.size() == empList.size();

        //Count of total laptops assigned to the employees
        long p7 = employeeList.stream()
                .map(Employee::getTotalLaptopsAssigned)
                .mapToInt(Integer::intValue)
                .sum();
        int ssum = employeeList.stream()
                .map(Employee::getTotalLaptopsAssigned)
                .mapToInt(Integer::intValue)
                .sum();
        assert p7 == ssum;
        //System.out.println(ssum);

        //Count of all projects with Robert Downey Jr as PM.
        long p8 = employeeList.stream()
                .map(Employee::getProjects)
                .flatMap(x->x.stream())
                .distinct()
                .filter(x-> x.getProjectManager().equals("Robert Downey Jr"))
                .count();
        long count = employeeList.stream()
                .map(Employee::getProjects)
                .flatMap(x->x.stream())
                .filter(x-> x.getProjectManager().equals("Robert Downey Jr"))
                .distinct()
                .count();

        //System.out.println(count);
        assert p8 == count;

        //List of all people working with Robert Downey Jr.
        List<Employee> p9 = employeeList.stream()
                .flatMap(x->x.getProjects().stream()
                        .map(y->new Pair(x,y)))
                .filter(z->((Project)z.getValue()).getProjectManager().equals("Robert Downey Jr"))
                .map(d->(Employee)d.getKey())
                //.peek(e-> System.out.println(e.getFirstName()))
                .collect(Collectors.toList());


        List<Project> p = employeeList.stream()
                .map(Employee::getProjects)
                .flatMap(x->x.stream())
                .filter(x-> x.getProjectManager().equals("Robert Downey Jr"))
                .distinct()
                .collect(Collectors.toList());


       Map<Project, List<String>> map =  employeeList.stream()
                .flatMap(e-> e.getProjects().stream()
                        .map(pr-> new Pair(pr,e)))
               //.peek(System.out::println)
                .collect(Collectors.groupingBy(pair-> (Project) pair.getKey(),Collectors.mapping(pair -> ((Employee)pair.getValue()).getFirstName(),Collectors.toList())));

        //System.out.println(map);
        List<String> empWorkingWithRDJ = p.stream().map(x-> map.get(x)).flatMap(y->y.stream()).collect(Collectors.toList());


        //System.out.println(empWorkingWithRDJ);
        assert p9.size() == empWorkingWithRDJ.size();

        //Create a map based on this data, they key should be the year of joining, and value should be list of all the employees who joined the particular year.
        Map<String, List<Employee>> p10 = employeeList.stream()
                .collect(Collectors.groupingBy(x->x.getId().substring(0,4)));
        Map<String, List<Employee>>  mapp = employeeList.stream()
                .map(x-> new Pair(x.getId().substring(0,4),x))
                .collect(Collectors.groupingBy(ppp-> (String)ppp.getKey(),Collectors.mapping(pppr -> (Employee)pppr.getValue(), Collectors.toList())));

//        System.out.println(p10);
//        System.out.println("----------------");
//        System.out.println(mapp);
        assert p10.equals(mapp);
        String[] names = {"sameer","sharma", "dad", "Mom"};
        long total = App.getTotalNumberOfLettersOfNamesLongerThanFive(names);
        //System.out.println(total);
    }

    public static long getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        return Arrays.stream(names)
                .filter(x->x.length() > 5)
                //.map(y->y.split(""))
                .flatMap(d-> Arrays.stream(d.split("")))
                .count();
    }
}