package me.jy.rds.invoiceDetail.service;

import me.jy.rds.common.base.EUDataGridResult;
import me.jy.rds.invoiceDetail.model.InvoiceDetail;
import me.jy.rds.sys.web.result.BaseResult;

/**
 * @author Cshuzhuo
 * @date 2018/10/18 11:43
 */
public interface InvoiceDetailService {

    EUDataGridResult listPage(InvoiceDetail form);

    BaseResult saveOrUpdate(InvoiceDetail model);

    BaseResult deleteByIds(String ids);

    BaseResult get(Long id);

    BaseResult getData(int month);
}
