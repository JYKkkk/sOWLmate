const { defineConfig } = require('@vue/cli-service');

module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    allowedHosts: 'all',
    https: false,
  },
  pluginOptions: {
    vuetify: {
      // https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
    },
  },
  css: {
    loaderOptions: {
      sass: {
        additionalData: `
                @import "@/assets/scss/variables.scss";
            `,
      },
    },
  },
});
