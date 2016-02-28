var lightApp = angular.module('lightApp', []);

lightApp.controller('LightCtrl', function ($scope) {
    $scope.lights = {
        'red' : true,
        'yellow' : true,
        'green' : false
    };

    $scope.phones = [
        {'name': 'Nexus S',
            'snippet': 'Fast just got faster with Nexus S.'},
        {'name': 'Motorola XOOM™ with Wi-Fi',
            'snippet': 'The Next, Next Generation tablet.'},
        {'name': 'MOTOROLA XOOM™',
            'snippet': 'The Next, Next Generation tablet.'}
    ];
});