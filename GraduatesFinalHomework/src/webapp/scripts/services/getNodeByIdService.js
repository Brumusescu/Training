'use strict';

angular.module ('Tree')
    .factory('getNodeByIdService', function ($http)) {
        return {
            nodeById: function ($nodeId, callback) {
                $http.get ('http://localhost:9090/Tree/getNodeById/{id}').success (callback);
            }
        }
});