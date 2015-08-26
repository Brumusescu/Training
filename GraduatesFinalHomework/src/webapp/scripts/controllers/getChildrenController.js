'use strict';

angular.module('Tree')
    .controller('getChildrenController', function getChildren($scope, getChildrenService) {
        getChildrenService.children(nodeId, function (data) {
            $scope.message = data;
        });
    });