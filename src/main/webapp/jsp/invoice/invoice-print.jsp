<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="InvoiceForm" method="post">
    <table class="com_table" align="center">
        <input type="hidden" name="id" id="InvoiceId" value="">
        <tr>
            <td></td>
            <td><label>计算月份:</label></td>
            <td><select class="easyui-combobox" data-options="editable:false" style="width:142px;height: 28px;" id="month">
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
                </select></td>
            <td></td>
        </tr>
    </table>
</form>
<script src="<%=request.getContextPath()%>/jsp/invoice/invoice-list.js"></script>
<script>
    Invoice.input.init('<%=request.getContextPath()%>');

    function printSubmit(){

       var month= $("#month").combobox("getValue");
        window.open("<%=request.getContextPath()%>/invoice/printPage/"+month);
    }
</script>
