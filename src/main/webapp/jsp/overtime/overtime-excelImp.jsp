<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="MonthForm" method="post" enctype="multipart/form-data">
    <table align="center">
        <%--<input type="hidden" name="id" id="InvoiceId" value="">--%>
        <tr>
            <td><label>选择导入Excel:</label></td>
            <td><input type="file" name="file" id="uploadFile"></td>
            <td>
                <input type="button" onclick="imp()" value="导入">
            </td>
            <td><a href="<%=request.getContextPath()%>/resources/xls/canteenTemplate.xlsx" target="_blank">饭堂就餐导入模版下载</a></td>

        </tr>
            <tr>
                <td colspan="4"></td>
            </tr>
        <tr>
            <td><label>日志:</label></td>
            <td colspan="3"><div id="divLogId"></div></td>
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

    function imp(){
        debugger;
       /* $("#MonthForm").attr("action",ctx+"/canteentime/uploadExcel")
        $("#MonthForm").submit();*/
        var formData = new FormData();
        formData.append('file', $('#uploadFile')[0].files[0]);
        formData.append("name",$('#uploadFile').val());
        $.ajax({
            url: ctx + "/canteentime/uploadExcel",
            type: 'POST',
            cache: false,
            data: formData,
            processData: false,
            contentType: false,
            dataType:"json",
            beforeSend: function(){

            },
            success : function(data) {
                $("#divLogId").empty();
                $("#divLogId").append("---------日志--------------");
                var append="";
                for (var i = 0; i < data.data.length; i++) {
                    append=append+data.data[i]+"<br>";
                }
                $("#divLogId").append(data.msg+"--"+append);
                if(data.code==200){
                    alert(data.msg+data.data.length+"条!");
                    //excleImportDialog.dialog('close');
                }


            }
        });


    }
</script>
