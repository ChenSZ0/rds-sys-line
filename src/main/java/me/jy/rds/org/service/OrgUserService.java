package me.jy.rds.org.service;

import me.jy.rds.common.base.EUDataGridResult;
import me.jy.rds.org.form.OrgUserForm;
import me.jy.rds.org.model.OrgUser;
import me.jy.rds.sys.web.result.BaseResult;

/**
 * @author Cshuzhuo
 * @date 2018/10/16 11:08
 */
public interface OrgUserService {

    EUDataGridResult listPage(OrgUserForm form);

    BaseResult saveOrUpdate(OrgUser orgUser);

    BaseResult deleteByIds(String ids);

    BaseResult get(Long id);
}
