
var app = angular.module('myApp',[]);
app.controller('teamPlayerCtrl', function($scope,$http) {

    $scope.playerList = null;
    $scope.team=null;
    $scope.team_account=null;



    $scope.setTypeAndInfo = function(){
        let type = document.getElementById("searchType").value;
        let info = document.getElementById("searchInfo").value;
        $scope.searchPlayers(type,info);
    };


    //根据条件筛选运动员
    $scope.searchPlayers = function(type,info){
        $http({
            method: "GET",
            url: "player/"+$scope.team.teamName,
            params: {
                type: type,
                info: info
            }
        }).then(function successCallback(response){
            $scope.playerList = response.data;
        })
    };


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
});

