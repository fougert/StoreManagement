
var RespCode = {
    SUCCESS:200,
    FAIL:0,
    TOKEN_TIMEOUT:1,
}

function ajaxPut(url, param, callback, errorCallback) {
    ajaxQuery(url, "PUT", param, callback, errorCallback) ;
}

function ajaxPost(url, param, callback, errorCallback) {
    ajaxQuery(url, "POST", param, callback, errorCallback) ;
}
function ajaxDelete(url, param, callback, errorCallback) {
    ajaxQuery(url, "DELETE", param, callback, errorCallback) ;
}

/**
 * 请求后台的ajax方法
 * @param url 请求的url
 * @param method 请求的方法
 * @param param 请求的数据 序列化好的对象
 * @param callback 成功的回调
 * @param errorCallback 错误的回调
 */
function ajaxQuery(url,method,param,callback, errorCallback){

    if('string' !== typeof(param)){//不是字符串类型需要转化为地址参数
        var p = "" ;
        for (var key in param){
            if(p !== ""){
                p+="&" ;
            }
            p += key;
            p += "=" + param[key] ;
        }
        param = p ;
    }

    $.ajax({
        url:url,
        data:param,
        dataType:"JSON",
        type:method,
        success:function (data) {
            switch (data.code){
                case RespCode.SUCCESS:
                    callback(data.data) ;
                    break;
                case RespCode.TOKEN_TIMEOUT:
                    //token过期重新登录
                    window.location.href="/login.html" ;
                    break;
                case RespCode.FAIL:
                    if(errorCallback != null){
                        errorCallback(data.data) ;
                    }
                    showError(data.msg) ;
                    break;
            }
        },
        error:function (data) {
            if(errorCallback != null){
                errorCallback(data) ;
            }
            showError("网络错误")
        }
    });
}


function showError(msg) {
    layer.alert(msg, {icon: 2});
}

function showSuccess(msg) {
    layer.alert(msg, {icon: 6});
}

function showToast(msg) {
    layer.msg(msg);
}