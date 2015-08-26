'use strict';

angular.module ('Tree')
    .factory('getParentService', function ($http)) {
        return {
            parent: function ($parentId, callback) {
                var result = $http.post ('http://localhost:9090/Tree/getParent/{id}');
                result.success (callback);
                result.error (callback);
            }
        }
    }
);