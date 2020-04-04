
var app = angular.module('myApp',[]);
app.controller('teamHelperCtrl', function($scope,$http) {

    $scope.team_account = null;
    $scope.team = null;

    $scope.coach = null;
    $scope.referee = null;
    $scope.leader = null;
    $scope.doctor = null;

    //从数据库中获取随队人员的信息
    $scope.initTeamHelper = function () {
        $http({
            method: "GET",
            url: "/helper/leader/"+$scope.team.teamName
        }).then(function successCallBack(response) {
            $scope.leader = response.data;
        });

        $http({
            method: "GET",
            url: "/helper/coach/"+$scope.team.teamName
        }).then(function successCallBack(response) {
            $scope.coach = response.data;
        });

        $http({
            method: "GET",
            url: "/helper/referee/"+$scope.team.teamName
        }).then(function successCallBack(response) {
            $scope.referee = response.data;
        });

        $http({
            method: "GET",
            url: "/helper/doctor/"+$scope.team.teamName
        }).then(function successCallBack(response) {
            $scope.doctor = response.data;
        });
    }



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
                $scope.initTeamHelper();
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
});

