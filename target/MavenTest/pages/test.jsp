<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css">
</head>
<body>
    <div class="login-box">
        <h1>Login</h1>
        <div class="input-box">
            <i class="iconfont">&#xe666;</i>
            <input type="text" placeholder="Username">
        </div>
        <div class="input-box">
            <i class="iconfont">&#xe641;</i>
            <input type="password" placeholder="Password">
        </div>
        <button>Sign in</button>
        <br/>
        <button>Register</button>
    </div>

    <div id="app">
        <input type="text" v-model="msg">
    </div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
<script>
    var app=new Vue({
        el:"#app",
        data:{
            msg:'6666'
        }
    })
</script>
</body>
</html>
