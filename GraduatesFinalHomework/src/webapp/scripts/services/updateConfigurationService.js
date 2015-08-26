'use strict';

angular.module ('Tree')
    .factory('updateConfigurationService', function ($http)) {
        return {
            root: function (callback) {
                var result = $http.post ('http://localhost:9090/Tree/updateConfiguration/{id}');
                result.success (callback);
                result.error (callback);
            }
        }
    }
);