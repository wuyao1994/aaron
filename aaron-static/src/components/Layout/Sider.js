import React from 'react'
import PropTypes from 'prop-types'
import { config } from '../../utils'
import Menus from './Menu'
import styles from './Layout.less'

const Sider = ({
  menu, location,
}) => {
  const menusProps = {
    menu,
    location,
  }
  return (
    <div>
      <div className={styles.logo}>
        <span>{config.name}</span>
      </div>
      <Menus {...menusProps} />
    </div>
  )
}

Sider.propTypes = {
  menu: PropTypes.array,
  location: PropTypes.object,
}

export default Sider
