<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <meta http-equiv=Content-Type content="text/html; charset=utf-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login-test.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css">
    <!-- 引入ElementUI样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
</head>
<body>
<div id="app" class="login-box">
    <h1>Login</h1>
    <span class="info"> <%-- 提示信息--%>
        <span v-text="message" v-show="flag"></span>
        ${msg}
    </span>
    <form action="${pageContext.request.contextPath}/loginTest.action" method="post"
          @submit.pervent="isEmpty" ref="export">
        <div class="input-box">
            <i class="iconfont">&#xe7af;</i>
            <select id="user_role" name="user_role" v-model="role">
                <option disabled value="">role</option>
                <option>个人</option>
                <option>企业</option>
                <option>管理员</option>
            </select>
        </div>
        <div class="input-box">
            <i class="iconfont">&#xe7ae;</i>
            <input type="text" id="username" name="username" v-model="username" placeholder="Username">
        </div>
        <div class="input-box">
            <i class="iconfont">&#xe7c9;</i>
            <input type="password" id="password" name="password" v-model="password" placeholder="Password">
        </div>
        <input type="submit" class="button" value="Sign in">
        <br>
        <a href="${pageContext.request.contextPath}/pages/register.jsp" v-html="register"></a>
    </form>
</div>

<!-- 引入ElementUI组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

<script>
    var app = new Vue({
        el: "#app",
        data: {
            role:'',
            username: '',
            password: '',
            flag: false,
            message: '账号或密码不能为空！ ',
            register: '<input class="button" type="button" value="Register"/>',
        },
        methods: {
            isEmpty: function () {
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
