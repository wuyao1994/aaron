const qs = require('qs')
const Mock = require('mockjs')
const config = require('../utils/config')

const { apiPrefix } = config

const enumRoleType = {
  ADMIN: 'admin',
  DEFAULT: 'guest',
  DEVELOPER: 'developer',
}
const userPermission = {
  DEFAULT: {
    visit: ['1', '2'],
    role: enumRoleType.DEFAULT,
  },
  ADMIN: {
    role: enumRoleType.ADMIN,
  },
  DEVELOPER: {
    role: enumRoleType.DEVELOPER,
  }
}

const adminUsers = [
  {
    id: 0,
    username: 'admin',
    password: 'admin',
    permissions: userPermission.ADMIN,
  },
]

module.exports = {
  [`GET ${apiPrefix}/user`] (res, rep) {

  },
}
