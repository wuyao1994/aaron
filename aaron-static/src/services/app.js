import { request, config } from '../utils'

const { api } = config
const { user, userLogout } = api

export async function query (params) {
  return request({
    url: user.replace('/:id', ''),
    method: 'get',
    data: params,
  })
}
export async function logout (params) {
  return request({
    url: userLogout,
    method: 'get',
    data: params,
  })
}
