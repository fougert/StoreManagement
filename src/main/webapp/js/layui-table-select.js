/**
 * 获取选择的对象
 * @param tableId 表的id
 * @param table 表对象
 * @param propName Select 对应的属性名称
 * @param data select回调返回的data
 * @return {object: *, oldValue: *}
 */
function getSelectObject(table, tableId, propName, data) {
    var elem = data.othis.parents('tr');
    var dataindex = elem.attr("data-index");
    var obj = table.cache[tableId][dataindex] ;
    var oldVal = obj[propName] ;
    obj[propName] = data.value ;
    var returnVal = {object:obj,oldValue:oldVal} ;
    return returnVal ;
}

function reloadTable() {
    $(".layui-laypage-btn")[0].click();
}