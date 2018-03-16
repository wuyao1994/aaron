import React from 'react'
import PropTypes from 'prop-types'
import { config } from '../utils'
import { Loader } from '../components'
import { withRouter } from 'dva/router'
import { connect } from 'dva'
const { openPages } = config
const App = (children, dispatch, app, loading, location) => {
  let { pathname } = location
  if (openPages && openPages.includes(pathname)) {
    return (
      <div>
        <Loader />
        {children}
      </div>
    )
  }

  return
}

App.propTypes = {
  children: PropTypes.element.isRequired(),
  dispatch: PropTypes.func,
  app: PropTypes.object,
  loading: PropTypes.object,
  location: PropTypes.object
}

export default withRouter(connect(({app, loading}) => ({app, loading}))(App))

