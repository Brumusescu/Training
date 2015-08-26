'use strict';

angular.module ('Tree')
    .factory('addRootNodeService', function ($http)) {
        return {
            addRoot: function ($nodeId, callback) {
                var result = $http.post ('http://localhost:9090/Tree/addRootNode/{nodeId}');
                result.success (callback);
                result.error (callback);
            }
        }
    }
);