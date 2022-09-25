package com.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utils.Page;
import com.bean.BaseDict;
import com.bean.Company;
import com.service.BaseDictService;
import com.service.CompanyService;

/**
 * 招聘管理控制器类
 */
@Controller
public class CompanyController {
    // 依赖注入
    @Autowired
    private CompanyService companyService;
    @Autowired
    private BaseDictService baseDictService;
    // 招聘来源
    @Value("${company.from.type}")
    private String FROM_TYPE;
    // 招聘行业
    @Value("${company.industry.type}")
    private String INDUSTRY_TYPE;
    // 公司人数
    @Value("${company.people.type}")
    private String PEOPLE_TYPE;
    // 招聘薪酬
    @Value("${company.money.type}")
    private String MONEY_TYPE;

    /**
     * 招聘列表Test
     */
    @RequestMapping(value = "/company/mainTest.action")
    public String mainTest() {
        return "index";
    }

    /**
     * 招聘列表
     * 用户页面
     */
    @RequestMapping(value = "/company/userList.action")
    public String userList(@RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "10") Integer rows,
                           String comName, String comSource, String comIndustry, String comPeople,
                           String comMoney, Model model,
                           @RequestParam(value = "user_id", required = false) int user_id) {
        // 条件查询所有招聘信息
        Page<Company> companys = companyService
                .findCompanyList(page, rows, comName,
                        comSource, comIndustry, comPeople, comMoney);
        model.addAttribute("page", companys);
        // 招聘来源
        List<BaseDict> fromType = baseDictService
                .findBaseDictByTypeCode(FROM_TYPE);
        // 所属行业
        List<BaseDict> industryType = baseDictService
                .findBaseDictByTypeCode(INDUSTRY_TYPE);
        // 公司人数
        List<BaseDict> peopleType = baseDictService
                .findBaseDictByTypeCode(PEOPLE_TYPE);
        // 薪酬
        List<BaseDict> moneyType = baseDictService
                .findBaseDictByTypeCode(MONEY_TYPE);
        // 添加参数
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("peopleType", peopleType);
        model.addAttribute("moneyType", moneyType);
        model.addAttribute("comName", comName);
        model.addAttribute("comSource", comSource);
        model.addAttribute("comIndustry", comIndustry);
        model.addAttribute("comPeople", comPeople);
        model.addAttribute("comMoney", comMoney);
        model.addAttribute("user_id", user_id);

        return "customer";
    }

    /**
     * 招聘列表
     * 企业页面
     */
    @RequestMapping(value = "/company/enterpriseList.action")
    public String enterpriseList(@RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10") Integer rows,
                                 String comName, String comSource, String comIndustry, String comPeople,
                                 String comMoney, Model model,
                                 @RequestParam(value = "en_id") int en_id) {

        model.addAttribute("en_id", en_id);
        // 条件查询所有招聘信息
        Page<Company> companys = companyService
                .findCompanyList(page, rows, comName,
                        comSource, comIndustry, comPeople, comMoney);
        model.addAttribute("page", companys);
        // 招聘来源
        List<BaseDict> fromType = baseDictService
                .findBaseDictByTypeCode(FROM_TYPE);
        // 所属行业
        List<BaseDict> industryType = baseDictService
                .findBaseDictByTypeCode(INDUSTRY_TYPE);
        // 公司人数
        List<BaseDict> peopleType = baseDictService
                .findBaseDictByTypeCode(PEOPLE_TYPE);
        // 薪酬
        List<BaseDict> moneyType = baseDictService
                .findBaseDictByTypeCode(MONEY_TYPE);
        // 添加参数
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("peopleType", peopleType);
        model.addAttribute("moneyType", moneyType);
        model.addAttribute("comName", comName);
        model.addAttribute("comSource", comSource);
        model.addAttribute("comIndustry", comIndustry);
        model.addAttribute("comPeople", comPeople);
        model.addAttribute("comMoney", comMoney);

        return "company";
    }

    /**
     * 招聘列表
     * 管理员页面
     */
    @RequestMapping(value = "/company/adminList.action")
    public String adminList(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer rows,
                            String comName, String comSource, String comIndustry, String comPeople,
                            String comMoney, Model model) {
        // 条件查询所有招聘信息

        Page<Company> companys = companyService
                .findCompanyList(page, rows, comName,
                        comSource, comIndustry, comPeople, comMoney);
        model.addAttribute("page", companys);
        // 招聘来源
        List<BaseDict> fromType = baseDictService
                .findBaseDictByTypeCode(FROM_TYPE);
        // 所属行业
        List<BaseDict> industryType = baseDictService
                .findBaseDictByTypeCode(INDUSTRY_TYPE);
        // 公司人数
        List<BaseDict> peopleType = baseDictService
                .findBaseDictByTypeCode(PEOPLE_TYPE);
        // 薪酬
        List<BaseDict> moneyType = baseDictService
                .findBaseDictByTypeCode(MONEY_TYPE);
        // 添加参数
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("peopleType", peopleType);
        model.addAttribute("moneyType", moneyType);
        model.addAttribute("comName", comName);
        model.addAttribute("comSource", comSource);
        model.addAttribute("comIndustry", comIndustry);
        model.addAttribute("comPeople", comPeople);
        model.addAttribute("comMoney", comMoney);

        return "admin";
    }

    /**
     * 招聘列表
     * 查询功能
     */
    @RequestMapping(value = "/company/searchList.action")
    public String searchList(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer rows,
                            String comName, String comSource, String comIndustry, String comPeople,
                            String comMoney, Model model) {
        // 条件查询所有招聘信息

        Page<Company> companys = companyService
                .findCompanyList(page, rows, comName,
                        comSource, comIndustry, comPeople, comMoney);
        model.addAttribute("page", companys);
        // 招聘来源
        List<BaseDict> fromType = baseDictService
                .findBaseDictByTypeCode(FROM_TYPE);
        // 所属行业
        List<BaseDict> industryType = baseDictService
                .findBaseDictByTypeCode(INDUSTRY_TYPE);
        // 公司人数
        List<BaseDict> peopleType = baseDictService
                .findBaseDictByTypeCode(PEOPLE_TYPE);
        // 薪酬
        List<BaseDict> moneyType = baseDictService
                .findBaseDictByTypeCode(MONEY_TYPE);
        // 添加参数
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("peopleType", peopleType);
        model.addAttribute("moneyType", moneyType);
        model.addAttribute("comName", comName);
        model.addAttribute("comSource", comSource);
        model.addAttribute("comIndustry", comIndustry);
        model.addAttribute("comPeople", comPeople);
        model.addAttribute("comMoney", comMoney);

        return "admin";
    }

    /**
     * 创建客户
     */
    @RequestMapping("/company/create.action")
    @ResponseBody
    public String CompanyCreate(Company company, HttpSession session) {
        System.out.println(company);
        // 执行Service层中的创建方法，返回的是受影响的行数
        int rows = companyService.createCompany(company);
        System.out.println(rows);
        if (rows > 0) {
            return "OK";
        } else {
            return "FAIL";
        }
    }

    /**
     * 通过id获取招聘信息
     */
    @RequestMapping("/company/getCompanyById.action")
    @ResponseBody
    public Company getCompanyById(Integer id) {
        Company company = companyService.getCompanyById(id);
        return company;
    }

    /**
     * 更新招聘信息
     */
    @RequestMapping("/company/update.action")
    @ResponseBody
    public String CompanyUpdate(Company company) {
        System.out.println(company);
        int rows = companyService.updateCompany(company);
        if (rows > 0) {
            return "OK";
        } else {
            return "FAIL";
        }
    }

    /**
     * 删除招聘信息
     */
    @RequestMapping("/company/delete.action")
    @ResponseBody
    public String CompanyDelete(Integer id) {
        System.out.println(id);
        int rows = companyService.deleteCompany(id);
        if (rows > 0) {
            return "OK";
        } else {
            return "FAIL";
        }
    }

    @RequestMapping("/company/showDetail.action")
    public String showDetail(Integer com_id, Integer user_id, Model model) {
        Company company = companyService.getCompanyById(com_id);
        System.out.println(company);

        String com_industry = baseDictService.findBaseDictById(company.getCom_industry());
        String com_people = baseDictService.findBaseDictById(company.getCom_people());
        String com_money = baseDictService.findBaseDictById(company.getCom_money());

        model.addAttribute("com_id", company.getCom_id());
        model.addAttribute("com_name", company.getCom_name());
        model.addAttribute("com_industry", com_industry);
        model.addAttribute("com_people", com_people);
        model.addAttribute("com_money", com_money);
        model.addAttribute("com_education", company.getCom_education());
        model.addAttribute("com_address", company.getCom_address());
        model.addAttribute("user_id", user_id);

        return "details";
    }
}
