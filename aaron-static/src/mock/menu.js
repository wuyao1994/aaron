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
    name: 'Charts',
    icon: 'code-o',
  },
  {
    id: '61',
    bpid: '6',
    mpid: '6',
    icon: 'line-chart',
    name: 'ECharts',
    route: '/chart/ECharts',
  },
]

module.exports = {

  [`GET ${apiPrefix}/menus`] (req, res) {
    res.status(200).json(database)
  },
}
