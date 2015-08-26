'use strict';

angular.module ('Tree')
    .factory('updateParentService', function ($http)) {
        return {
            root: function (callback) {
                var result = $http.post ('http://localhost:9090/Tree/updateParent/{idNode}/{idParent}');
                result.success (callback);
                result.error (callback);
            }
        }
    }
);