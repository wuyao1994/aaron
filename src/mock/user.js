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
  [`POST ${apiPrefix}/user/login`] (req, res) {
    const { username, password } = req.body
    const user = adminUsers.filter(_ => _.username === username)

    if (user.length > 0 && user[0].password === password) {
      const now = new Date()
      now.setDate(now.getDate() + 1)
      res.cookie('token', JSON.stringify({ id: user[0].id, deadline: now.getTime()}), {
        maxAge: 900000,
        httpOnly: true,
      })
    } else {
      res.status(400).end()
    }
  },

  [`GET ${apiPrefix}/user`] (req, res) {
    const cookie = req.header.cookie || ''
    const cookies = qs.parse(cookie.replace(/\s/g, ''), {delimiter: ';'})
    const respose = {}
    const user = {}
    if (!cookies.token) {
      res.status(200).send({ message: 'Not Login'})
      return
    }
    const token = JSON.parse(cookies.token);
    if (token) {
      respose.success = token.deadline > new Date().getTime()

    }
    if (respose.success) {
      const userItem = adminUsers.filter(_ => _.id === token.id)
      if (userItem.length > 0) {
        user.permission = userItem.permission
        user.username = userItem.username
        user.id = userItem.id
      }
    }
    respose.user = user
    res.json(respose)
  },
}
