'use strict';

angular.module ('Tree')
    .factory('fetchNodeByStrategyService', function ($http)) {
        return {
            root: function (callback) {
                var result = $http.post ('http://localhost:9090/Tree/fetchNodeByStrategy/{id}/{strategy}');
                result.success (callback);
                result.error (callback);
            }
        }
    }
);