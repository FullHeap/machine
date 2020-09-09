import request from '@/utils/request'

// 查询产品信息列表
export function listProduction(query) {
  return request({
    url: '/system/production/list',
    method: 'get',
    params: query
  })
}

// 查询产品信息详细
export function getProduction(productId) {
  return request({
    url: '/system/production/' + productId,
    method: 'get'
  })
}

// 新增产品信息
export function addProduction(data) {
  return request({
    url: '/system/production',
    method: 'post',
    data: data
  })
}

// 修改产品信息
export function updateProduction(data) {
  return request({
    url: '/system/production',
    method: 'put',
    data: data
  })
}

// 删除产品信息
export function delProduction(productId) {
  return request({
    url: '/system/production/' + productId,
    method: 'delete'
  })
}

// 导出产品信息
export function exportProduction(query) {
  return request({
    url: '/system/production/export',
    method: 'get',
    params: query
  })
}