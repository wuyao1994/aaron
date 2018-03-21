import React from 'react'
import PropTypes from 'prop-types'
import { config } from '../../utils'
import Menus from './Menu'

const Sider = ({
  menu, location,
}) => {
  const menusProps = {
    menu,
    location,
  }
  return (
    <div>
      <div>
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
