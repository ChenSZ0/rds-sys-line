<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="MonthForm" method="post">
    <table align="center">
        <%--<input type="hidden" name="id" id="InvoiceId" value="">--%>
        <tr>
            <td><label>日期:</label></td>
            <td><input type="text" editable="false" class="easyui-datebox" required="required" name="startDate" id="startDate">至</td>
            <td>
                <input type="text" editable="false" class="easyui-datebox" required="required" name="endDate" id="endDate">
                <%--<input class="easyui-textbox com_input" type="text" name="month" id="month" data-options="required:true"/>--%>
                <%--<select class="webui-combobox" id="order-back-certType" data-options="editable:false" style="width:142px;height: 28px;">
                    <option value="1">1月</option>
                    <option value="2">2月</option>
                    <option value="3">3月</option>
                    <option value="4">4月</option>
                    <option value="5">5月</option>
                    <option value="6">6月</option>
                    <option value="7">7月</option>
                    <option value="8">8月</option>
                    <option value="9">9月</option>
                    <option value="10">10月</option>
                    <option value="11">11月</option>
                    <option value="12">12月</option>
                </select>--%>
            </td>
            <td></td>

            <td></td>
        </tr>
    </table>
</form>
<script src="<%=request.getContextPath()%>/jsp/org/org-list.js"></script>
<script>
    OrgUser.list.init('<%=request.getContextPath()%>');

    var flag="${flag}";
    function printMonthSubmit(){
      // var month= $("#month").combobox("getValue");
        var startDate =$('#startDate').datebox('getValue');
       var endDate = $('#endDate').datebox('getValue');
        window.open("<%=request.getContextPath()%>/overtime/printPage?startDate="+startDate+"&endDate="+endDate+"&flag="+flag);
    }
</script>
