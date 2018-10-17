var ctx = "";//项目部署的工程名
var OrgList;
var OrgUserEdit;
var OrgUserForm;

//其它组件
var OrgUserOrgTree;
var OrgUserOrg;
var OrgUserRole;

var addTimeDialog;

var OrgUser = {
    URL: {
        inputUI: function () {
            return ctx + "/org/user/input";
        },
        overTimeUI: function () {
            return ctx + "/overtime/to/input";
        },
        listUI: function () {
            return ctx + "/sys/users/ui/list";
        },
        list: function () {
            return ctx + "/org/list";
        },
        save: function () {
            return ctx + "/org/save";
        },
        delete: function (ids) {
            return ctx + "/org/del/" + ids;
        },
        get: function (id) {
            return ctx + "/org/get/" + id;
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
            OrgUser.input.initComponent();
            OrgUser.input.initForm();
        },
        initComponent: function () {
            OrgUserForm = $("#OrgUserForm");
            OrgUserOrg = $("#OrgUserOrg");
            OrgUserRole = $("#OrgUserRole");
        },
        initForm: function () {
            OrgUserForm.form({
                url: OrgUser.URL.save(),
                onSubmit: function () {
                    // do some check
                    // return false to prevent submit;
                },
                success: function (data) {
                    var data = eval('(' + data + ')');
                    if (data.code == 200) {
                        OrgUser.input.close();
                        OrgUser.list.reload();
                    }
                }
            });
        },
        submitForm: function () {
            if(OrgUserForm.form('validate'))
            OrgUserForm.submit();
        },
        close: function () {
            OrgUserEdit.dialog('close');
        }
    },
    list: {
        init: function (ct) {
            ctx = ct;
            OrgUser.list.initComponent();
            OrgUser.list.initOrgTree();
            OrgUser.list.initList();
        },
        initComponent: function () {
            OrgList = $("#OrgList");
            OrgUserEdit = $('#OrgUserEdit');
            OrgUserOrgTree = $('#OrgUserOrgTree');
            addTimeDialog = $('#addTimeDialog');
        },
        initOrgTree: function () {
            OrgUserOrgTree.tree({
                method: 'get',
                url: OrgUser.URL.orgTree(),
                onSelect: function (node) {
                    if (OrgUserOrgTree.tree('isLeaf', node.target)) {
                        OrgList.datagrid({
                            queryParams: {orgId: node.id},
                        });
                    }
                }
            });
        },
        initList: function () {
            OrgList.datagrid({
                url: OrgUser.URL.list(),
                method: 'get',
                pagination: true,
                pageSize: 30,
                toolbar: '#OrgToolbar',//OrgUser.list.toolbar,
                singleSelect: false,
                collapsible: false,
                columns: [[
                    {field: 'ck', checkbox: true},
                    {field: 'id', title: '主键id', hidden: true},
                    {field: 'userNum', title: '用户号码', width: '40%', hidden: false},
                    {field: 'name', title: '名称', width: '40%', hidden: false},
                ]],
                //设置选中事件，清除之前的行选择
                onClickRow: function (index,row) {
                    OrgList.datagrid("unselectAll");
                    OrgList.datagrid("selectRow",index);
                },
            });
        },
        getSelectionsIds: function () {
            var sels = OrgList.datagrid("getSelections");
            var ids = [];
            for (var i in sels) {
                ids.push(sels[i].id);
            }
            ids = ids.join(",");
            return ids;
        },
        //增
        add: function () {
            OrgUserEdit.dialog({
                    href: OrgUser.URL.inputUI(),
                    onLoad: function () {
                        /*OrgUserOrg.combotree({
                            url: OrgUser.URL.orgTree(),
                            method: 'get',
                            panelHeight: 'auto'
                        });
                        OrgUserRole.combobox({
                            url: OrgUser.URL.roleListAll(),
                            method: 'get',
                            panelHeight: 'auto'
                        });*/
                    }
                })
                .dialog("open");
        },
        //改
        edit: function () {
            var sels = OrgList.datagrid("getSelections");
            if (sels.length < 1) {
                $.messager.alert("对话框", "至少选择一行");
                return;
            }

            if (sels.length > 1) {
                $.messager.alert("对话框", "只能选择一行");
                return;
            }

            OrgUserEdit.dialog({
                    href: OrgUser.URL.inputUI(),
                    onLoad: function () {
                        //方案一：使用Form的load去load数据
                        //OrgUserForm.form("load", OrgUser.URL.get(sels[0].id));
                        //方案二：直接使用列表的row数据
                        //OrgUserForm.form("load",sels[0]);
                        //方案三：使用Ajax请求数据
                        $.ajax({
                            type: "GET",
                            url: OrgUser.URL.get(sels[0].id),
                            success: function (data) {
                                if (data.code == 200) {
                                    OrgUserForm.form("load", data.data);
                                    OrgUserOrg.combotree({
                                        url: OrgUser.URL.orgTree(),
                                        method: 'get',
                                        panelHeight: 'auto',
                                        onLoadSuccess: function () {
                                            OrgUserOrg.combotree('setValue', data.data.orgId);
                                        }
                                    });
                                    OrgUserRole.combobox({
                                        url: OrgUser.URL.roleListAll(),
                                        method: 'get',
                                        panelHeight: 'auto',
                                        onLoadSuccess: function () {
                                            OrgUserRole.combobox('setValues', data.data.roleId);
                                        }
                                    });
                                }
                            }
                        });
                    }
                })
                .dialog("open");
        },
        addTime:function(){
            var sels = OrgList.datagrid("getSelections");
            if (sels.length < 1) {
                $.messager.alert("对话框", "至少选择一行");
                return;
            }

            if (sels.length > 1) {
                $.messager.alert("对话框", "只能选择一行");
                return;
            }
            addTimeDialog.dialog({
                href: OrgUser.URL.overTimeUI(),
                onLoad: function () {
                    //方案一：使用Form的load去load数据
                    //OrgUserForm.form("load", OrgUser.URL.get(sels[0].id));
                    //方案二：直接使用列表的row数据
                    //OrgUserForm.form("load",sels[0]);
                    //方案三：使用Ajax请求数据
                    $.ajax({
                        type: "GET",
                        url: OrgUser.URL.addTime(sels[0].id),
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
            var ids = OrgUser.list.getSelectionsIds();
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
                            url: OrgUser.URL.delete(ids),
                            success: function () {
                                OrgUser.list.reload();
                                OrgUser.list.clearSelectionsAndChecked();
                            }
                        });
                    }
                }
            });
        },
        //刷新
        reload: function () {
            OrgList.datagrid("reload");
        },
        clearSelectionsAndChecked:function(){
            OrgList.datagrid("clearChecked");
            OrgList.datagrid("clearSelections");
        },
        //搜索
        search: function () {
            var searchName = [];
            var searchValue = [];
            $("input[lang='searchOrgUser']").each(function (i) {
                searchName[i] = $(this).attr("name");
                searchValue[i] = $(this).val();
            });

            var queryParamsArr = [];
            for (var i = 0; i < searchName.length; i++) {
                queryParamsArr.push(searchName[i] + ":'" + searchValue[i] + "'")
            }
            var queryParams = "{" + queryParamsArr.join(",") + "}";

            OrgList.datagrid({
                queryParams: eval('(' + queryParams + ')'),
                onLoadSuccess: function (data) {
                    //回显搜索内容
                    $("input[lang='searchOrgUser']").each(function (i) {
                        $(this).val(searchValue[i]);
                    });
                }
            });
        },
        //清空
        clear: function () {
            $("input[lang='searchOrgUser']").each(function (i) {
                $(this).val("");
            });
        }
    }
}
