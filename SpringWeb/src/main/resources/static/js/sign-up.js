var app = angular.module('myApp',[]);
app.controller('sign-upCtrl', function($scope,$http) {

    $scope.team_account = null;
    $scope.team = null;	//队伍信息

    //提交领队信息
    $('#leaderSubmit').on('click',function () {
        let leaderName = $('#leaderName').val();
        let leaderIdcard = $('#leaderIdcard').val();
        let leaderPhone = $('#leaderPhone').val();
        $http({
            method: "POST",
            url: "helper/leader/"+$scope.team.teamName,
            data: {
                "leaderName": leaderName,
                "leaderIdcard": leaderIdcard,
                "leaderPhone": leaderPhone
            }
        }).then(function successCallback(response) {
            var statusCode = response.status;
            if (statusCode == 200) {
                alert('添加成功');
            }
            else
                alert('添加失败');
        })
    });

    //提交队医信息
    $('#doctorSubmit').on('click',function () {
        let doctorName = $('#doctorName').val();
        let doctorIdcard = $('#doctorIdcard').val();
        let doctorPhone = $('#doctorPhone').val();
        $http({
            method: "POST",
            url: "helper/doctor/"+$scope.team.teamName,
            data: {
                "doctorName": doctorName,
                "doctorIdcard": doctorIdcard,
                "doctorPhone": doctorPhone
            }
        }).then(function successCallback(response) {
            var statusCode = response.status;
            if (statusCode == 200) {
                alert('添加成功');
            }
            else
                alert('添加失败');
        })
    });

    //提交裁判信息
    $('#refereeSubmit').on('click',function () {
        let refereeName = $('#refereeName').val();
        let refereeIdcard = $('#refereeIdcard').val();
        let refereePhone = $('#refereePhone').val();
        $http({
            method: "POST",
            url: "helper/referee/"+$scope.team.teamName,
            data: {
                "refereeName": refereeName,
                "refereeIdcard": refereeIdcard,
                "refereePhone": refereePhone
            }
        }).then(function successCallback(response) {
            var statusCode = response.status;
            if (statusCode == 200) {
                alert('添加成功');
            }
            else
                alert('添加失败');
        })
    });

    //提交裁判信息
    $('#coachSubmit').on('click',function () {
        let coachName = $('#coachName').val();
        let coachIdcard = $('#coachIdcard').val();
        let coachPhone = $('#coachPhone').val();
        let coachSex = $('#coachSex').find('option:selected').val();
        $http({
            method: "POST",
            url: "helper/coach/666",
            data: {
                "coachName": coachName,
                "coachIdcard": coachIdcard,
                "coachPhone": coachPhone,
                "coachSex": coachSex
            }
        }).then(function successCallback(response) {
            var statusCode = response.status;
            if (statusCode == 200) {
                alert('添加成功');
            }
            else
                alert('添加失败');
        })
    });


    //提交运动员信息
    $('#playerSubmit').on('click',function () {
        let playerName = $('#playerName').val();
        let playerIdcard = $('#playerIdcard').val();
        let playerAge = $('#playerAge').val();
        let playerSex = $('#playerSex').find('option:selected').val();
        let playerTeam = '3';
        $http({
            method: "POST",
            url: "player",
            data: {
                "playerId": '007',
                "playerName": playerName,
                "playerIdcard": playerIdcard,
                "playerAge": playerAge,
                "playerSex": playerSex,
                "playerTeam": playerTeam
            }
        }).then(function successCallback(response) {
            var statusCode = response.status;
            if (statusCode == 200) {
                alert('添加成功');
            }
            else
                alert('添加失败');
        })
    });




    //根据队伍初始化主页面
    $scope.initIndex = function(){
        $http({
            method: "GET",
            url: "user/init"
        }).then(function successCallback(response){
            $scope.team_account = response.data.team_account;
            $http({
                method: "GET",
                url: "gym",
                params: {
                    team_account: $scope.team_account
                }
            }).then(function successCallback(response) {
                $scope.team = response.data;
            })
        })
    };



    //点击队伍信息，展示或关闭分类
    $scope.openOrCloseInfo = function(){
        var info = document.getElementById("info");
        if(info.className!="open"){
            document.getElementById("info").setAttribute("class", "open");
            document.getElementById("info_details").style.display="block";
            document.getElementById("arrow").setAttribute("class","arrow open");
        }
        else{
            document.getElementById("info").setAttribute("class", "");
            document.getElementById("info_details").style.display="none";
            document.getElementById("arrow").setAttribute("class","arrow");
        }
    };


    //报名比赛
    $('#matchSubmit').on('click',function () {
        let playerName = $('#playerName').val();
        let matchName = $('#matchName').find('option:selected').val();
        $http({
            method: "POST",
            url: "match",
            data: {
                "teamName": ($scope.team).teamName,
                "playerName": playerName,
                "matchName": matchName
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
            var statusCode = response.status;
            if (statusCode == 200) {
                alert('报名成功');
            }
            else
                alert('报名失败');
        })
    });



    /*--------------------------------
           Section Box Actions
       --------------------------------*/

    $('section.box .actions .box_toggle').on('click', function() {

        let content = $(this).parent().parent().parent().find(".content-body");
        if (content.hasClass("collapsed")) {
            content.removeClass("collapsed").slideDown(10);
            $(this).removeClass("fa-chevron-up").addClass("fa-chevron-down");
        } else {
            content.addClass("collapsed").slideUp(10);
            $(this).removeClass("fa-chevron-down").addClass("fa-chevron-up");
        }
    })
    $('section.box .actions .box_close').on('click', function() {
        let content = $(this).parent().parent().parent().remove();
    });
});
