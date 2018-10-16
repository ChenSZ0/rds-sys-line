<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="OrgUserForm" method="post">
    <table class="com_table" align="center">
        <input type="hidden" name="id">
        <tr>
            <td></td>
            <td><label>当月加班次数:</label></td>
            <td><input class="easyui-textbox com_input" type="text" name="count" data-options="required:true"/></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><label>用户名名称:</label></td>
            <td><input class="easyui-textbox com_input" type="text" name="name" data-options="required:true"/></td>
            <td></td>
        </tr>
    </table>
</form>
<script src="<%=request.getContextPath()%>/jsp/org/org-list.js"></script>
<script>
    OrgUser.input.init('<%=request.getContextPath()%>');
</script>
