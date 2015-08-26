'use strict';

angular.module ('Tree')
    .factory('updateConfigurationForParentNodeService', function ($http)) {
        return {
            root: function (callback) {
                var result = $http.post ('http://localhost:9090/Tree/updateConfigurationForParentNode/{parentId}');
                result.success (callback);
                result.error (callback);
            }
        }
    }
);