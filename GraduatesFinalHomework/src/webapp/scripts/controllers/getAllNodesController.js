'use strict';

angular.module('Tree')
    .controller('getAllNodesController', function getAllNodes($scope, getAllNodesService) {
        getAllNodesService.allNodes(function (data) {
            $scope.message = data;
        });
    });