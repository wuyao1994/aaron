import React from 'react'
import PropTypes from 'prop-types'
import { Menu, Icon, Layout, Popover } from 'antd'

const { SubMenu } = Menu
const Header = ({
  user, menu,
}) => {
  return (
    <Layout.Header>
      <div>
        <Menu mode="horizontal">
          <SubMenu title={<span><Icon type="user" />{user.name}</span>}>
            <Menu.Item key="logout">
              Sign out
            </Menu.Item>
          </SubMenu>
        </Menu>
      </div>
    </Layout.Header>
  )
}

Header.propTypes = {
  user: PropTypes.object,
  menu: PropTypes.array,
}
export default Header
