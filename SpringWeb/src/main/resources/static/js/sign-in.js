var app = angular.module('myApp', []);
app.controller('loginCtrl', function ($scope, $http) {

    //前往主页面
    $scope.goIndex = function (msg) {
        var hre = 'index.html?msg=' + angular.toJson(msg);//传递对象：先将对象转成字符串（序列化）
        location.href = hre;
    };



    //登陆
    $('#wp-submit').on('click', function () {

        let user = $('#user_login').val();
        let pass = $('#user_pass').val();

        if (user.length == 0 || pass.length == 0) {
            alert("请输入用户名和密码！");
            return;
        }
        $http({
            method: 'POST',
            url: "/user/login",
            data: {
                user: user,
                password: pass
            },
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function (obj) {
                var str = [];
                for (var s in obj) {
                    str.push(encodeURIComponent(s) + "=" + encodeURIComponent(obj[s]));
                }
                return str.join("&");
            }
        }).then(function successCallback(response) {
            if (response.data) {                           //登陆成功，跳转页面、传递队伍信息
                location.href = "index.html";
            }
            else                                        //登陆失败
                alert("用户名或密码错误");
        })
    });

});
