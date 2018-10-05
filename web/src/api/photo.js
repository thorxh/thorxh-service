import request from '@/util/paRequest'

/**
 * 查询图片
 */
export function query (params) {
  return request({
    url: '/photo',
    method: 'get',
    params
  })
}
