import config  from '../utils/config'
import { query } from '../services/app'
import { routerRedux } from 'dva/router'
import queryString from 'query-string'

export default {
  namespace: 'app',
  state: {
    user: {},
    locationPathname,
  },
  subscription: {

    setup ({ dispatch}) {
      dispatch({ type: 'query'})
    },

    setupHistory ({ dispatch, history }) {
      history.listen((location) => {
        dispatch({
          type: 'updateState',
          payload: {
            locationPathname: location.pathname,
            locationQuery: queryString.parse(location.search),
          },
        })
      })
    },
  },
  effects: {
    * query ({ payload}, {call, put, select}) {
      const { success, user } = yield call(query, payload)
      const { locationPathname } = yield select( _ => _.app)
      if ( success && user) {

      } else if (config.openPages && config.openPages.indexOf(locationPathname) < 0) {
        yield put(routerRedux.push({
          pathname: '/login',
          search: queryString.stringify({
            from: locationPathname,
          })
        }))
      }
    }
  },
  reducers: {
    updateState (state, { payload }) {
      return {
        ...state,
        ...payload,
      }
    }
  }
}
