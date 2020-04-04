var app = angular.module('myApp',[]);
app.controller('indexCtrl', function($scope,$http) {

	$scope.team_account = null;
	$scope.team = null;	//队伍信息
    $scope.rankList = null;

	
	
	$scope.setTypeAndInfo = function(){
		let type0 = document.getElementById("category").value;
		let type1 = document.getElementById("matchName").value;
		let type2 = document.getElementById("matchAge").value;
		let type3 = document.getElementById("matchSex").value;
		let info = document.getElementById("searchInfo").value;

		$scope.search(type0,type1,type2,type3,info);
	};

	//根据比赛信息和条件查询相关信息
	$scope.search = function (type0,type1,type2,type3,info) {
	    if(info.length==0) {
            $http({
                method: "GET",
                url: "match",
                params: {
                    type0: type0,
                    type1: type1,
                    type2: type2,
                    type3: type3
                }
            }).then(function successCallback(response) {
                $scope.rankList = response.data;
                console.log($scope.rankList);
            })
        }else{

        }
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
