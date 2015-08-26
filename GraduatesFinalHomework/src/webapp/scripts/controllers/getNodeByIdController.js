'use strict';

angular.module('Tree')
    .controller('getNodeByIdController', function getNodeById($scope, getNodeByIdService) {
        getNodeByIdService.nodeById(nodeId, function (data) {
            $scope.message = data;
        });
    });