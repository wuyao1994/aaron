import { connect } from 'dva'
import React from 'react'
import PropTypes from 'prop-types'

function Dashboard ({ dashboard, loading }) {
  return (<div>dashboard</div>)
}

Dashboard.propTypes = {
  dashboard: PropTypes.object,
  loading: PropTypes.object,
}

export default connect(({ dashboard, loading }) => ({ dashboard, loading }))(Dashboard)
