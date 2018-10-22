<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="overTimeForm" method="post">
    <table class="com_table" align="center" id="tab1">
        <input type="hidden" name="id">
        <tr>
            <td></td>
            <td><label>用户名名称:</label></td>
            <td><input class="easyui-textbox com_input" type="text" name="name" data-options="required:true" disabled="disabled"/></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><label>当月加班次数:</label></td>
            <td><input class="easyui-textbox com_input" type="text" name="count" data-options="required:true"/></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><label>出差时间:</label></td>
            <td><input type="text" class="easyui-datetimebox outtimeAdd" required="required" name="outTime"><a href="javascript:outDate(1)">增加</a></td>
            <td></td>
        </tr>
    </table>
    <table class="com_table" align="center" id="tab2">
        <tr>
            <td></td>
            <td><label>休假时间:&nbsp;&nbsp;</label></td>
            <td><input type="text" class="easyui-datetimebox vacationTimeAdd" required="required" name="vacationTime"><a href="javascript:outDate(2)">增加</a></td>
            <td></td>
        </tr>
    </table>
</form>
<script src="<%=request.getContextPath()%>/jsp/org/org-list.js"></script>
<script>
    OrgUser.input.init('<%=request.getContextPath()%>');



    function outDate(obj){
        if(obj==1){
            var targetObj = $("<tr class='outData'>\n" +
                "            <td></td>\n" +
                "            <td><label></label></td>\n" +
                "            <td><input type=\"text\" class=\"easyui-datetimebox outtimeAdd\"  name=\"outTime\" required=\"required\"><a href=\"javascript:removeDate(1)\">移除</a></td>\n" +
                "            <td></td>\n" +
                "        </tr>").appendTo("#tab1");
        }else if(obj==2){
            var targetObj = $("<tr class='outData2'>\n" +
                "            <td></td>\n" +
                "            <td><label></label></td>\n" +
                "            <td><input type=\"text\" class=\"easyui-datetimebox vacationTimeAdd\"  name=\"vacationTime\" required=\"required\"><a href=\"javascript:removeDate(2)\">移除</a></td>\n" +
                "            <td></td>\n" +
                "        </tr>").appendTo("#tab2");
        }
        $.parser.parse(targetObj);

    }

    function removeDate(obj){
        if(obj==1){
            $($(".outData")[$(".outData").length-1]).remove();
        }else if(obj==2){
            $($(".outData2")[$(".outData2").length-1]).remove();
        }
    }

    function form2Submit(){
        debugger;
        var data =$("#overTimeForm").serialize();
        //console.log($("#overTimeForm").serialize());
        var beforeStr=data.substring(0,data.indexOf("outTime")-1);
        //console.log(beforeStr);
        var endStr=data.substring(data.indexOf("outTime"));
       // console.log(endStr);
        var arr=endStr.split("&");
        var outTimeData="";
        var vacationTimeData="";
        for(var i=0;i<arr.length;i++){
            var index=arr[i].indexOf("outTime=");
            if(index>-1){
                outTimeData=outTimeData+arr[i].substring(8)+","
            }else{
               index= arr[i].indexOf("vacationTime=");
               if(index>-1){
                   vacationTimeData=vacationTimeData+arr[i].substring(13)+",";
               }
            }
        }
        //console.log(outTimeData);
       // console.log(vacationTimeData);

        var ajaxData=beforeStr+"&outTime="+outTimeData.substring(0,outTimeData.length-1)+"&vacationTime="+vacationTimeData.substring(0,vacationTimeData.length-1);
        console.log(ajaxData);
        $.ajax({
            type: "POST",
            url: "/overtime/saveData",
            data: ajaxData,
            success: function(data){
                if(data.code==200){
                    $("#addTimeDialog").dialog('close');
                    OrgList.datagrid("reload");
                }else{
                    alert("保存失败!");
                    console.log("data");
                }

            }
        });
    }

</script>
