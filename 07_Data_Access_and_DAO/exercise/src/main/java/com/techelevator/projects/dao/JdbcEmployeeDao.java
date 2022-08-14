package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		String select = "SELECT * " + "FROM Employee ";
		SqlRowSet result = jdbcTemplate.queryForRowSet(select);

		while (result.next()) {
			employees.add(mapRowToEmployee(result));
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT * " +  "FROM employee " + "WHERE first_name ILIKE ? AND last_name ILIKE ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%");
		while (result.next()) {
			employees.add(mapRowToEmployee(result));
		}


		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> employees = new ArrayList<Employee>();
		String select = "SELECT e.employee_id, e.department_id, e.first_name, e.last_name, e.birth_date, e.hire_date "
				+ "FROM employee e " +
				"JOIN project_employee pe ON pe.employee_id = e.employee_id " + "WHERE project_id = ?;" ;
		SqlRowSet result = jdbcTemplate.queryForRowSet(select, projectId);

		while (result.next()) {
			employees.add(mapRowToEmployee(result));
		}
		return employees;
	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {
		String sql = "INSERT INTO project_employee  (project_id, employee_id ) VALUES (?, ?);";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_Id = ?; ";
		jdbcTemplate.update(sql, projectId, employeeId);

	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT * " + "FROM employee e " + "LEFT JOIN project_employee pe ON pe.employee_id = e.employee_id "
				+ "WHERE project_id IS NULL;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
		while (result.next()) {
			employees.add(mapRowToEmployee(result));
		}

		return employees;
	}

	private Employee mapRowToEmployee (SqlRowSet rowSet) {
		Employee employee = new Employee();
		employee.setFirstName(rowSet.getString("first_name"));
		employee.setLastName(rowSet.getString("last_name"));
		employee.setDepartmentId(rowSet.getInt("department_id"));
		employee.setHireDate(rowSet.getDate("hire_date").toLocalDate());
		employee.setId(rowSet.getInt("employee_id"));
		employee.setBirthDate(rowSet.getDate("birth_date").toLocalDate());

		return employee;

	}
}
