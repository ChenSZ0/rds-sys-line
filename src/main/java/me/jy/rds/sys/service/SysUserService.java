package me.jy.rds.sys.service;

import me.jy.rds.sys.domain.SysUser;
import me.jy.rds.sys.web.form.SysUserForm;
import me.jy.rds.common.base.BaseResult;
import me.jy.rds.common.base.EUDataGridResult;
import me.jy.rds.common.base.Tree;

import java.util.List;


public interface SysUserService {

    /**
     * Description: 增加或修改 <br/>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult saveOrUpdate(SysUserForm form);

    /**
     * Description: 根据条件修改 <br/>
     * 主键或其它条件<p>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult update(SysUserForm form);

    /**
     * Description: 根据主键删除 <br/>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult delete(Long id);

    /**
     * Description: 根据主键删除多个 <br/>
     * ids: 1,2,3<p>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult deleteByIds(String ids);

    /**
     * Description: 根据ID查询 <br/>
     * page: ture 分页 false 查询所有<p>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult get(Long id);

    /**
     * Description: 查询列表 <br/>
     * page: ture 分页 false 查询所有<p>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult list(SysUserForm form);

    /**
     * Description: 查询列表 <br/>
     * page: ture 分页 false 查询所有<p>
     * Autor: Created by JinKun on 2016-12-30.
     */
    EUDataGridResult listPage(SysUserForm form);

    BaseResult login(SysUserForm form);

    /**
     * Description: 根据登录名获取用户 <br/>
     * Autor: Created by JinKun on 2016-12-30.
     */
    SysUser getByLoginName(String loginName);

    BaseResult topMenu();

    List<Tree> menuTree(Long id);

    BaseResult logout();
}