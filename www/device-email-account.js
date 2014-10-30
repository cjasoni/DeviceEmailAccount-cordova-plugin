var DeviceEmailAccountLoader = function (require, exports, module) {
    var exec = require("cordova/exec");
    
    function DeviceEmailAccount () {}
        
    DeviceEmailAccount.prototype.get = function (successFunc, failFunc) {
        exec(successFunc, failFunc, "DeviceEmailAccount","get",[]);
    };
    
    var deviceInformation = new DeviceEmailAccount();
    module.exports = deviceInformation;
};

DeviceEmailAccountLoader(require, exports, module);

cordova.define("cordova/plugin/DeviceEmailAccount", DeviceEmailAccountLoader);



