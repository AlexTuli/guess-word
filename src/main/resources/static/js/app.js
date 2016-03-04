(function () {
    var app = angular.module('guessWord', [ ]);
    app.controller('wordController', ['$http', function ($http) {
        var vm = this;
        vm.isSended = false;
        vm.word = '';
        vm.answer = '';
        vm.logs = {};
        vm.makeRequest = function (){
            $http({
                method: "GET",
                url: "/check?word=" + vm.word
            }).then(function successCallback(response){
                vm.answer = response.data;
            }, function errorCallback(response){
                vm.answer = false;
                vm.logs = response.statusText;
            });
            vm.isSended = true;
        };

    }]);
})();