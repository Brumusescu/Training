'use strict';

angular.module ('Tree')
    .factory('getChildrenService', function ($http)) {
        return {
            children: function ($nodeId, callback) {
                var result = $http.post ('http://localhost:9090/Tree/getChildren/{id}');
                result.success ($nodeId, callback);
                result.error (callback);
            }
        }
    }
);