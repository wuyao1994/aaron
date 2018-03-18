import React from 'react'
import PropTypes from 'prop-types'
import { config } from '../utils'
import { withRouter } from 'dva/router'
import { connect } from 'dva'
import { Spin } from 'antd'
const { openPages } = config
const App = ({children, dispatch, app, loading, location}) => {
  const {
    user, menu, permissions
  } = app
  let { pathname } = location
  pathname = pathname.startsWith('/') ? pathname : `/${pathname}`
  if (openPages && openPages.includes(pathname)) {
    return (
      <div>
        <Spin spinning={loading.effects['app/query']} />
        {children}
      </div>
    )
  }

  return (<div>{children}</div>)
}

App.propTypes = {
  children: PropTypes.element.isRequired,
  dispatch: PropTypes.func,
  app: PropTypes.object,
  loading: PropTypes.object,
  location: PropTypes.object,
}

export default withRouter(connect(({app, loading}) => ({app, loading}))(App))

