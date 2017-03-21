package me.luajk.company.controller;

import me.luajk.company.model.Company;
import me.luajk.company.model.Sign;
import me.luajk.company.service.CompanyService;
import me.luajk.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CompanyController {

    private CompanyService companyService;

    @Resource
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("company/hm")
    public ModelAndView hm() {
        List<Company> companies = companyService.listComp();
        ModelAndView modelAndView = new ModelAndView("company/home");
        modelAndView.addObject("companies",companies);
        return modelAndView;
    }

    @RequestMapping("company/rep")
    public ModelAndView rep() {
        return new ModelAndView("company/rep");
    }

    @RequestMapping("company/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        Company companies = companyService.getComp(id);
        ModelAndView modelAndView = new ModelAndView("company/detail");
        modelAndView.addObject("com",companies);
        return modelAndView;
    }

    @RequestMapping("comins")
    @ResponseBody
    public Result quesInsert(Company company) {

        return new Result(true, companyService.addComp(company));
    }

    @RequestMapping("signins")
    @ResponseBody
    public Result sign(Sign sign){



        return new Result(true,"");
    }

    @RequestMapping("commdf")
    @ResponseBody
    public Result quesModify(Company company) {

        companyService.modifyComp(company);

        return new Result(true, "");
    }

    @RequestMapping("comdel")
    @ResponseBody
    public Result quesDelete(String id) {

        companyService.deleteComp(id);

        return new Result(true, "");
    }

    @RequestMapping("comlist")
    @ResponseBody
    public List<Company> quesList() {

        return companyService.listComp();
    }
}
