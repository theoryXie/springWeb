
var app = angular.module('myApp',[]);
app.controller('singleCtrl', function($scope,$http) {


    $scope.queryInfo = null;
    $scope.team_account = null;
    $scope.team = null;




    $scope.query = function(){
        let playerName = $('#playerName').val();
        let type = $('#searchType').find('option:selected').val();

        $http({
            method: 'GET',
            url: 'player',
            params: {
                type: type,
                playerName: playerName
            }
        }).then(function successCallback(response) {
            $scope.queryInfo = response.data;
            angular.forEach($scope.queryInfo, function (info) {
               info[1] = parseInt(info[1]);
            });
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

