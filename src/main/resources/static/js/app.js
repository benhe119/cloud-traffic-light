var lightApp = angular.module('lightApp', []);

lightApp.controller('LightCtrl', function ($scope, $http, $interval) {
    $scope.lights = {
        'red' : true,
        'yellow' : true,
        'green' : false
    };

    $scope.getLightState = function() {
        $http.get('/light')
            .then(function(response) {
                $scope.lights = response.data;
            }
        )
    };

    $scope.getLightState();

    $interval($scope.getLightState, 1000);
});