<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 工具栏 -->
<div id="InvoiceToolbar"  style="padding:5px;height:auto">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" plain="true" onclick="javascript:Invoice.list.add()">增加</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" plain="true" onclick="javascript:Invoice.list.delete()">删除</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" plain="true" onclick="javascript:Invoice.list.edit()">编辑</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" plain="true" onclick="javascript:Invoice.list.reload()">刷新</a>
    <span style="float: right;margin-right: 10px;padding: 1px">
        <span>持卡人:</span>
        <input lang="searchInvoice" name="cardName" style="line-height:19px;border:1px solid #ccc">
        <span>计算月份:</span>
        <input lang="searchInvoice" name="month" style="line-height:19px;border:1px solid #ccc">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" plain="true" onclick="javascript:Invoice.list.clear()">清除</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" plain="true" onclick="javascript:Invoice.list.search()">搜索</a>
    </span>
</div>
<div class="easyui-panel" data-options="fit:true,border:false">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'center',border:false">
            <!-- 列表 -->
            <table id="InvoiceList" data-options="border:false" style="width: 100%;" title="用户"></table>
        </div>
    </div>
</div>
<!-- 弹窗  --> <!-- inline:true 不然多次打开tab会重复提交表单 -->
<div id="InvoiceEdit" title="报销明细"  style="width:500px;height:500px;top: 100px;padding: 10px;display: none" data-options="iconCls: 'icon-save',closed: true,modal: true,inline:true,buttons:[{text:'保存',iconCls:'icon-save',handler:function(){Invoice.input.submitForm()}},{text:'取消',iconCls:'icon-cancel',handler:function(){Invoice.input.close()}}]"></div>

<%--
<div id="addTimeDialog" title="用户加班情况"  style="width:500px;height:500px;top: 100px;padding: 10px;display: none" data-options="iconCls: 'icon-save',closed: true,modal: true,inline:true,buttons:[{text:'保存',iconCls:'icon-save',handler:function(){form2Submit()}},{text:'取消',iconCls:'icon-cancel',handler:function(){OrgUser.input.close()}}]"></div>
--%>

<script src="<%=request.getContextPath()%>/jsp/invoice/invoice-list.js"></script>
<script>
    Invoice.list.init('<%=request.getContextPath()%>');

</script>