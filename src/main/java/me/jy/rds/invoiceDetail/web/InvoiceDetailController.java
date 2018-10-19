package me.jy.rds.invoiceDetail.web;

import me.jy.rds.invoiceDetail.model.InvoiceDetail;
import me.jy.rds.invoiceDetail.service.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Cshuzhuo
 * @date 2018/10/18 11:42
 */
@Controller
@RequestMapping("/invoice")
public class InvoiceDetailController {
    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(InvoiceDetail form){
        return invoiceDetailService.listPage(form);
    }

    @RequestMapping(value = "toView/{ui}", method = RequestMethod.GET)
    public String ui(@PathVariable("ui") String ui) {
        return "invoice/invoice-" + ui;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Object save(InvoiceDetail model) {
        return invoiceDetailService.saveOrUpdate(model);
    }

    @RequestMapping(value = "/del/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        return invoiceDetailService.deleteByIds(ids);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object get(@PathVariable("id") Long id) {
        return invoiceDetailService.get(id);
    }
}
