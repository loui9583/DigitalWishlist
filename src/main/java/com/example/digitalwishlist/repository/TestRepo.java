package com.example.digitalwishlist.repository;

import com.example.digitalwishlist.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class TestRepo {

    private JdbcTemplate template;

    public TestRepo(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }



}
