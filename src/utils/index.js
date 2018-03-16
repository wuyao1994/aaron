import lodash from 'lodash'
import config from './config'

/**
 * 数组内查询
 * @param array
 * @param key
 * @param keyAlias
 * @returns {null}
 */
const queryArray = (array, key, keyAlias = 'key') => {
  if (!(array instanceof Array)) {
    return null
  }
  const item = array.filter(_ => _[keyAlias] === key);
  if (item.length) {
    return item[0]
  }
  return null
}

const arryaToTree = (array, id = 'id', bpid = 'bpid', children = 'children') => {
  let data = lodash.cloneDeep(array)
  let result = []
  let hash = {}
  data.forEach((index) => {
    hash[data[index][id]] = data[index]
  })
  data.forEach((item) => {
    let hashVP = hash[item[bpid]]
    if (hashVP) {
      !(hashVP[children]) && (hashVP[children] = {})
      hashVP[children].push(item)
    } else {
      result.push(item)
    }
  })

  return result
}

module.exports = {
  queryArray,
  arryaToTree,
  config,
}
