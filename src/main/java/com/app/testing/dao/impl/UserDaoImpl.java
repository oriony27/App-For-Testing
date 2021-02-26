package com.app.testing.dao.impl;

import com.app.testing.dao.UserDao;
import com.app.testing.model.User;
import com.app.testing.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public <S extends User> S save(S entity) {
        jdbcTemplate.update("INSERT INTO users VALUES(?,?,?)", entity.getId(), entity.getName(), entity.getAge());
        return entity;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", new UserMapper());
    }

    @Override
    public User findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", new Long[]{id}, new UserMapper());
    }

    @Override
    public boolean deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id=?", id) != 0;
    }
}
