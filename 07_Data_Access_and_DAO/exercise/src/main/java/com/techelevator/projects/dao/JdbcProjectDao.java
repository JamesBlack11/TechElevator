package com.techelevator.projects.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(int project_Id) {
		Project project = null;
		String sqlSelectById = "SELECT project_Id, name, from_Date, to_Date  " + "FROM Project " + "WHERE project_Id = ? ; ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectById, project_Id);
		if (results.next()) {
			project = mapRowToProject(results);


		} return project;

	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<Project>();
		String select = "SELECT * " + "FROM Project ";
		SqlRowSet result = jdbcTemplate.queryForRowSet(select);

		while (result.next()) {
			projects.add(mapRowToProject(result));
		}
		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO Project (name, from_Date, to_Date) " +
				"VALUES (?, ?, ?) RETURNING project_Id; ";
		Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
				newProject.getName(), newProject.getFromDate(), newProject.getToDate());

		return getProject(newId);
	}

	@Override
	public void deleteProject(int project_Id) {
			String sql = "DELETE FROM project_employee WHERE project_Id = ?; ";
			jdbcTemplate.update(sql, project_Id);
			sql = "DELETE FROM Project Where project_id = ? ;";
			jdbcTemplate.update(sql, project_Id);
		}


	private Project mapRowToProject(SqlRowSet rowSet) {

		Project project = new Project();
		project.setId(rowSet.getInt("project_Id"));
		project.setName(rowSet.getString("name"));

		if (rowSet.getDate("from_Date") != null) {
		project.setFromDate(rowSet.getDate("from_Date").toLocalDate());}
		if (rowSet.getDate("to_Date") != null) {
			project.setToDate(rowSet.getDate("to_Date").toLocalDate());
		}

		return project;

	}
}
