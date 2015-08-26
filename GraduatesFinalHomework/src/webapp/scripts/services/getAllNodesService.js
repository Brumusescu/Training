'use strict';

angular.module ('Tree')
    .factory('getAllNodesService', function ($http)) {
        return {
            allNodes: function (callback) {
                var result = $http.post ('http://localhost:9090/Tree/getAllNodes').success (callback);
            }
        }
    }
);