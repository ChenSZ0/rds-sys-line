var ctx = "";//项目部署的工程名
var InvoiceList;
var InvoiceEdit;
var InvoiceForm;

//其它组件
var OrgUserOrgTree;
var OrgUserOrg;
var OrgUserRole;

var addTimeDialog;




    var Invoice = {
    URL: {
        inputUI: function () {
            return ctx + "/invoice/toView/input";
        },
        overTimeUI: function () {
            return ctx + "/overtime/to/input";
        },
        listUI: function () {
            return ctx + "/sys/users/ui/list";
        },
        list: function () {
            return ctx + "/invoice/list";
        },
        save: function () {
            return ctx + "/invoice/save";
        },
        delete: function (ids) {
            return ctx + "/invoice/del/" + ids;
        },
        get: function (id) {
            return ctx + "/invoice/get/" + id;
        },
        addTime: function (id) {
            return ctx + "/overtime/getOverTime/" + id;
        },
        orgTree: function () {
            return ctx + "/sys/orgs/tree";
        },
        roleListAll: function () {
            return ctx + "/sys/roles/all";
        },
    },
    input: {
        init: function (ct) {
            ctx = ct;
            Invoice.input.initComponent();
            Invoice.input.initForm();
        },
        initComponent: function () {
            InvoiceForm = $("#InvoiceForm");
           // InvoiceOrg = $("#InvoiceOrg");
            //InvoiceRole = $("#InvoiceRole");
        },
        initForm: function () {
            InvoiceForm.form({
                url: Invoice.URL.save(),
                onSubmit: function () {
                    // do some check
                    // return false to prevent submit;
                },
                success: function (data) {
                    var data = eval('(' + data + ')');
                    if (data.code == 200) {
                        Invoice.input.close();
                        Invoice.list.reload();
                    }
                }
            });
        },
        submitForm: function () {
            if(InvoiceForm.form('validate'))
                InvoiceForm.submit();
        },
        close: function () {
            InvoiceEdit.dialog('close');
        }
    },
    list: {
        init: function (ct) {
            ctx = ct;
            Invoice.list.initComponent();
            // Invoice.list.initOrgTree();
            Invoice.list.initList();
        },
        initComponent: function () {
            InvoiceList = $("#InvoiceList");
            InvoiceEdit = $('#InvoiceEdit');
            // InvoiceOrgTree = $('#InvoiceOrgTree');
            // addTimeDialog = $('#addTimeDialog');
        },
       /* initOrgTree: function () {
            InvoiceOrgTree.tree({
                method: 'get',
                url: Invoice.URL.orgTree(),
                onSelect: function (node) {
                    if (InvoiceOrgTree.tree('isLeaf', node.target)) {
                        InvoiceList.datagrid({
                            queryParams: {orgId: node.id},
                        });
                    }
                }
            });
        },*/
        initList: function () {
            InvoiceList.datagrid({
                url: Invoice.URL.list(),
                method: 'get',
                pagination: true,
                pageSize: 30,
                toolbar: '#InvoiceToolbar',//Invoice.list.toolbar,
                singleSelect: false,
                collapsible: false,
                columns: [[
                    {field: 'ck', checkbox: true},
                    {field: 'id', title: '主键id', hidden: true},
                    {field: 'number', title: '票据编号', hidden: false},
                    {field: 'ticketName', title: '交票人', hidden: false},
                    {field: 'cardName', title: '持卡人', hidden: false},
                    {field: 'cardNum', title: '卡号', hidden: false},
                    {field: 'consumeTime', title: '消费时间', hidden: false,formatter: function (value) {
                            return new Date(value).format("yyyy-MM-dd hh:mm:ss");
                        }},
                    {field: 'cardMoney', title: '公务卡金额', hidden: false},
                    {field: 'cashMoney', title: '现金金额', hidden: false},
                    {field: 'cashSubsidy', title: '现金补助费', hidden: false},
                    {field: 'responsibleName', title: '出差补助费负责人', hidden: false},
                    {field: 'invoiceType', title: '发票类型', hidden: false},
                    {field: 'month', title: '计算月份', hidden: false},
                    {field: 'summary', title: '摘要', hidden: false},
                    {field: 'refund', title: '退票', hidden: false},
                    {field: 'receivingTime', title: '到帐时间', hidden: false,formatter: function (value) {
                            return new Date(value).format("yyyy-MM-dd hh:mm:ss");
                        }},
                    {field: 'receivedTime', title: '收票时间', hidden: false,formatter: function (value) {
                            return new Date(value).format("yyyy-MM-dd hh:mm:ss");
                        }},
                    {field: 'accountTime', title: '报账时间', hidden: false,formatter: function (value) {
                            return new Date(value).format("yyyy-MM-dd hh:mm:ss");
                        }},
                    {field: 'purpose', title: '开支用途', hidden: false},
                    {field: 'remark', title: '备注', hidden: false},

                ]],
                //设置选中事件，清除之前的行选择
                onClickRow: function (index,row) {
                    InvoiceList.datagrid("unselectAll");
                    InvoiceList.datagrid("selectRow",index);
                },
            });
        },
        getSelectionsIds: function () {
            var sels = InvoiceList.datagrid("getSelections");
            var ids = [];
            for (var i in sels) {
                ids.push(sels[i].id);
            }
            ids = ids.join(",");
            return ids;
        },
        //增
        add: function () {
            InvoiceEdit.dialog({
                    href: Invoice.URL.inputUI(),
                    onLoad: function () {
                        /*InvoiceOrg.combotree({
                            url: Invoice.URL.orgTree(),
                            method: 'get',
                            panelHeight: 'auto'
                        });
                        InvoiceRole.combobox({
                            url: Invoice.URL.roleListAll(),
                            method: 'get',
                            panelHeight: 'auto'
                        });*/
                    }
                })
                .dialog("open");
        },
        //改
        edit: function () {
            var sels = InvoiceList.datagrid("getSelections");
            if (sels.length < 1) {
                $.messager.alert("对话框", "至少选择一行");
                return;
            }

            if (sels.length > 1) {
                $.messager.alert("对话框", "只能选择一行");
                return;
            }

            InvoiceEdit.dialog({
                    href: Invoice.URL.inputUI(),
                    onLoad: function () {
                        //方案一：使用Form的load去load数据
                        //InvoiceForm.form("load", Invoice.URL.get(sels[0].id));
                        //方案二：直接使用列表的row数据
                        //InvoiceForm.form("load",sels[0]);
                        //方案三：使用Ajax请求数据
                        $.ajax({
                            type: "GET",
                            url: Invoice.URL.get(sels[0].id),
                            success: function (data) {
                                if (data.code == 200) {

                                    $('#receivingTime').datetimebox('setValue', new Date(data.data.receivingTime).format("yyyy-MM-dd hh:mm:ss"));
                                    $('#receivedTime').datetimebox('setValue', new Date(data.data.receivedTime).format("yyyy-MM-dd hh:mm:ss"));
                                    $('#consumeTime').datetimebox('setValue', new Date(data.data.consumeTime).format("yyyy-MM-dd hh:mm:ss"));
                                    $('#accountTime').datetimebox('setValue', new Date(data.data.accountTime).format("yyyy-MM-dd hh:mm:ss"));

                                    $("#InvoiceId").val(data.data.id);
                                    $("#number").textbox("setValue",data.data.number);
                                    $("#ticketName").textbox("setValue",data.data.ticketName);
                                    $("#cardName").textbox("setValue",data.data.cardName);
                                    $("#cardNum").textbox("setValue",data.data.cardNum);
                                    $("#cardMoney").textbox("setValue",data.data.cardMoney);
                                    $("#cashMoney").textbox("setValue",data.data.cashMoney);
                                    $("#cashSubsidy").textbox("setValue",data.data.cashSubsidy);
                                    $("#responsibleName").textbox("setValue",data.data.responsibleName);
                                    $("#invoiceType").textbox("setValue",data.data.invoiceType);
                                    $("#month").textbox("setValue",data.data.month);
                                    $("#summary").textbox("setValue",data.data.summary);
                                    $("#refund").textbox("setValue",data.data.refund);
                                    $("#purpose").textbox("setValue",data.data.purpose);
                                    $("#remark").textbox("setValue",data.data.remark);
                                }
                            }
                        });
                    }
                })
                .dialog("open");
        },
        addTime:function(){
            var sels = InvoiceList.datagrid("getSelections");
            if (sels.length < 1) {
                $.messager.alert("对话框", "至少选择一行");
                return;
            }

            if (sels.length > 1) {
                $.messager.alert("对话框", "只能选择一行");
                return;
            }
            addTimeDialog.dialog({
                href: Invoice.URL.overTimeUI(),
                onLoad: function () {
                    //方案一：使用Form的load去load数据
                    //InvoiceForm.form("load", Invoice.URL.get(sels[0].id));
                    //方案二：直接使用列表的row数据
                    //InvoiceForm.form("load",sels[0]);
                    //方案三：使用Ajax请求数据
                    $.ajax({
                        type: "GET",
                        url: Invoice.URL.addTime(sels[0].id),
                        success: function (data) {
                            if (data.code == 200) {
                                $('#overTimeForm').form("load", data.data);
                            }
                        }
                    });
                }
            }).dialog("open");
        },
        //删
        delete: function () {
            var ids = Invoice.list.getSelectionsIds();
            if (ids.length == 0) {
                $.messager.alert("对话框", "至少选择一行");
                return;
            }

            $.messager.confirm({
                title: '确认提示框',
                msg: '你确定要删除吗？',
                fn: function (r) {
                    if (r) {
                        $.ajax({
                            type: "DELETE",
                            url: Invoice.URL.delete(ids),
                            success: function () {
                                Invoice.list.reload();
                                Invoice.list.clearSelectionsAndChecked();
                            }
                        });
                    }
                }
            });
        },
        //刷新
        reload: function () {
            InvoiceList.datagrid("reload");
        },
        clearSelectionsAndChecked:function(){
            InvoiceList.datagrid("clearChecked");
            InvoiceList.datagrid("clearSelections");
        },
        //搜索
        search: function () {
            var searchName = [];
            var searchValue = [];
            $("input[lang='searchInvoice']").each(function (i) {
                searchName[i] = $(this).attr("name");
                searchValue[i] = $(this).val();
            });

            var queryParamsArr = [];
            for (var i = 0; i < searchName.length; i++) {
                queryParamsArr.push(searchName[i] + ":'" + searchValue[i] + "'")
            }
            var queryParams = "{" + queryParamsArr.join(",") + "}";

            InvoiceList.datagrid({
                queryParams: eval('(' + queryParams + ')'),
                onLoadSuccess: function (data) {
                    //回显搜索内容
                    $("input[lang='searchInvoice']").each(function (i) {
                        $(this).val(searchValue[i]);
                    });
                }
            });
        },
        //清空
        clear: function () {
            $("input[lang='searchInvoice']").each(function (i) {
                $(this).val("");
            });
        }
    }
}
