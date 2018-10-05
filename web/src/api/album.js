import request from '@/util/paRequest'
import qs from 'qs'

/**
 * 查询相册
 */
export function query (params) {
  return request({
    url: '/album',
    method: 'get',
    data: qs.stringify(params)
  })
}

/**
 * 新增相册
 */
export function createAlbum (model) {
  return request({
    url: '/album',
    method: 'post',
    data: JSON.stringify(model)
  })
}
