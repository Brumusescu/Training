'use strict';

angular.module ('Tree')
    .factory('addNodeService', function ($http)) {
        return {
            addNewNode: function ($nodeId, $parentId, callback) {
                var result = $http.post ('http://localhost:9090/Tree/addNode/{nodeId}/{parentId}');
                result.success (callback);
                result.error (callback);
            }
        }
    }
);