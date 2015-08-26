'use strict';

angular.module('Tree')
    .controller('getRootController', function getRoot($scope, getRootService) {
        getRootService.getRoot(function (data) {
            $scope.message = data;
        });
});
