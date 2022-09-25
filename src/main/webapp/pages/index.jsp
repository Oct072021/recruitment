<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <!-- 引入ElementUI样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<div id="app">
    <el-container style="height: 100%">
        <el-header class="header">
            <el-row :gutter="20">
                <el-col :span="1" :offset="2">
                    <el-button type="text" class="header-button">首页</el-button>
                </el-col>
                <el-col :span="1">
                    <el-button type="text" class="header-button">校招</el-button>
                </el-col>
                <el-col :span="1">
                    <el-button type="text" class="header-button">社招</el-button>
                </el-col>
                <el-col :span="1" :offset="15">
                    <el-button type="text" class="header-button">xxx</el-button>
                </el-col>
                <el-col :span="1">
                    <img class="header-img"
                         src="https://mypics.zhaopin.cn/avatar/2022/6/24/70ed1bce-513a-416c-b3f6-f446b8c09d6a.png">
                </el-col>
            </el-row>
        </el-header>
        <el-container style="height: 100%">
            <el-aside class="aside" width="230px">
                <ul>
                    <li>
                        <a href="#"><i class="el-icon-s-home"></i>招聘信息</a>
                    </li>
                    <li>
                        <a href="#"><i class="el-icon-s-opportunity"></i>消息</a>
                    </li>
                </ul>
            </el-aside>
            <el-main>
                <el-row class="main-top">
                    <h5 style="font-size: 35px">招聘信息管理</h5>
                </el-row>
                <el-divider></el-divider>
                <el-row class="main-search">
                    <el-card>
                        <el-form :model="searchForm" ref="searchForm">
                            <label>公司名称</label>
                            <el-input v-model="searchForm.search" style="width: 20%" :clearable="true"></el-input>
                            <label>招聘来源</label>
                            <el-select v-model="searchForm.comFrom" style="width: 130px">
                                <el-option v-for="item in comFrom"
                                           :key="item.value"
                                           :label="item.label"
                                           :value="item.value">
                                </el-option>
                            </el-select>
                            <label>招聘行业</label>
                            <el-select v-model="searchForm.jobValue" style="width: 130px">
                                <el-option v-for="item in jobValue"
                                           :key="item.value"
                                           :label="item.label"
                                           :value="item.value">
                                </el-option>
                            </el-select>
                            <label>公司人数</label>
                            <el-select v-model="searchForm.comNumber" style="width: 130px">
                                <el-option v-for="item in comNumber"
                                           :key="item.value"
                                           :label="item.label"
                                           :value="item.value">
                                </el-option>
                            </el-select>
                            <label>招聘薪酬</label>
                            <el-select v-model="searchForm.salary" style="width: 130px">
                                <el-option v-for="item in salary"
                                           :key="item.value"
                                           :label="item.label"
                                           :value="item.value">
                                </el-option>
                            </el-select>
                            <el-button type="primary" icon="el-icon-search">搜索</el-button>
                        </el-form>
                    </el-card>
                </el-row>
                <el-row>
                    <el-button type="primary" icon="el-icon-plus" style="margin-top: 20px"
                               @click="newDialog = true">新建
                    </el-button>

                    <el-dialog title="新建招聘信息" :visible.sync="newDialog" top="7vh" width="40%">
                        <el-form :model="newCom" ref="newCompany" :rules="comRules">
                            <el-form-item label="公司名称" prop="com_name" :label-width="formLabelWidth">
                                <el-input v-model="newCom.com_name" autocomplete="off" style="width: 500px"></el-input>
                            </el-form-item>

                            <el-form-item label="招聘来源" prop="comFrom" :label-width="formLabelWidth">
                                <el-select v-model="newCom.comFrom" style="width: 500px">
                                    <el-option v-for="item in comFrom"
                                               :key="item.value"
                                               :label="item.label"
                                               :value="item.value">
                                    </el-option>
                                </el-select>
                            </el-form-item>

                            <el-form-item label="所属行业" prop="jobValue" :label-width="formLabelWidth">
                                <el-select v-model="newCom.jobValue" style="width: 500px">
                                    <el-option v-for="item in jobValue"
                                               :key="item.value"
                                               :label="item.label"
                                               :value="item.value">
                                    </el-option>
                                </el-select>
                            </el-form-item>

                            <el-form-item label="公司人数" prop="comNumber" :label-width="formLabelWidth">
                                <el-select v-model="newCom.comNumber" style="width: 500px">
                                    <el-option v-for="item in comNumber"
                                               :key="item.value"
                                               :label="item.label"
                                               :value="item.value">
                                    </el-option>
                                </el-select>
                            </el-form-item>

                            <el-form-item label="招聘薪酬" prop="salary" :label-width="formLabelWidth">
                                <el-select v-model="newCom.salary" style="width: 500px">
                                    <el-option v-for="item in salary"
                                               :key="item.value"
                                               :label="item.label"
                                               :value="item.value">
                                    </el-option>
                                </el-select>
                            </el-form-item>

                            <el-form-item label="负责人" prop="principle" :label-width="formLabelWidth">
                                <el-input v-model="newCom.principle" autocomplete="off" style="width: 500px"></el-input>
                            </el-form-item>

                            <el-form-item label="学历要求" prop="edu" :label-width="formLabelWidth">
                                <el-input v-model="newCom.edu" autocomplete="off" style="width: 500px"></el-input>
                            </el-form-item>

                            <el-form-item label="公司地址" prop="address" :label-width="formLabelWidth">
                                <el-input v-model="newCom.address" autocomplete="off" style="width: 500px"></el-input>
                            </el-form-item>
                        </el-form>

                        <div slot="footer" class="dialog-footer">
                            <el-button @click="newDialog = false">取 消</el-button>
                            <el-button type="primary" @click="newCompany()">确 定</el-button>
                        </div>
                    </el-dialog>
                </el-row>
                <el-row>
                    <el-table :data="jobTable" :stripe="true">
                        <el-table-column prop="id" label="编号"></el-table-column>
                        <el-table-column prop="comName" label="公司名称"></el-table-column>
                        <el-table-column prop="comFrom" label="招聘来源"></el-table-column>
                        <el-table-column prop="jobValue" label="招聘行业"></el-table-column>
                        <el-table-column prop="comNumber" label="公司人数"></el-table-column>
                        <el-table-column prop="salary" label="招聘薪酬"></el-table-column>
                        <el-table-column prop="edu" label="学历要求"></el-table-column>
                        <el-table-column prop="address" label="公司地址"></el-table-column>
                        <el-table-column>
                            <template slot-scope="scope">
                                <el-button type="primary" icon="el-icon-eleme" size="small"
                                           @click="editDialog = true;editCompany(scope.row.id)">修改
                                </el-button>
                                <el-button type="danger" icon="el-icon-delete" size="small" style="margin-left: 0"
                                           @click="deleteCompany(scope.row.id)">删除
                                </el-button>

                                <el-dialog title="新建招聘信息" :visible.sync="editDialog" top="7vh" width="40%">
                                    <el-form :model="editCom" ref="editCompany" :rules="comRules">
                                        <el-input type="hidden" v-model="editCom.com_id" autocomplete="off"></el-input>

                                        <el-form-item label="公司名称" prop="com_name" :label-width="formLabelWidth">
                                            <el-input v-model="editCom.com_name" autocomplete="off"
                                                      style="width: 500px"></el-input>
                                        </el-form-item>

                                        <el-form-item label="招聘来源" prop="comFrom" :label-width="formLabelWidth">
                                            <el-select v-model="editCom.comFrom" style="width: 500px">
                                                <el-option v-for="item in comFrom"
                                                           :key="item.value"
                                                           :label="item.label"
                                                           :value="item.value">
                                                </el-option>
                                            </el-select>
                                        </el-form-item>

                                        <el-form-item label="所属行业" prop="jobValue" :label-width="formLabelWidth">
                                            <el-select v-model="editCom.jobValue" style="width: 500px">
                                                <el-option v-for="item in jobValue"
                                                           :key="item.value"
                                                           :label="item.label"
                                                           :value="item.value">
                                                </el-option>
                                            </el-select>
                                        </el-form-item>

                                        <el-form-item label="公司人数" prop="comNumber" :label-width="formLabelWidth">
                                            <el-select v-model="editCom.comNumber" style="width: 500px">
                                                <el-option v-for="item in comNumber"
                                                           :key="item.value"
                                                           :label="item.label"
                                                           :value="item.value">
                                                </el-option>
                                            </el-select>
                                        </el-form-item>

                                        <el-form-item label="招聘薪酬" prop="salary" :label-width="formLabelWidth">
                                            <el-select v-model="editCom.salary" style="width: 500px">
                                                <el-option v-for="item in salary"
                                                           :key="item.value"
                                                           :label="item.label"
                                                           :value="item.value">
                                                </el-option>
                                            </el-select>
                                        </el-form-item>

                                        <el-form-item label="负责人" prop="principle" :label-width="formLabelWidth">
                                            <el-input v-model="editCom.principle" autocomplete="off"
                                                      style="width: 500px"></el-input>
                                        </el-form-item>

                                        <el-form-item label="学历要求" prop="edu" :label-width="formLabelWidth">
                                            <el-input v-model="editCom.edu" autocomplete="off"
                                                      style="width: 500px"></el-input>
                                        </el-form-item>

                                        <el-form-item label="公司地址" prop="address" :label-width="formLabelWidth">
                                            <el-input v-model="editCom.address" autocomplete="off"
                                                      style="width: 500px"></el-input>
                                        </el-form-item>
                                    </el-form>

                                    <div slot="footer" class="dialog-footer">
                                        <el-button @click="newDialog = false">取 消</el-button>
                                        <el-button type="primary" @click="updateCompany()">确 定</el-button>
                                    </div>
                                </el-dialog>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-row>
            </el-main>
        </el-container>
    </el-container>
