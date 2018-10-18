package me.jy.rds.org.web;

import me.jy.rds.org.form.OrgUserForm;
import me.jy.rds.org.model.OrgUser;
import me.jy.rds.org.service.OrgUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author csz
 * @since 2018-10-15
 */
@Controller
@RequestMapping("/org")
public class OrgUserController {

    @Autowired
    private OrgUserService orgUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(OrgUserForm form){
        return orgUserService.listPage(form);
    }

    @RequestMapping(value = "user/{ui}", method = RequestMethod.GET)
    public String ui(@PathVariable("ui") String ui) {
        return "org/org-" + ui;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Object save(OrgUser orgUser) {
        return orgUserService.saveOrUpdate(orgUser);
    }

    @RequestMapping(value = "/del/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        return orgUserService.deleteByIds(ids);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object get(@PathVariable("id") Long id) {
        return orgUserService.get(id);
    }

}

