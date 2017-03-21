package me.luajk.company.service.impl;

import me.luajk.company.dao.CompanyDao;
import me.luajk.company.model.Company;
import me.luajk.company.service.CompanyService;
import me.luajk.utils.IdGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyDao companyDao;

    @Resource
    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public String addComp(Company company) {
        String id = IdGenerator.getId();
        company.setId(id);
        companyDao.add(company);
        return id;
    }

    public void modifyComp(Company company) {
        companyDao.update(company);
    }

    public void deleteComp(String id) {
        companyDao.delete(id);
    }

    public List<Company> listComp() {
        return companyDao.list();
    }

    public Company getComp(String id) {
        return companyDao.get(id);
    }
}
