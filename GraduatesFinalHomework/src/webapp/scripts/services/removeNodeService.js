'use strict';

angular.module ('Tree')
    .factory('removeNodeService', function ($http)) {
        return {
            root: function (callback) {
                var result = $http.post ('http://localhost:9090/Tree/removeNode/{id}');
                result.success (callback);
                result.error (callback);
            }
        }
    }
);