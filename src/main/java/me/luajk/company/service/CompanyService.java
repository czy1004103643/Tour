package me.luajk.company.service;

import me.luajk.company.model.Company;

import java.util.List;

public interface CompanyService {

    String addComp(Company company);

    void modifyComp(Company company);

    void deleteComp(String id);

    List<Company> listComp();

    Company getComp(String id);
}
