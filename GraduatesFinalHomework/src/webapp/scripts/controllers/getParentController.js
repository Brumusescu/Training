'use strict';

angular.module('Tree')
    .controller('getParentController', function getParent($scope, getParentService) {
        getParentService.parent(nodeId, function (data) {
            $scope.message = data;
        });
    });