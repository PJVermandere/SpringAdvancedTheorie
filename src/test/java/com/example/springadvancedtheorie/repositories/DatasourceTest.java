package com.example.springadvancedtheorie.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.sql.SQLException;

@DataJpaTest
public class DatasourceTest {
    private final DataSource dataSource;

    public DatasourceTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Test
    void getConnecetion() throws Exception{
        try{
            var connection = dataSource.getConnection().getCatalog();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