</div>


<!-- 引入JS -->
<!-- Vue.js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
<!-- axios.js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/axios.js"></script>
<!-- JQuery.js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<!-- qs.js -->
<script src="https://cdn.bootcdn.net/ajax/libs/qs/6.11.0/qs.js"></script>
<!-- 引入ElementUI组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

<script>
    new Vue({
        el: '#app',
        data() {
            return {
                comFrom: [{
                    value: '智联',
                    label: '智联',
                }, {
                    value: 'BOSS',
                    label: 'BOSS',
                }, {
                    value: '前程无忧',
                    label: '前程无忧',
                }],
                jobValue: [{
                    value: '运维',
                    label: '运维',
                }, {
                    value: '测试',
                    label: '测试',
                }, {
                    value: '开发',
                    label: '开发',
                }],
                comNumber: [{
                    value: '0-20人',
                    label: '0-20人',
                }, {
                    value: '21-99人',
                    label: '21-99人',
                }, {
                    value: '100-499人',
                    label: '100-499人',
                }, {
                    value: '500人以上',
                    label: '500人以上',
                }],
                salary: [{
                    value: '1-3K',
                    label: '1-3K',
                }, {
                    value: '3-5K',
                    label: '3-5K',
                }, {
                    value: '5-10K',
                    label: '5-10K',
                }],
                jobTable: [{
                    id: '1',
                    comName: 'xx科技',
                    comFrom: '智联',
                    jobValue: '开发',
                    comNumber: '20-99人',
                    salary: '5-10K',
                    edu: '本科',
                    address: 'xxxxxx',
                }, {
                    id: '2',
                    comName: 'xx科技',
                    comFrom: '智联',
                    jobValue: '测试',
                    comNumber: '20-99人',
                    salary: '5-9K',
                    edu: '本科',
                    address: 'xxxxxx',
                }, {
                    id: '3',
                    comName: 'xx科技',
                    comFrom: 'BOSS',
                    jobValue: '开发',
                    comNumber: '100-499人',
                    salary: '7-15K',
                    edu: '本科',
                    address: 'xxxxxxx',
                }, {
                    id: '4',
                    comName: 'xx科技',
                    comFrom: '前程无忧',
                    jobValue: '运维',
                    comNumber: '100-499人',
                    salary: '6-12K',
                    edu: '本科',
                    address: 'xxxxxxx',
                }, {
                    id: '5',
                    comName: 'xxx科技',
                    comFrom: '智联',
                    jobValue: '开发',
                    comNumber: '500人以上',
                    salary: '5-10K',
                    edu: '本科',
                    address: 'xxxxxx',
                }, {
                    id: '6',
                    comName: 'xxx科技',
                    comFrom: '智联',
                    jobValue: '运维',
                    comNumber: '500人以上',
                    salary: '5-10K',
                    edu: '本科',
                    address: 'xxxxxx',
                }],
                searchForm: {
                    search: '',
                    comFrom: '',
                    jobValue: '',
                    comNumber: '',
                    salary: '',
                },
                newDialog: false,
                newCom: {
                    com_name: '',
                    comFrom: '',
                    jobValue: '',
                    comNum: '',
                    salary: '',
                    principle: '',
                    edu: '',
                    address: '',
                },
                formLabelWidth: "120px",
                comRules: {
                    comName: [{required: true, message: '公司名称不能为空'}],
                    comFrom: [{required: true, message: '招聘来源不能为空'}],
                    jobValue: [{required: true, message: '招聘行业不能为空'}],
                    comNumber: [{required: true, message: '公司人数不能为空'}],
                    salary: [{required: true, message: '招聘薪酬不能为空'}],
                    principle: [{required: true, message: '负责人不能为空'}],
                    edu: [{required: true, message: '学历要求不能为空'}],
                    address: [{required: true, message: '公司地址不能为空'}],
                },
                editDialog: false,
                editCom: {
                    com_id: '',
                    com_name: '',
                    comFrom: '',
                    jobValue: '',
                    comNum: '',
                    salary: '',
                    principle: '',
                    edu: '',
                    address: '',
                }
            }
        },
        methods: {
            newCompany: function () {
                let that = this
                console.log(that.newCom)
                console.log(Qs.stringify(that.newCom))
                axios.post("<%=basePath%>company/create.action", Qs.stringify(that.newCom))
                    .then(function (response) {
                            console.log(response.date)
                            if (response.date == "OK") {
                                if (response.data == "OK") {
                                    alert("招聘信息创建成功！");
                                    window.location.reload();
                                } else {
                                    alert("招聘信息创建失败！");
                                    window.location.reload();
                                }
                            }
                        }
                    )
            },
            editCompany: function (id) {
                let that=this
                console.log(id)
                axios.get("<%=basePath%>company/getCompanyById.action?id=" + id)
                    .then(function (response) {
                        console.log(response.data)
                        that.editCom.com_id=response.data.com_id
                        that.editCom.com_name=response.data.com_name
                        that.editCom.comFrom=response.data.com_source
                        that.editCom.jobValue=response.data.com_industry
                        that.editCom.comNum=response.data.com_people
                        that.editCom.salary=response.data.com_money
                        that.editCom.principle=response.data.com_principal
                        that.editCom.edu=response.data.com_education
                        that.editCom.address=response.com_address
                    })
            },
            updateCompany:function (id){
                axios.get("<%=basePath%>company/update.action?id"+id)
                .then(function (response){
                    console.log(response.data)
                    if (response.data == "OK") {
                        alert("更新成功！");
                        window.location.reload();
                    } else {
                        alert("更新失败！");
                        window.location.reload();
                    }
                })
            },
            deleteCompany: function (id) {
                console.log(id)
                if (confirm('确认删除吗')) {
                    axios.get("<%=basePath%>company/delete.action?id=" + id)
                        .then(function (response) {
                            console.log(response.data)
                            if (response.data == "OK") {
                                alert("删除成功！");
                                window.location.reload();
                            } else {
                                alert("删除失败！");
                                window.location.reload();
                            }
                        })
                }
            }
        }
    })
</script>
</body>
</html>
