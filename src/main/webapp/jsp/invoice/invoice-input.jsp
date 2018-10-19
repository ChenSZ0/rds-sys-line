<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="InvoiceForm" method="post">
    <table class="com_table" align="center">
        <input type="hidden" name="id" id="InvoiceId" value="">
        <tr>
            <td></td>
            <td><label>票据编号:</label></td>
            <td><input class="easyui-textbox com_input" type="text" name="number" id="number" data-options="required:true"/></td>
            <td></td>
        </tr>
       <tr>
            <td></td>
            <td><label>交票人:</label></td>
            <td><input class="easyui-textbox com_input" type="text" name="ticketName"  id="ticketName"data-options="required:true"/></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><label>持卡人:</label></td>
            <td><input class="easyui-textbox com_input" type="text" name="cardName"  id="cardName" data-options="required:true"/></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><label>卡号:</label></td>
            <td><input class="easyui-textbox com_input" type="text" name="cardNum" id="cardNum" data-options="required:true"/></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><label>消费时间:</label></td>
            <td><input type="text" class="easyui-datetimebox outtimeAdd" required="required" editable="false" name="consumeTime" id="consumeTime"></td>
            <td></td>
        </tr>
        <tr>
                    <td></td>
                    <td><label>公务卡金额:</label></td>
                    <td><input class="easyui-textbox com_input" type="text" id="cardMoney" name="cardMoney" data-options="required:true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label>现金金额:</label></td>
                    <td><input class="easyui-textbox com_input" type="text" name="cashMoney" id="cashMoney" data-options="required:true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label>现金补助费:</label></td>
                    <td><input class="easyui-textbox com_input" type="text" name="cashSubsidy" id="cashSubsidy" data-options="required:true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label>出差补助费负责人:</label></td>
                    <td><input class="easyui-textbox com_input" type="text" name="responsibleName" id="responsibleName" data-options="required:true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label>发票类型:</label></td>
                    <td><input class="easyui-textbox com_input" type="text" name="invoiceType" id="invoiceType" data-options="required:true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label>计算月份:</label></td>
                    <td><input class="easyui-textbox com_input" type="text" name="month" id="month" data-options="required:true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label>摘要:</label></td>
                    <td><input class="easyui-textbox com_input" type="text" name="summary" id="summary" data-options="required:true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label>退票:</label></td>
                    <td><input class="easyui-textbox com_input" type="text" name="refund" id="refund" data-options="required:true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label>到帐时间:</label></td>
                    <td><input type="text" class="easyui-datetimebox outtimeAdd" required="required" name="receivingTime" id="receivingTime" editable="false"></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label>收票时间:</label></td>
                    <td><input type="text" editable="false" class="easyui-datetimebox outtimeAdd" required="required" name="receivedTime" id="receivedTime"></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label>报账时间:</label></td>
                    <td><input type="text" editable="false" class="easyui-datetimebox outtimeAdd" required="required" name="accountTime" id="accountTime"></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label>开支用途:</label></td>
                    <td><input class="easyui-textbox com_input" type="text" name="purpose" id="purpose" data-options="required:true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label>备注:</label></td>
                    <td><input class="easyui-textbox com_input" type="text" name="remark"  id="remark" data-options="required:true"/></td>
                    <td></td>
                </tr>



    </table>
</form>
<script src="<%=request.getContextPath()%>/jsp/invoice/invoice-list.js"></script>
<script>
    Invoice.input.init('<%=request.getContextPath()%>');
</script>
