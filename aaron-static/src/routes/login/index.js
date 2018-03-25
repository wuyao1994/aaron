import React from 'react'
import PropTypes from 'prop-types'
import { connect } from 'dva'
import { Form, Icon, Input, Button, Checkbox } from 'antd'
import styles from './index.less'

const FormItem = Form.Item

const Login = ({
  loading,
  dispatch,
  form: {
    getFieldDecorator,
    validateFieldsAndScroll,
  },
}) => {
  function handleSubmit () {
    validateFieldsAndScroll((err, values) => {
      if (err) {
        return
      }
      dispatch({
        type: 'login/login',
        payload: values,
      })
    })
  }

  return (
    <div className={styles.form}>
      <div className={styles.title}>
        <span>AARON</span>
      </div>
      <Form onSubmit={handleSubmit}>
        <FormItem>
          {getFieldDecorator('username', {
            rules: [{ required: true, message: 'Please input your username!' }],
          })(<Input prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />} placeholder="Username" />)}
        </FormItem>
        <FormItem>
          {getFieldDecorator('password', {
            rules: [{ required: true, message: 'Please input your Password!' }],
          })(<Input prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />} type="password" placeholder="Password" />)}
        </FormItem>
        <FormItem>
          {getFieldDecorator('remember', {
            valuePropName: 'checked',
            initialValue: true,
          })(<Checkbox>Remember me</Checkbox>)}
          <a className={styles.forget} href="">Forgot password</a>
          <Button type="primary" onClick={handleSubmit} htmlType="submit" className={styles.button} loading={loading.effects['login/login']}>
            Log in
          </Button>
          Or <a href="">register now!</a>
        </FormItem>
      </Form>
    </div>
  )
}
Login.propTypes = {
  loading: PropTypes.object,
  dispatch: PropTypes.func,
  form: PropTypes.object,
}

export default connect(({ loading }) => ({ loading }))(Form.create()(Login))
