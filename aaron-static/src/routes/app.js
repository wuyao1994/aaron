import { withRouter } from 'dva/router'
import { connect } from 'dva'
import { Spin, Layout } from 'antd'
import { Helmet } from 'react-helmet'
import React from 'react'
import PropTypes from 'prop-types'
import { config } from '../utils'
import styles from './app.less'
import { MyLayout } from '../components'

const { Header, Bread } = MyLayout
const { Footer, Sider, Content } = Layout

const { openPages } = config
const App = ({
  children, dispatch, app, loading, location,
}) => {
  const { user, menu, permissions } = app
  let { pathname } = location
  pathname = pathname.startsWith('/') ? pathname : `/${pathname}`

  const headerProps = {
    menu,
    user,
    location,
    logout () {
      dispatch({
        type: 'app/logout',
      })
    },
  }

  const siderProps = {
    menu,
    location,
  }

  const breadProps = {
    menu,
    location,
  }

  if (openPages && openPages.includes(pathname)) {
    return (
      <div>
        <Spin size="large" className={styles.spin} spinning={loading.effects['app/query']} />
        {children}
      </div>
    )
  }

  return (
    <div>
      <Spin size="large" className={styles.spin} spinning={loading.effects['app/query']} />
      <Helmet>
        <title>aaron</title>
      </Helmet>

      <Layout>
        <Sider trigger={null}>
          <MyLayout.Sider {...siderProps} />
        </Sider>
        <Layout>
          <Header {...headerProps} />
          <Content>
            <Bread {...breadProps} />
            {children}
          </Content>
          <Footer>{config.footerText}</Footer>
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

export default withRouter(connect(({ app, loading }) => ({ app, loading }))(App))
