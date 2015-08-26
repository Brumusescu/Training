'use strict';

angular.module('Tree')
    .controller('addNodeController', function addNode ($nodeId, $parentId, addNodeService) {
        var id = nodeId;
        var parentId = parentId;
        var childList = {};
        var configuration = {
            json: {
                key: content
            },
        };

        addNodeService.addNewNode(nodeId, parentId, function (data) {
            $scope.message = data;
        });
});
