import React from 'react'
import PropTypes from 'prop-types'
import { Menu, Icon } from 'antd'
import { Link } from 'react-router-dom'
import { arrayToTree, queryArray } from '../../utils'
import pathToRegexp from 'path-to-regexp'

const { SubMenu } = Menu
const Menus = ({
  menu, location
}) => {
  const menuTree = arrayToTree(menu.filter(_ => _.mpid !== '-1'), 'id', 'mpid')

  const getMenus = (menuTreeN) => {
    return menuTreeN.map((item) => {
      if (item.children) {
        return (
          <SubMenu
            key="{item.id}"
            title={<span>{item.icon && <Icon type={item.icon} />}{item.name}</span>}
          >
            {getMenus(item.children)}
          </SubMenu>
        )
      }
      return (
        <Menu.Item key={item.id}>
          <Link to={item.route || '#'}>
            {item.icon && <Icon type={item.icon} />}
            {item.name}
          </Link>
        </Menu.Item>
      )
    })
  }
  const menuItems = getMenus(menuTree)

  return (
    <Menu>
      {menuItems}
    </Menu>
  )
}

export default Menus

