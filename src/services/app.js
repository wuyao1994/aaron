import { request, config } from '../utils'

const { api } = config
const { user } = api

export async function query (params) {
  return request({
    url: user.replace('/:id', ''),
    method: 'get',
    data: params,
  })
}
