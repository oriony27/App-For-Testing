package com.app.testing.model.mapper;

import com.app.testing.model.User;
import com.app.testing.model.impl.UserImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new UserImpl();
        user.setId(rs.getLong(1));
        user.setName(rs.getString(2));
        user.setAge(rs.getInt(3));
        return user;
    }

}
