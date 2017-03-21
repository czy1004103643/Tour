package me.luajk.company.dao;

import me.luajk.company.model.Company;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyDao {

    void add(Company company);

    void update(Company company);

    void delete(String id);

    List<Company> list();

    Company get(String id);

}
