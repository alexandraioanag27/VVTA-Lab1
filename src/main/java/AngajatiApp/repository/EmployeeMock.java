package AngajatiApp.repository;

import java.util.ArrayList;
import java.util.List;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import AngajatiApp.validator.EmployeeValidator;

public class EmployeeMock implements EmployeeRepositoryInterface {

	private List<Employee> employeeList;
	private EmployeeValidator employeeValidator;
	
	public EmployeeMock() {
		employeeValidator = new EmployeeValidator();
		employeeList = new ArrayList<Employee>();

		String CNP = "1234567890876";
		Employee Ionel = new Employee(1,"Marius", "Pacuraru", CNP, DidacticFunction.ASSISTENT, 2500d);
		Employee Mihai = new Employee(2, "Ion", "Dumitrescu", CNP, DidacticFunction.LECTURER, 2500d);
		Employee Ionela = new Employee(3, "Gicu", "Ionescu", CNP, DidacticFunction.LECTURER, 2500d);
		Employee Mihaela = new Employee(4, "Dodel", "Pacuraru", CNP, DidacticFunction.ASSISTENT, 2500d);
		Employee Vasile = new Employee(5, "Dorel", "Georgescu", CNP, DidacticFunction.TEACHER, 2500d);
		Employee Marin   = new Employee(6, "Larson", "Puscas", CNP, DidacticFunction.TEACHER,  2500d);

		employeeList.add(Ionel);
		employeeList.add(Mihai);
		employeeList.add(Ionela);
		employeeList.add(Mihaela);
		employeeList.add(Vasile);
		employeeList.add(Marin);
	}

	/**
	 * adauga un angajat in repository
	 * @param employee - un angajat cu atributele id, nlastName, firstName, cnp,
	 *                 function, salary;
	 * @return boolean - false daca employee nu este valid
	 */
	@Override
	public boolean addEmployee(Employee emp) {
		if (emp.getId() <= 0) return false;  // ID should be positive
		if (emp.getCnp() == null || emp.getCnp().length() != 13 || !emp.getCnp().matches("\\d+")) return false;  // CNP should be exactly 13 digits

		return true;
	}

	/**
	 * Modifica atributul 'functia didactica' pentru un angajat dat
	 * @param employee - anagajtul eptnru care se modifica atributul 'functia didactica'
	 * @param newFunction - noua functie didactica (ASISTENT, LECTURER, TEACHER, CONFERENTIAR)
	 */
	@Override
	public void modifyEmployeeFunction(Employee employee, DidacticFunction newFunction) {

		if (employee!=null) {
			int i = 0;
			while (i < employeeList.size()) {
				if (employeeList.get(i).getId() == employee.getId())
					employeeList.get(i).setFunction(newFunction);
				i++;
			}
		}
	}

	@Override
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeByCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmployeeById(int idOldEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

}
