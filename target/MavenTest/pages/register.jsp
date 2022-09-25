<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>登录页面</title>
    <meta http-equiv=Content-Type content="text/html; charset=utf-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login-test.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css">
</head>
<body>
<div id="app" class="login-box">
    <h1>Register</h1>
    <span class="info"> <%-- 提示信息--%>
        <span v-text="message" v-show="flag"></span>
        ${msg}
    </span>
    <form action="${pageContext.request.contextPath}/register.action" method="post"
          @submit.prevent="isRight" ref="export">
        <div class="input-box">
            <i class="iconfont">&#xe7af;</i>
            <select id="user_role" name="user_role" v-model="selected">
                <option disabled value="">role</option>
                <option>个人</option>
                <option>企业</option>
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
        <div class="input-box">
            <i class="iconfont">&#xe7c9;</i>
            <input type="password" id="password2" name="password2" v-model="password2" placeholder="Re-password">
        </div>
        <input type="submit" class="button" value="Register">
    </form>
</div>

<script>
    var app = new Vue({
        el: "#app",
        data: {
            selected: '',
            username: '',
            password: '',
            password2: '',
            flag: false,
            message: '',
        },
        methods: {
            isRight: function () {
                if (this.selected == '') {
                    this.flag = true;
                    this.message = '角色不能为空！';
                    return false;
                } else {
                    if (this.username == '' || this.password == '') {
                        this.flag = true;
                        this.message = '账号或密码不能为空！ ';
                        return false;
                    } else {
                        if (this.password != this.password2) {
                            this.flag = true;
                            this.message = '两次输入的密码不相等！ ';
                            return false;
                        } else {
                            this.$refs.export.submit();
                        }
                    }
                }
            },

        },

    })
</script>
</body>
</html>
