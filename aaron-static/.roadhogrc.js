const { version } = require('./package.json')

export default {
  entry: 'src/index.js',
  theme: "./theme.config.js",
  publicPath: `/${version}/`,
  outputPath: `./dist/${version}`,
  // 接口代理示例
  proxy: {
    "proxy": [{
      "context": ['/api/v1', '/common'],
      "target": "http://localhost:7000/",
      "changeOrigin": true,
      "pathRewrite": { "^/api/v1": "" }
    }],
  },
  env: {
    development: {
      extraBabelPlugins: [
        "dva-hmr",
        "transform-runtime",
        [
          "import", {
            "libraryName": "antd",
            "style": true
          }
        ]
      ]
    },
    production: {
      extraBabelPlugins: [
        "transform-runtime",
        [
          "import", {
            "libraryName": "antd",
            "style": true
          }
        ]
      ]
    }
  },
  dllPlugin: {
    exclude: ["babel-runtime", "roadhog", "cross-env"],
    include: ["dva/router", "dva/saga", "dva/fetch"]
  }
}
