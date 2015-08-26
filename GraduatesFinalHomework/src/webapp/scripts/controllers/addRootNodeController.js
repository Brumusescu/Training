'use strict';

angular.module('Tree')
    .controller('addRootNodeController', function addRootNode($scope, addRootNodeService) {
        var id = nodeId;
        var parentId = "-1";
        var childList = {};
        var configuration = {
            json: {
                key: content
            },
        };

        addRootNodeService.addRoot(nodeId, function (data) {
            $scope.message = data;
        });
});
