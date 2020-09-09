import request from '@/utils/request'

// 查询销售信息列表
export function listSell(query) {
  return request({
    url: '/system/sell/list',
    method: 'get',
    params: query
  })
}

// 查询销售信息详细
export function getSell(sellId) {
  return request({
    url: '/system/sell/' + sellId,
    method: 'get'
  })
}

// 新增销售信息
export function addSell(data) {
  return request({
    url: '/system/sell',
    method: 'post',
    data: data
  })
}

// 修改销售信息
export function updateSell(data) {
  return request({
    url: '/system/sell',
    method: 'put',
    data: data
  })
}

// 删除销售信息
export function delSell(sellId) {
  return request({
    url: '/system/sell/' + sellId,
    method: 'delete'
  })
}

// 导出销售信息
export function exportSell(query) {
  return request({
    url: '/system/sell/export',
    method: 'get',
    params: query
  })
}