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
    <title>补助费申请审批表</title>
</head>

<%@include file="../../resources/common/header.jsp" %>
<body style="text-align:center">
<br><br>
<div style="width:800px; margin:0 auto;"><button onclick="myPrint(document.getElementById('trialDivId'))">打 印</button></div>
<div style="width:800px; margin:0 auto;" id="trialDivId">
    <br><br>

<table border="1" cellspacing="0" bordercolor="#000000" width = "90%" style="border-collapse:collapse;" id="trialTab">
<%--    <tr>
        <th colspan="8">补助费申请审批表</th>
    </tr>
    <tr align="center">
        <td colspan="8">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</td>
    </tr>
    <tr>
        <td colspan="3" >申报部门：（盖章）</td>
        <td colspan="4"></td>
        <td colspan="1">单位：元</td>
    </tr>
    <tr align="center">
        <td >序号</td>
        <td >补助项目（午餐/晚餐）</td>
        <td >姓名</td>
        <td >补助时间</td>
        <td >次数</td>
        <td >标准金额</td>
        <td >补助总额</td>
        <td >补助原因说明</td>
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
        <td colspan="2" >合计:</td>
        <td colspan="4">100</td>
        <td colspan="2">200</td>
    </tr>--%>
</table>
    <div style="margin-top: 20px;width: 90%">
        <div style="width: 30%;float: left">单位领导</div>
        <div style="width: 30%;float: left">审核：</div>
        <div style="width: 30%;float: left">经手人：</div>
    </div>
</div>
<script type="text/javascript">

var data=${data};
var startDate ="${startDate}";
var endDate ="${endDate}";
var resultdate="";
if(startDate!='' && endDate!=''){
    startDate=new Date(startDate).format("yyyy-MM");
    endDate=new Date(endDate).format("dd");
    resultdate=startDate+"至"+endDate+"日";
}
debugger;
init();
   function init(){
       if (data!=null && data.length>0){
           var append="    <tr>\n" +
               "        <th colspan=\"8\">补助费申请审批表</th>\n" +
               "    </tr>\n" +
               "    <tr align=\"center\">\n" +
               "        <td colspan=\"8\">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</td>\n" +
               "    </tr>\n" +
               "    <tr>\n" +
               "        <td colspan=\"3\" >申报部门：（盖章）</td>\n" +
               "        <td colspan=\"4\"></td>\n" +
               "        <td colspan=\"1\">单位：元</td>\n" +
               "    </tr>\n" +
               "    <tr align=\"center\">\n" +
               "        <td >序号</td>\n" +
               "        <td >补助项目（午餐/晚餐）</td>\n" +
               "        <td >姓名</td>\n" +
               "        <td >补助时间</td>\n" +
               "        <td >次数</td>\n" +
               "        <td >标准金额</td>\n" +
               "        <td >补助总额</td>\n" +
               "        <td >补助原因说明</td>\n" +
               "    </tr>";
           var moneyCount=0;
           for (var i = 0; i < data.length; i++) {
               var data_i=data[i];
               var money=parseInt(data_i.count)*40;
               moneyCount=moneyCount+money;
               append+="    <tr align=\"center\">\n" +
                   "        <td>"+(i+1)+"</td>\n" +
                   "        <td>午餐、晚餐</td>\n" +
                   "        <td>"+data_i.userName+"</td>\n" +
                   "        <td>"+resultdate+"</td>\n" +
                   "        <td>"+data_i.count+"</td>\n" +
                   "        <td>40</td>\n" +
                   "        <td>"+money+"</td>\n" +
                   "        <td>"+data_i.reasonArr+"</td>\n" +
                   "    </tr>";

           }
           append+="<tr align=\"center\">\n" +
           "        <td colspan=\"2\" >合计:</td>\n" +
           "        <td colspan=\"4\">（大写）"+DX(moneyCount)+"</td>\n" +
           "        <td colspan=\"2\">(小写)￥"+moneyCount+"元</td>\n" +
           "    </tr>";
           $("#trialTab").append(append);
       }
   }
function DX(n) {
    if (!/^(0|[1-9]\d*)(\.\d+)?$/.test(n))
        return "数据非法";
    var unit = "千百拾亿千百拾万千百拾元角分", str = "";
    n += "00";
    var p = n.indexOf('.');
    if (p >= 0)
        n = n.substring(0, p) + n.substr(p+1, 2);
    unit = unit.substr(unit.length - n.length);
    for (var i=0; i < n.length; i++)
        str += '零壹贰叁肆伍陆柒捌玖'.charAt(n.charAt(i)) + unit.charAt(i);
    return str.replace(/零(千|百|拾|角)/g, "零").replace(/(零)+/g, "零").replace(/零(万|亿|元)/g, "$1").replace(/(亿)万|壹(拾)/g, "$1$2").replace(/^元零?|零分/g, "").replace(/元$/g, "元整");
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
