const config = require('../utils/config')
const { apiPrefix } = config

let database = [
  {
    id: '1',
    icon: 'dashboard',
    name: 'Dashboard',
    route: '/dashboard',
  },
  {
    id: '6',
    bpid: '1',
    name: 'Test Navigation',
    icon: 'setting',
  },
  {
    id: '61',
    bpid: '6',
    mpid: '6',
    name: 'Test Navigation1',
    route: '/navigation/navigation1',
  },
  {
    id: '62',
    bpid: '6',
    mpid: '6',
    name: 'Test Navigation2',
    route: '/navigation/navigation2',
  },
  {
    id: '621',
    bpid: '62',
    mpid: '62',
    name: 'Test Navigation21',
    route: '/navigation/navigation2/navigation1',
  },
  {
    id: '622',
    bpid: '62',
    mpid: '62',
    name: 'Test Navigation22',
    route: '/navigation/navigation2/navigation2',
  },
]

module.exports = {

  [`GET ${apiPrefix}/menus`] (req, res) {
    res.status(200).json(database)
  },
}
