import React from 'react'
import PropTypes from 'prop-types'
import { Breadcrumb, Icon } from 'antd'
import styles from './Layout.less'

const Bread = ({

}) => {
  return (
    <div className={styles.bread}>
      <Breadcrumb>
        <Breadcrumb.Item><Icon type="dashboard" /> Dashboard</Breadcrumb.Item>
      </Breadcrumb>
    </div>
  )
}

export default Bread
