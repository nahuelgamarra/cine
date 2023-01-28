package com.example.cine;

import com.example.cine.models.Company;
import com.example.cine.services.company.CompanyService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CompanyServiceTest {

    @Autowired
    private CompanyService service;

    @Test
    @Transactional
    @Rollback
    public void queSePuedaCrearUnaCompania(){
        Company compania = dadoQueTengoUnaCompania("Test");
        Company companiaGuardada = this.service.createdCompany(compania);

        assertThat(companiaGuardada.getIdCompany()).isEqualTo(compania.getIdCompany());
    }

    private Company dadoQueTengoUnaCompania(String test) {
        Company cmp = new Company();
        cmp.setName(test);
        cmp.setOrigin("Test");
        return cmp;
    }
}
