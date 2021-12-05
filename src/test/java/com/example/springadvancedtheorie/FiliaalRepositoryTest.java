package com.example.springadvancedtheorie;

import com.example.springadvancedtheorie.domain.Filiaal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.math.BigDecimal;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@Sql("/FiliaalRepository.sql")
class FiliaalRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final FiliaalRepository repository;
    private static final String FILIALEN_TABLE = "filialen";
    private Filiaal filiaal;

    FiliaalRepositoryTest(FiliaalRepository repository) {
        this.repository = repository;
    }

    @BeforeEach
    public void setUp(){
        filiaal = new Filiaal("daresalam", "africa", BigDecimal.valueOf(100000));
    }

    public long idVanAntwerpen(){
        return jdbcTemplate.queryForObject("select id from filialen where naam = ?", Long.class, "antwerpen");
    }
    public long idVanBrussel(){
        return jdbcTemplate.queryForObject("select id from filialen where naam = ?", Long.class, "brussel");
    }
    public long idVanDaresalam(){
        return jdbcTemplate.queryForObject("select id from filialen where naam = ?", Long.class, "daresalam");
    }

    @Test
    public void findAll(){
        assertThat(repository.findAll()).hasSize(countRowsInTable(FILIALEN_TABLE));
    }
    @Test
    public void findAllSorted(){
        assertThat(repository.findAll(Sort.by("gemeente")))
                .hasSize(countRowsInTable(FILIALEN_TABLE))
                .extracting(Filiaal::getGemeente)
                .isSortedAccordingTo(String.CASE_INSENSITIVE_ORDER);
    }
    @Test
    public void getById(){
        assertThat(repository.findById(idVanAntwerpen())).hasValueSatisfying(filiaal -> assertThat(filiaal.getNaam()).isEqualTo("antwerpen"));
    }
    @Test
    public void findByIdIn(){
        assertThat(repository.findAllById(Set.of(idVanAntwerpen(), idVanBrussel())))
                .hasSize(2)
                .extracting(Filiaal::getNaam)
                .containsExactlyInAnyOrder("brussel", "antwerpen");
    }
    @Test
    public void count(){
        assertThat(repository.count()).isEqualTo(countRowsInTable(FILIALEN_TABLE));
    }
    @Test
    public void safe(){
        assertThat(countRowsInTableWhere(FILIALEN_TABLE, "naam = 'daresalam'")).isZero();
        repository.save(filiaal);
        assertThat(countRowsInTableWhere(FILIALEN_TABLE, "naam = 'daresalam'")).isOne();
    }
    @Test
    public void delete(){
        assertThat(countRowsInTableWhere(FILIALEN_TABLE, "naam = 'daresalam'")).isZero();
        repository.save(filiaal);
        assertThat(countRowsInTableWhere(FILIALEN_TABLE, "naam = 'daresalam'")).isOne();
        repository.deleteById(idVanDaresalam());
        repository.flush();
        assertThat(countRowsInTableWhere(FILIALEN_TABLE, "naam = 'daresalam'")).isZero();
    }
    @Test
    public void findByGemeente(){
        assertThat(repository.findByGemeente("borgerhout"))
                .extracting(Filiaal::getGemeente)
                .containsOnly("borgerhout");
    }
}