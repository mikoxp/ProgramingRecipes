package com.moles.h2;

import com.moles.h2.entities.Info;
import com.moles.h2.repositories.InfoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class InfoTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private InfoRepository infoRepository;

    @BeforeEach
    void beforeAll() {
        Info info=new Info();
        entityManager.persist(info);
    }

    @Test
    public void all(){
        List<Info> all = infoRepository.findAll();
        Assertions.assertEquals(1,all.size());
    }
}
