package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {

    private EmployeeMock employeeMock;
    private Employee existingEmployee;
    private Employee nonExistingEmployee;
    private DidacticFunction newFunction;

    @BeforeEach
    void setUp() {
        employeeMock = new EmployeeMock();

        existingEmployee = new Employee(1,"Popescu", "Ion", "1234567890123", DidacticFunction.LECTURER, 300.0);
        employeeMock.addEmployee(existingEmployee); // Ensure existing employee is added

        nonExistingEmployee = new Employee(2, "Ionescu", "Maria", "1234567890124", DidacticFunction.TEACHER, 400.0);

        newFunction = DidacticFunction.ASSISTENT;
    }

    @AfterEach
    void tearDown() {
        // Clear the employeeMock list if needed
        // employeeMock.clear();
    }

        // Lab 2
        @Test
        public void testAddEmployee_TC3_BVA() {
            Employee emp = new Employee(1, "Popescu", "Maria", "1234567890123", DidacticFunction.LECTURER, 300.0);
            assertTrue(employeeMock.addEmployee(emp));
        }

        @Test
        public void testAddEmployee_TC8_BVA() {
            Employee emp = new Employee(1, "Popescu", "Maria", "1234567890123", DidacticFunction.LECTURER, 300.0);
            assertTrue(employeeMock.addEmployee(emp));
        }

        @Test
        public void testAddEmployee_TC9_BVA() {
            Employee emp = new Employee(3, "Pop", "Mihai", "1234567890123", DidacticFunction.TEACHER, 500.0);
            assertTrue(employeeMock.addEmployee(emp));
        }

        @Test
        public void testAddEmployee_TC1_BVA() {
            Employee emp = new Employee(0, "Dan", "Monica", "12345678901234", DidacticFunction.CONFERENTIAR, 400.0);
            assertFalse(employeeMock.addEmployee(emp));
        }

        @Test
        public void testAddEmployee_TC2_BVA() {
            Employee emp = new Employee(0, "Dan", "Monica", "1234567890123", DidacticFunction.CONFERENTIAR, 400.0);
            assertFalse(employeeMock.addEmployee(emp));
        }

        @Test
        public void testAddEmployee_TC7_BVA() {
            Employee emp = new Employee(3, "Pop", "Mihai", "123456789012", DidacticFunction.ASSISTENT, 350.0);
            assertFalse(employeeMock.addEmployee(emp));
        }


    // Lab 3
    @Test
    void testModifyEmployeeFunction_NullEmployee() {
        employeeMock.modifyEmployeeFunction(null, newFunction);
        assertEquals(DidacticFunction.LECTURER, existingEmployee.getFunction());
    }

    @Test
    void testModifyEmployeeFunction_EmployeeInList() {
        employeeMock.modifyEmployeeFunction(existingEmployee, newFunction);
        assertEquals(newFunction, existingEmployee.getFunction());
    }

}
