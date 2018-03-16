import axios from 'axios'
import lodash from 'lodash'
import pathToRegexp from 'path-to-regexp'
import { message } from 'antd'

const fetch  = (options) => {
  let {
    method = 'get',
    data,
    url,
  } = options

  const clonedata = lodash.cloneDeep(data)

  try {
    let domin = ''
    if (url.match(/[a-zA-Z]+:\/\/[^/]*/)) {
      [domain] = url.match(/[a-zA-Z]+:\/\/[^/]*/)
      url = url.slice(domin.length)
    }
    const match = pathToRegexp.parse(url)
    url = pathToRegexp.compile(url)(data)
    url = domin + url
  } catch (e) {
    message.error(e.message)
  }

  switch (method.toLowerCase()) {
    case 'get':
      return axios.get(
        url,
        {
          params:clonedata,
        }
      )
    case 'post':
      return axios.post(
        url,
        clonedata,
      )
    case 'delete':
      return axios.delete(
        url,
        {
          data: clonedata

        },
      )
    case 'put':
      return axios.put(
        url,
        clonedata,
      )
    case 'patch':
      return axios.patch(
        url,
        clonedata
      )
    default:
      return axios(options)
  }
}

export default function request (options) {
  return fetch(options).then((response) => {
    const { statusText, status } = response
    let data = response.data
    if (data instanceof Array) {
      data = {
        list: data,
      }
    }
    return Promise.resolve({
      success: true,
      message: statusText,
      statusCode: status,
      ...data,
    })
  }).catch((error) => {
    const { response } = error
    let msg
    let statusCode
    if (response && response instanceof Object) {
      const { data, statusText } = response
      statusCode = response.status
      msg = data.message || statusText
    } else {
      statusCode = 600
      msg = error.message || 'Network error'
    }
  })
}
