'use strict';


angular.module ('Tree')
    .factory('getRootService', function ($http)) {
        return {
            getRoot: function (callback) {
                $http.get ('http://localhost:9090/Tree/getRoot').success (callback);
            }
        }
});