package me.jy.rds.invoiceDetail.dao;

import java.util.List;
import me.jy.rds.invoiceDetail.model.InvoiceDetail;
import me.jy.rds.invoiceDetail.model.InvoiceDetailExample;
import org.apache.ibatis.annotations.Param;

public interface InvoiceDetailMapper {
    int countByExample(InvoiceDetailExample example);

    int deleteByExample(InvoiceDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InvoiceDetail record);

    int insertSelective(InvoiceDetail record);

    List<InvoiceDetail> selectByExample(InvoiceDetailExample example);

    InvoiceDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InvoiceDetail record, @Param("example") InvoiceDetailExample example);

    int updateByExample(@Param("record") InvoiceDetail record, @Param("example") InvoiceDetailExample example);

    int updateByPrimaryKeySelective(InvoiceDetail record);

    int updateByPrimaryKey(InvoiceDetail record);
}