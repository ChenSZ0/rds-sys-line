package me.jinkun.rds.org.service;

import me.jinkun.rds.common.base.EUDataGridResult;
import me.jinkun.rds.org.form.OrgUserForm;
import me.jinkun.rds.org.model.OrgUser;
import me.jinkun.rds.sys.web.result.BaseResult;

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
