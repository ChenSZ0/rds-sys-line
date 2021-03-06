package me.jy.rds.sys.service;

import me.jy.rds.common.base.BaseResult;
import me.jy.rds.common.base.EUDataGridResult;
import me.jy.rds.sys.web.form.SysRoleResourceForm;

import java.util.List;


public interface SysRoleResourceService {

    /**
     * Description: 跟据角色获取资源ID <br/>
     * Autor: Created by jinkun on 2017/4/20.
     */
    List<Long> getResourcesIdsByRoleId(Long id);

    /**
     * Description: 删除角色关联的资源信息 <br/>
     * Autor: Created by jinkun on 2017/4/20.
     */
    void deleteByRoleId(Long id);

    /**
     * Description: 删除角色关联的资源信息 <br/>
     * Autor: Created by jinkun on 2017/4/20.
     */
    void deleteByRoleIds(List<Long> ids);

    /**
     * Description: 删除资源关联的角色信息 <br/>
     * Autor: Created by jinkun on 2017/4/20.
     */
    void deleteByResourceIds(List<Long> ids);

    /**
     * Description: 增加或修改 <br/>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult saveOrUpdate(SysRoleResourceForm form);

    /**
     * Description: 根据条件修改 <br/>
     * 主键或其它条件<p>
     * Autor: Created by JinKun on 2016-12-30.
     */
    BaseResult update(SysRoleResourceForm form);

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
    BaseResult list(SysRoleResourceForm form);

    /**
     * Description: 查询列表 <br/>
     * page: ture 分页 false 查询所有<p>
     * Autor: Created by JinKun on 2016-12-30.
     */
    EUDataGridResult listPage(SysRoleResourceForm form);

}