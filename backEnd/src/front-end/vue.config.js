// vue.config.js
module.exports = {
    // https://cli.vuejs.org/config/#devserver-proxy
    // https://www.danvega.dev/blog/2021/01/22/full-stack-java-vue/
    devServer: {
        port: 3000,
        proxy: {
            '': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true
            }
        }
    }
}