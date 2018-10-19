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
    <title>公务卡报账明细表</title>
</head>

<%@include file="../../resources/common/header.jsp" %>
<body style="text-align:center">
<br><br>
<div style="width:800px; margin:0 auto;"><button onclick="myPrint(document.getElementById('divId'))">打 印</button></div>
<div style="width:800px; margin:0 auto;" id="divId">
    <br><br>

<%--<table border="1" cellspacing="0" bordercolor="#000000" width = "80%"style="border-collapse:collapse;">
    <tr>
        <th colspan="5">公务卡报账明细表</th>
    </tr>
    <tr>
        <td colspan="3" >持卡人姓名:叶文杰</td>
        <td colspan="2">公务卡卡号：6282880052217625</td>
    </tr>
    <tr align="center">
        <td >序号</td>
        <td >消费日期</td>
        <td >报账科目</td>
        <td >消费金额</td>
        <td >凭证张数</td>
    </tr>
    <tr align="center">
        <td>1</td>
        <td>2018/2/1</td>
        <td>住宿费</td>
        <td>566</td>
        <td>1</td>
    </tr>
    <tr align="center">
        <td colspan="3" >合计:</td>
        <td >100</td>
        <td >200</td>
    </tr>
</table>--%>
</div>
<script type="text/javascript">
    console.info(GetRandomNum(1,5));
    var rn=GetRandomNum(1,5);
    var arrTemp=[];
    $.ajax({
        type: "get",
        url: "/invoice/getData",
        data: {month:${month}},
        success: function(data){

            if(data.code==200){
                if(data.data.length==0){
                    $("#divId").append("<h2>暂无数据</h2>")
                }else{
                    var append="";
                    var headStr="";
                    for (var i = 0; i < data.data.length; i++) {

                        var data_i = data.data[i];

                        var heji=0;var pz=0;
                        for (var j = 0; j < data_i.length; j++) {
                            if(j==0){
                                headStr="<table border=\"1\" cellspacing=\"0\" bordercolor=\"#000000\" width = \"80%\"style=\"border-collapse:collapse;\">"+
                                    "            <tr>\n" +
                                    "            <th colspan=\"5\">公务卡报账明细表</th>\n" +
                                    "            </tr>\n" +
                                    "            <tr>\n" +
                                    "            <td colspan=\"3\" >持卡人姓名:"+data_i[0].cardName+"</td>\n" +
                                    "        <td colspan=\"2\">公务卡卡号："+data_i[0].cardNum+"</td>\n" +
                                    "        </tr>\n" +
                                    "        <tr align=\"center\">\n" +
                                    "            <td >序号</td>\n" +
                                    "            <td >消费日期</td>\n" +
                                    "            <td >报账科目</td>\n" +
                                    "            <td >消费金额</td>\n" +
                                    "            <td >凭证张数</td>\n" +
                                    "            </tr>";
                            }



                            var addmunS=addNum(data_i[j].cardMoney,data_i[j].cashMoney)
                            var rd=GetRandomNum(1,4);
                            heji=heji+addmunS;
                            pz=pz+rd;
                            headStr=headStr+ "            <tr align=\"center\">\n" +
                            "            <td>"+(j+1)+"</td>\n" +
                            "            <td>"+new Date(data_i[j].consumeTime).format("yyyy-MM-dd hh:mm:ss")+"</td>\n" +
                            "            <td>"+data_i[j].invoiceType+"</td>\n" +
                            "            <td>"+addmunS+"</td>\n" +
                            "            <td>"+rd+"</td>\n" +
                            "            </tr>";
                        }

                        headStr=headStr+"            <tr align=\"center\">\n" +
                        "            <td colspan=\"3\" >合计:</td>\n" +
                        "        <td >"+heji+"</td>\n" +
                        "        <td >"+pz+"</td>\n" +
                        "        </tr>\n" +
                        "        </table><br><br><br><br><br><br>"

                        append+=headStr;

                    }
                    $("#divId").append(append);







                }
            }
        }
    });

    function GetRandomNum(Min,Max)
    {
        var Range = Max - Min;
        var Rand = Math.random();
        return(Min + Math.round(Rand * Range));
    }

    function  addNum(num1,num2){
       return  parseInt(num1)+ parseInt(num2);
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
