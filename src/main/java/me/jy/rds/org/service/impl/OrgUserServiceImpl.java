package me.jy.rds.org.service.impl;

import com.github.pagehelper.PageHelper;
import me.jy.rds.common.base.EUDataGridResult;
import me.jy.rds.org.dao.OrgUserMapper;
import me.jy.rds.org.form.OrgUserForm;
import me.jy.rds.org.model.OrgUser;
import me.jy.rds.org.model.OrgUserExample;
import me.jy.rds.org.service.OrgUserService;
import me.jy.rds.sys.web.result.BaseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cshuzhuo
 * @date 2018/10/16 11:09
 */
@Service
public class OrgUserServiceImpl implements OrgUserService {

    @Autowired
    private OrgUserMapper orgUserMapper;

    @Override
    public EUDataGridResult listPage(OrgUserForm form) {
        OrgUserExample example = new OrgUserExample();
        if (StringUtils.isNotBlank(form.getName())){
            OrgUserExample.Criteria criteria = example.createCriteria();
            criteria.andNameLike("%"+form.getName()+"%");
        }

        //查询分页列表
        int page=(int) form.getPage().longValue();
        int rows=(int)form.getRows().longValue();
        PageHelper.startPage(page,rows);
        List<OrgUser> sysUserList = orgUserMapper.selectByExample(example);
        int count = orgUserMapper.countByExample(example);
        //返回结果
        EUDataGridResult result = new EUDataGridResult(count,sysUserList);
        return result;
    }

    @Override
    @Transactional
    public BaseResult saveOrUpdate(OrgUser orgUser) {
        int result;
        if(orgUser.getId()==null){
            result = orgUserMapper.insert(orgUser);
            if(result>0) return BaseResult.ok("保存成功!");
        }else{
            result = orgUserMapper.updateByPrimaryKey(orgUser);
            if(result>0) return BaseResult.ok("更新成功!");
        }
        return BaseResult.fail("保存失败!!");
    }

    @Override
    @Transactional
    public BaseResult deleteByIds(String ids) {
        List<Long> idList = idsToList(ids);
        OrgUserExample example = new OrgUserExample();
        example.createCriteria().andIdIn(idList);
        int i = orgUserMapper.deleteByExample(example);
        if(i>0)return BaseResult.ok("删除成功");
        return BaseResult.fail("删除失败");

    }

    @Override
    public BaseResult get(Long id) {
        OrgUser orgUser = orgUserMapper.selectByPrimaryKey(id);
        return BaseResult.ok("获取信息成功",orgUser);
    }

    @Override
    public int countByExample(OrgUserExample example) {
        return orgUserMapper.countByExample(example);
    }

    private List<Long> idsToList(String ids) {
        String[] id = ids.split(",");
        List<Long> idList = new ArrayList<>();
        for (int i = 0; i < id.length; i++) {
            idList.add(Long.parseLong(id[i]));
        }
        return idList;
    }
}
