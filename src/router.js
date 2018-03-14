import React from 'react'
import PropTypes from 'prop-types'
import {Switch, Route, Redirect, routerRedux} from 'dva/router'
import dynamic from 'dva/dynamic'
import App from 'routes/app'
import {LocaleProvider} from 'antd'
import enUS from 'antd/lib/locale-provider/en_US'
import Switch from "antd/lib/switch/index.d";

const { ConnectedRouter } = routerRedux

const Routers  = function ({history, app}) {
  const error = dynamic({
    app,
    component: () => import('./routes/error')
  })
  const routes = [
    {
      path: '/dashboard',
      models: () => [import('./modsls/dashboard')],
      component: () => import('./routes/dashboard/'),
    }, {
      path: '/login',
      models: () => [import('./models/login')],
      component: () => import('./routes/login'),
    }
  ]

  return (
    <ConnectedRouter history={history}>
      <LocaleProvider locale={enUS}>
        <App>
          <Switch>
            <Route exact path="/" render={() => (<Redirect to="/dashboard" />)}/>
            {
              routes.map(({path, ...dynamics}, key) => (
                  <Route key={key}
                    exact
                    path={path}
                    component={dynamic({
                      app,
                      ...dynamics,
                    })}
                  />
                )
              )
            }
            <Route component={error}/>
          </Switch>
        </App>
      </LocaleProvider>
    </ConnectedRouter>
  )
}
