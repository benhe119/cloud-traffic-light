var lightApp = angular.module('lightApp', []);

lightApp.controller('LightCtrl', function ($scope, $http, $interval) {
    $scope.lights = {
        'red': true,
        'yellow': true,
        'green': false
    };

    $scope.getLightState = function () {
        $http.get('/light')
            .then(function (response) {
                    $scope.lights = response.data;
                }
            )
    };

    $scope.nextLightState = function () {
        $http.put('/light/next')
            .then(function (response) {
                    $scope.getLightState();
                }
            )
    };

    $scope.getLightState();

    $interval($scope.getLightState, 1000);
});