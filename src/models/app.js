import { config } from '../utils'
import { query }
export default {
  namespace: 'app',
  state: {
    user: {},
  },
  subscription: {
    setup ({ dispatch}) {
      dispatch({ type: 'query'})
    }
  },
  effects: {
    * query ({ payload}, {call, put, select}) {

    }
  },
  reducers: {

  }
}
