<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="InvoiceForm" method="post">
    <table class="com_table" align="center">
        <input type="hidden" name="id" id="InvoiceId" value="">
        <tr>
            <td></td>
            <td><label>计算月份:</label></td>
            <td><input class="easyui-textbox com_input" type="text" name="month" id="month" data-options="required:true"/></td>
            <td></td>
        </tr>
    </table>
</form>
<script src="<%=request.getContextPath()%>/jsp/invoice/invoice-list.js"></script>
<script>
    Invoice.input.init('<%=request.getContextPath()%>');

    function printSubmit(){
       var month= $("#month").textbox("getValue");
        window.open("<%=request.getContextPath()%>/invoice/printPage/"+month);
    }
</script>
