package com.example.digitalwishlist.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TestRepo {
    private final JdbcTemplate template;

    public TestRepo(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }


}
