<%--
  Created by IntelliJ IDEA.
  User: GDGA
  Date: 2018/10/19
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>误餐补助情况表</title>
</head>

<%@include file="../../resources/common/header.jsp" %>
<body style="text-align:center">
<br><br>
<div style="width:800px; margin:0 auto;"><button onclick="myPrint(document.getElementById('missdivId'))">打 印</button></div>
<div style="width:800px; margin:0 auto;" id="missdivId">
    <br><br>

<table border="1" cellspacing="0" bordercolor="#000000" width = "80%"style="border-collapse:collapse;" id="missTab">
<%--    <tr>
        <th colspan="8">误餐补助情况表</th>
    </tr>
    <tr>
        <th colspan="2" >单位盖章</th>
        <th colspan="4" ></th>
        <th colspan="4">制表时间:</th>
    </tr>
    <tr align="center">
        <th >序号</th>
        <th >日期</th>
        <th >午餐</th>
        <th >晚餐</th>
        <th >人数</th>
        <th >误餐补助金额</th>
        <th >误餐原因</th>
        <th >人员名单</th>
    </tr>
    <tr align="center">
        <td>1</td>
        <td>2018/2/1</td>
        <td>住宿费</td>
        <td>566</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
    </tr>
    <tr align="center">
        <td colspan="4" >合计（人数/金额）:</td>
        <td >300</td>
        <td >200</td>
        <td colspan="2" ></td>
    </tr>--%>
</table>
</div>
<script type="text/javascript">



    var data=${data}

    init();
    function init(){

        if(data!=null && data!=''){
            var append="<tr>\n" +
                "        <th colspan=\"8\">误餐补助情况表</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <th colspan=\"2\" >单位盖章</th>\n" +
                "        <th colspan=\"4\" ></th>\n" +
                "        <th colspan=\"4\">制表时间:</th>\n" +
                "    </tr>\n" +
                "    <tr align=\"center\">\n" +
                "        <th >序号</th>\n" +
                "        <th >日期</th>\n" +
                "        <th >午餐</th>\n" +
                "        <th >晚餐</th>\n" +
                "        <th >人数</th>\n" +
                "        <th >误餐补助金额</th>\n" +
                "        <th >误餐原因</th>\n" +
                "        <th >人员名单</th>\n" +
                "    </tr>";
            var personCount=0;
            var moneyCount=0;
            for (var i = 0; i < data.length; i++) {
                var data_i=data[i];
                var count=data_i.userNameArr.split(",").length;
                personCount=personCount+parseInt(count);
                var money=parseInt(count)*40;
                moneyCount=moneyCount+parseInt(money);

                append+= "    <tr align=\"center\">\n" +
                "        <td>"+(i+1)+"</td>\n" +
                "        <td>"+data_i.date+"</td>\n" +
                "        <td>"+ww(data_i.flagArr,0)+"</td>\n" +
                "        <td>"+ww(data_i.flagArr,1)+"</td>\n" +
                "        <td>"+count+"</td>\n" +
                "        <td>"+money+"</td>\n" +
                "        <td>"+data_i.reasonArr+"</td>\n" +
                "        <td>"+data_i.userNameArr+"</td>\n" +
                "    </tr>";
            }
            append+="<tr align=\"center\">\n" +
                "        <td colspan=\"4\" >合计（人数/金额）:</td>\n" +
                "        <td >"+personCount+"</td>\n" +
                "        <td >"+moneyCount+"</td>\n" +
                "        <td colspan=\"2\" ></td>\n" +
                "    </tr>";
            $("#missTab").append(append)
        }else{
            alert('没数据');
        // #("#missTab").append("<>")
        }
    }

    function ww(val,flag){
        var arr=val.split(",");
        if(arr.length==2){
            if(arr[0]==flag){
                return "√";
            }

        }else if(arr.length==1){
            if(val==flag){
                return "√";
            }
        }
        return "";
    }


    function myPrint(obj){
        var newWindow=window.open("打印窗口","_blank");
        var docStr = obj.innerHTML;
        newWindow.document.write(docStr);
        newWindow.document.close();
        newWindow.print();
        newWindow.close();
    }

</script>
</body>
</html>
