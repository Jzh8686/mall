# mall
a simple shopping mall.use springboot+thmleaf+druid
function ajaxPost(url, obj, fn) {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", url);

    // xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");

    xhr.send(obj);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            fn(xhr.responseText);
        }
    }
}

function dateToString(date) {
    var year = date.getFullYear();
    var month = (date.getMonth() + 1).toString();
    var day = (date.getDate()).toString();
    if (month.length == 1) {
        month = "0" + month;
    }
    if (day.length == 1) {
        day = "0" + day;
    }
    var hours = date.getHours().toString();
    if (hours.length == 1) {
        hours = "0" + hours;
    }
    var mintus = date.getMinutes().toString();
    if (mintus.length == 1) {
        mintus = "0" + mintus;
    }
    var second = date.getSeconds().toString();
    if (second.length == 1) {
        second = "0" + second;
    }
    var dateTime = year + "-" + month + "-" + day + " " + hours + ":" + mintus + ":" + second;
    return dateTime;
}

function sleep(time) {
    return new Promise((resolve) => setTimeout(resolve, time));
}



async function start() {
    var id = '48235701';
    var userIdList = id.split(',');

    for (var i = 0; i < userIdList.length; i++) {

        var userId = userIdList[i];
        var searchTarde = new FormData();
        searchTarde.append("userId", userId);
        searchTarde.append("listingId", '');
        searchTarde.append("bizType", '');
        searchTarde.append("status", '');

        var endDate = dateToString(new Date())
        var time = (new Date).getTime() - 24 * 60 * 60 * 1000 * 180;
        var startDate = dateToString(new Date(time));
        searchTarde.append("startTime", startDate);
        searchTarde.append("endTime", endDate);
        searchTarde.append("page", 1);
        searchTarde.append("rows", 10);
        ajaxPost('/follow/getTradeInfoList', searchTarde, function (res) {
            var resObj = JSON.parse(res);

            if (resObj.rows.length === 0) {
                
            } else {
                console.log('用户id:' + userId + '有以下还款记录');
                for (var j = 0; j < resObj.rows.length; j++) {
                    var record = resObj.rows[i];
                    console.log(
                        '交易流水号:' + record.bizUnikey
                            + '用户id:' + record.userId
                            + 'listingId:' + record.listingId
                            + '业务类型：还款'
                            + '金额:' + record.amount
                            + '银行卡:' + record.bankCardNo
                            + '交易类型:' + record.tradeTypeName
                            + '交易详情:' + record.tradeDesc
                            + '交易状态:' + record.status === 1 ? '成功' : '失败'
                            + '原因:' + record.failReason
                            + '创建时间:' + record.tradeTime
                            + '更新时间:' + record.lastTradeChangeTime
                    )
                }
            }
        })
        console.log('---------------------------------------------------------------------------------------')
        await sleep(100);
    }
}
start()
