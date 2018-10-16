<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 工具栏 -->
<div id="OrgToolbar"  style="padding:5px;height:auto">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" plain="true" onclick="javascript:OrgUser.list.add()">增加</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" plain="true" onclick="javascript:OrgUser.list.delete()">删除</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" plain="true" onclick="javascript:OrgUser.list.edit()">编辑</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" plain="true" onclick="javascript:OrgUser.list.addTime()">加班情况</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" plain="true" onclick="javascript:OrgUser.list.reload()">刷新</a>
    <span style="float: right;margin-right: 10px;padding: 1px">
        <span>用户名:</span>
        <input lang="searchSysUser" name="name" style="line-height:19px;border:1px solid #ccc">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" plain="true" onclick="javascript:OrgUser.list.clear()">清除</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" plain="true" onclick="javascript:OrgUser.list.search()">搜索</a>
    </span>
</div>
<div class="easyui-panel" data-options="fit:true,border:false">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'center',border:false">
            <!-- 列表 -->
            <table id="OrgList" data-options="border:false" style="width: 100%;" title="用户"></table>
        </div>
    </div>
</div>
<!-- 弹窗  --> <!-- inline:true 不然多次打开tab会重复提交表单 -->
<div id="OrgUserEdit" title="用户"  style="width:500px;height:500px;top: 100px;padding: 10px;display: none" data-options="iconCls: 'icon-save',closed: true,modal: true,inline:true,buttons:[{text:'保存',iconCls:'icon-save',handler:function(){OrgUser.input.submitForm()}},{text:'取消',iconCls:'icon-cancel',handler:function(){SysUser.input.close()}}]"></div>

<div id="addTimeDialog" title="用户加班情况"  style="width:500px;height:500px;top: 100px;padding: 10px;display: none" data-options="iconCls: 'icon-save',closed: true,modal: true,inline:true,buttons:[{text:'保存',iconCls:'icon-save',handler:function(){OrgUser.input.submitForm()}},{text:'取消',iconCls:'icon-cancel',handler:function(){SysUser.input.close()}}]"></div>

<script src="<%=request.getContextPath()%>/jsp/org/org-list.js"></script>
<script>
    OrgUser.list.init('<%=request.getContextPath()%>');

</script>