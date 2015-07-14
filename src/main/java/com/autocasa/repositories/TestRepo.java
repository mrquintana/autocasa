package com.autocasa.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.autocasa.model.Test;

@Repository
public class TestRepo {

	private JdbcTemplate jdbc;

	@Autowired
	public TestRepo(JdbcTemplate jdbc) {
		super();
		this.jdbc = jdbc;
	}

	public List<Test> findAll() {
		return jdbc.query("select id, firstName, lastName from vehicles",
				new RowMapper<Test>() {
					@Override
					public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
						Test test = new Test();
						test.setId(rs.getLong(1));
						test.setFirstName(rs.getString(2));
						test.setLastName(rs.getString(3));
						return test;
					}
				});
	}
}
