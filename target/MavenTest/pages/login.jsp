<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <meta http-equiv=Content-Type content="text/html; charset=utf-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<div id="app" class="login-box">
    <fieldset>
        <legend>
            <h2>欢迎使用招聘信息管理系统</h2>
        </legend>
        <span class="info"> <%-- 提示信息--%>
            <span v-text="message" v-show="flag"></span>
            ${msg}
        </span>
        <form action="${pageContext.request.contextPath}/login.action" method="post"
              @submit.prevent="isEmpty" ref="export">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
            <br/> 账&nbsp;号：<input id="username" name="username" v-model="username" type="text"/>
            <br/>
            <br/> 密&nbsp;码：<input id="password" name="password" v-model="password" type="password"/> <br/>
            <br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <center>
                <input type="submit" value="登录"/>
                <a href="${pageContext.request.contextPath}/pages/register.jsp" v-html="register"></a>
            </center>
        </form>
    </fieldset>
</div>

<script>
    var app = new Vue({
        el: "#app",
        data: {
            username: '',
            password: '',
            flag: false,
            message: '账号或密码不能为空！ ',
            register:'<input type="button" value="注册"/>',
        },
        methods: {
            isEmpty: function () {
                console.log(this.username);
                console.log(this.password);
                if (this.username == '' || this.password == '') {
                    this.flag = true;
                    return false;
                } else {
                    this.$refs.export.submit();
                }
            },
        },

    })
</script>
</body>
</html>
