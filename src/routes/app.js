import React from 'react'
import PropTypes from 'prop-types'
import { config } from '../utils'
import { withRouter } from 'dva/router'
import { connect } from 'dva'
import { Spin, Layout } from 'antd'
import styles from './app.less'
const { Header, Footer, Sider, Content } = Layout;

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
        <Spin size="large" className={styles.spin} spinning={loading.effects['app/query']}/>
        {children}
      </div>
    )
  }

  return (
    <div>
      <Spin size="large" className={styles.spin} spinning={loading.effects['app/query']}/>
      <Layout>
        <Sider>Sider</Sider>
        <Layout>
          <Header>Header</Header>
          <Content>{children}</Content>
          <Footer>Footer</Footer>
        </Layout>
      </Layout>
    </div>)
}

App.propTypes = {
  children: PropTypes.element.isRequired,
  dispatch: PropTypes.func,
  app: PropTypes.object,
  loading: PropTypes.object,
  location: PropTypes.object,
}

export default withRouter(connect(({app, loading}) => ({app, loading}))(App))

