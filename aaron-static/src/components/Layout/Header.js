import React from 'react'
import PropTypes from 'prop-types'
import { Menu, Icon, Layout, Popover } from 'antd'
import styles from './Header.less'

const { SubMenu } = Menu
const Header = ({
  user, menu, logout,
}) => {
  let handleClickMneu = _ => _.key === 'logout' && logout()
  return (
    <Layout.Header className={styles.header}>
      <div>
        <Menu mode="horizontal" onClick={handleClickMneu}>
          <SubMenu
            style={{
              float: 'right',
            }}
            title={<span><Icon type="user" />{user.name}</span>}
          >
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
  logout: PropTypes.func,
}
export default Header
