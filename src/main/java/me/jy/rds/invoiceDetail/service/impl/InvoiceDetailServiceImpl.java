package me.jy.rds.invoiceDetail.service.impl;

import com.github.pagehelper.PageHelper;
import me.jy.rds.common.base.EUDataGridResult;
import me.jy.rds.invoiceDetail.dao.InvoiceDetailMapper;
import me.jy.rds.invoiceDetail.model.InvoiceDetail;
import me.jy.rds.invoiceDetail.model.InvoiceDetailExample;
import me.jy.rds.invoiceDetail.service.InvoiceDetailService;
import me.jy.rds.org.model.OrgUser;
import me.jy.rds.sys.web.result.BaseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cshuzhuo
 * @date 2018/10/18 11:44
 */
@Service
public class InvoiceDetailServiceImpl  implements InvoiceDetailService {

    @Autowired
    private InvoiceDetailMapper  invoiceDetailMapper;

    @Override
    public EUDataGridResult listPage(InvoiceDetail form) {
        InvoiceDetailExample example = new InvoiceDetailExample();
        //查询分页列表
        int page=(int) form.getPage().longValue();
        int rows=(int)form.getRows().longValue();
        PageHelper.startPage(page,rows);
        InvoiceDetailExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(form.getCardName())){
            criteria.andCardNameLike("%"+form.getCardName()+"%");
        }
        if(StringUtils.isNotBlank(form.getMonth())){
            criteria.andMonthEqualTo(form.getMonth());
        }


        List<InvoiceDetail> sysUserList = invoiceDetailMapper.selectByExample(example);
        int count = invoiceDetailMapper.countByExample(example);
        //返回结果
        EUDataGridResult result = new EUDataGridResult(count,sysUserList);
        return result;
    }

    @Override
    @Transactional
    public BaseResult saveOrUpdate(InvoiceDetail model) {
        if(model.getId()==null){
            int result = invoiceDetailMapper.insert(model);
            if(result>0) return BaseResult.ok("保存成功!");
        }else{
            int result = invoiceDetailMapper.updateByPrimaryKey(model);
            if(result>0) return BaseResult.ok("更新成功!");
        }
        return BaseResult.fail("保存失败!!");
    }

    @Override
    public BaseResult deleteByIds(String ids) {
        List<Long> idList = idsToList(ids);
        InvoiceDetailExample example = new InvoiceDetailExample();
        example.createCriteria().andIdIn(idList);
        int i = invoiceDetailMapper.deleteByExample(example);
        if(i>0)return BaseResult.ok("删除成功");
        return BaseResult.fail("删除失败");
    }

    @Override
    public BaseResult get(Long id) {
        InvoiceDetail orgUser = invoiceDetailMapper.selectByPrimaryKey(id);
        return BaseResult.ok("获取信息成功",orgUser);
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
