import { config } from '../utils'
import { Loader } from '../components'
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
}
