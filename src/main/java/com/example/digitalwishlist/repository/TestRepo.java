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

    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        return template.query(sql, (rs, rowNum) ->
                new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_password")
                )
        );
    }

}
